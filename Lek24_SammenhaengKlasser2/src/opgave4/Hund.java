package opgave4;

public class Hund {

    private String navn;
    private boolean stamtavle;
    private int pris;
    private Race race;

    public Hund(String navn, boolean stamtavle, int pris, Race race) {
        this.navn = navn;
        this.stamtavle = stamtavle;
        this.pris = pris;
        this.race = race;
    }

    public int getPrice() {
        return pris;
    }

    public Race getRace() {
        return race;
    }

    @Override
    public String toString() {
        return "Hund{" +
                "navn='" + navn + '\'' +
                ", stamtavle=" + stamtavle +
                ", pris=" + pris +
                ", race=" + race +
                '}';
    }
}
