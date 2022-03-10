package com.techbee.lajoskosa.javastrings;

public class Words extends Sentence {
    public Words(){
        id          = 3;
        message     = "Please enter a sentence:";
        description = "This task counts the amounf of words in a sentence";
    }

    protected void displayWordCount(boolean uniqueWords) {
        if (hasValidInput(false)) {
            if (uniqueWords) {
                System.out.printf("Unique words in this sentence: %d\n", getWordCount(uniqueWords));

            } else {
                System.out.printf("Words in this sentence: %d\n", getWordCount(uniqueWords));
            }
        }
    }


}
