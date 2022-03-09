package com.techbee.lajoskosa.javastrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Sentence {
//    Variable to store User Input
    private String userSentence;
//    Scanner to take user input
    Scanner scr = new Scanner(System.in);
//    Immutable array of Vowels
    protected final char[] VOWELS     = {'a','e','i','o','u'};
//    Immutable array of Consonants
    protected final char[] CONSONANTS = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};
// Fields to handle Task related information
    //LATER: Encapsulate
  int id;
  String message;
  String description;

    /**
     * TryParse implementation
     * @param value String value to be parsed as int
     * @return Parsed integer
     */
    private int intTryParse(String value){
        try {
            return Integer.parseInt(value);
        }catch (NumberFormatException ex){
            System.out.printf("Please enter only positive Integer numbers. Unable to parse value '%s'\n",value);
            return Integer.MIN_VALUE;
        }
    }

    /**
     * Convert each word to String array. Values are separated by space
     * @return String array of user input
     */
    protected String[] getInputAsArray(){
        return getUserSentence().split("\\n");
    }

    /**
     * Get value of user input
     * @return User Input
     */
    public String getUserSentence(){
        return Objects.requireNonNullElse(userSentence, "");
    }

    /**
     * Set user input value
     * @param sentence Set user input to String
     */
    public void setUserSentence(String sentence){
        userSentence = sentence;
    }

    /**
     * Print header and as for user input
     */
    public void getInput(){
        printHeader();
        String sentence = scr.nextLine();
        setUserSentence(sentence);
    }

    /**
     * Used for Task  6. User provided integer
     * @param message Set header message to this before user is able to enter their input
     * @return integer number
     */
    public int getNumber(String message){
        if (hasValidInput(false)){
            System.out.printf("%s\n",message);
            return new Scanner(System.in).nextInt();
        }
        return -1;
    }

    /**
     * Parses 1 or more user provided numbers, separated by space of comma
     * @return array of integers user provided
     */
    public int[] getIntArrayInput() {
        printHeader();
        int[] intArray;

        userSentence = scr.nextLine();
        if (hasValidInput(false)) {
            String[] rawValues = getInputAsArray();
            intArray = new int[rawValues.length];
            for (int i = 0; i < rawValues.length; i++) {
                intArray[i] = intTryParse(rawValues[i]);
            }

            return intArray;
        }
        return new int[0];
    }

    /**
     * Check if user has provided valid input which affects loop and makes sure code is not getting executed with invalid data
     * @param provideFeedback Provide feedback to user
     * @return TRUE - user has provided valid input\nFALSE - user has not proided valid input
     */
    public boolean hasValidInput(boolean provideFeedback) {
        if(getUserSentence().equals("")){
            if(provideFeedback){
            System.out.println("No input was provided. Exiting task.\n");
            }
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * Count the number of words in user input
     * @param countOnlyUnique Limit count to unique words versus every word
     * @return words counted in user input
     */
    protected int getWordCount(boolean countOnlyUnique) {
        if (countOnlyUnique) {
            //LATER: Count only unique words?
            return -1;
        } else {
            return getUserSentence().split("\\s").length;
        }
    }

    /**
     * Calculate the longest word in user input, used for text padding
     * @return length of longest word in user input as integer
     */
    public int getLongestWord() {
        String[] sentence = getUserSentence().replaceAll("\\?!,\\.", "").replaceAll("@", " ").split("\\s");
        int longest = Integer.MIN_VALUE;
        for (String word : sentence) {
            if (word.length() > longest) {
                longest = word.length();
            }
        }
        return longest;
    }

    /**
     * PadLeft implementation. User for text formatting, clamps text to left side
     * @param text text to be padded to the left
     * @param padAmount  total character size
     * @return Left-padded text
     */
    protected String padLeft(String text, int padAmount){
        return String.format("%-" + padAmount + "s",text);
    }
    /**
     * PadLeft implementation. User for text formatting, clamps text to right side
     * @param text text to be padded to the right
     * @param padAmount  total character size
     * @return Right-padded text
     */
    protected String padRight(String text, int padAmount){
        return String.format("%" + padAmount + "s",text);
    }

    /**
     * User input in list array format
     * @return List\<\> of user input
     */
    protected ArrayList<String> getInputList(){
        return new ArrayList<>(Arrays.asList(getUserSentence().split("\\s")));
    }

    /**
     * Gets first word of user input, even if they entered multiple words
     * @return First word of user input
     */
    protected String getInputFirstWord(){
        return getInputList().get(0);
    }

    /**
     * Provides visual separation and information to user
     */
    private void printHeader(){
        System.out.printf("================ TASK %d ================\n", id);
        System.out.printf("= %s\n", description);
        System.out.println("========================================");
        System.out.println(message);
    }
}
