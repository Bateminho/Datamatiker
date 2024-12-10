package opgave8_findMaxMinAVG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AppReadFilesToFindMaxMinAVG {
    public static void main(String[] args) {

        try {
            String fileName1 = "10tal.txt";
            String fileName2 = "2500tal.txt"; // Filnavn i samme package
            int max10 = max(fileName1);
            int max2500 = max(fileName2);
            int min10 = min(fileName1);
            int min2500 = min(fileName2);
            double avg10 = gennemsnit(fileName1);
            double avg2500 = gennemsnit(fileName2);


            System.out.println("Det højeste tal i filen med 10 tal er: " + max10);
            System.out.println("Det højeste tal i filen med 2500 tal er: " + max2500);
            System.out.println("Det mindste tal i filen med 10 tal er: " + min10);
            System.out.println("Det mindste tal i filen med 2500 tal er: " + min2500);
            System.out.println("Det gennemsnitlige tal af tallene i filen med 10 tal er: " + avg10);
            System.out.println("Det gennemsnitlige tal af tallene i filen med 2500 tal er: " + avg2500);
        } catch (IOException e) {
            System.out.println("Der opstod en fejl: " + e.getMessage());
        }
    }

    public static int max(String fileName) throws IOException {
        int max = Integer.MIN_VALUE; // Startværdi for maksimal sammenligning

        // Åbn filen som InputStream
        try (InputStream inputStream = AppReadFilesToFindMaxMinAVG.class.getResourceAsStream(fileName)) {
            assert inputStream != null;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    int number = Integer.parseInt(line); // Konverter linjen til et heltal
                    if (number > max) {
                        max = number; // Opdater max, hvis tallet er større
                    }
                }
            }
        } catch (NullPointerException e) {
            throw new IOException("Filen blev ikke fundet: " + fileName, e);
        } catch (NumberFormatException e) {
            throw new IOException("Filen indeholder ugyldige data: " + e.getMessage(), e);
        }

        return max; // Returner det største tal
    }

    public static int min(String fileName) throws IOException {
        int min = Integer.MAX_VALUE; // Startværdi for maksimal sammenligning

        // Åbn filen som InputStream
        try (InputStream inputStream = AppReadFilesToFindMaxMinAVG.class.getResourceAsStream(fileName)) {
            assert inputStream != null;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    int number = Integer.parseInt(line); // Konverter linjen til et heltal
                    if (number < min) {
                        min = number; // Opdater min, hvis tallet er mindre
                    }
                }
            }
        } catch (NullPointerException e) {
            throw new IOException("Filen blev ikke fundet: " + fileName, e);
        } catch (NumberFormatException e) {
            throw new IOException("Filen indeholder ugyldige data: " + e.getMessage(), e);
        }

        return min; // Returner det største tal
    }

    public static double gennemsnit(String fileName) throws IOException {
        double gns = 0;
        int count = 0;//

        // Åbn filen som InputStream
        try (InputStream inputStream = AppReadFilesToFindMaxMinAVG.class.getResourceAsStream(fileName)) {
            assert inputStream != null;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

                String line;
                while ((line = reader.readLine()) != null) {
                    int number = Integer.parseInt(line); // Konverter linjen til et heltal
                    gns += number;
                    count++;

                }
            }
        } catch (NullPointerException e) {
            throw new IOException("Filen blev ikke fundet: " + fileName, e);
        } catch (NumberFormatException e) {
            throw new IOException("Filen indeholder ugyldige data: " + e.getMessage(), e);
        }

        return gns / count; // Gennemsnittet af alle tallene i filen.
    }
}
