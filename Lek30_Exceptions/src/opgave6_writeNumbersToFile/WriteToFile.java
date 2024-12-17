package opgave6_writeNumbersToFile;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


public class WriteToFile {
    public static void main(String[] args) {

        String filePath = "C:\\Users\\Sean\\Documents\\Uddannelse\\Datamatiker\\1. semester\\Programmering\\textfiler\\opgave6.txt";

        try {
            File file = new File(filePath);

            if (file.createNewFile()) {
                System.out.println("Filen blev oprettet: " + file.getName());
            } else {
                System.out.println("Filen eksisterer allerede.");
            }

            try (PrintWriter printWriter = new PrintWriter(file)) {
                for (int i = 0; i < 100; i++ ) {
                    if (i % 2 != 0) {
                        printWriter.println(i);
                    }
                }
                System.out.println("Ulige tal fra 0 til 99 blev skrevet til filen.");
            }


        } catch (IOException e) {
            System.out.println("Der opstod en fejl: " + e.getMessage());
        }

    }
}
