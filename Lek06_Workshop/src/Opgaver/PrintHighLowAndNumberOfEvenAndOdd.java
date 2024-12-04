package Opgaver;

import java.util.Scanner;

public class PrintHighLowAndNumberOfEvenAndOdd {
    public static void main(String[] args) {

        Scanner inputScan = new Scanner(System.in);

        int max = 0, min = 1, even = 0, odd = 0;

        System.out.println("Indtast en masse helt mellem 1-99 og afslut med 0");
        int input = inputScan.nextInt();

        while (input != 0) {
            if (input > max)
                max = input;
            if (input < min)
                min = input;
            if (input % 2 == 0)
                even++;
            else odd++;
            input = inputScan.nextInt();
        }
        System.out.printf("Max er: %d\nmin er: %d\nAntal af lige tal: %d\nAntal ulige tal: %d", max, min, even, odd);
    }
}
