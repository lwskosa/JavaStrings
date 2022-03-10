package com.techbee.lajoskosa.javastrings;

import java.util.ArrayList;

/**
 * Possible methods to check for Palindromes in input
 */
enum SearchMode {
    FIRST_WORD_ONLY,
    SENTENCE_TO_WORDS,
    WHOLE_SENTENCE,
    WHOLE_SENTENCE_IGNORE_SPACE
}

public class Palindrome extends Sentence {
    final int MIN_WORD_LENGTH = 3;
    public Palindrome(){
        id          = 2;
        message     = "Please enter a sentence or word:";
        description = "This task checks if input is a Palindrome";
    }

    /**
     * Naive solution, basic functionality
     * @param ignoreSpaces TRUE - Word separation does not matter<br>FALSE - Word separation and spacing matters
     */
    public void checkPalindrome(boolean ignoreSpaces) {
        if (hasValidInput(false)) {
            String userWord = getInputFirstWord();
            System.out.println("======== NATIVE SOLUTION ========");
            String tempString;
            boolean isPalindrome = true;
            if (ignoreSpaces) {
                tempString = getUserSentence().replaceAll("\\s", "");
            } else {
                tempString = getUserSentence();
            }
            if(userWord.length() >= MIN_WORD_LENGTH) {
                int counter = tempString.length() - 1;
                for (int i = 0; i < tempString.length(); i++) {
                    if (tempString.toLowerCase().charAt(i) != tempString.toLowerCase().charAt(counter--)) {
                        System.out.printf("Your word '%s' is not a Palindrome\n", userWord);
                        break;
                    } else {
                        if (isPalindrome) System.out.printf("Your word '%s' is a Palindrome\n", userWord);
                    }
                }
            }
            else{
                System.out.printf("Your word '%s' is too short. please enter a longer word.\n",userWord);
            }
        }
    }

    /**
     * Advanced version of the Palindome checker
     * @param checkThis String to be checked for Palindromes
     * @param mode <b>enum</b>, select which method to be used to check for Palindrome
     */
    public void checkPalindrome(String checkThis, SearchMode mode){
            if(hasValidInput(false)){
            String sentence = checkThis.toLowerCase();
            ArrayList<String> words = getInputList();

            switch (mode) {
                case FIRST_WORD_ONLY -> {
                    System.out.println("======== CHECK FIRST WORD ONLY ========");
                    String oneWord = words.get(0);
                    printResults(oneWord, isPalindrome(oneWord));
                }
                case SENTENCE_TO_WORDS -> {
                    int paddingAmount = getLongestWord() + 2;
                    System.out.println("======== CHECK EACH WORD IN SENTENCE ========");
                    System.out.println("Breakdown of your sentence:");
                    for (String word : words) {
                        printResults(word, isPalindrome(word), paddingAmount);
                    }
                }
                case WHOLE_SENTENCE -> {
                    System.out.println("======== CHECK WHOLE SENTENCE, INCLUDING WORD SEPARATIONS ========");
                    printResults(isPalindrome(sentence), true);
                }
                case WHOLE_SENTENCE_IGNORE_SPACE -> {
                    System.out.println("======== CHECK WHOLE SENTENCE, IGNORING WORD SEPARATIONS ========");
                    printResults(isPalindrome(sentence.replaceAll("\\s", "")), false);
                }
            }
        }
    }

    /**
     * Steps through the input to see if it is a Palindrome
     * @param wordToCheck <b>String</b> to check for Palindromes
     * @return TRUE - input is a Palindrome<br>FALSE - input is not a Palindrome
     */
    private boolean isPalindrome(String wordToCheck) {
        int counter = wordToCheck.length() - 1;
        for (int i = 0; i < wordToCheck.length(); i++) {
            if (wordToCheck.toLowerCase().charAt(i) != wordToCheck.toLowerCase().charAt(counter--)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Print results for the Palindrome check
     * @param input
     * @param isPalindrome
     */
    private void printResults(String input, boolean isPalindrome) {
        if (input.length() >= MIN_WORD_LENGTH) {
            if (isPalindrome) {
                System.out.printf("\tThe word '%s' is a Palindrome\n", input);
            } else {
                System.out.printf("\tThe word '%s' is NOT a Palindrome\n", input);
            }
        } else {
            System.out.printf("\tThe word '%s' is too short - must be more than %d characters\n", input, MIN_WORD_LENGTH);
        }
    }

    /**
     * Provide formatted restults for the Palindrome check
     * @param input Provide <b>String</b> to check for Palindromes
     * @param isPalindrome Results for Palindrome check.<br>TRUE - input is a Palindrome<br>FALSE - input is not a Palindrome
     * @param padding Total characters for padding<br><i>Needs to be more than input length</i>
     */
    private void printResults(String input, boolean isPalindrome, int padding) {
        if (input.length() >= MIN_WORD_LENGTH) {
            if (isPalindrome) {
                System.out.printf("\tThe word %s is a Palindrome\n", padRight("'" + input + "'", padding));
            } else {
                System.out.printf("\tThe word %s is NOT a Palindrome\n", padRight("'" + input + "'", padding));
            }
        }
        else{
            System.out.printf("\tThe word %s is too short, was ignored\n", padRight("'" + input + "'", padding));
        }
    }

    /**
     * Check if input is a "true" Palindrome.<br>True Palindromes match even if word separation/spaces are not ignored
     * @param isPalindrome Results for Palindrome check.<br>TRUE - input is a Palindrome<br>FALSE - input is not a Palindrome
     * @param includeSpaces TRUE - Word separation matters<br>FALSE - Word separation/spacing does not matter
     */
    private void printResults(boolean isPalindrome, boolean includeSpaces) {
        if (isPalindrome && includeSpaces) {
            System.out.println("Your sentence is an absolute Palindrome");
        } else if (isPalindrome && !includeSpaces) {
            System.out.println("Your sentence is a Palindrome");
        }
        else if(!isPalindrome && includeSpaces){
            System.out.println("Your sentence is NOT an absolute Palindrome");
        }
        else if(!isPalindrome && !includeSpaces) {
            System.out.println("Your sentence is NOT a Palindrome");
        }
    }
}
