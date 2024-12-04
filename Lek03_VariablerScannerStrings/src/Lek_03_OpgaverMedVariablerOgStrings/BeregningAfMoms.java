package Lek_03_OpgaverMedVariablerOgStrings;

import java.util.Scanner;

public class BeregningAfMoms {
    public static void main(String[] args) {
        //Import Scanner
        //Initiering af scanner
        Scanner scanIn = new Scanner(System.in);

        //Opret double variabler input, sum, moms
        double input, sum, moms;
        moms = 0.25;

        //Prompt bruger for input af tal
        System.out.println("Dette program beregner momsen af et tal");
        System.out.println("Indtast et tal, som du vil have beregnet momsen af?!");
        //Beregn moms
        input = scanIn.nextDouble();
        sum = input * moms;

        //Udskriv værdi til bruger
        System.out.printf("Momsen er: %.2f", sum);
    }
}
