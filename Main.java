package com.techbee.lajoskosa.javastrings;

public class Main {

    public static void main(String[] args) {
        Vowels     task1 = new Vowels();
        Palindrome task2 = new Palindrome();
        Words      task3 = new Words();
        Consonants task4 = new Consonants();
        LastLetterCount task5 = new LastLetterCount();
        RotateString    task6 = new RotateString();
        Occurrences     task7 = new Occurrences();
        TraverseString  task8 = new TraverseString();


        do {
                task1.getInput();
                task1.showResults(false);
                task1.showResults(true);
        } while (task1.hasValidInput(true));

        do {
            task2.getInput();
                task2.checkPalindrome(true);
                task2.checkPalindrome(task2.getUserSentence(), SearchMode.FIRST_WORD_ONLY);
                task2.checkPalindrome(task2.getUserSentence(), SearchMode.SENTENCE_TO_WORDS);
                task2.checkPalindrome(task2.getUserSentence(), SearchMode.WHOLE_SENTENCE);
                task2.checkPalindrome(task2.getUserSentence(), SearchMode.WHOLE_SENTENCE_IGNORE_SPACE);
        } while (task2.hasValidInput(true));

        do {
                task3.getInput();
                task3.displayWordCount(false);
        } while (task3.hasValidInput(true));

        do {
            task4.getInput();
            task4.displayConsonantCount(false);
            task4.displayConsonantCount(true);
            System.out.println(task4.maskConsonants());

        } while (task4.hasValidInput(true));

        do {
                task5.getInput();
                task5.displayLastLetters();
        } while (task5.hasValidInput(true));

        do {
                task6.getInput();
                int rotateAmount = task6.getNumber("How many places would you like to shift:");
                task6.rotateWord(rotateAmount);
                task6.rotateSentenceWords(rotateAmount);
        } while (task6.hasValidInput(true));

        do {
                task7.numericOccurrences(task7.getIntArrayInput());
        } while (task7.hasValidInput(true));

        do {
                task8.getInput();
                task8.listUniqueCharacters();
        } while (task8.hasValidInput(true));



    }// END OF PSVM
}// END OF CLASS MAIN
