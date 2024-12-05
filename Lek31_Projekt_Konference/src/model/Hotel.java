package model;

import java.util.ArrayList;

public class Hotel {
    private String navn;
    private double prisEnkeltVærelse;
    private double prisDobbeltVærelse;

    private ArrayList<Tilmelding> tilmeldinger;
    private ArrayList<Tilvalg> tilvalg;

    public Hotel(String navn, double prisEnkeltVærelse, double prisDobbeltVærelse) {
        this.navn = navn;
        this.prisEnkeltVærelse = prisEnkeltVærelse;
        this.prisDobbeltVærelse = prisDobbeltVærelse;
        tilvalg = new ArrayList<>();
        tilmeldinger = new ArrayList<>();
    }

    public String getNavn() { return navn; }
    public void setNavn(String navn) { this.navn = navn; }

    public double getPrisEnkeltVærelse() {return prisEnkeltVærelse; }
    public void setPrisEnkeltVærelse(double prisEnkeltVærelse) { this.prisEnkeltVærelse = prisEnkeltVærelse; }

    public double getPrisDobbeltVærelse() {return prisDobbeltVærelse; }
    public void setPrisDobbeltVærelse(double prisDobbeltVærelse) { this.prisDobbeltVærelse = prisEnkeltVærelse; }

    public void tilføjTilmelding(Tilmelding tilmelding) {
        this.tilmeldinger.add(tilmelding);
    }

    public void fjernTilmeldling(Tilmelding tilmelding) {
        this.tilmeldinger.remove(tilmelding);
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }


    // Tilføj tilvalg
    public Tilvalg createTilvalg(String type, double pris) {
        Tilvalg tilvalg = new Tilvalg(type, pris);
        this.tilvalg.add(tilvalg);
        return tilvalg;
    }

    // Fjern tilvalg
    public void fjernTilvalg(Tilvalg tilvalg) {
        this.tilvalg.remove(tilvalg);
    }

    // Get tilvalg
    public ArrayList<Tilvalg> getTilvalg() {
        return tilvalg;
    }

    public String toString() {
        return navn;
    }

    public double beregnOpholdsPris(int antalNætter, boolean enkeltVærelse, ArrayList<Tilvalg> valgteTilvalg) {
        double basisPris = antalNætter * (enkeltVærelse ? prisEnkeltVærelse : prisDobbeltVærelse);
        double tilvalgsPris = 0;

        for (Tilvalg tilvalg : valgteTilvalg) {
            tilvalgsPris += tilvalg.getPris() ;
        }

        return basisPris + (tilvalgsPris * antalNætter);
    }


}
