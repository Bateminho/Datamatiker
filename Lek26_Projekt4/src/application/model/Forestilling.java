package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Forestilling {
    private String navn;
    private LocalDate startDato;
    private LocalDate slutDato;
    private ArrayList<Bestilling> bestillinger = new ArrayList<>();
    private boolean erLedig;

    public Forestilling (String navn, LocalDate startDato, LocalDate slutDato) {
        this.navn = navn;
        this.startDato = startDato;
        this.slutDato = slutDato;

    }

    public String toString(){
        return navn + " (fra " + slutDato + " til " + startDato;
    }

    public String getNavn() {
        return navn;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public ArrayList<Bestilling> getBestillinger() {
        return new ArrayList<>(bestillinger);
    }

    public Bestilling createBestilling(LocalDate dato, Kunde kunde){
        Bestilling bestilling = new Bestilling(dato, kunde);
        this.bestillinger.add(bestilling);
        bestilling.setForestilling(this);
        return bestilling;
    }


    public boolean erPladsLedig(int række, int nr, LocalDate dato){
        boolean result = true;
        for (Bestilling b : bestillinger){
            if (b.getDato() == dato)
                for (Plads p : b.getPladser()){
                    if (p.getNr() == nr && p.getRække() == række && result){
                        result = false;
                }
            }
        }
        return result;
    }

    public int antalBestiltePladserPåDag(LocalDate dato){
        int result = 0;
        for (Bestilling b : bestillinger){
            if (b.getDato().equals(dato)){
                result += b.getPladser().size();
            }
        }
        return result;
    }

    public LocalDate succesDato(){

        LocalDate result = null;
        int maxPladser = 0;

        for (Bestilling bestilling : bestillinger) {
            LocalDate dato = bestilling.getDato();
            int antalPladser = antalBestiltePladserPåDag(dato);

            if (antalPladser > maxPladser) {
                maxPladser = antalPladser;
                result = dato;
            }

        }

        return result;
    }
}
