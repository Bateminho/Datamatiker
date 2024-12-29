package model;

import java.util.ArrayList;

public class Hold {
    private String navn;
    private String disciplin;
    private int maxAntal;

    // aggregering --> 0..* Tilmelding
    private final ArrayList<Tilmelding> tilmeldinger = new ArrayList<>();

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getDisciplin() {
        return disciplin;
    }

    public void setDisciplin(String disciplin) {
        this.disciplin = disciplin;
    }

    public int getMaxAntal() {
        return maxAntal;
    }

    public void setMaxAntal(int maxAntal) {
        this.maxAntal = maxAntal;
    }

    public ArrayList<Tilmelding> getTilmeldinger() {
        return new ArrayList<>(tilmeldinger);
    }

    @Override
    public String toString() {
        return navn;
    }

    public Tilmelding createTilmelding(boolean aktiv, boolean VIPMedlem) {
        Tilmelding tilmelding = new Tilmelding(aktiv, VIPMedlem);
        tilmeldinger.add(tilmelding);
        return tilmelding;
    }
    /**
     * Adds the person to this group,
     * if they aren't connected.
     * Pre: The person isn't connected to another group.
     */
    public void addTilmelding(Tilmelding tilmelding) {
        if (!tilmeldinger.contains(tilmelding)) {
            tilmeldinger.add(tilmelding);
        }
    }
    /**
     * Removes the person from this group,
     * if they are connected.
     */
    public void removeTilmelding(Tilmelding tilmelding) {
        if (tilmeldinger.contains(tilmelding)) {
            tilmeldinger.remove(tilmelding);
        }
    }

    public int getAntalTilmeldinger(String adresse) {
       int result = 0;

       for (Tilmelding tilmelding : tilmeldinger) {
            if (tilmelding.getMedlem().getAdresse().equals(adresse)) {
                result++;
            }
       }

       return result;
    }

    public String findVipMedlem() {
        String result = null; // <INITIALISER RESULTAT TIL IKKE-FUNDET>
        int i = 0; // <INITIALISER KM>
        while (result == null && i < tilmeldinger.size()) { // while (<RESULTAT ER IKKE-FUNDET> && <KM != Ø>)
            Tilmelding tilmelding = tilmeldinger.get(i); // <UDVÆLG K FRA KM>
            if (tilmelding.isVIPmedlem()) { // if (<K ER LIG M>)
                result = tilmelding.getMedlem().getNavn(); // <SÆT RESULTAT (M ER FUNDET)>
            } else {
                i++; // <SPLIT KM I FORHOLD TIL K OG M>
            }
        }
        return result; // Returnér navnet på VIP-medlemmet eller null
    }

}
