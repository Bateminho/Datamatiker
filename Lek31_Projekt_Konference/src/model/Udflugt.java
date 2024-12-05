package model;

import java.time.LocalDate;

public class Udflugt {
    private String aktivitet;
    private double pris;
    private LocalDate dato;

    Udflugt(String aktivitet, double pris, LocalDate dato) {
        this.aktivitet = aktivitet;
        this.pris = pris;
        this.dato = dato;
    }


    public String getAktivitet() {
        return aktivitet;
    }

    public double getPris() {
        return pris;
    }

    public LocalDate getDato() {
        return dato;
    }

    public String toString() {
        return this.aktivitet;
    }
}
