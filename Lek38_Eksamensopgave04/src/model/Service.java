package model;

import java.util.ArrayList;

public class Service {

    private ArrayList<PersonChip> personer;
    private ArrayList<Facilitet> faciliteter;
    private ArrayList<Gruppe> grupper;

    // Constructor
    public Service() {
        this.personer = new ArrayList<>();
        this.faciliteter = new ArrayList<>();
        this.grupper = new ArrayList<>();
    }

    public void opretPersonchip(int nr, String navn, int saldo, int alder) {
        PersonChip person = new PersonChip(nr, navn, saldo, alder);
        personer.add(person);
    }

    public void opretFacilitet(String navn, int minimumsalder, String aabningstid, int pris) {
        Facilitet facilitet = new Facilitet(navn, minimumsalder, aabningstid, pris);
        faciliteter.add(facilitet);
    }

    public void opretGruppe(int nr) {
        Gruppe gruppe = new Gruppe(nr);
        grupper.add(gruppe);
    }

    /**
     * Returnerer en sorteret ArrayList der indeholder alle
     * elementer fra både faciliteterTidligere og faciliteterNu.
     * Krav: faciliteterTidligere og faciliteterNu er sorterede og indeholder Faciliteter.
     */
    public static ArrayList<Facilitet> alleFaciliteter(ArrayList<Facilitet> faciliteterTidligere, ArrayList<Facilitet> faciliteterNu) {
        ArrayList<Facilitet> result = new ArrayList<>();
        int i1 = 0;
        int i2 = 0;

        // Flet så længe der er noget i begge lister
        while (i1 < faciliteterTidligere.size() && i2 < faciliteterNu.size()) {
            Facilitet facilitet1 = faciliteterTidligere.get(i1);
            Facilitet facilitet2 = faciliteterNu.get(i2);

            // Brug compareTo for at sammenligne faciliteterne
            if (facilitet1.compareTo(facilitet2) <= 0) {
                // facilitet1 er mindre eller lig med facilitet2, så tilføj facilitet1
                result.add(facilitet1);
                i1++;
            } else {
                // facilitet2 er mindre, så tilføj facilitet2
                result.add(facilitet2);
                i2++;
            }
        }

        // Tøm den liste, der ikke er tom
        while (i1 < faciliteterTidligere.size()) {
            result.add(faciliteterTidligere.get(i1));
            i1++;
        }

        while (i2 < faciliteterNu.size()) {
            result.add(faciliteterNu.get(i2));
            i2++;
        }

        return result;
    }


    public void createSomeObjects() {

       opretGruppe(1);

       opretPersonchip(1, "Peter", 200, 12);
       opretPersonchip(1, "Søren", 0, 35);
       opretPersonchip(3, "Camilla", 300, 15);

       opretFacilitet("Badeland", 3, "08.00-22.00", 0);
       opretFacilitet("Bowling", 10, "08.00-2200", 50);
       opretFacilitet("Billiard", 15, "08.00-2200", 75);

       // Tilføj personer til gruppe 1
       Gruppe gruppe1 = grupper.getFirst();
       gruppe1.addPersonChip(personer.getFirst());
       gruppe1.addPersonChip(personer.get(1));
       gruppe1.addPersonChip(personer.get(2));

       // Tilføj faciliteter til personer
       PersonChip p1 = personer.get(0);  // Peter
       PersonChip p2 = personer.get(1);  // Søren
       PersonChip p3 = personer.get(2);  // Camilla

       Facilitet badeland = faciliteter.get(0);  // Badeland
       Facilitet bowling = faciliteter.get(1);  // Bowling
       Facilitet billard = faciliteter.get(2);  // Billard

       // Peter vælger Badeland og Billard
       p1.addFacillitet(badeland);
       p1.addFacillitet(billard);

       // Søren vælger Badeland
       p2.addFacillitet(badeland);

       // Camilla vælger Badeland, Bowling og Billard
       p3.addFacillitet(badeland);
       p3.addFacillitet(bowling);
       p3.addFacillitet(billard);
    }
}
