package model;

import java.util.ArrayList;


public class Medlem implements Comparable<Medlem> {
    private String navn;
    private String adresse;
    private String email;
    private int mobiltlf;

    // association --> 0..* Tilmelding
    private final ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    public Medlem(String navn, String adresse, String email, int mobiltlf) {
        this.navn = navn;
        this.adresse = adresse;
        this.email = email;
        this.mobiltlf = mobiltlf;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getMobiltlf() {
        return mobiltlf;
    }

    public void setMobiltlf(int mobiltlf) {
        this.mobiltlf = mobiltlf;
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }
    /**
     * Adds the person to this group,
     * if they aren't connected.
     */
    public void addTilmelding(Tilmelding tilmelding) {
        if (!tilmeldinger.contains(tilmelding)) {
            tilmeldinger.add(tilmelding);
            tilmelding.setMedlem(this);
        }
    }
    /**
     * Removes the person from this group,
     * if they are connected.
     */
    public void removeTilmelding(Tilmelding tilmelding) {
        if (tilmeldinger.contains(tilmelding)) {
            tilmeldinger.remove(tilmelding);
            tilmelding.setMedlem(null);
        }
    }

    @Override
    public int compareTo(Medlem other) {
        return this.navn.compareTo(other.navn);
    }
}

