package opgave9_babynames;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BabyNames12_31 {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            // Brugeren indtaster år, køn og navn
            System.out.println("Enter the year between 2001-2010: ");
            int year = input.nextInt();

            System.out.println("Enter the gender (M for male, F for female): ");
            char gender = input.next().toUpperCase().charAt(0);

            System.out.println("Enter the name: ");
            input.nextLine(); // Ryd scanner-bufferen
            String name = input.nextLine();

            // Filstien baseret på året
            String filePath = "C:\\Users\\Sean\\Documents\\Uddannelse\\Datamatiker\\1. semester\\Programmering\\Babynames\\nameranking" + year + ".txt";

            // Kald metoden for at finde rangeringen
            try {
                String result = linearSearchBabyName(filePath, name, gender, year);
                System.out.println(result);
            } catch (FileNotFoundException e) {
                System.out.println("The file for year " + year + " could not be found. Try between 2001-2010");
            }
        }
    }

    /**
     * Metode til at finde rangeringen af et navn i en fil
     *
     * @param filePath Stien til filen
     * @param name     Navnet der skal findes
     * @param gender   Kønnet (M for male, F for female)
     * @return En streng med rangeringen eller en fejlbesked
     * @throws FileNotFoundException Hvis filen ikke findes
     */
    public static String linearSearchBabyName(String filePath, String name, char gender, int year) throws FileNotFoundException {
        String result = null;
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {
            while (result == null && scanner.hasNextLine()) {
                // Læs en linje fra filen
                String line = scanner.nextLine();
                // Split linjen i kolonner
                String[] columns = line.split("\\s+");

                // Hent data fra linjen
                int rank = Integer.parseInt(columns[0]);
                String maleName = columns[1];
                String femaleName = columns[3];

                // Kontrollér baseret på køn og navn
                if (gender == 'M' && maleName.equalsIgnoreCase(name)) {
                    result = name + " is ranked #" + rank + " in year " + year;
                } else if (gender == 'F' && femaleName.equalsIgnoreCase(name)) {
                    result = name + " is ranked #" + rank + " in year " + year;
                }
            }
        }

        // Hvis navnet ikke blev fundet, returnér en fejlbesked
        return result != null ? result : "The name " + name + " is not ranked in year " + year;
    }
}
