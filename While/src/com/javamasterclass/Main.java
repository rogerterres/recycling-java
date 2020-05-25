package com.javamasterclass;

public class Main {

    public static void main(String[] args) {

        int count = 1;
        while (count != 6) {
            System.out.println("Count value is " + count);
            count++;
        }

        for (count = 1; count != 6; count++) {
            System.out.println("Count value is " + count);
        }

        count = 1;
        while (true) {
            if (count == 6) {
                break;
            }
            System.out.println("Count value is " + count);
            count++;
        }

        count = 6;
        do {
            System.out.println("Count value was " + count);
            count++;

            if (count > 100) {
                break;
            }
        } while (count != 6);

        int number = 4;
        int finishNumber = 20;
        while (number <= finishNumber) {
            number++;
            if (!isEvenNumber(number)) {
                continue;
            }
            System.out.println("Even number " + number);
        }

        // Modify the while code above
        // Make it alse record the total number of even numbers it has found
        // and break once 5 are found
        // and at the end, display the total number of even numbers found

        int numbers = 4;
        int finishNumbers = 20;
        int evenNumbersFound = 0;

        while (numbers <= finishNumbers) {
            numbers++;
            if (!isEvenNumber(numbers)) {
                continue;
            }

            System.out.println("Even number " + numbers);
            evenNumbersFound++;
            if (evenNumbersFound >= 5) {
                break;
            }
        }

        System.out.println("Total even numbers found = " + evenNumbersFound);
    }

    // Create a method called isEvenNumber that takes a parameter of type int
    // Its purpose is to determine if the argument passed to the method is
    // an even number or not.
    // Return true if an even number, otherwise return false;

    public static boolean isEvenNumber(int number) {
        if ((number % 2) == 0) {
            return true;
        } else {
            return false;
        }
    }
}
