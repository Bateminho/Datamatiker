package opgave3GameClass;

import java.net.SocketTimeoutException;

public class TeamApp {
    public static void main(String[] args) {
        Player p1 = new Player("Sean", 41);

        System.out.println("The playes name is: " + p1.getName());
        System.out.println("The players age is: " + p1.getAge());
        System.out.println("The players score is: " + p1.getScore());

        p1.setScore(100);
        System.out.println("\nThe player is given 100 points");
        System.out.println("The players score is: " + p1.getScore());
        p1.addScore(150);

        System.out.println("\nThe player has added 150 points");
        System.out.println("The players score is: " + p1.getScore());


        Team t1 = new Team("De bedste");

        Player p2 = new Player("Carlos", 40);
        p2.setScore(200);

        Player p3 = new Player("Kasper", 41);
        p3.setScore(220);

        System.out.println("-------------------------------------------------------------");
        System.out.println();

        t1.addPlayer(p1);
        t1.addPlayer(p2);
        t1.addPlayer(p3);

        t1.printPlayers();


        System.out.printf("\nSpillerne gennemsnitsalder er: %.02f ", t1.calcAverageAge());

        System.out.println("\nSpillernes totale score er: " + t1.calcTotalScore());

        System.out.println("\nDen samlede score fra de ældste spillere er: " + t1.calcOldPlayersScore(41));

        System.out.println("\nMax scoren blandt spillerne er: " + t1.maxScore());

        System.out.println("\nNavnet på spilleren med max scoren er: " + t1.bestPlayer());
    }
}
