package dates;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class App2 {

    public static void main(String[] args) {
        // Forskellige måder at tildele en LocalDate en værdi
        LocalDate dat1 = LocalDate.now();
        System.out.println(dat1);
        LocalDate dat2 = dat1.plusMonths(3);
        System.out.println(dat2);
        LocalDate dat3 = LocalDate.of(2022, 01, 31);
        System.out.println(dat3.plusMonths(3));
        System.out.println();
        LocalDate dat4 = LocalDate.parse("2021-10-26");
        System.out.println(dat4);

        // Varigheden mellem to datoer
        Period per = dat1.until(dat2);
        long days = per.getDays();
        long months = per.getMonths();
        long years = per.getYears();

        System.out.println(
            "Fra " + dat1 + " til " + dat2 + " er der " + years + " år " + months + " måneder "
                + days + " dage");

        months = ChronoUnit.MONTHS.between(dat1, dat2);
        days = ChronoUnit.DAYS.between(dat1, dat2);
////
        System.out.println("Måneder: " + months);
        System.out.println("Dage: " + days);
////
////         LocalTime time1 = LocalTime.of(9, 15);
//         System.out.println(time1);
//         LocalTime time2 = LocalTime.now();
//         System.out.println(time2);
////
//         LocalDateTime dt = LocalDateTime.of(2021, 11, 3, 10, 15);
//         System.out.println(dt.toLocalDate());
//         System.out.println(dt.toLocalTime());
//
//         LocalDateTime fra = LocalDateTime.of(2021, 11, 8,8 ,0);
//         LocalDateTime til = LocalDateTime.of(2021, 11, 9,7 ,59);
//         System.out.println("dage mellem " + fra + " " + til + " " +ChronoUnit.DAYS.between(fra, til));
    }

}
