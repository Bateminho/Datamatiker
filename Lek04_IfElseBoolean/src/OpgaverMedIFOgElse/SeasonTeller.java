package OpgaverMedIFOgElse;

import java.util.Scanner;

public class SeasonTeller {
    public static void main(String[] args) {

        Scanner inputScan = new Scanner(System.in);
        System.out.println("\nThis program takes a date by month and day and tells you which season it is.");
        System.out.println("\nInput month as an integer: ");
        int month = inputScan.nextInt();
        System.out.println("\nInput day of the month as an integer: ");
        int day = inputScan.nextInt();

        System.out.println(seasonDescriber(month, day));


    }

    public static String seasonDescriber(int month, int day) {

        String result;

        if ( month <= 3) {
            result = "\n1The season is Winter!";
            if (month % 3 == 0 && day >= 21) {
                result = "\nThe season is Spring!";
            }
        } else if (month <= 6) {
            result = "\nThe season is Spring!";
            if (month % 3 == 0 && day >= 21) {
                result = "\nThe season is Sommer!";
            }
        } else if (month <= 9) {
            result = "\nThe season is Sommer!";
            if (month % 3 == 0 && day >= 21) {
                result = "\nThe season is Fall!";
            }
        } else {
            result = "\nThe season is Fall!";
            if (month % 3 == 0 && day >= 21) {
                result = "\nThe season is Winter!";
            }
        }

        return result;
    }
}
