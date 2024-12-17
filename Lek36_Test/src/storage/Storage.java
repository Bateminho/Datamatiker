package storage;

import model.Fag;
import model.Studerende;

import java.util.ArrayList;

public class Storage {

    private static ArrayList<Fag> fagsliste = new ArrayList<>();
    private static ArrayList<Studerende> studerendeListe = new ArrayList<>();

    //-----------------------------------------------------------------------------------

    public static void addFag(Fag fag) {
        if (!fagsliste.contains(fag)) {
            fagsliste.add(fag);
        }
    }

    public static ArrayList<Fag> getFagsliste() {
        return new ArrayList<>(fagsliste);
    }

    //-----------------------------------------------------------------------------------

    public static void addStuderende(Studerende studerende) {
        if (!studerendeListe.contains(studerende)) {
            studerendeListe.add(studerende);
        }
    }

    public static ArrayList<Studerende> getStuderende() {
        return new ArrayList<>(studerendeListe);
    }


}
