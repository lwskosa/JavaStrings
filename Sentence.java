package com.techbee.lajoskosa.javastrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Sentence {


    private String userSentence;
    Scanner scr = new Scanner(System.in);
    protected final char[] VOWELS     = {'a','e','i','o','u'};
    protected final char[] CONSONANTS = {'b','c','d','f','g','h','j','k','l','m','n','p','q','r','s','t','v','w','x','y','z'};

  int id;
  String message;
  String description;


    private int intTryParse(String value){
        try {
            return Integer.parseInt(value);
        }catch (NumberFormatException ex){
            System.out.printf("Please enter only positive Integer numbers. Unable to parse value '%s'\n",value);
            return Integer.MIN_VALUE;
        }
    }

    protected String[] getInputAsArray(){
        return getUserSentence().split("\\n");
    }

    public String getUserSentence(){
        return Objects.requireNonNullElse(userSentence, "");
    }

    public void setUserSentence(String sentence){
        userSentence = sentence;
    }

    public void getInput(){
        printHeader();
        String sentence = scr.nextLine();
        setUserSentence(sentence);
    }

    public int getNumber(String message){
        if (hasValidInput(false)){
            System.out.printf("%s\n",message);
            return new Scanner(System.in).nextInt();
        }
        return -1;
    }

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

    protected int getWordCount(boolean countOnlyUnique) {
        if (countOnlyUnique) {
            //TODO: Count only unique words
            return -1;
        } else {
            return getUserSentence().split("\\s").length;
        }
    }

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


    protected String padLeft(String text, int padAmount){
        return String.format("%-" + padAmount + "s",text);
    }
    protected String padRight(String text, int padAmount){
        return String.format("%" + padAmount + "s",text);
    }
    protected ArrayList<String> getInputList(){
        return new ArrayList<>(Arrays.asList(getUserSentence().split("\\s")));
    }
    protected String getInputFirstWord(){
        return getInputList().get(0);
    }
    private void printHeader(){
        System.out.printf("================ TASK %d ================\n", id);
        System.out.printf("= %s\n", description);
        System.out.println("========================================");
        System.out.println(message);
    }
}
