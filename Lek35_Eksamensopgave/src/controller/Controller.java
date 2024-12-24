package controller;

import model.*;
import storage.Storage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Controller {

    public static Sælger createSælger(String navn, int studieKortNummer, String mobil) {
        Sælger sælger = new Sælger(navn, studieKortNummer, mobil);
        Storage.addSælger(sælger);
        return sælger;
    }

    public static ArrayList<Sælger> getSælgere() {
        return Storage.getSælgere();
    }

    public static ArrayList<Salgsannonce> getAktiveSalgannoncer() {
        ArrayList<Salgsannonce> aktiveAnnoncer = new ArrayList<>();
        for (Sælger sælger : Storage.getSælgere()) {
            for (Salgsannonce annonce : sælger.getSalgsannoncer()) {
                if (annonce.isAktiv()) {
                    aktiveAnnoncer.add(annonce);
                }
            }
        }
        // Sortér annoncerne efter nummer
        aktiveAnnoncer.sort((a1, a2) -> Integer.compare(a1.getAnnonceNummer(), a2.getAnnonceNummer()));
        return aktiveAnnoncer;
    }


    public static Vare createVare(Varekategori kategori, String navn, int udbudspris) {
        Vare vare = new Vare(kategori, navn, udbudspris);
        Storage.addVare(vare);
        return vare;
    }

    public static ArrayList<Vare> getVare() {
        return Storage.getVare();
    }


    public static Salg createSalg(String købersnavn, int aftalteSamletPris, ArrayList<Vare> varer) {
        Salg salg = new Salg(købersnavn, aftalteSamletPris, varer);
        Storage.addSalg(salg);
        return salg;
    }

    public static ArrayList<Salg> getSalg() {
        return Storage.getSalg();
    }


    public static void salgTilFil(String filnavn) {
        String filePath = "C:\\Users\\Sean\\Documents\\Uddannelse\\Datamatiker\\1. semester\\Programmering\\textfiler\\" + filnavn + ".txt";

        try {
            File file = new File(filePath);

            if (file.createNewFile()) {
                System.out.println("Filen blev oprettet: " + file.getName());
            } else {
                System.out.println("Filen eksisterer allerede.");
            }

            try (PrintWriter printWriter = new PrintWriter(file)) {
                // Hent alle salgene
                ArrayList<Salg> salgListe = new ArrayList<>(Storage.getSalg());

                // Sortér salgene efter købers navn med insertion sort
                insertionSortArrayList(salgListe);

                // Skriv hvert salg til filen
                for (Salg salg : salgListe) {
                    printWriter.println(salg.getKøbersNavn() + ":");

                    int samletUdbudspris = 0;
                    for (Vare vare : salg.getVarer()) {
                        samletUdbudspris += vare.getUdbudspris();
                    }

                    // Beregn rabat
                    int rabat = samletUdbudspris - salg.getAftaltSamletPris();
                    // Skriv aftalt pris og rabat
                    printWriter.println("Aftalt pris: " + salg.getAftaltSamletPris() + "  rabat er: " + rabat);
                    printWriter.println(); // Ekstra linjeskift mellem salgene
                }

               System.out.println("Salgsdata blev skrevet til filen: " + file.getName());
            }

        } catch (IOException e) {
            System.out.println("Der opstod en fejl: " + e.getMessage());
        }
    }


    // Insertion sort til ArrayList
    public static void insertionSortArrayList(ArrayList<Salg> salgListe) {
        for (int i = 1; i < salgListe.size(); i++) {
            Salg next = salgListe.get(i);
            int j = i - 1;

            // Flyt elementer, der er større end 'next', en plads frem
            while (j >= 0 && salgListe.get(j).getKøbersNavn().compareToIgnoreCase(next.getKøbersNavn()) > 0) {
                salgListe.set(j + 1, salgListe.get(j));
                j--;
            }
            // Placer 'next' på den korrekte plads
            salgListe.set(j + 1, next);
        }
    }

    public static ArrayList<Sælger> sælgerDerharKøbt() {

        ArrayList<Sælger> sælgere = new ArrayList<>(Storage.getSælgere());
        ArrayList<Salg> salg = new ArrayList<>(Storage.getSalg());

        ArrayList<Sælger> result = new ArrayList<>();

//        sælgere.sort((s1, s2) -> s1.getNavn().compareToIgnoreCase(s2.getNavn()));
//        salg.sort((s1, s2) -> s1.getKøbersNavn().compareToIgnoreCase(s2.getKøbersNavn()));

        int i1 = 0; // Index for l1
        int i2 = 0; // Index for l2

        while (i1 < sælgere.size() && i2 < salg.size()) {
            int comparison = sælgere.get(i1).getNavn().compareTo(salg.get(i2).getKøbersNavn());
            if (comparison == 0) {
                // Sælger er i begge lister tilføj sælger
                result.add(sælgere.get(i1));
                i1++;
                i2++;
            } else if (comparison < 0) {
                // Sælger har ikke købt noget
                i1++;
            } else {
                i2++;
            }
        }

        return result;
    }


    public static void initStorage() {

        Sælger viktor = createSælger("Viktor", 23, "45344247");
        Sælger gustav = createSælger("Gustav", 35, "56124522");

        Vare samsungMobil = createVare(Varekategori.MOBILTELEFON, "Samsung mobil", 1200);
        Vare iPhoneMobil = createVare(Varekategori.MOBILTELEFON, "IPhone", 2000);
        Vare javaBog = createVare(Varekategori.STUDIEBOG, "Java", 400);
        Vare androidBog = createVare(Varekategori.STUDIEBOG, "Android", 300);
        Vare pythonBog = createVare(Varekategori.STUDIEBOG, "Python", 200);
        Vare regnjakke = createVare(Varekategori.TØJ, "Regnjakke", 100);
        Vare regnbukser = createVare(Varekategori.TØJ, "Regnbukser", 80);

        // Opret salgsannoncer for Viktor
        Salgsannonce salgsannonce1 = viktor.createSalgsannoce(viktor);
        salgsannonce1.addVare(samsungMobil);

        Salgsannonce salgsannonce2 = viktor.createSalgsannoce(viktor);
        salgsannonce2.addVare(javaBog);
        salgsannonce2.addVare(androidBog);
        salgsannonce2.addVare(pythonBog);

        // Opret salgsannoncer for Gustav
        Salgsannonce salgsannonce3 = gustav.createSalgsannoce(gustav);
        salgsannonce3.addVare(iPhoneMobil);

        Salgsannonce salgsannonce4 = gustav.createSalgsannoce(gustav);
        salgsannonce4.addVare(regnjakke);
        salgsannonce4.addVare(regnbukser);

        ArrayList<Vare> stinesVarer = new ArrayList<>();
        stinesVarer.add(androidBog);
        stinesVarer.add(pythonBog);

        Salg stine = createSalg("Stine", 450, stinesVarer);
        Storage.addSalg(stine);
        ArrayList<Vare> laurasVarer = new ArrayList<>();
        laurasVarer.add(regnjakke);
        laurasVarer.add(regnbukser);

        Salg laura = createSalg("Laura", 120, laurasVarer);
        Storage.addSalg(laura);

    }


}