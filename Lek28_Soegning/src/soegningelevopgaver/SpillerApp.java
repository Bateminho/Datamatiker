package soegningelevopgaver;

import java.util.ArrayList;

public class SpillerApp {

    public static Spiller findScoreLinear(ArrayList<Spiller> spillere, int score) {
        Spiller spiller = null;
        int i = 0;
        while (spiller == null && i < spillere.size()) {
            Spiller k = spillere.get(i);
            if (k.getMaal() == score) {
                spiller = k; // Match fundet
            } else {
                i++;
            }
        }
        return spiller; // Returnér null, hvis ingen spiller matcher scoren
    }

    public static Spiller findScoreBinær(ArrayList<Spiller> spillere, int score) {
        Spiller spiller = null;
        int left = 0;
        int right = spillere.size() - 1;

        while (spiller == null && left <= right) {
            int middle = (left + right) / 2;
            Spiller s = spillere.get(middle);

            if (s.getMaal() == score) {
                return s;
            } else if (s.getMaal() < score) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return spiller;
    }

    public static String godSpiller(ArrayList<Spiller> spillere) {
        String spillerMatch = "";
        int i = 0;
        while (spillerMatch.isEmpty() && i < spillere.size()) {
            Spiller k = spillere.get(i);
            if (k.getHoejde() < 170 && k.getMaal() > 50) {
                spillerMatch = k.getNavn(); // Match fundet
            } else {
                i++;
            }
        }
        return spillerMatch; // Returnér spillerens navn eller tom streng
    }

    public static void main(String[] args) {
        // Opgave 4.1
        System.out.println("Opgave 4.1");
        ArrayList<Spiller> spillerListe = new ArrayList<>();
        spillerListe.add(new Spiller("Hans", 196, 99, 45));
        spillerListe.add(new Spiller("Bo", 203, 89, 60));
        spillerListe.add(new Spiller("Jens", 188, 109, 32));
        spillerListe.add(new Spiller("Finn", 194, 102, 12));
        spillerListe.add(new Spiller("Lars", 192, 86, 35));
        spillerListe.add(new Spiller("Mads", 200, 103, 37));

        System.out.println("Spiller der har scoret 35 mål: " + findScoreLinear(spillerListe, 35));
        System.out.println("Spiller der har scoret 30 mål: " + findScoreLinear(spillerListe, 30));

        // Opgave 4.2
        System.out.println("\nOpgave 4.2");
        ArrayList<Spiller> spillerListe2 = new ArrayList<>();
        spillerListe2.add(new Spiller("Bo", 203, 89, 60));
        spillerListe2.add(new Spiller("Hans", 196, 99, 45));
        spillerListe2.add(new Spiller("Mads", 200, 103, 37));
        spillerListe2.add(new Spiller("Lars", 192, 86, 35));
        spillerListe2.add(new Spiller("Jens", 188, 109, 32));
        spillerListe2.add(new Spiller("Finn", 194, 102, 12));

        // Sortér listen i aftagende orden efter målscore
        spillerListe2.sort((s1, s2) -> Integer.compare(s2.getMaal(), s1.getMaal()));

        System.out.println("Spiller der har scoret 35 mål: " + findScoreBinær(spillerListe2, 35));
        System.out.println("Spiller der har scoret 37 mål: " + findScoreBinær(spillerListe2, 37));

        // Opgave 4.3
        System.out.println("\nOpgave 4.3");
        ArrayList<Spiller> spillerListe3 = new ArrayList<>();
        spillerListe3.add(new Spiller("Hans", 196, 99, 45));
        spillerListe3.add(new Spiller("Bo", 203, 89, 60)); // Matcher kriterierne
        spillerListe3.add(new Spiller("Mads", 169, 103, 55)); // Matcher kriterierne
        spillerListe3.add(new Spiller("Lars", 192, 86, 35));
        spillerListe3.add(new Spiller("Jens", 188, 109, 32));
        spillerListe3.add(new Spiller("Finn", 194, 102, 12));

        String result = godSpiller(spillerListe3);
        if (!result.isEmpty()) {
            System.out.println("En spiller der er under 170 cm høj og har scoret over 50 mål: " + result);
        } else {
            System.out.println("Ingen spiller opfylder kriterierne.");
        }
    }
}
