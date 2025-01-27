package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Færge {
    private String navn;
    private int maxAntalPassagerer;
    private int maxAntalBiler;
    private int maxAntalLastbiler;
    // aggregation: --> 0..* Afgang
    private final ArrayList<Afgang> afgange = new ArrayList<>();

    public Færge(String navn, int maxAntalPassagerer, int maxAntalBiler, int maxAntalLastbiler) {
        this.navn = navn;
        this.maxAntalPassagerer = maxAntalPassagerer;
        this.maxAntalBiler = maxAntalBiler;
        this.maxAntalLastbiler = maxAntalLastbiler;
    }

    public String getNavn() {
        return navn;
    }

    public int getMaxAntalPassagerer() {
        return maxAntalPassagerer;
    }

    public int getMaxAntalBiler() {
        return maxAntalBiler;
    }

    public int getMaxAntalLastbiler() {
        return maxAntalLastbiler;
    }

    public Booking findBooking(int bookingNummer) {
        Booking resultat = null;
        int i = 0;

        while (resultat == null && i < afgange.size()) {
            Afgang afgang = afgange.get(i);
            int j = 0;

            while (resultat == null && j < afgang.getBookinger().size()) {
                Booking booking = afgang.getBookinger().get(j);
                if (booking.getBookingNummer() == bookingNummer) {
                    resultat = booking;
                } else {
                    j++;
                }
            }
            i++;
        }

        return resultat;
    }


    public ArrayList<Afgang> getAfgange() { return new ArrayList<>(afgange); }

    public Afgang createAfgang(Havn fraDestination, Havn tilDestination, LocalDate date, LocalTime klokkeslet, double grundPris) {
        Afgang afgang = new Afgang(fraDestination, tilDestination, date, klokkeslet, grundPris, this);
            afgange.add(afgang);
            return afgang;
    }

    public void addAfgang(Afgang afgang) {
        if (!afgange.contains(afgang)) {
            afgange.add(afgang);
            afgang.setFærge(this); } }

    public void removeAfgang(Afgang afgang) {
        if (afgange.contains(afgang)) {
            afgange.remove(afgang);
        }
    }

}
