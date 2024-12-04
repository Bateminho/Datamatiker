package momsprocent;

public class Vare {
    private String navn;
    private double pris;
    private int momsProcent = 25;

    public Vare(String navn, double pris) {
        this.navn = navn;
        this.pris = pris;
    }

    public String getNavn() {
        return this.navn;
    }

    public void setNavn(String navn) {
        navn = navn;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public int getMomsProcent() {
        return momsProcent;
    }

    public  void setMomsProcent(int momsProcent) {
        this.momsProcent = momsProcent;

    }
}
