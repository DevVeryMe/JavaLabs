package com.company;

import java.util.*;

import javafx.util.Pair;

public class Main {

    public static void main(String[] args) {
	// write your code here
        WordsDictionary wordsDictionary = new WordsDictionary();

        wordsDictionary.words = FileReader.readFileAsStringList("dictionary.txt");
        String text = FileReader.readFileAsString("text.txt");

        System.out.println("Dictionary: ");
        System.out.println(wordsDictionary.words);

        System.out.println("Text: ");
        System.out.println(text);

        DividedText dividedText = new DividedText(text);

        List<String> combinedWords = TaskHelper.findCombinedWords(wordsDictionary.words, dividedText.getSeparateWords());

        String result = TaskHelper.replaceCombinedWords(dividedText.getSeparateSentences(), combinedWords);

        System.out.println("Result text: ");
        System.out.println(result);

        Dictionary<String, Character> wordsToSort
                = TaskHelper.findWordsStartingWithVowelLetter(dividedText.getSeparateWords());

        List<Pair<String, Character>> sortedWords = TaskHelper.sortByKeyConsonant(wordsToSort);

        System.out.println("Result words starting with vowel and sorted by first consonant: ");
        System.out.println(sortedWords);
    }
}
