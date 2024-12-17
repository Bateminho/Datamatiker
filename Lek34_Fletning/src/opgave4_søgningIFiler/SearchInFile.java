package opgave4_søgningIFiler;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class SearchInFile {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Sean\\Documents\\Uddannelse\\Datamatiker\\1. semester\\Programmering\\opgave4Søgning.txt";

        int target = 959;
        try {
            boolean result = linFileSearch(filePath, target);
            System.out.println("Findes tallet " + target + " i filen: " + result);
        } catch (IOException e) {
            System.out.println("Der opstod en fejl: " + e.getMessage());
        }
    }

    public static boolean linFileSearch(String fileName, int target) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            throw new FileNotFoundException("Filen blev ikke fundet: " + fileName);
        }

        boolean result = false;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine() && !result) {
                String line = scanner.nextLine();
                try {
                    int number = Integer.parseInt(line); // Konverter linjen til heltal
                    if (number == target) {
                        result = true; // Returnér true, hvis tallet findes
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ugyldig linje, kunne ikke konverteres til et tal: " + line);
                }
            }
        }
        return result; // Returnér false, hvis tallet ikke findes
    }
}
