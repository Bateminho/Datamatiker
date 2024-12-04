package pigsgame;


import java.util.Arrays;
import java.util.Scanner;

public class Pigs {
    private static int player1Score = 0;
    private static int player2Score = 0;
    private static int gamePoint = 0;
    private static int player1Round = 0;
    private static int player1Throw = 0;
    private static double avgPlayer1 = 0;
    private static int player2Round = 0;
    private static int player2Throw = 0;
    private static double avgPlayer2 = 0;
    private static String player1 = "Player 1";
    private static String player2 = "Player 2";

    public static void main(String[] args) {
        System.out.println("\nWelcome to the game of Pig");
        printRules();
        playPig();
        updateStatistics();
        printStatistics();
        System.out.println();
        System.out.println("\nThank you for playing Pig");
    }

    private static void printRules() {
        System.out.println("\n========================================================================");
        System.out.println("Rules for Pig:");
        System.out.println("Pig is a two player game. The goal is to reach a desired amount of points");
        System.out.println("Player1 throws two dice where the eyes total = round score.");
        System.out.println("A player can stop his round or continue until the player either");
        System.out.println(" reaches the desired amount of points or busts.");
        System.out.println("A player busts if the eyes of one die is a 1 and turn changes hands");
        System.out.println("If both dice show [1, 1] all players points are lost");
        System.out.println("==========================================================================");
    }

    public static void gameSetup(Scanner inputScan) {

        System.out.println("\n*********** Game setup ***********");
        System.out.println("Enter name of player 1");
        player1 = inputScan.nextLine();
        System.out.println("Enter name of player 2");
        player2 = inputScan.nextLine();
        System.out.println("Enter the amount of points you want to play to");
        gamePoint = inputScan.nextInt();
        inputScan.nextLine();
        System.out.println("\nYou chose to play to " + gamePoint + " points");
        System.out.println("\n*********** Exiting game setup ***********");

    }

    public static void playPig() {
        Scanner inputScan = new Scanner(System.in);
        String answer;

       // do {
            gameSetup(inputScan);
            System.out.print("\nPress Enter to start! ");
            answer = inputScan.nextLine();

            if (answer.equals("n")) {
                System.out.println("\nYou chose no - Game terminates");
                return;
            }

            //Variable to hold players turn.
            int player = 1;

            //Play as long as playerScore < set amount
            while (player1Score < gamePoint && player2Score < gamePoint) {
                player = playerRoll(player, inputScan);

                if (player == 1) {
                    player1Round++;
                } else player2Round++;
            }

            if (player1Score >= gamePoint) {
                System.out.println("\n**** " + player1 + " wins!!! ****");
            } else {
                System.out.println("\n**** " + player2 + " wins!!! ****");
            }
      //  } while (true);

    }

    public static int playerRoll(int player, Scanner inputScan  ) {
        String answer ;
        int roundScore = 0;

        System.out.println("\n-------------------------------");
        if (player == 1) {
            System.out.println(player1 + "'s turn");
        } else {
            System.out.println(player2 + "'s turn");
        }

        System.out.println("-------------------------------");
        System.out.println("\nPress Enter to roll or 'n' to pass.");
        answer = inputScan.nextLine();

        while (!answer.equals("n")) {
            int[] dice = rollDice();
            int sumOfDice = dice[0] + dice[1];

            //Increase player throw for statistics
            if (player == 1) {
                player1Throw++;
            } else {
                player2Throw++;
            }

            // If dice shows 1,1 All players points are = 0 and turn lost
            if (dice[0] == 1 && dice[1] == 1) {
                System.out.printf("You rolled %s. Turn and all points lost!!!", Arrays.toString(dice));
                if (player == 1) {
                    player1Score = 0;
                } else {
                    player2Score = 0;
                }
                return (player == 1) ? 2 : 1;
            }
            // If one die is a 1, player turn lost
            else if (dice[0] == 1 || dice[1] == 1) {
                System.out.printf("You rolled %s. Turn lost.", Arrays.toString(dice));
                return (player == 1) ? 2 : 1;
            }
            // Else players point
            else {
                roundScore += sumOfDice;
                System.out.printf("Your score before this round was: %d", (player == 1) ? player1Score : player2Score);
                System.out.println("\nYou threw: " + Arrays.toString(dice));
                System.out.println("Your round score is: " + roundScore);
                System.out.printf("%s's total score so far: %d\n",
                        (player == 1) ? player1 : player2,
                        (player == 1) ? player1Score + roundScore : player2Score + roundScore);
                System.out.println("=================================");
            }

            // Check if the player has won after this throw
            if ((player == 1 && player1Score + roundScore >= gamePoint) || (player == 2 && player2Score + roundScore >= gamePoint)) {
                if (player == 1) {
                    player1Score += roundScore;
                } else {
                    player2Score += roundScore;
                }
                return player;
            }

            System.out.println("\nPress Enter to roll again or 'n' to end your turn.");
            answer = inputScan.nextLine();
        }

        // Update the total score when the player chooses to end his turn
        if (player == 1) {
            player1Score += roundScore;
        } else {
            player2Score += roundScore;
        }

        // Change turn to the other player
        return (player == 1) ? 2 : 1;
    }

    private static int[] rollDice() {
        int[] faces = new int[2];
        for (int i = 0; i < faces.length; i++) {
            faces[i] = (int) (Math.random() * 6 + 1);
        }
        return faces;
    }

    private static void updateStatistics() {

        avgPlayer1 = (double) player1Throw / player1Round;
        avgPlayer2 = (double) player2Throw / player2Round;
    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("------------------------------------------------------");
        System.out.printf("%s\nRounds: %d\nThrows: %d\nAverage throws pr. round: %.2f", player1, player1Round, player1Throw, avgPlayer1);
        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.printf("%s\nRounds: %d\nThrows: %d\nAverage throws pr. round: %.2f", player2, player2Round, player2Throw, avgPlayer2);
    }
}
