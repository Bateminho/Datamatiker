package Opgaver;


import java.util.Scanner;

public class FindMaxAndOccurens {
    public static void main(String[] args) {

        Scanner inputScan = new Scanner(System.in);

        System.out.println("\nDette program findes maks og hvormange gang det er indtastet!");
        System.out.println("Indtast flere heltal og afslut med 0.");

        int input = inputScan.nextInt();
        int max = 0;
        int antalMax = 0;

        while (input != 0)
        {
            if (input > max) {
                max = input;
                antalMax = 1;
            }
            else if (input == max)
                antalMax++;

            input = inputScan.nextInt();
        }
        System.out.printf("Max er %d og er forekommet %d antal gange!", max, antalMax);
    }
}
