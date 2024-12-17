package opgave5_fletHeltalFraFiler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FletHeltalFraToFiler {
    public static void main(String[] args) {
        String filePath1 = "C:\\Users\\Sean\\Documents\\Uddannelse\\Datamatiker\\1. semester\\Programmering\\textfiler\\fileName1.txt";
        String filePath2 = "C:\\Users\\Sean\\Documents\\Uddannelse\\Datamatiker\\1. semester\\Programmering\\textfiler\\fileName2.txt";
        String filePath3 = "C:\\Users\\Sean\\Documents\\Uddannelse\\Datamatiker\\1. semester\\Programmering\\textfiler\\fileNameNy.txt";

        try {
            fletAlleHeltal(filePath1, filePath2, filePath3);
        } catch (IOException e) {
            System.out.println("Der opstod en fejl: " + e.getMessage());
        }
    }

    public static void fletAlleHeltal(String fileName1, String fileName2, String fileNameNy) throws IOException {
        // Åbn filer
        File file1 = new File(fileName1);
        File file2 = new File(fileName2);
        File file3 = new File(fileNameNy);

        // Tjek om filer findes
        if (!file1.exists() || !file2.exists()) {
            throw new FileNotFoundException("Filen blev ikke fundet: " + (!file1.exists() ? fileName1 : fileName2));
        }

        // Opret eller overskriv outputfilen
        if (file3.createNewFile()) {
            System.out.println("Filen blev oprettet: " + file3.getName());
        } else {
            System.out.println("Filen eksisterer allerede - Indhold bliver overskrevet!");
        }

        try (Scanner scanner1 = new Scanner(file1); Scanner scanner2 = new Scanner(file2);
             PrintWriter printWriter = new PrintWriter(file3)) {

            // Start med de første elementer i begge filer
            Integer number1 = scanner1.hasNextInt() ? scanner1.nextInt() : null;
            Integer number2 = scanner2.hasNextInt() ? scanner2.nextInt() : null;

            // Fletning af elementer fra begge filer
            while (number1 != null && number2 != null) {
                if (number1.equals(Integer.MAX_VALUE)) {
                    number1 = null; // Ignorer MAX_VALUE
                }
                if (number2.equals(Integer.MAX_VALUE)) {
                    number2 = null; // Ignorer MAX_VALUE
                }

                if (number1 != null && (number2 == null || number1 <= number2)) {
                    printWriter.println(number1); // Skriv number1 til filen
                    number1 = scanner1.hasNextInt() ? scanner1.nextInt() : null; // Læs næste fra file1
                } else if (number2 != null) {
                    printWriter.println(number2); // Skriv number2 til filen
                    number2 = scanner2.hasNextInt() ? scanner2.nextInt() : null; // Læs næste fra file2
                }
            }

            // Håndter resterende elementer i s1
            while (number1 != null) {
                if (!number1.equals(Integer.MAX_VALUE)) { // Ignorer MAX_VALUE
                    printWriter.println(number1);
                }
                number1 = scanner1.hasNextInt() ? scanner1.nextInt() : null;
            }

            // Håndter resterende elementer i s2
            while (number2 != null) {
                if (!number2.equals(Integer.MAX_VALUE)) { // Ignorer MAX_VALUE
                    printWriter.println(number2);
                }
                number2 = scanner2.hasNextInt() ? scanner2.nextInt() : null;
            }
        }
    }
}