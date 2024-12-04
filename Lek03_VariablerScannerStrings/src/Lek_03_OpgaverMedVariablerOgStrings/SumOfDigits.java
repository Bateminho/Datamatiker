package Lek_03_OpgaverMedVariablerOgStrings;

import java.util.Scanner;

public class SumOfDigits {
    public static void main(String[] args) {

        Scanner scanInput = new Scanner(System.in);

        int rest1, rest2, rest3, rest4, input, sum;

        System.out.println("Dette program udregner summen af cifrene fra et tal");
        System.out.println("Indtast et tal mellem 1-1000");

        input = scanInput.nextInt();

        rest4 = input % 10;
        rest3 = (input / 10) % 10;
        rest2 = (input / 100) % 10;
        rest1 = (input / 1000) % 10;
        sum = rest1 + rest2 + rest3 + rest4;

        System.out.println("Summen af talets cifre er: " + sum);

    }
}
