package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bestilling {

    private LocalDate dato;
    // linkattribut til kunde
    private Kunde kunde;
    //linkattribut til plads
    private ArrayList<Plads> pladser = new ArrayList<>();
    //linkattribut til forestilling
    private Forestilling forestilling;

    Bestilling (LocalDate dato, Kunde kunde) {
        this.dato = dato;
        this.kunde = kunde;
    }

    public LocalDate getBestilling() {
        return dato;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public Forestilling getForestilling() {
        return forestilling;
    }

    public ArrayList<Plads> getPladser() {
        return new ArrayList<>(pladser);
    }

    public void addPLads(Plads plads) {
        pladser.add(plads);
    }

    public Kunde getKunde() { return kunde; }

    public void setForestilling(Forestilling forestilling) {
        this.forestilling = forestilling;
    }

    public LocalDate getDato() {
        return dato;
    }
}
