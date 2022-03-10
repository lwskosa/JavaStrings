package com.techbee.lajoskosa.javastrings;

public class Vowels extends Sentence{
    private String userSentence;
    // Alternatively, we can use a string as our character list to check against
    private final String stringVowels = "aeiou";
    public Vowels(){
        id          = 1;
        message     = "Please enter a sentence:";
        description = "This task counts vowels in a sentence";
    }

    /**
     * Count how many Vowels the input has
     * @return Amount of Vowels the input has
     */
    public int getVowelCount() {
        if(hasValidInput(false)) {
            int vowelCount = 0;
//        Alternatively: for loop, charAt[i] instead of charArray
            /* Alternatively: nested for loop can be replaced with direct comparison: if (letter == 'a' || letter == 'e'...etc
             * The downside is that this way of doing it can get out of hand if we need to compare it against more letters. Passing a*/
            for (char letter : getUserSentence().toLowerCase().toCharArray()) {
                for (char vowel : VOWELS) {
                    if (letter == vowel) {
                        vowelCount++;
                    }
                }
            }
            return vowelCount;
        }
        return -1;
    }

    /**
     * Count how many times a specific character has occurred in input
     * @param input Character to count
     * @return Amount of specific character occurrences
     */
    public int getCharCount(char input) {
        if(hasValidInput(false)) {
            int vowelCount = 0;
            for (int i = 0; i < getUserSentence().length(); i++) {
                if (getUserSentence().toLowerCase().charAt(i) == Character.toLowerCase(input)) {
                    vowelCount++;
                }
            }
            return vowelCount;
        }
        return -1;
    }

    /**
     * Print information on how many times Vowels occurred in sentence
     * @param showDetailedInfo
     */
    public void showResults(boolean showDetailedInfo) {
        if (hasValidInput(false)) {
            if (showDetailedInfo) {
                System.out.println("======== DETAILED ========");
            } else {
                System.out.println("======== STANDARD ========");
            }
            System.out.printf("Vowels in sentence: %d\n", getVowelCount());
            if (showDetailedInfo) {
                for (char letter : VOWELS) {
                    int vowelCount = getCharCount(letter);
                    if (vowelCount > 0) {
                        System.out.printf("\tNumber of '%c's in sentence: %d\n", Character.toUpperCase(letter), vowelCount);
                    }
                }
            }
        }
    }

//    Alternative methods
/*

    public int getVowelCount(String sentence) {
        int vowelCount = 0;       Alternatively: for loop, charArray instead of charAt[i]
        // Alternatively: nested for loop so custom set of chars can be tested
        // The downside of the above is that this way more variables are needed and nested loops cause: O = n^2
        for (int i = 0; i < sentence.length(); i++) {
        if (sentence.charAt(i) == 'a' ||
                sentence.charAt(i) == 'e' ||
                sentence.charAt(i) == 'i' ||
                sentence.charAt(i) == 'o' ||
                sentence.charAt(i) == 'u') {
            vowelCount++;
        }
    }
        return vowelCount;
}



   public void showDetailedResults(){
        showResults();
        for (char letter : vowels) {
            int vowelCount = getCharCount(letter);
            if(vowelCount > 0  ) {
                System.out.printf("\tNumber of '%c's in sentence: %d\n", Character.toUpperCase(letter), vowelCount);
            }
        }
    }*/

}// END OF CLASS
