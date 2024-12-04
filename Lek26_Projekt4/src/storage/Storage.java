package storage;

import application.model.Forestilling;
import application.model.Kunde;
import application.model.Plads;

import java.util.ArrayList;

public class Storage {
    private static ArrayList<Kunde> kunder = new ArrayList<>();
    private static ArrayList<Forestilling> forestillinger = new ArrayList<>();
    private static ArrayList<Plads> pladser = new ArrayList<>();


    //---------------------------------------------------------------------------------------

    public static ArrayList<Kunde> getKunder() {
        return new ArrayList<>(kunder);
    }
    public static void addKunde(Kunde kunde){
        kunder.add(kunde);
    }
    public static void removeKunde(Kunde kunde){
        kunder.remove(kunde);
    }


    public static ArrayList<Forestilling> getForestillinger() { return new ArrayList<Forestilling>(forestillinger); }
    public static void addForestilling(Forestilling forestilling) {forestillinger.add(forestilling); }
    public static void removeForestilling (Forestilling forestilling) {forestillinger.remove(forestilling); }

    //---------------------------------------------------------------------------------------

    public static ArrayList<Plads> getPladser(){ return new ArrayList<Plads>(pladser); }
    public static void addPlads(Plads plads) { pladser.add(plads); }
    public static void removePlads(Plads plads) {pladser.remove(plads); }


    //---------------------------------------------------------------------------------------


}
