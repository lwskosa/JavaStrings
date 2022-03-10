package com.techbee.lajoskosa.javastrings;

import java.util.regex.Pattern;

public class Consonants extends Sentence{
    public Consonants(){
        id          = 4;
        message     = "Please enter a sentence:";
        description = "This task counts the amount of consonants in a sentence and can mask them";
    }
//  Default masking character
    private final char maskingChar = '*';

    /**
     * Count the amount of consonants in sentence
     * @return integer of consonants found in sentence
     */
    public int getConsonantCount() {
        if(getUserSentence() != null) {
            int consonantCount = 0;
//          Count instances
            for (char letter : getUserSentence().toLowerCase().toCharArray()) {
                for (char consonant : CONSONANTS) {
                    if (letter == consonant) {
                        consonantCount++;
                    }
                }
            }
            return consonantCount;
        }
//      Return this value if user has not provided valid input
        return -1;
    }

    /**
     * Since consonants can be masked, alternative way to count them
     * @return Amount of consonants replaced by maskin character found in sentence
     */
    public int getConsonantCountByMasked(){
        String sentence = maskConsonants();
        int count =0;
//      Count instances
        for(char letter: sentence.toCharArray()){
            if (letter == maskingChar){
                count++;
            }
        }
        return count;
    }

    /**
     * Provied feedback on how many consonants are found in sentence
     * @param countByMasked Count values by masked characters or consonants
     */
    public void displayConsonantCount(boolean countByMasked) {
        if (hasValidInput(false)) {
            if (countByMasked) {
                System.out.printf("Consonants in your sentence: %d\n", getConsonantCountByMasked());
            } else {
                System.out.printf("Consonants in your sentence: %d\n", getConsonantCount());
            }
        }
    }

    /**
     * Replaces consonants with mask characters
     * @return String of masked sentence
     */
    public String maskConsonants(){
        return getUserSentence().replaceAll("(?i)[bcdfghjklmnpqrstvwxyz]","\\"+ maskingChar);
    }

    /**
     * Replaces consonants with mask characters
     * @param mask Overrides default masking character
     * @return String of masked sentence
     */
    public String maskConsonants(char mask){
        return getUserSentence().replaceAll("(?i)[bcdfghjklmnpqrstvwxyz]","\\"+ mask);
    }
}
