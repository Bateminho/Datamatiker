package Lek_03_OpgaverMedVariablerOgStrings;

import java.util.Scanner;

public class VolumeOfTriangle {
    public static void main(String[] args) {

        //init scanner
        Scanner input = new Scanner(System.in);

        //init variabler area, volume, length
        double area, volume, length;

        //prompt user
        System.out.println("\nDette program beregner volumen af en ligsidet trekant");
        System.out.println("Indtast længden på en side");

        //scan input
        length = input.nextDouble();

        //compute area
        area = Math.sqrt(3)/4 * Math.pow(length, 2);

        //compute volume
        volume = area * length;

        //print result
        System.out.printf("Volumen af trekenten er: %.2f", volume);
    }
}
