package application.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Kunde {
    private String navn;
    private String mobil;
    private ArrayList<Bestilling> bestillinger = new ArrayList<>();
    private LocalDate date;


    public Kunde (String navn, String mobil) {
        this.navn = navn;
        this.mobil = mobil;

    }

    public String toString(){
        return navn + "(" + mobil + ")";
    }

    public String getNavn() {
        return navn;
    }

    public String getMobil() {
        return mobil;
    }

    public void Bestil (Bestilling bestilling) {
        if (!bestillinger.contains(bestilling)) {
            this.bestillinger.add(bestilling);
            bestilling.setKunde(this);
        }
    }

    public ArrayList<Bestilling> getBestillinger() {
        return new ArrayList<>(bestillinger);
    }

    public ArrayList<Plads> bestiltePladserTilForestillingPådag(Forestilling forestilling, LocalDate dato) {
        ArrayList<Plads> result = new ArrayList<>();

        for (Bestilling bestilling : bestillinger) {

            if (bestilling.getForestilling() == forestilling && bestilling.getDato().isEqual(dato)) {

                result.addAll(bestilling.getPladser());
            }
        }

        return result;
    }
}
