package model;

import java.util.ArrayList;

public class Booking {
    private int bookingNummer;
    private String kundeNavn;
    private int antalPassagerer;
    private static int bookingID = 101;
    // association --> 1 Afgang
    private Afgang afgang;
    // association: --> 0..* Køretøj
    private final ArrayList<Køretøj> køretøjer = new ArrayList<>();

    public Booking(String kundeNavn, int antalPassagerer, Afgang afgang, ArrayList<Køretøj> køretøjer) {
        this.kundeNavn = kundeNavn;
        this.antalPassagerer = antalPassagerer;
        this.afgang = afgang;
        bookingNummer = bookingID;
        bookingID++;
        if (køretøjer != null) {
            this.køretøjer.addAll(køretøjer);
        }
    }

    public int getBookingNummer() {
        return bookingNummer;
    }

    public String getKundeNavn() {
        return kundeNavn;
    }

    public int getAntalPassagerer() {
        return antalPassagerer;
    }

    public double samletPris() {
        double samletPris = 0;

        int inkluderetPassager = køretøjer.size();

        for (Køretøj køretøj : køretøjer) {
            double køretøjsPris = afgang.getGrundPris(); // Grundpris fra afgangen
            switch (køretøj.getKøretøjsKategori()) {
                case PERSONBIL:
                    // Ingen tillæg for almindelige personbiler
                    break;
                case PERSONBIL_LARGE:
                    køretøjsPris *= 1.10; // 10% tillæg
                    break;
                case BUS:
                    køretøjsPris *= 3; // 3 gange grundpris
                    break;
                case LASTBIL:
                    køretøjsPris *= 5; // 5 gange grundpris
                    break;
            }
            samletPris += køretøjsPris;
        }

        int ekstraPassagerer = Math.max(antalPassagerer - inkluderetPassager, 0);
        samletPris += ekstraPassagerer * 50; // 50 kr. per ekstra passager

        return samletPris;
    }


    // --------------- Afgang ----------------------
    public void setAfgang(Afgang afgang) {
        if (this.afgang != afgang) {
            Afgang oldAfgang = this.afgang;
            if (oldAfgang != null) {
                oldAfgang.removeBooking(this);
            }
            this.afgang = afgang;
            if (afgang != null) {
                afgang.addBooking(this);
            }
        }
    }

    // --------------- Køretøj ----------------------
    public ArrayList<Køretøj> getKøretøjer() { return new ArrayList<>(køretøjer); }



    public void addKøretøj(Køretøj køretøj) {
        if (!køretøjer.contains(køretøj)) {
            køretøjer.add(køretøj);
        }
    }


    public void removeKøretøj(Køretøj køretøj) {
        if (køretøjer.contains(køretøj)) {
            køretøjer.remove(køretøj);
        }
    }
}
