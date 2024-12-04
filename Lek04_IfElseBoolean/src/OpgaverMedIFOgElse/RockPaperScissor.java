package OpgaverMedIFOgElse;

import java.util.Scanner;

public class RockPaperScissor {
    public static void main(String[] args) {

        Scanner inputScan = new Scanner(System.in);
        String continueGame;

        do {
            System.out.println("\nScissor (0), rock (1), paper (2): ");
            int move = inputScan.nextInt();

            String playerMove = sign(move);
            int random = (int) (Math.random() * 3);
            String computerMove = sign(random);

            String decision = referee(move, random);

            System.out.printf("The computer is %s. You are %s. %s\n", computerMove, playerMove, decision);

            // Spørg brugeren, om de vil spille igen
            System.out.println("\nDo you want to play again? (y/n): ");
            continueGame = inputScan.next();
        } while (continueGame.equalsIgnoreCase("y"));

        System.out.println("Thanks for playing!");
    }

    public static String sign(int move) {
        return switch (move) {
            case 0 -> "scissor";
            case 1 -> "rock";
            case 2 -> "paper";
            default -> "";
        };
    }

    public static String referee(int move, int random) {

        String result;

        if ((move == 0 && random == 1) || (move == 1 && random == 2) || (move == 2 && random == 0)) {
            result = "Computer Win";
        } else if ((move == 0 && random == 2) || (move == 1 && random == 0) || (move == 2 && random == 1)) {
            result = "You Win";
        } else result = "It is a draw";

        return result;
    }
}
