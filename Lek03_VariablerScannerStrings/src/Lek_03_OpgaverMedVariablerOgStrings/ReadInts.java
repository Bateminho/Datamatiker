package Lek_03_OpgaverMedVariablerOgStrings;

import java.util.Scanner;

public class ReadInts {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number1 ,number2, number3, sum, produkt;

        System.out.println("Dette program kan udregne summen og produktet af tre heltal");
        System.out.println("Indtast det første tal");
        number1 = in.nextInt();
        System.out.println("Indtast det andet tal");
        number2 = in.nextInt();
        System.out.println("Indtast det tredje tal");
        number3 = in.nextInt();

        sum = number1 + number2 + number3;
        produkt = number1 * number2 * number3;

        System.out.println("Summen af de tre tal er: " + sum);
        System.out.println("Produktet af de tre tal er: " + produkt);


    }
}
