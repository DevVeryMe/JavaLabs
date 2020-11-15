package com.company;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskHelperTest {

    @org.junit.jupiter.api.Test
    void findWordsStartingWithVowelLetter() {
        List<String> words = new ArrayList<>();
        words.add("actual");
        words.add("expected");
        words.add("cat");
        words.add("people");

        Dictionary<String, Character> expectedWords = new Hashtable<>();
        expectedWords.put("actual", 'c');
        expectedWords.put("expected", 'x');

        Dictionary<String, Character> actualWords = TaskHelper.findWordsStartingWithVowelLetter(words);

        assertEquals(expectedWords, actualWords);
    }

    @org.junit.jupiter.api.Test
    void sortByKeyConsonant() {
        Dictionary<String, Character> words = new Hashtable<>();
        words.put("actual", 'c');
        words.put("expected", 'x');
        words.put("apple", 'p');
        words.put("abandon", 'b');

        List<Pair<String, Character>> expectedWordsList = new ArrayList<>();
        expectedWordsList.add(new Pair<>("abandon", 'b'));
        expectedWordsList.add(new Pair<>("actual", 'c'));
        expectedWordsList.add(new Pair<>("apple", 'p'));
        expectedWordsList.add(new Pair<>("expected", 'x'));

        List<Pair<String, Character>> actualWordsList = TaskHelper.sortByKeyConsonant(words);

        assertEquals(expectedWordsList, actualWordsList);
    }

    @org.junit.jupiter.api.Test
    void isVowel() {
        char letter = 'a';

        assertTrue(TaskHelper.isVowel(letter));
    }
}