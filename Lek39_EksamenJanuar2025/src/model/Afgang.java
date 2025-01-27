package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Afgang {
    private Havn fraDestination;
    private Havn tilDestination;
    private LocalDate date;
    private LocalTime klokkeslet;
    private double grundPris;
    // aggregation: --> 1 Færge
    private Færge færge;
    // association --> 0..* Booking
    private final ArrayList<Booking> bookinger = new ArrayList<>();


    public Afgang(Havn fraDestination, Havn tilDestination, LocalDate date, LocalTime klokkeslet, double grundPris, Færge færge) {
        this.fraDestination = fraDestination;
        this.tilDestination = tilDestination;
        this.date = date;
        this.klokkeslet = klokkeslet;
        this.grundPris = grundPris;
        this.færge = færge;
    }

    public Havn getFraDestination() {
        return fraDestination;
    }

    public Havn getTilDestination() {
        return tilDestination;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getKlokkeslet() {
        return klokkeslet;
    }

    public double getGrundPris() {
        return grundPris;
    }

    public int antalPassagerer() {
        int result = 0;

        for (Booking booking : bookinger) {
            result += booking.getAntalPassagerer();
        }

        return result;
    }

    public int antalLedigePersonbilPladser() {
        int maksPladser = færge.getMaxAntalBiler();
        int optagetPladser = 0;

        for (Booking booking : bookinger) {
            for (Køretøj køretøj : booking.getKøretøjer()) {
                if (køretøj.getKøretøjsKategori() == KøretøjsKategori.PERSONBIL ||
                        køretøj.getKøretøjsKategori() == KøretøjsKategori.PERSONBIL_LARGE) {
                    optagetPladser++;
                }
            }
        }

        return maksPladser - optagetPladser;
    }

    public int antLedigeLastbilPladser() {
        int maksPlader = færge.getMaxAntalLastbiler();
        int optagetPladser = 0;

        for (Booking booking : bookinger) {
            for (Køretøj køretøj : booking.getKøretøjer()) {
                if (køretøj.getKøretøjsKategori() == KøretøjsKategori.BUS ||
                køretøj.getKøretøjsKategori() == KøretøjsKategori.LASTBIL) {
                    optagetPladser++;
                }
            }
        }

        return maksPlader - optagetPladser;
    }

    // ---------------- Færger -------------------
    public Færge getFærge() { return færge; }

    public void setFærge(Færge færge) {
        if (this.færge != færge) {
            Færge oldFærge = this.færge;
            if (oldFærge != null) {
                oldFærge.removeAfgang(this);
            }
            this.færge = færge;
            if (færge != null) {
                færge.addAfgang(this);
            }
        }
    }

    // ---------------- Bookinger -------------------
    public ArrayList<Booking> getBookinger() { return new ArrayList<>(bookinger); }

    public void addBooking(Booking booking) {
        if (!bookinger.contains(booking)) {
            bookinger.add(booking);
            booking.setAfgang(this);
        }
    }

    public void removeBooking(Booking booking) {
        if (bookinger.contains(booking)) {
            bookinger.remove(booking);
            booking.setAfgang(null);
        }
    }
}
