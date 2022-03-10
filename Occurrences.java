package com.techbee.lajoskosa.javastrings;

import java.util.Hashtable;

public class Occurrences extends Sentence{
    public Occurrences(){
        id          = 7;
        message     = "Please enter sequence of whole Integer numbers greater than 0, separated by spaces or commas:";
        description = "This task counts the frequency individual numbers occur in an array";
    }

    /**
     * Count unique numbers in an int[] array
     * @param numbers Array that holds the desired numbers
     */
    public void numericOccurrences(int[] numbers) {
        if (hasValidInput(false)) {
            Hashtable<Integer, Integer> intOccurrence = new Hashtable<>();

            for (int number : numbers) {
                if (intOccurrence.containsKey(number)) {
                    int value = intOccurrence.get(number);
                    intOccurrence.replace(number, value, ++value);
                } else {
                    intOccurrence.put(number, 1);
                }
            }
            intOccurrence.remove(Integer.MIN_VALUE);
            System.out.println(intOccurrence);
        }
    }
}
