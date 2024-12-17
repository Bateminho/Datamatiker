package controller;

import model.*;
import storage.Storage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {

    public static Studerende createStuderende(String navn, String email) {
        Studerende studerende = new Studerende(navn, email);
        Storage.addStuderende(studerende);
        return studerende;
    }

    public static ArrayList<Studerende> getStuderende() {
        return Storage.getStuderende();
    }


    public static Fag createFag(String navn, String klasse) {
        Fag fag = new Fag(navn, klasse);
        Storage.addFag(fag);
        return fag;
    }

    public static ArrayList<Fag> getFag() {
        return Storage.getFagsliste();
    }

    public static Lektion createLektion(LocalDate dato, LocalTime startTid, String lokale) {
        return new Lektion(dato, startTid, lokale);
    }

    public static void opretDeltagelser(Fag fag, Studerende studerende) {

        //Iterér over fagets lektioner:

        //Metoden fag.getLektioner() returnerer en liste over alle lektioner i faget.
        //Opret Deltagelse-objekter:

        //For hver lektion oprettes en Deltagelse med standardværdierne false for registreret og TILSTEDE for status.
        //Dette sikres ved at bruge lektion.createDeltagelse(false, DeltagerStatus.TILSTEDE).
        //Knyt deltagelse til den studerende:

        //Hver Deltagelse bliver koblet til den specifikke Studerende med deltagelse.setStuderende(studerende).

        // Gennemgå alle lektioner i faget
        for (Lektion lektion : fag.getLektioner()) {
            // Opret en Deltagelse med registreret=false og status=TILSTEDE
            Deltagelse deltagelse = lektion.createDeltagelse(false, DeltagerStatus.TILSTEDE);
            // Knyt deltagelsen til den studerende
            deltagelse.setStuderende(studerende);
        }
    }


    public static ArrayList<Studerende> studerendeTilObservation(int grænse) {
        ArrayList<Studerende> result = new ArrayList<>();

        for (Studerende studerende : Storage.getStuderende()) {
            if (studerende.antalFraværsLektioner() >= grænse) {
                result.add(studerende);
            }
        }

        insertionSortArrayList(result);

        return result;

    }

    public static void insertionSortArrayList(ArrayList<Studerende> list) {
        for (int i = 1; i < list.size(); i++) {
            Studerende next = list.get(i);
            int j = i;
            boolean found = false;

            while (!found && j > 0) {
                if (next.getNavn().compareTo(list.get(j - 1).getNavn()) >= 0) {
                    found = true; // Placering fundet
                } else {
                    list.set(j, list.get(j - 1)); // Flyt elementet til højre
                    j--;
                }
            }

            list.set(j, next); // Placer elementet korrekt
        }
    }

    public static void fraværOmgængere(String[] omgængere, ArrayList<Studerende> megetFravær, String filnavn) {


        String filePath = "C:\\Users\\Sean\\Documents\\Uddannelse\\Datamatiker\\1. semester\\Programmering\\textfiler\\testOpgave.txt";

        try {
            File file = new File(filePath);

            if (file.createNewFile()) {
                System.out.println("Filen blev oprettet: " + file.getName());
            } else {
                System.out.println("Filen eksisterer allerede.");
            }

            try (PrintWriter printWriter = new PrintWriter(file)) {
                printWriter.println("Navn og antal fraværslektioner:");

                int i1 = 0; // Index for megetfravær
                int i2 = 0; // Index for omgængere

                while (i1 < megetFravær.size() && i2 < omgængere.length) {
                    int comparison = megetFravær.get(i1).getNavn().compareTo(omgængere[i2]);
                    if (comparison == 0) {
                        // Studerende er i begge lister add studerende til resultat.
                        printWriter.println(megetFravær.get(i1));
                        i1++;
                        i2++;

                    } else if (comparison < 0) {
                        // Studerende findes ikke i listen
                        i1++;

                    } else {
                        // Studerende i l2 er ikke i l1, gå videre i l2
                        i2++;
                    }
                }


                System.out.println("Ulige tal fra 0 til 99 blev skrevet til filen.");
            }


        } catch (IOException e) {
            System.out.println("Der opstod en fejl: " + e.getMessage());
        }

    }


    public static void initStorage() {
       Studerende peter = createStuderende("Peter Hansen", "ph@stud.dk");
       Studerende tina = createStuderende("Tina Jensen", "tj@stud.dk");
       Studerende sascha = createStuderende("Sascha Petersen", "sp@stud.dk");

        Fag pro1_20s = createFag("PRO1", "20S");
        Fag pro1_20t = createFag("PRO1", "20T");
        Fag su1_20s = createFag("SU1", "20S");

       pro1_20s.addLektion(createLektion(LocalDate.of(2021, 2, 1), LocalTime.of(8, 30), "A1.32"));
       pro1_20s.addLektion(createLektion(LocalDate.of(2021, 2, 1), LocalTime.of(10, 30), "A1.32"));
       pro1_20s.addLektion(createLektion(LocalDate.of(2021, 2, 3), LocalTime.of(8, 30), "A1.32"));
       pro1_20s.addLektion(createLektion(LocalDate.of(2021, 2, 3), LocalTime.of(10, 30), "A1.32"));

        // Tilføj deltagelser for hver studerende
        opretDeltagelser(pro1_20s, peter);
        opretDeltagelser(pro1_20s, tina);
        opretDeltagelser(pro1_20s, sascha);
    }
}
