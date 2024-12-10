package opgave9_babynames;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BabyNamesList_12_32 {
    public static void main(String[] args) {

        // Startår
        int year = 2010;

        // Print header
        System.out.printf("%-7s %-11s %-11s %-11s %-11s %-11s %-11s %-11s %-11s %-11s %-11s\n",
                "Year", "Rank 1", "Rank 2", "Rank 3", "Rank 4", "Rank 5",
                "Rank 1", "Rank 2", "Rank 3", "Rank 4", "Rank 5");

        // Iterér gennem de 10 år
        for (int i = 10; i > 0; i--) {
            String filePath = "C:\\Users\\Sean\\Documents\\Uddannelse\\Datamatiker\\1. semester\\Programmering\\Babynames\\nameranking" + year + ".txt";

            try {
                // Print top 5 navne for året
                listTopFiveBabyNames(filePath, year);
            } catch (FileNotFoundException e) {
                System.out.println("The file for year " + year + " could not be found.");
            }
            year--;
        }
    }

    public static void listTopFiveBabyNames(String filePath, int year) throws FileNotFoundException {
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            int lineCount = 0;

            // Arrays til top 5 drenge- og pigenavne
            String[] boyNames = new String[5];
            String[] girlNames = new String[5];

            // Læs de første 5 linjer
            while (scanner.hasNextLine() && lineCount < 5) {
                String line = scanner.nextLine();
                String[] columns = line.split("\\s+");

                // Hent drengenavn og pigenavn
                boyNames[lineCount] = columns[1];
                girlNames[lineCount] = columns[3];

                lineCount++;
            }

            // Print året og navne
            System.out.printf("%-8s", year);
            for (String girlName : girlNames) {
                System.out.printf("%-12s", girlName);
            }
            for (String boyName : boyNames) {
                System.out.printf("%-12s", boyName);
            }
            System.out.println(); // Ny linje efter hvert år
        }
    }
}
