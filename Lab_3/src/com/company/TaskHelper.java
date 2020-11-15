package com.company;

import javafx.util.Pair;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TaskHelper {
    public static Dictionary<String, Character> findWordsStartingWithVowelLetter(List<String> words)
    {
        Pattern p = Pattern.compile("^[aeiouаояуюеєиії].*", Pattern.CASE_INSENSITIVE);
        List<String> startingWithVowels =
                words.stream().filter(w -> p.matcher(w).matches()).collect(Collectors.toList());

        Dictionary<String, Character> wordFirstConsonantLetter = new Hashtable<>();

        for (String word: startingWithVowels) {
            int i = 0;
            while (isVowel(word.charAt(i)))
            {
                i++;
            }

            wordFirstConsonantLetter.put(word ,word.charAt(i));
        }

        return wordFirstConsonantLetter;
    }

    public static List<Pair<String, Character>> sortByKeyConsonant(Dictionary<String, Character> words)
    {
        List<Character> consonants = Collections.list(words.elements());
        Collections.sort(consonants);

        List<Pair<String, Character>> resultList = new ArrayList<>();

        List<String> keys = Collections.list(words.keys());

        for (char letter: consonants)
        {
            for (String key: keys)
            {
                if (words.get(key) == letter)
                {
                    resultList.add(new Pair<>(key, letter));
                    words.remove(key);
                    keys.remove(key);

                    break;
                }
            }
        }

        return resultList;
    }

    public static List<String> findCombinedWords(List<String> dictionary, List<String> words)
    {
        List<String> combinedWords = new ArrayList<>();

        for (String combinedWord: words)
        {
            int partsCount = 0;
            for (String word: dictionary) {
                if (StringUtils.containsIgnoreCase(combinedWord, word)) {
                    partsCount++;
                }
            }

            if (partsCount > 1)
            {
                combinedWords.add(combinedWord);
            }
        }

        return combinedWords;
    }

    public static String replaceCombinedWords(List<String> sentences, List<String> combinedWords)
    {
        StringBuilder resultText = new StringBuilder();

        for (String sentence: sentences)
        {
            String sentenceFirstWord = findSentenceFirstWord(sentence);

            for (String word: combinedWords)
            {
                if (StringUtils.containsIgnoreCase(sentence, word))
                {
                    sentence = sentence.replace(word, sentenceFirstWord);
                }
            }

            resultText.append(sentence);
        }

        return resultText.toString();
    }

    public static String findSentenceFirstWord(String sentence)
    {
        String sentenceFirstWord;

        int startIndex;
        int endIndex;

        int i = 0;
        while (!Character.isLetter(sentence.charAt(i))) {
            i++;
        }

        startIndex = i;

        while (Character.isLetter(sentence.charAt(i)) || sentence.charAt(i) == '-') {
            i++;
        }

        endIndex = i;

        sentenceFirstWord = sentence.substring(startIndex, endIndex);

        return sentenceFirstWord;
    }

    public static boolean isVowel(char letter){
        String vowels = "aeiouAEIOUаояуюеєиіїАОЯЮУЕЄИІЇ";

        return vowels.contains(String.valueOf(letter));
    }
}
