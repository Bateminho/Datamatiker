package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Tilmelding {
    private LocalDate ankomstDato;
    private LocalDate afrejseDato;
    private boolean foredragsholder;

    private Ledsager ledsager;
    private Deltager deltager;
    private Hotel hotel;
    private Konference konference;

    private ArrayList<Udflugt> udflugter;
    private ArrayList<Tilvalg> tilvalg = new ArrayList<>();

    // Komplet konstruktør
    Tilmelding(Konference konference, Hotel hotel, Deltager deltager, Ledsager ledsager, LocalDate ankomstDato, LocalDate afrejseDato, boolean foredragsholder) {
        this.konference = konference;
        this.hotel = hotel;
        this.deltager = deltager;
        this.ledsager = ledsager;
        this.ankomstDato = ankomstDato;
        this.afrejseDato = afrejseDato;
        this.foredragsholder = foredragsholder;
        this.udflugter = new ArrayList<>();

    }

    public LocalDate getAnkomstDato() {
        return ankomstDato;
    }

    public void setAnkomstDato(LocalDate ankomstDato) {
        this.ankomstDato = ankomstDato;
    }

    public LocalDate getAfrejseDato() {
        return afrejseDato;
    }

    public void setAfrejseDato(LocalDate afrejseDato) {
        this.afrejseDato = afrejseDato;
    }

    public boolean isForedragsholder() {
        return foredragsholder;
    }

    public void setForedragsholder(boolean foredragsholder) {
        this.foredragsholder = foredragsholder;
    }

    public Deltager getDeltager() {
        return deltager;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Ledsager getLedsager() {
        return ledsager;
    }

    public void setLedsager(Ledsager ledsager) {
        this.ledsager = ledsager;
    }

    public Konference getKonference() {
        return konference;
    }

    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter);
    }

    public String toString() {
        return this.deltager.getNavn() + " (Tlf.nr. " + this.deltager.getTelefonnr() + ")";
    }

    // Metoder til håndtering af udflugter
    public void tilføjUdflugt(Udflugt udflugt) {
        if (udflugt != null && !udflugter.contains(udflugt)) {
            udflugter.add(udflugt);
        }
    }

    public void fjernUdflugt(Udflugt udflugt) {
        udflugter.remove(udflugt);
    }

    // Tilføj et tilvalg til denne tilmelding
    public void tilføjTilvalg(Tilvalg tilvalg) {
        if (tilvalg != null && !this.tilvalg.contains(tilvalg)) {
            this.tilvalg.add(tilvalg);
        }
    }

    // Fjern et tilvalg fra denne tilmelding
    public void fjernTilvalg(Tilvalg tilvalg) {
        this.tilvalg.remove(tilvalg);
    }

    public double beregnSamletPris() {

        double konferencepris = konference.beregnKonferencePris(ankomstDato, afrejseDato, foredragsholder, deltager.getFirmanavn() != null);

        // Beregn hotelpris
        double hotelPris = 0;
        if (hotel != null) {
            int antalNætter = (int) ChronoUnit.DAYS.between(ankomstDato, afrejseDato);
            boolean enkeltVærelse = ledsager == null;
            hotelPris = hotel.beregnOpholdsPris(antalNætter, enkeltVærelse, tilvalg);
        }

        // Beregn udflugtspriser (kun for ledsager)
        double udflugtsPris = 0;
        if (ledsager != null) {
            for (Udflugt udflugt : udflugter) {
                udflugtsPris += udflugt.getPris();
            }
        }

        return konferencepris + hotelPris + udflugtsPris;
    }


}
