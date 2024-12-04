package OpgaverMedIFOgElse;

import java.util.Scanner;

public class ReadThreeNumbersAndDisplayOrder {
    public static void main(String[] args) {

        //Import/Init Scanner
        Scanner inputScan = new Scanner(System.in);

        //Prompt user for three numbers
        System.out.println("\nDette program fortæller om du har indtastet tre tal i stigende, faldende eller ingen orden!");
        System.out.println("Indtast tre tal: ");
        int number1 = inputScan.nextInt();

        //System.out.println("Indtast andet tal: ");
        int number2 = inputScan.nextInt();

        //System.out.println("Indtast tredje tal: ");
        int number3 = inputScan.nextInt();



        System.out.println(inOrder(number1, number2, number3));

    }

    public static String inOrder(int number1, int number2, int number3 ) {
        String result;
        //Compare number
        if (number1 < number2 && number2 < number3) {
            result = "Dine valgte tal " + number1 + " " + number2 + " " + number3 + " er stigende!";
        }
        else if (number1 > number2 && number1 > number3) {
            result = "Dine valgte tal " + number1 + " " + number2 + " " + number3 + " faldende!";
        }
        else {
            result = "Dine valgte tal " + number1 + " " + number2 + " " + number3 + "er hverken stigende eller faldende!!!";
        }

        return result;
    }
}
