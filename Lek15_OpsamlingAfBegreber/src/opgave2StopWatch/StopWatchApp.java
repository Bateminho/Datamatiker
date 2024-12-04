package opgave2StopWatch;

import java.util.Scanner;

public class StopWatchApp {
    public static void main(String[] args) {

        Scanner inputScan = new Scanner(System.in);
        StopWatch stopWatch = new StopWatch();
        boolean start = false;

        String answer;
        System.out.println("\nDette er et stopur. Skriv 'Start' og enter for start.");
        answer = inputScan.nextLine();


        while (!start) {
            if (answer.equals("Start")) {
                stopWatch.start();
                System.out.println("Stopuret er startet!!");
                start = true;
            } else {
                System.out.println("Du skal skrive Start");
                answer = inputScan.nextLine();
            }
        }

        System.out.println("\nSkriv 'Stop' for at stoppe");
        answer = inputScan.nextLine();

        while (start) {
            if (answer.equals("Stop")) {
                stopWatch.stop();
                System.out.println("\nStopuret er stoppet!!");
                start = false;
            } else {
                System.out.println("Du skal skrive Stop for at stoppe!!");
                answer = inputScan.nextLine();
            }
        }

        System.out.println("Antal seconder der er gået: " + stopWatch.elapsedTime());


    }


}
