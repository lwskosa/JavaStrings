package com.techbee.lajoskosa.javastrings;

import java.util.List;

public class RotateString extends Sentence{
    public RotateString(){
        id          = 6;
        message     = "Please enter a word:";
        description = "This task rotates the string of a word by putting next letter to last";
    }

    /**
     * Moves next first letter to end of word.<br>Uses and rotates <strong>only</strong> first word in sentence
     * @param rotateAmount How many spaces are the letters shifted
     */
    public void rotateWord(int rotateAmount) {
        if (hasValidInput(false)) {
            System.out.println("======== ROTATE FIRST WORD IN SENTENCE ========");
            StringBuilder builder = new StringBuilder();
            String word    = getInputList().get(0);
            int rotateWord = rotateAmount % word.length();
            String slice   = word.substring(0, rotateWord);
            String body    = word.substring(rotateWord);
            builder.append(body).append(slice);
            System.out.println(builder);
        }
    }

    /**
     * Moves next first letter to end of word.<br>Rotates every individual word in a sentence
     * @param rotateAmount How many characters are the letters shifted
     */
    public void rotateSentenceWords(int rotateAmount) {
        if (hasValidInput(false)) {
            System.out.println("======== ROTATE EACH WORD IN SENTENCE ========");
            StringBuilder builder = new StringBuilder();
            List<String> words    = getInputList();
            for (String word : words) {
                int rotateWord    = rotateAmount % word.length();
                String slice      = word.substring(0, rotateWord);
                String body       = word.substring(rotateWord);
                builder.append(body).append(slice).append(" ");
            }
            System.out.println(builder);
        }
    }
}
