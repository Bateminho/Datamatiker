package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Konference {
    private String navn;
    private String adresse;
    private double prisPrDag;
    private LocalDate startDato;
    private LocalDate slutDato;

    private ArrayList<Hotel> hoteller;
    private ArrayList<Udflugt> udflugter;
    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    public Konference(String navn, String adresse, double pris, LocalDate startDato, LocalDate slutDato) {
        this.navn = navn;
        this.adresse = adresse;
        this.prisPrDag = pris;
        this.startDato = startDato;
        this.slutDato = slutDato;
        hoteller = new ArrayList<>();
        udflugter = new ArrayList<>();
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getPrisPrDag() {
        return prisPrDag;
    }

    public void setPrisPrDag(double prisPrDag) {
        this.prisPrDag = prisPrDag;
    }

    public LocalDate getStartDato() {
        return startDato;
    }

    public void setStartDato(LocalDate startDato) {
        this.startDato = startDato;
    }

    public LocalDate getSlutDato() {
        return slutDato;
    }

    public void setSlutDato(LocalDate slutDato) {
        this.slutDato = slutDato;
    }

    public Tilmelding createTilmelding(Konference konference, Hotel hotel, Deltager deltager, Ledsager ledsager, LocalDate ankomstDato, LocalDate afrejseDato, boolean foredragsholder) {
        Tilmelding tilmelding = new Tilmelding(konference, hotel, deltager,ledsager, ankomstDato, afrejseDato, foredragsholder);
            tilmeldinger.add(tilmelding);
            return tilmelding;

    }

    public ArrayList<Tilmelding> getTilmeldinger() {return new ArrayList<>(tilmeldinger); }

    public Udflugt creatUdflugt(String aktivitet, double pris, LocalDate dato){
        Udflugt udflugt = new Udflugt(aktivitet, pris, dato);
        udflugter.add(udflugt);
        return udflugt;
    }

    public ArrayList<Udflugt> getUdflugter() {
        return new ArrayList<>(udflugter); // Returnér en kopi for at beskytte den interne liste
    }

    // Metoder til håndtering af udflugter
    public void tilføjHotel(Hotel hotel) {
        if (hotel != null && !hoteller.contains(hotel)) {
            hoteller.add(hotel);
        }
    }

    public void fjernHotel(Hotel hotel) {
        hoteller.remove(hotel);
    }

    public double beregnKonferencePris(LocalDate ankomstDato, LocalDate afrejseDato, boolean foredragsholder, boolean firmaBetaler) {
        if (foredragsholder || firmaBetaler) {
            return 0;
        }
        long antalDage = (int) ChronoUnit.DAYS.between(ankomstDato, afrejseDato) + 1;
        return antalDage * this.prisPrDag;
    }
}
