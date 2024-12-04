package Lek_03_OpgaverMedVariablerOgStrings;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ConvertMilesToKm {
    public static void main(String[] args) {

        //Import Scanner
        //Init scanner
        Scanner scanIn = new Scanner(System.in);

        //Init variables miles, km
        double miles, km;

        //Prompt user for number of miles
        System.out.println("Dette program omregner miles til km");
        System.out.println("Indtast antal miles: ");
        miles = scanIn.nextDouble();

        //Convert miles to km
        km = miles * 1.6;

        //Print the convertet value
        System.out.printf("%.2f miles er lig med %.2f kilometer %n", miles, km);
    }


}
