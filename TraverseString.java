package com.techbee.lajoskosa.javastrings;

import java.util.Hashtable;

public class TraverseString extends Sentence {
    public TraverseString(){
        id          = 8;
        message     = "Please enter a sentence:";
        description = "This task lists unique characters in a sentence";
    }

    /**
     * Lists all unique characters in input, in the order of appearance
     */
    public void listUniqueCharacters() {
        if(hasValidInput(false)) {
            Hashtable<Character, Integer> uniques = new Hashtable<>();
            StringBuilder builder = new StringBuilder();
            String word = getUserSentence().replaceAll("[.,!?]", "").toLowerCase();
            for (char letter : word.toCharArray()) {
                if (!uniques.containsKey(letter)) {
                    uniques.put(letter, 1);
                    builder.append(letter);
                }
            }
            System.out.println("Unique characters in input:");
            System.out.println("\t" + builder.toString().replaceAll("\\s", ""));
        }
    }
}
