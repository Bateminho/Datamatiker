package opgave4_inputFromFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFromFile {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Sean\\Documents\\Uddannelse\\Datamatiker\\1. semester\\Programmering\\opgave4.txt";

        try {
            File file = new File(filePath);

            try (Scanner scanner = new Scanner(file)) {
                System.out.println("Indhold af filen: ");
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine(); // Læs linjen som en String
                    try {
                        // Forsøg at konvertere til et heltal
                        int number = Integer.parseInt(line);
                        System.out.println(number * 2); // Udskriv det dobbelte
                    } catch (NumberFormatException e) {
                        System.out.println("Ugyldig linje, kunne ikke konverteres til et tal: " + line);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Filen blev ikke fundet: " + e.getMessage());
        }
    }
}
