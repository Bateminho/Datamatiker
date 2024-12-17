package model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Fag {
    private String navn;
    private String klasse;

    //association --> 0..* Lektion
    private final ArrayList<Lektion> lektioner = new ArrayList<>();

    public Fag(String navn, String klasse) {
        this.navn = navn;
        this.klasse = klasse;
    }

    public String getKlasse() {
        return klasse;
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public String toString() {
        return this.navn + " " + this.klasse;
    }

    public ArrayList<Lektion> getLektioner() {
        return new ArrayList<>(lektioner);
    }

    public Lektion getMestFravær() {
        // Variabel til at holde lektionen med det højeste antal fravær
        Lektion mestFraværLektion = null;

        // Variabel til at holde det maksimale antal fravær, vi har fundet indtil nu
        int maxFravær = 0;

        // Gennemgå alle lektioner i dette fag
        for (Lektion lektion : lektioner) {

            // Variabel til at tælle antallet af registrerede fravær i den aktuelle lektion
            int fraværTæller = 0;

            // Gennemgå alle deltagelser i lektionen
            for (Deltagelse deltagelse : lektion.getDeltagelser()) {

                // Tjek om denne deltagelse er registreret som fraværende
                if (deltagelse.erRegisteretFraværende()) {
                    // Hvis ja, øg fraværstælleren
                    fraværTæller++;
                }
            }

            // Efter at have talt fraværet for denne lektion:
            // Tjek, om dette antal fravær er højere end det nuværende maksimum
            if (fraværTæller > maxFravær) {
                // Hvis ja, opdater det maksimale antal fravær
                maxFravær = fraværTæller;

                // Og sæt mestFraværLektion til at pege på denne lektion
                mestFraværLektion = lektion;
            }
        }

        // Når alle lektioner er gennemgået, returnér lektionen med mest fravær
        // Hvis ingen lektion havde registreret fravær, returneres null
        return mestFraværLektion;
    }



    public void addLektion(Lektion lektion) {
        if (!lektioner.contains(lektion)) {
            lektioner.add(lektion);
        }
    }

    public void removePerson(Lektion lektion) {
        if (lektioner.contains(lektion)) {
            lektioner.remove(lektion);
        }
    }

    public ArrayList<Studerende> sygdomPåDato(LocalDate dato) {

        ArrayList<Studerende> sygeStuderende = new ArrayList<>();

        // Gennemløber alle lektioner, der er tilknyttet dette fag
        // for at undersøge deltagelsen i alle lektioner for at finde syge
        for (Lektion lektion : lektioner) {

            // Henter alle deltagelser (studenteroptegnelser) for den aktuelle lektion
            // returnere en liste over Deltagelse-objekter
            for (Deltagelse deltagelse : lektion.getDeltagelser()) {

                // Tjekker, om status for denne deltagelse er "SYG"
                if (deltagelse.getStatus() == DeltagerStatus.SYG) {

                    // Henter den studerende, der er knyttet til denne deltagelse
                    Studerende studerende = deltagelse.getStuderende();

                    // Tjekker, om denne studerende allerede er på listen over syge studerende
                    if (!sygeStuderende.contains(studerende)) {

                        // Hvis den studerende ikke allerede er på listen, tilføjes vedkommende
                        sygeStuderende.add(studerende);
                    }
                }
            }
        }

        return sygeStuderende;
    }
}
