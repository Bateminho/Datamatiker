package twodice;


import java.util.Arrays;
import java.util.Scanner;

public class RollTwoDice {
    private static int rollCount = 0;
    private static int totalSum = 0;
    private static int sameFacesTotal = 0;
    private static int highestMax = 0;
    private static final int[] countEyes = new int[6];


    public static void main(String[] args) {
        System.out.println("\nWelcome to the game of Roll two Dices");
        printRules();

        playTwoDice();

        System.out.println();
        System.out.println("\nThank you for playing Roll two Dices");
    }

    private static void printRules() {
        System.out.println("\n=====================================================");
        System.out.println("Rules of Roll two Dices:");
        System.out.println("The player throws two dice as long as he/she wants.");
        System.out.println("The program will show the faces of the dice and the sum of faces");
        System.out.println("\nTo end games type 'n' followed by Enter to finish");
        System.out.println("=====================================================");
    }

    public static void playTwoDice() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nPress Enter to roll! ");
        String answer = scanner.nextLine();
        while (!answer.equals("n")) {
            int[] arrayFaces = rollDice();

            System.out.println();
            System.out.printf("Eyes: " + Arrays.toString(arrayFaces));
            System.out.println();

            updateStatistics(arrayFaces);

            System.out.print("\nPress Enter to roll next: ");
            answer = scanner.nextLine();
        }

        printStatistics();
        scanner.close();
    }


    private static void updateStatistics(int[] array) {
        rollCount++;
        totalSum = totalSum + array[0] + array[1];

        if (array[0] == array[1]) {
            sameFacesTotal++;
        }

        if (totalSum > highestMax)
            highestMax = totalSum;

        countEyes[array[0] - 1]++;
        countEyes[array[1] - 1]++;
     }



    private static int[] rollDice() {

        int[] faces = new int[2];

        for (int i = 0; i < faces.length; i++)
            faces[i] = (int) (Math.random() * 6 + 1);
        return faces;
    }


    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%17s %4d\n", "Roll count:", rollCount);
        System.out.println("The total sum of dice is: " + totalSum );
        System.out.printf("Times the dice have shown the same faces: %d", sameFacesTotal);
        System.out.printf("\nThe higest sum of the faces is: %d", highestMax);
        for (int i = 0; i < countEyes.length; i++) {
            System.out.printf("\nYou have thrown a %d: %d times", (i+1), countEyes[i]);

        }
    }

}
