package application.controller;


import application.model.*;
import storage.Storage;
import java.time.LocalDate;
import java.util.ArrayList;


public class Controller {

    // ----------------------------------------------------------------------------------
public static void createKunde (String navn, String mobil) {
    Kunde kunde = new Kunde(navn,mobil);
    Storage.addKunde(kunde);
}



    // ----------------------------------------------------------------------------------
public static Forestilling createForestilling(String navn, LocalDate start, LocalDate slut){
    Forestilling f = new Forestilling(navn, start, slut);
    Storage.addForestilling(f);
    return f;
}


    /**
     * Creates a new plads.<br />
     * Requires: række > 0, nr > 0, pris > 0, pladstype
     */
    public static Plads createPlads(int række, int nr, int pris, PladsType pladsType) {
        Plads plads = new Plads(række, nr, pris, pladsType);
        Storage.addPlads(plads);
        return plads;
    }

    public static Bestilling opretBestillingMedPladser(Forestilling forestilling, Kunde kunde, LocalDate dato, ArrayList<Plads> pladser) {

        if (dato.isBefore(forestilling.getStartDato()) || dato.isAfter(forestilling.getSlutDato())){
            return null;
        }

        for (Plads plads : pladser) {
            if (!forestilling.erPladsLedig(plads.getRække(), plads.getNr(), dato)) {
                return null;
            }
        }

        Bestilling bestilling = forestilling.createBestilling(dato,kunde);
         for (Plads plads : pladser) {
             bestilling.addPLads(plads);
         }

         return bestilling;
    }
}

