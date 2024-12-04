package Opgaver;

import java.util.Scanner;

public class RunningSum {
    public static void main(String[] args) {

        Scanner inputScan = new Scanner(System.in);

        System.out.println("\nDette program summer og udskriver indtastede tal løbende!");
        System.out.println("Indtast en masse helt mellem 1-99 og afslut med 0");
        int input = inputScan.nextInt();
        int sum = 0;

        while (input !=0)
        {
            sum = sum + input;
            System.out.print(sum + " ");
            input = inputScan.nextInt();
        }

    }
}
