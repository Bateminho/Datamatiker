
package opgave4;

import java.util.ArrayList;

public class AppHund {
    public static void main(String[] args) {
        Hund h1 = new Hund("Fenja", true, 1000, Race.PUDDEL);
        Hund h2 = new Hund("Bølle", true, 1500, Race.BOKSER);
        Hund h3 = new Hund("King", false, 1000, Race.TERRIER);
        Hund h4 = new Hund("Vaps", true, 2000, Race.BOKSER);
        Hund h5 = new Hund("Gizmo", true, 1000, Race.PUDDEL);

        ArrayList<Hund> hunde = new ArrayList<>();

        hunde.add(h1);
        hunde.add(h2);
        hunde.add(h3);
        hunde.add(h4);
        hunde.add(h5);

        System.out.println("\nDen samlede pris for hunde af racen Bokser er: " + samletPris(hunde, Race.BOKSER));
    }

    public static int samletPris(ArrayList<Hund> hunde, Race _race) {
        int resultatSamletPris = 0;

        for (Hund hund : hunde) {
            if (hund.getRace() == _race) { // Tjekker om hundens race matcher
                resultatSamletPris += hund.getPrice();
            }
        }

        return resultatSamletPris;
    }
}


