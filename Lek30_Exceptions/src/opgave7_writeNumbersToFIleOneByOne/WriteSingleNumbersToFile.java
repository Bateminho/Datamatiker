package opgave7_writeNumbersToFIleOneByOne;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class WriteSingleNumbersToFile {
    public static void main(String[] args) {

        String filePath = "C:\\Users\\Sean\\Documents\\Uddannelse\\Datamatiker\\1. semester\\Programmering\\opgave7WritenumbersFromScanner.txt";

        try {
            File file = new File(filePath);

            if (file.createNewFile()) {
                System.out.println("Filen blev oprettet: " + file.getName());
            } else {
                System.out.println("Filen eksisterer allerede og indholdet vil blive overskrevet.");
            }

            try (PrintWriter printWriter = new PrintWriter(file);
                 Scanner scanner = new Scanner(System.in)) {

                System.out.println("Indtast positive tal for at gemme dem i filen. Afslut med -1:");

                while (true) {
                    System.out.print("Indtast et tal: ");

                    try {
                        if (scanner.hasNextInt()) {
                            int next = scanner.nextInt();

                            // Afslut med -1
                            if (next == -1) {
                                System.out.println("Indtastning afsluttet.");
                                break;
                            }

                            // Kast exception for negative tal
                            if (next < 0) {
                                throw new IllegalArgumentException("Negative tal er ikke tilladt: " + next);
                            }

                            // Skriv positive tal til filen
                            printWriter.println(next);

                        } else {
                            throw new InputMismatchException("Ugyldigt input! Indtast kun heltal.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("Fejl: " + e.getMessage());
                        scanner.next(); // Ryd ugyldigt input
                    }
                }
            }

            System.out.println("Alle gyldige tal blev skrevet til filen.");

        } catch (IOException e) {
            System.out.println("Der opstod en fejl: " + e.getMessage());
        }
    }
}