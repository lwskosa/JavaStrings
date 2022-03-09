package com.techbee.lajoskosa.javastrings;

public class Main {

    public static void main(String[] args) {
//        TASK 1
        Vowels     task1 = new Vowels();
//        TASK 2
        Palindrome task2 = new Palindrome();
//        TASK 3
        Words      task3 = new Words();
//        TASK 4
        Consonants task4 = new Consonants();
//        TASK 5
        LastLetterCount task5 = new LastLetterCount();
//        TASK 6
        RotateString    task6 = new RotateString();
//        TASK 7
        Occurrences     task7 = new Occurrences();
//        TASK 8
        TraverseString  task8 = new TraverseString();

//  TASK 1 - Count Vowels in Inout
        do {
                task1.getInput();
                task1.showResults(false);
                task1.showResults(true);
        } while (task1.hasValidInput(true));

//  TASK 2 - Check for Palindromes in Input
        do {
            task2.getInput();
                task2.checkPalindrome(true);
                task2.checkPalindrome(task2.getUserSentence(), SearchMode.FIRST_WORD_ONLY);
                task2.checkPalindrome(task2.getUserSentence(), SearchMode.SENTENCE_TO_WORDS);
                task2.checkPalindrome(task2.getUserSentence(), SearchMode.WHOLE_SENTENCE);
                task2.checkPalindrome(task2.getUserSentence(), SearchMode.WHOLE_SENTENCE_IGNORE_SPACE);
        } while (task2.hasValidInput(true));

//  TASK 3 - Count Words in Input
        do {
                task3.getInput();
                task3.displayWordCount(false);
        } while (task3.hasValidInput(true));

//  TASK 4 - Count Consonants in Inout
        do {
            task4.getInput();
            task4.displayConsonantCount(false);
            task4.displayConsonantCount(true);
            System.out.println(task4.maskConsonants());

        } while (task4.hasValidInput(true));

//  TASK 5 - Count words that end with A or B, selected by user, also swap the first instance of those words around
        do {
                task5.getInput();
                task5.displayLastLetters();
        } while (task5.hasValidInput(true));

//  TASK 6 - Rotate string around by moving current first letter to end of word
        do {
                task6.getInput();
                int rotateAmount = task6.getNumber("How many places would you like to shift:");
                task6.rotateWord(rotateAmount);
                task6.rotateSentenceWords(rotateAmount);
        } while (task6.hasValidInput(true));

//  TASK 7 - Count unique occurrences if numbers in an array
        do {
                task7.numericOccurrences(task7.getIntArrayInput());
        } while (task7.hasValidInput(true));

//  TASK 8 - Count and mask Input
        do {
                task8.getInput();
                task8.listUniqueCharacters();
        } while (task8.hasValidInput(true));
    }// END OF PSVM
}// END OF CLASS MAIN
