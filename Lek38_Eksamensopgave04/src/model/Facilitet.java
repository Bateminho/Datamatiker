package model;

import java.util.ArrayList;

public class Facilitet implements Comparable<Facilitet> {
    private String navn;
    private int minimumsalder;
    private String åbningstid;
    private int pris;
    // association: --> 0..1 PersonChip
    private final ArrayList<PersonChip> personChips = new ArrayList<>();

    public Facilitet(String navn, int minimumsalder, String åbningstid, int pris) {
        this.navn = navn;
        this.minimumsalder = minimumsalder;
        this.åbningstid = åbningstid;
        this.pris = pris;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getMinimumsalder() {
        return minimumsalder;
    }

    public void setMinimumsalder(int minimumsalder) {
        this.minimumsalder = minimumsalder;
    }

    public String getÅbningstid() {
        return åbningstid;
    }

    public void setÅbningstid(String åbningstid) {
        this.åbningstid = åbningstid;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    @Override
    public String toString() {
        return navn;
    }

    public ArrayList<PersonChip> getPersonChips() {
        return new ArrayList<>(personChips);
    }

    public void addPersonChip(PersonChip personChip) {
        if (!personChips.contains(personChip)) {
            personChips.add(personChip);
            personChip.addFacillitet(this);
        }
    }

    public void removePersonChip(PersonChip personChip) {
        if (personChips.contains(personChip)) {
            personChips.remove(personChip);
            personChip.removeFacillitet(this);
        }
    }

    @Override
    public int compareTo(Facilitet other) {
        // Først sammenlignes minimumsalder
        if (this.minimumsalder < other.minimumsalder) {
            return -1; // Denne facilitet kommer før den anden
        } else if (this.minimumsalder > other.minimumsalder) {
            return 1; // Denne facilitet kommer efter den anden
        } else {
            // Hvis minimumsalder er den samme, sammenlignes prisen
            if (this.pris < other.pris) {
                return -1; // Denne facilitet kommer før den anden
            } else if (this.pris > other.pris) {
                return 1; // Denne facilitet kommer efter den anden
            } else {
                return 0; // Begge faciliteter er ens
            }
        }
    }
}
