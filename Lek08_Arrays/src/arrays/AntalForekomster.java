package arrays;

import java.util.Arrays;
import java.util.Scanner;

public class AntalForekomster {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner input = new Scanner(System.in);

        // Array to hold the counts of numbers from 1 to 50
        int[] numberArray = new int[50];

        System.out.println("Indtast optil 50 helt mellem 1 and 50 (Afslut med 0):");

        // Read numbers from user until 0 is entered
        int number = input.nextInt();
        while (number != 0) {
            if (number >= 1 && number <= 50) {
                // Increment the count for the corresponding number
                numberArray[number - 1]++;
            }
            number = input.nextInt(); // Read the next number
        }

       // Display the occurrences of each number
        for (int i = 0; i < numberArray.length; i++) {
            if (numberArray[i] > 0) {
                System.out.println((i + 1) + " forekommer " + numberArray[i] + " gange" );
            }
        }
    }
}
