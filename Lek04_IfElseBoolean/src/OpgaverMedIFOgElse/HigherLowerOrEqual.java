package OpgaverMedIFOgElse;

import java.util.Scanner;

public class HigherLowerOrEqual {

    public static void main(String[] args) {

        //Import and Init Scanner
        Scanner inputScan = new Scanner(System.in);
        String continueInput = "y";

        while (continueInput.equalsIgnoreCase("y")) {
            //Prompt user for one number
            System.out.println("Enter either a positiv or negavtiv integer.");

            //Variable for scanned number
            int number = inputScan.nextInt();

            System.out.println(sign(number));

            System.out.println("\nDo you want to try again (y/n)");

            continueInput = inputScan.next();

        }

    }

    public static String sign(int number) {

        String result;

        if (number > 0) {
           result = "Your number is positiv!";

        } else if (number < 0) {
            result = "Your number is negativ!";
        }
        else result = "Your number is nul!";

        return result;
    }

}
