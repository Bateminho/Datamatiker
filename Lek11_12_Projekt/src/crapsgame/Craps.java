package crapsgame;

import java.util.Scanner;

public class Craps {
    //Variables to track total of wins and losses
    private static int wins = 0;
    private static int losses = 0;

    public static void main(String[] args) {
        System.out.println("\nWelcome to Craps");

        printRules();

        playCrabs();

        printStatistics();

        System.out.println("\n\nThank you for playing Craps");

    }

    private static void printRules() {
        System.out.println("\n=====================================================");
        System.out.println("Rules for Craps:");
        System.out.println("On first throw:\nPlayer throws two dice.");
        System.out.println("Player wins if the total of eyes sums to 7 or 11");
        System.out.println("PLayer loses if the total of eyes sums to 2, 3 or 12.");
        System.out.println("All other sums gives the player a points tally.");
        System.out.println("\nOn second or consecutively throws:\nPlayer wins if total of eyes = point tally");
        System.out.println("Player loses if the sum of eyes = 7");
        System.out.println("Player keeps throwing until player wins or loses");
        System.out.println("=====================================================");
    }


    public static void playCrabs() {
        Scanner inputScan = new Scanner(System.in);
        String answer;
        System.out.print("\nPress 'y' than Enter to roll or 'n' than Enter to quit");

        //Do While loop that keeps looping the game until players stops the game by pressing 'n'
        do {
            answer = inputScan.nextLine();

            //Returns game if n is entered
            if (answer.equals("n")) {
                System.out.println("\nYou chose no - Game terminates");
                return;
            }

            //Array for to random dice plus to of point
            int[] arrayDices = rollDice();
            int point = arrayDices[0] + arrayDices[1];

            System.out.printf("First throw:\nFirst dice: %d\nSecond dice %d\nPoints = %d", arrayDices[0], arrayDices[1], point);

            //Game won if 7 or 11. Prints win and returns
            if (point == 7 || point == 11) {
                System.out.println("\nCongrats!!! You have won the game!!!");
                System.out.print("\nDo you want to play again?\nPress 'y' for yes or 'n' to quit: ");
                wins++;
                continue;
            }

            //Game lost if 2,3 12. Print los and return
            else if (point == 2 || point == 3 || point == 12) {
                System.out.println("\nOh no... You lost - Sorry buddy.");
                System.out.print("\nDo you want to play again?\nPress 'y' for yes or 'n' to quit: ");
                losses++;
                continue;
            }



            // A boolean variable is declared to store the returned value from the rollForPoint method.
            boolean won = rollForPoint(point, inputScan);

            //If value returned from method = true, player have won if false player have lost
            if (won) {
                System.out.printf("\nCongrats - you hit your points %d and have won the game!!!", point);
                wins++;
            }
            else {
                System.out.println("\nSorry - you rolled a 7 and have now lost.");
                losses++;
            }
            // Ask player if player wants to play again
            System.out.print("\nDo you want to play again?\nPress 'y' for yes or 'n' to quit: ");


        } while (true);
    }


     public static boolean rollForPoint(int point, Scanner inputScan) {
        System.out.println();
        System.out.printf("\nYou now need to roll %d to win, but avoid rolling a 7!\n", point);

        // Variable to hold the new sum of dice to be compared with the players points
        int sum;

        //New do while loop to keep looping until player has won or lost.
        do {
            System.out.print("\nPress Enter to roll the dice!");
            inputScan.nextLine();

            int[] arrayDice = rollDice();
            sum = arrayDice[0] + arrayDice[1];
            System.out.printf("\nNext throw:\nFirst dice: %d\nSecond dice: %d\nWhich sums to %d.\n", arrayDice[0], arrayDice[1], sum);


        } while (sum != point && sum != 7);

        // Return true if sum == point!! else false!
        return sum == point;
    }


    private static int[] rollDice() {

        int[] faces = new int[2];

        for (int i = 0; i < faces.length; i++)
            faces[i] = (int) (Math.random() * 6 + 1);
        return faces;
    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("----------------------------------");
        System.out.printf("\nAmount of games you won: %d", wins);
        System.out.printf("\nAmount of games you lost: %d",losses);
        System.out.println("\n----------------------------------");

    }

}





