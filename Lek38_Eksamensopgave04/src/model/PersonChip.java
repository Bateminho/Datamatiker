package model;

import java.util.ArrayList;

public class PersonChip {
    private int nr;
    private String navn;
    private int maxSaldo;
    private int alder;
    // association: --> 0..* Facillitet
    private final ArrayList<Facilitet> faciliteter = new ArrayList<>();

    public PersonChip(int nr, String navn, int maxSaldo, int alder) {
        this.nr = nr;
        this.navn = navn;
        this.maxSaldo = maxSaldo;
        this.alder = alder;
    }


    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public int getMaxSaldo() {
        return maxSaldo;
    }

    public void setMaxSaldo(int maxSaldo) {
        this.maxSaldo = maxSaldo;
    }

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    public boolean checkSaldo(int prisFacilitet) {
        boolean result = false;
        int saldo = 0;

        for (Facilitet facilitet : faciliteter) {
            saldo += facilitet.getPris();
        }

        if (saldo + prisFacilitet <= getMaxSaldo()) {
            result = true;
        }

        return result;

    }

    @Override
    public String toString() {
        return navn;
    }

    public ArrayList<Facilitet> getFaciliteter() { return new ArrayList<>(faciliteter); }

    /** * Adds the person to this group and the group to the person,
     * if they aren't connected.
     */
    public void addFacillitet(Facilitet facilitet) {
        if (!faciliteter.contains(facilitet)) {
            faciliteter.add(facilitet);
            facilitet.addPersonChip(this); }
    }

    /** * Removes the person from this group and the grop from the person,
     * if they are connected.
     */
    public void removeFacillitet(Facilitet facilitet) {
        if (faciliteter.contains(facilitet)) {
            faciliteter.remove(facilitet);
            facilitet.removePersonChip(this);
        }
    }
}
