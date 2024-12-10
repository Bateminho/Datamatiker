package opgave5_inputFromFileToArrayLIst;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadFromFIleToArrayList {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Sean\\Documents\\Uddannelse\\Datamatiker\\1. semester\\Programmering\\opgave4.txt";

        try {
            File file = new File(filePath);

            try (Scanner scanner = new Scanner(file)) {
                System.out.println("Tallene fra filen indlæses og udskrives bagfra");
                ArrayList<Integer> numbers = new ArrayList<>();

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();

                    try {
                        int number = Integer.parseInt(line);
                        numbers.add(number);
                    } catch (NumberFormatException e) {
                        System.out.println("Ugyldig linje, kunne ikke konverteres til et tal: " + line);
                    }
                }

                for (int i = numbers.size() - 1; i >= 0; i--) {
                    System.out.println(numbers.get(i));
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("Filen blev ikke fundet: " + e.getMessage());
        }
    }
}
