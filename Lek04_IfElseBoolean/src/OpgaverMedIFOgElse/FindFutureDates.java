package OpgaverMedIFOgElse;

import java.util.Scanner;

public class FindFutureDates {
    public static void main(String[] args) {

        Scanner inputScan = new Scanner(System.in);

        System.out.println("\nThis program can predict a future day of the week");
        System.out.println("\nEnter today's day as an int, where Sunday is 0");
        int day = inputScan.nextInt();
        System.out.println("\nEnter the number of days elapsed since today: ");
        int futureDay = inputScan.nextInt();

        System.out.printf(predictFutureDay(day, futureDay));

    }

    // Method to show today's day and future day
    public static String predictFutureDay(int day, int futureDay) {
        String today = getDayName(day);
    //Compute future day
        String futureDayName = getDayName((day + futureDay) % 7);

        return String.format("\nToday is %s and the future day is %s\n", today, futureDayName);
    }

    public static String getDayName(int day) {
        return switch (day) {
            case 0 -> "Sunday";
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            default -> "";
        };
    }
}
