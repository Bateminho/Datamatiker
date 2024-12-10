package model;

import java.util.ArrayList;

public class Deltager {
    private String navn;
    private String adresse;
    private String by;
    private String land;
    private String telefonnr;
    private String firmanavn;
    private String firmaTelefonnr;

    private ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();


   public Deltager(String navn, String adresse, String by, String land, String telefonnr, String firmanavn, String firmaTelefonnr) {
        this.navn = navn;
        this.adresse = adresse;
        this.by = by;
        this.land = land;
        this.telefonnr = telefonnr;
        this.firmanavn = firmanavn;
        this.firmaTelefonnr = firmaTelefonnr;

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

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getTelefonnr() {
        return telefonnr;
    }

    public void setTelefonnr(String telefonnr) {
        this.telefonnr = telefonnr;
    }

    public String getFirmanavn() {
        return firmanavn;
    }

    public void setFirmanavn(String firmanavn) {
        this.firmanavn = firmanavn;
    }

    public String getFirmaTelefonnr() {
        return firmaTelefonnr;
    }

    public void setFirmaTelefonnr(String firmaTelefonnr) {
        this.firmaTelefonnr = firmaTelefonnr;
    }

    public String toString() {
       return this.navn;
    }

    //--------------------------------------------------------------------------------


    // Tilføj tilmelding
    public void tilføjTilmelding(Tilmelding tilmelding) {
        if (tilmeldinger != null && !this.tilmeldinger.contains(tilmelding)) {
            this.tilmeldinger.add(tilmelding);
        }
    }

    // Hent alle tilmeldinger
    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger); }
}
