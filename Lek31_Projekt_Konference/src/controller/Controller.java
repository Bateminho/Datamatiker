package controller;

import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;
import java.util.stream.StreamSupport;

public class Controller {

    public static Konference createKonference(String navn, String adresse, double pris, LocalDate startDato, LocalDate slutDato) {
        Konference konference = new Konference(navn, adresse, pris, startDato, slutDato);
        Storage.tilføjKonference(konference);
        return konference;
    }

    public static ArrayList<Konference> getKonference() {return Storage.getKonferencer(); }


    public static Hotel createHotel(String navn, double prisEnkeltVærelse, double prisDobbeltVærelse) {
        Hotel hotel = new Hotel(navn, prisEnkeltVærelse, prisDobbeltVærelse);
        Storage.tilføjHotel(hotel);
        return hotel;
    }

    public static ArrayList<Hotel> getHoteller() { return Storage.getHoteller(); }

    public static Deltager createDeltager(String navn, String adresse, String by, String land, String telefonnr, String firmanavn, String firmaTelefonnr) {
        Deltager deltager = new Deltager(navn, adresse, by, land, telefonnr, firmanavn, firmaTelefonnr);
        Storage.tilføjDeltager(deltager);
        return deltager;
    }

    public static ArrayList<Deltager> getDeltagere() { return Storage.getDeltagere(); }

    public static Ledsager createLedsager(String navn) {
        Ledsager ledsager = new Ledsager(navn);
        Storage.tilføjLedsager(ledsager);
        return ledsager;
    }

    public static ArrayList<Ledsager> getLedsagere() {return Storage.getLedsagere(); }


    public static Udflugt createUdflugt(Konference konference, String aktivitet, double pris, LocalDate dato) {
        return konference.creatUdflugt(aktivitet, pris, dato);
    }

    public static Tilvalg createTilvalg(Hotel hotel, String  type, double pris) {
        return hotel.createTilvalg(type, pris);
    }

    public static Tilmelding createTilmelding(Konference konference, Hotel hotel, Deltager deltager, Ledsager ledsager, LocalDate ankomstDato, LocalDate afrejseDato, boolean foredragsholder) {
        return konference.createTilmelding(konference, hotel, deltager, ledsager, ankomstDato, afrejseDato, foredragsholder);
    }

    public static double beregnSamletPris(Tilmelding tilmelding) {
     return tilmelding.beregnSamletPris();
    }

    public static void vælgTilvalg(Tilmelding tilmelding, Hotel hotel, String type){
        Tilvalg tilvalg = null;
        int i = 0;
        ArrayList<Tilvalg> tilvalgList = hotel.getTilvalg();

        while (tilvalg == null && i < tilvalgList.size()){
            String k = tilvalgList.get(i).getType();
            if (k.equalsIgnoreCase(type)){
                tilvalg = tilvalgList.get(i);
            } else {
                i++;
            }
        }
        if (tilvalg != null){
            tilmelding.tilføjTilvalg(tilvalg);
        }
    }

    public static void vælgUdflugt(Tilmelding tilmelding, Konference konference, String aktivitet){
        Udflugt udflugt = null;
        int i = 0;
        ArrayList<Udflugt> udflugter = konference.getUdflugter();

        while (udflugt == null && i < udflugter.size()){
            String k = udflugter.get(i).getAktivitet();
            if (k.equalsIgnoreCase(aktivitet)){
                udflugt = udflugter.get(i);
            } else {
                i++;
            }
        }
        if (udflugt != null){
            tilmelding.tilføjUdflugt(udflugt);
        }
    }

}
