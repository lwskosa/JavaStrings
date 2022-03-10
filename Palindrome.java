package com.techbee.lajoskosa.javastrings;

import java.util.ArrayList;

enum SearchMode{
        FIRST_WORD_ONLY,
        SENTENCE_TO_WORDS,
        WHOLE_SENTENCE,
        WHOLE_SENTENCE_IGNORE_SPACE,

    }
public class Palindrome extends Sentence {
    final int MIN_WORD_LENGTH = 3;
    public Palindrome(){
        id          = 2;
        message     = "Please enter a sentence or word:";
        description = "This task checks if input is a Palindrome";
    }

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

    private boolean isPalindrome(String wordToCheck) {
        int counter = wordToCheck.length() - 1;
        for (int i = 0; i < wordToCheck.length(); i++) {
            if (wordToCheck.toLowerCase().charAt(i) != wordToCheck.toLowerCase().charAt(counter--)) {
                return false;
            }
        }
        return true;
    }

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

    private void printResults(boolean isPalindrome, boolean includeSpaces) {
        //TODO: Minimum length for words to be checked? Should "a" or "I" count?
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
