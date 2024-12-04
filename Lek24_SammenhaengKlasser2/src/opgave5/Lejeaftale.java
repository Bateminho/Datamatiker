package opgave5;

import java.time.LocalDate;
import java.util.ArrayList;

public class Lejeaftale {
    private LocalDate fraDato;
    private LocalDate tilDato;
    private final ArrayList<Lejer> lejere = new ArrayList<>(2);
    private Bolig bolig;

    Lejeaftale(LocalDate fraDato){
        this.fraDato = fraDato;
        this.tilDato = null;
    }

    public LocalDate getFraDato() {
        return fraDato;
    }

    public void setFraDato(LocalDate fraDato) {
        this.fraDato = fraDato;
    }

    public void setTilDato(LocalDate tilDato) {
        this.tilDato = tilDato;
    }

    public ArrayList<Lejer> getLejere() {
        return new ArrayList<>(lejere);
    }

    public void addLejer(Lejer lejer) {
        if (!lejere.contains(lejer) && lejere.size() < 2 ) {
            lejere.add(lejer);
        } else {
            throw new IllegalStateException("Lejeaftalen kan kun have to lejere!");
        }
    }

    public void removeLejer(Lejer lejer) {
        if (lejere.contains(lejer)) {
            lejere.remove(lejer);
        }
    }

    public Bolig getBolig() {
        return bolig;
    }

    public void setBolig(Bolig bolig) {
        this.bolig = bolig;
    }

    @Override
    public String toString() {
        return "Lejeaftale{" +
                "fraDato=" + fraDato +
                ", tilDato=" + (tilDato != null ? tilDato : "Ikke opsagt") +
                ", lejere=" + lejere +
                ", bolig=" + (bolig != null ? bolig.getAdresse() : "Ingen bolig") +
                '}';
    }

}
