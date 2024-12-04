package opgaver_02;

public class MilesPerHour {
    public static void main(String[] args) {
        double distance = 15;
        double time = 50.5;
        double minutes = 60;
        double kmtoomiles = 1.6;

        // Beregn hastigheden
        double speed = (distance / kmtoomiles) / time * minutes;

        // Udskriv hastigheden med to decimaler
        System.out.printf("The runner's avg running speed in miles is: %.2f miles per hour%n", speed);

    }
}
