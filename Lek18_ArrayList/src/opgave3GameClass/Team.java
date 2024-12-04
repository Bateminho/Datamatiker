package opgave3GameClass;

import java.util.ArrayList;

public class Team {

    public String name;
    ArrayList<Player> players;

    Team(String _name) {
        name = _name;
        players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public double calcAverageAge() {
        double resultAvgAge = 0;

        for (Player playerAge : players) {
            resultAvgAge += playerAge.getAge();
        }
        return resultAvgAge/players.size();
    }

    public int calcTotalScore() {
        int resultTotalScore = 0;

        for (Player playerScore : players) {
            resultTotalScore += playerScore.getScore();
        }

        return resultTotalScore;
    }

    public int calcOldPlayersScore(int ageLimit) {

        int resultTotalScoreOldPlayers = 0;

        for (Player oldPlayers : players) {
            if (oldPlayers.getAge() >= ageLimit) {
                resultTotalScoreOldPlayers += oldPlayers.getScore();
            }
        }

        return resultTotalScoreOldPlayers;
    }

    public int maxScore() {

        int resultMaxScore = 0;

        for (Player playerMaxScore : players) {
            if (playerMaxScore.getScore() > resultMaxScore) {
                resultMaxScore = playerMaxScore.getScore();
            }
        }

        return resultMaxScore;
    }

    public String bestPlayer() {
        String resultBestPlayer = " ";

       int max = maxScore();

       for (Player bestPlayerName : players) {
           if (bestPlayerName.getScore() == max) {
               resultBestPlayer = bestPlayerName.getName();
           }
       }
       return resultBestPlayer;
    }

    public void printPlayers() {
        // Udskriv en header for at gøre det mere læsevenligt
        System.out.printf("%-15s %-5s %-6s%n", "Name", "Age", "Score");
        System.out.println("----------------------------");

        // Iterér over spillerne og udskriv deres detaljer
        for (Player player : players) {
            System.out.printf("%-15s %-5d %-6d%n", player.getName(), player.getAge(), player.getScore());
        }
    }

    public String toString(){
        return name;
    }

}
