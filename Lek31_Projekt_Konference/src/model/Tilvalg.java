package model;

public class Tilvalg {
    private String type;
    private double pris;

    Tilvalg(String type, double pris) {
        this.type = type;
        this.pris = pris;
    }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public double getPris() { return pris; }
    public void setPris(double pris) { this.pris = pris; }

}
