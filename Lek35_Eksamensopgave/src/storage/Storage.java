package storage;

import model.Salg;
import model.Sælger;
import model.Vare;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Sælger> sælgere = new ArrayList<>();
    private static ArrayList<Vare> varer = new ArrayList<>();
    private static ArrayList<Salg> salgsliste = new ArrayList<>();

    //-----------------------------------------------------------------------------------

    public static void addSælger(Sælger sælger) {
        if (!sælgere.contains(sælger)) {
            sælgere.add(sælger);
            sælgere.sort((s1, s2) -> s1.getNavn().compareToIgnoreCase(s2.getNavn()));

        }
    }

    public static ArrayList<Sælger> getSælgere() {
        return new ArrayList<>(sælgere);
    }


    //-----------------------------------------------------------------------------------

    public static void addVare(Vare vare) {
        if (!varer.contains(vare)) {
            varer.add(vare);
        }
    }

    public static ArrayList<Vare> getVare() {
        return new ArrayList<>(varer);
    }



    //-----------------------------------------------------------------------------------

    public static void addSalg(Salg salg) {
        if (!salgsliste.contains(salg)) {
            salgsliste.add(salg);
        }
    }

    public static ArrayList<Salg> getSalg() {
        return new ArrayList<>(salgsliste);
    }



    //-----------------------------------------------------------------------------------
}
