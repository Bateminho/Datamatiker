package model;

import java.util.ArrayList;

public class Studerende {
    private String navn;
    private String email;

    // association --> 0..* Deltagelse
    private final ArrayList<Deltagelse> deltagelser = new ArrayList<>();

    public Studerende(String navn, String email) {
        this.navn = navn;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getNavn() {
        return navn;
    }

    @Override
    public String toString() {
        return this.navn + " " + this.email;
    }

    public ArrayList<Deltagelse> getDeltagelser() {
        return new ArrayList<>(deltagelser);
    }

    public void addDeltager(Deltagelse deltagelse) {
        if (!deltagelser.contains(deltagelse)) {
            deltagelser.add(deltagelse);
            deltagelse.setStuderende(this);
        }
    }

    public void removeDeltager(Deltagelse deltagelse) {
        if (deltagelser.contains(deltagelse)) {
            deltagelser.remove(deltagelse);
            deltagelse.setStuderende(null);
        }
    }

    public int antalFraværsLektioner() {
        int result = 0;

        // Iterér gennem alle deltagelser
        for (Deltagelse deltagelse : deltagelser) {
            // Tæl kun registrerede fraværslektioner
            if (deltagelse.erRegisteretFraværende()) {
                result++;
            }
        }

        return result;
    }
}

