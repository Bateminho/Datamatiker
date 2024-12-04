package momsprocentstatic;

public class Vare {
    private String navn;
    private double pris;
    private  static int momsProcent = 25;

    public Vare(String navn, double pris) {
        this.navn = navn;
        this.pris = pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public static int getMomsProcent() {
        return momsProcent;
    }

    public  static void setMomsProcent(int momsProcent) {
        Vare.momsProcent = momsProcent;

    }
    public String getNavn() {
        return this.navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public double getPris() {
        return this.pris;
    }

}
