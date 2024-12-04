package rental;


import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;



public class RentalApp {
    public static void main(String[] args) {
        Rental r1 = new Rental(1, 3, 300, LocalDate.of(2024, 11, 1));
        Rental r2 = new Rental(2, 3, 300, LocalDate.now().plusMonths(10));


        r1.printRentalInfo();
        r2.printRentalInfo();

        System.out.println("Udskriv den totale pris, slutdatoen og dagen før startdatoen for hver af udlejningerne.");
        System.out.println("\nRental 1");
        System.out.println(r1.getTotalPrice());
        System.out.println(r1.getEndDate());
        System.out.println(r1.getEndDate().minusDays(1));

        System.out.println("\nRental 2");
        System.out.println(r2.getTotalPrice());
        System.out.println(r2.getEndDate());
        System.out.println(r2.getEndDate().minusDays(1));

        System.out.println("\nUdskriv antallet af år, måneder og dage mellem startdatoen for den første udlejning og startdatoen på den anden udlejning.");

        Period p1 = Period.between(r1.getStartDate(), r2.getStartDate());

        System.out.println("Period between Rental1 and Rental2: " + p1.getYears() + " år, "
                + p1.getMonths() + " måneder, og "
                + p1.getDays() + " dage.");

        Duration duration = Duration.between(r1.getStartDate().atStartOfDay(), r2.getStartDate().atStartOfDay());
        long daysBetween = duration.toDays();

        System.out.println("\nAntal dage mellem Rental1 and Rental2: " + daysBetween + " dage.");



    }
}
