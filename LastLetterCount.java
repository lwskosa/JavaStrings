package com.techbee.lajoskosa.javastrings;

import java.util.ArrayList;

public class LastLetterCount extends Sentence{
//  Default Last Letters to search for and manipulate
    private final String REPLACE_FILTER_A ="s";
    private final String REPLACE_FILTER_B ="y";

    public LastLetterCount(){
        id          = 5;
        message     = "Please enter a sentence:";
        description = String.format("This task can count how many words end with '%s' and '%s' and can swap them around",REPLACE_FILTER_A,REPLACE_FILTER_B);
    }

    /**
     * Count how many times desired filtered words appear in sentence
     * @return int arrary of how many times A and B filtered words appear in sentence
     */
    public int[] countFiltered(){
        int[] filters ={0,0};
        ArrayList<String> words = getInputList();

        for (String word: words){
            if(word.endsWith(REPLACE_FILTER_A)){
                filters[0]++;
            }
            else if(word.endsWith(REPLACE_FILTER_B)){
                filters[1]++;
            }
        }
        return filters;
    }

    /**
     * Provide statistical information about desired filtered words
     */
    public void displayLastLetters() {
        if (hasValidInput(false)) {
            int[] lastLetterCounts = countFiltered();
            System.out.printf("Number of words in sentence: %d\n", getWordCount(false));
            // Below 2 lines can be replaced with a for loop
            System.out.printf("Number of words ending with '%s': %d\n", REPLACE_FILTER_A, lastLetterCounts[0]);
            System.out.printf("Number of words ending with '%s': %d\n", REPLACE_FILTER_B, lastLetterCounts[1]);

            switchWords();
        }
    }

    /**
     * Switch word A and word B's position in sentence
     */
    private void switchWords(){
        ArrayList<String> sentence = getInputList();
        String[] filters = {REPLACE_FILTER_A,REPLACE_FILTER_B};
        int[] swapIndexes = {0,0};
//      Find indexes/positions for first instances in the sentence
        for (String filter : filters) {
            for (int j = 0; j < sentence.size(); j++) {
                if (sentence.get(j).endsWith(filter)) {
                    swapIndexes[0] = sentence.indexOf(sentence.get(j));
                    break;
                }
            }
        }
//      Helper variable to swap words around
        String  tempItem =  sentence.get(swapIndexes[0]);
        String secondWord = sentence.get(swapIndexes[1]);
//      Assign new positions
        sentence.set(swapIndexes[0],secondWord);
        sentence.set(swapIndexes[1], tempItem);
//      Print out new sentence to user
        System.out.println(String.join(" ", sentence));
    }

}
