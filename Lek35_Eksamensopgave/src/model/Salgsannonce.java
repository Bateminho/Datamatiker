package model;


import java.time.LocalDate;
import java.util.ArrayList;

public class Salgsannonce {
    private static int antalAnnocer = 0;
    private int annonceNummer;
    private boolean aktiv;
    private LocalDate udløbsdato;

    private final Sælger sælger;
    // association --> 0..* Vare
    private ArrayList<Vare> varer = new ArrayList<>();


    public Salgsannonce(Sælger sælger) {
        antalAnnocer++;
        this.sælger = sælger;
        annonceNummer = antalAnnocer;
        udløbsdato = LocalDate.now().plusMonths(1);
        aktiv = true;
    }

    public int getAnnonceNummer() {
        return annonceNummer;
    }

    public LocalDate getUdløbsdato() {
        return udløbsdato;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public void deactivate() {
        aktiv = false;
    }

    public Sælger getSælger() {
        return sælger;
    }

    public ArrayList<Vare> getVarer() {
        return new ArrayList<>(varer);
    }

    public void addVare(Vare vare) {
       if(!varer.contains(vare)) {
           varer.add(vare);
           vare.setSalgsannonce(this);
       }

    }

    public void removeVare(Vare vare) {
        if (varer.contains(vare)) {
            varer.remove(vare);
            vare.setSalgsannonce(null);
        }
    }

    public int samletAnnonceUdbud() {
        int samletPris = 0;

        for (Vare udbudspris : varer) {
            samletPris += udbudspris.getUdbudspris();
        }

        return samletPris;
    }

}
