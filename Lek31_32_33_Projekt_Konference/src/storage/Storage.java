package storage;

import model.*;

import java.util.ArrayList;


public class Storage {


    private static ArrayList<Hotel> hoteller = new ArrayList<>();
    private static ArrayList<Konference> konferencer = new ArrayList<>();
    private static ArrayList<Deltager> deltagere = new ArrayList<>();
    private static ArrayList<Ledsager> ledsagere = new ArrayList<>();



    //-----------------------------------------------------------------------------

    public static void tilføjHotel(Hotel hotel){
        if (!hoteller.contains(hotel)){
            hoteller.add(hotel);
        }
    }

    public static ArrayList<Hotel> getHoteller() {
        return new ArrayList<>(hoteller);
    }

    //-----------------------------------------------------------------------------

    public static void tilføjKonference(Konference konference){
        if (!konferencer.contains(konference)){
            konferencer.add(konference);
        }
    }

    public static ArrayList<Konference> getKonferencer() {
        return new ArrayList<>(konferencer);
    }

    //-----------------------------------------------------------------------------

    public static void tilføjDeltager(Deltager deltager){
        if (!deltagere.contains(deltager)){
            deltagere.add(deltager);
        }
    }

    public static ArrayList<Deltager> getDeltagere() {
        return new ArrayList<>(deltagere);
    }

    //-----------------------------------------------------------------------------

    public static void tilføjLedsager(Ledsager ledsager){
        if (!ledsagere.contains(ledsager)){
            ledsagere.add(ledsager);
        }
    }

    public static ArrayList<Ledsager> getLedsagere() {
        return new ArrayList<>(ledsagere);
    }
}


