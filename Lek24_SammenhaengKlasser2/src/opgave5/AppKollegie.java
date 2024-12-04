package opgave5;

import java.time.LocalDate;

public class AppKollegie {

    public static void main(String[] args) {
        Kollegie christianD10 = new Kollegie("Christian", "De Mezzasvej" );

        Bolig bolig = new Bolig(46, "Skovvangsvej 184", 3200);

        Lejeaftale lejeaftale = bolig.createLejeaftale(LocalDate.of(2024, 1,15));

        Lejer sean = new Lejer("Sean", "Studerende");
        Lejer katja = new Lejer("Katja", "Tandklinikassistent");

        christianD10.addBolig(bolig);

        lejeaftale.addLejer(sean);
        lejeaftale.addLejer(katja);


        System.out.println(christianD10);
        System.out.println();
        System.out.println(bolig);
        System.out.println();
        System.out.println(lejeaftale);

        System.out.println();
        lejeaftale.setTilDato(LocalDate.of(2024,12,31));
        System.out.println("Opdateret lejeaftale" + lejeaftale);
    }
}
