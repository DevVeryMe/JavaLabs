package com.company;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class DividedText {
    private String fullText;

    private List<String> separateSentences;

    private List<String> separateWords;

    public DividedText(String fullText)
    {
        this.fullText = fullText;
        this.separateSentences = new ArrayList<>();
        this.separateWords = new ArrayList<>();

        splitIntoSentences();
        splitIntoWords();
    }

    private void splitIntoSentences()
    {
        BreakIterator bi = BreakIterator.getSentenceInstance();
        bi.setText(fullText);
        int index = 0;
        while (bi.next() != BreakIterator.DONE) {
            String sentence = fullText.substring(index, bi.current());
            separateSentences.add(sentence);
            index = bi.current();
        }
    }

    private void splitIntoWords()
    {
        int startIndex = 0;
        int endIndex = fullText.length() - 1;

        boolean isStartIndexSet = false;

        for (int i = 0; i < fullText.length(); i++)
        {
            if (!isStartIndexSet) {
                while (!Character.isLetter(fullText.charAt(i)) && i < fullText.length()) {
                    i++;
                }

                startIndex = i;
                isStartIndexSet = true;
            }
            else
            {
                while ((Character.isLetter(fullText.charAt(i)) || fullText.charAt(i) == '-') && i < fullText.length()) {
                    i++;
                }

                endIndex = i;
                isStartIndexSet = false;

                String word = fullText.substring(startIndex, endIndex);
                separateWords.add(word);
            }
        }
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public List<String> getSeparateSentences() {
        return separateSentences;
    }

    public void setSeparateSentences(List<String> separateSentences) {
        this.separateSentences = separateSentences;
    }

    public List<String> getSeparateWords() {
        return separateWords;
    }

    public void setSeparateWords(List<String> separateWords) {
        this.separateWords = separateWords;
    }
}
