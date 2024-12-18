package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Lektion {
    private LocalDate dato;
    private LocalTime startTid;
    private String lokale;

    // composition --> 0..* Deltagelse
    private final ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Lektion(LocalDate dato, LocalTime startTid, String lokale) {
        this.dato = dato;
        this.startTid = startTid;
        this.lokale = lokale;
    }

    public LocalDate getDato() {
        return dato;
    }

    public LocalTime getStartTid() {
        return startTid;
    }

    public String getLokale() {
        return lokale;
    }

    @Override
    public String toString() {
        return dato.toString() + " " + startTid.toString() + " " + lokale;
    }

    public ArrayList<Deltagelse> getDeltagelser() {
        return new ArrayList<>(deltagelser);
    }

    public Deltagelse createDeltagelse(boolean registreret, DeltagerStatus status) {
        Deltagelse deltagelse = new Deltagelse(registreret, status);
        deltagelser.add(deltagelse);
        return deltagelse;
    }

    public void removeDeltagelse(Deltagelse deltagelse) {
        if (deltagelser.contains(deltagelse)) {
            deltagelser.remove(deltagelse);
        }
    }
}
