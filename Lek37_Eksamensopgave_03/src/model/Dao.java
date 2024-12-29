package model;

import java.util.ArrayList;

public class Dao {
    private static final ArrayList<Medlem> medlemmer = new ArrayList<>();
    private static final ArrayList<Hold> alleHold = new ArrayList<>();

    public static void addMedlem(Medlem medlem) {
        if (!medlemmer.contains(medlem)) {
            medlemmer.add(medlem);
        }
    }

    public static void addHold(Hold hold) {
        if (!alleHold.contains(hold)) {
            alleHold.add(hold);
        }
    }

    public static ArrayList<Medlem> getMedlemmer() {
        return new ArrayList<>(medlemmer);
    }

    public static ArrayList<Hold> getAlleHold() {
        return new ArrayList<>(alleHold);
    }

    public static void indsætMedlem(Medlem medlem) {

        int i = 0;
        boolean inserted = false;

        //Find den korrekte posistion at indsætte medlemment
        while (!inserted && i < medlemmer.size()) {
            Medlem current = medlemmer.get(i);

            // Hvis det nye medlem skal placeres før det aktuelle medlem
            if (medlem.getNavn().compareTo(current.getNavn()) < 0) {
                medlemmer.add(i, medlem);
                inserted = true;
            } else {
                i++;
            }
        }

        // Hvis medlemmet skal indsættes i slutningen af listen
        if (!inserted) {
            medlemmer.add(medlem);
        }
    }

    public static void createSomeObjects() {
        // Opret to hold
        Hold hold1 = new Hold();
        hold1.setNavn("Fitness");
        hold1.setDisciplin("Styrketræning");
        hold1.setMaxAntal(10);

        Hold hold2 = new Hold();
        hold2.setNavn("Yoga");
        hold2.setDisciplin("Afslapning");
        hold2.setMaxAntal(5);

        addHold(hold1);
        addHold(hold2);

        // Opret fem medlemmer
        Medlem medlem1 = new Medlem("Anna", "Gade 1", "anna@mail.com", 12345678);
        Medlem medlem2 = new Medlem("Bent", "Gade 1", "bent@mail.com", 87654321);
        Medlem medlem3 = new Medlem("Cecilie", "Gade 3", "cecilie@mail.com", 11223344);
        Medlem medlem4 = new Medlem("David", "Gade 4", "david@mail.com", 44332211);
        Medlem medlem5 = new Medlem("Eva", "Gade 5", "eva@mail.com", 99887766);

        addMedlem(medlem1);
        addMedlem(medlem2);
        addMedlem(medlem3);
        addMedlem(medlem4);
        addMedlem(medlem5);

        // Tilmeld medlemmer til hold
        Tilmelding tilmelding1 = hold1.createTilmelding(true, true);
        tilmelding1.setMedlem(medlem1);

        Tilmelding tilmelding2 = hold1.createTilmelding(true, true);
        tilmelding2.setMedlem(medlem2);

        Tilmelding tilmelding3 = hold1.createTilmelding(true, false);
        tilmelding3.setMedlem(medlem3);

        Tilmelding tilmelding4 = hold2.createTilmelding(true, true);
        tilmelding4.setMedlem(medlem4);

        Tilmelding tilmelding5 = hold2.createTilmelding(true, false);
        tilmelding5.setMedlem(medlem5);
    }
}
