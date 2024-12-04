package Opgaver;

import java.util.Scanner;

public class PrintIfDouble {
    public static void main(String[] args) {

        Scanner inputScan = new Scanner(System.in);

        System.out.println("\nDette program udskriver et tal, hvis det forekommer to gange i streg!");
        System.out.println("Indtast en masse hel tal og afslut med 0!");

        int input = inputScan.nextInt();
        int doubleDigit = 0;

        while (input != 0) {

            if (input != doubleDigit) {
                doubleDigit = input;
            } else System.out.print(doubleDigit + " ");

            input = inputScan.nextInt();
        }

    }
}
