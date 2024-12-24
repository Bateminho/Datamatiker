package model;

import java.util.ArrayList;

public class Salg {
    private String købersNavn;
    private int aftaltSamletPris;

    private final ArrayList<Vare> varer;

    public ArrayList<Vare> getVarer() {
        return new ArrayList<>(varer);
    }

    public Salg(String købersNavn, int aftaltSamletPris, ArrayList<Vare> varer) {
        this.købersNavn = købersNavn;
        this.aftaltSamletPris = aftaltSamletPris;
        this.varer = new ArrayList<>(varer);

        // Registrer alle varer som solgt
        for (Vare vare : varer) {
            vare.setSolgt();
            Salgsannonce salgsannonce = vare.getSalgsannonce();
            if (salgsannonce != null) {
                vare.getSalgsannonce().opdatereAktivStatus();
            }
        }

    }

    public int getAftaltSamletPris() {
        return aftaltSamletPris;
    }

    public String getKøbersNavn() {
        return købersNavn;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Køber: ").append(købersNavn).append("\n");
        sb.append("Aftalt samlet pris: ").append(aftaltSamletPris).append(" kr.\n");
        sb.append("Varer:\n");

        for (Vare vare : varer) {
            sb.append("  - ").append(vare.getNavn()).append(", Udbudspris: ").append(vare.getUdbudspris()).append(" kr.\n");
        }

        return sb.toString();
    }


}
