package com.techbee.lajoskosa.javastrings;

import java.util.regex.Pattern;

public class Consonants extends Sentence{
    public Consonants(){
        id          = 4;
        message     = "Please enter a sentence:";
        description = "This task counts the amount of consonants in a sentence and can mask them";
    }

    private final char maskingChar = '*';

    public int getConsonantCount() {
        if(getUserSentence() != null) {
            int consonantCount = 0;
            for (char letter : getUserSentence().toLowerCase().toCharArray()) {
                for (char consonant : CONSONANTS) {
                    if (letter == consonant) {
                        consonantCount++;
                    }
                }
            }
            return consonantCount;
        }
        return -1;
    }

    public int getConsonantCountByMasked(){
        String sentence = maskConsonants();
        int count =0;
        for(char letter: sentence.toCharArray()){
            if (letter == maskingChar){
                count++;
            }
        }
        return count;
    }

    public void displayConsonantCount(boolean countByMasked) {
        if (hasValidInput(false)) {
            if (countByMasked) {
                System.out.printf("Consonants in your sentence: %d\n", getConsonantCountByMasked());
            } else {
                System.out.printf("Consonants in your sentence: %d\n", getConsonantCount());
            }
        }
    }


    public String maskConsonants(){
        return getUserSentence().replaceAll("(?i)[bcdfghjklmnpqrstvwxyz]","\\"+ maskingChar);
    }

}
