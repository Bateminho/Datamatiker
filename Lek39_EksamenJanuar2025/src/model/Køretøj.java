package model;

public class Køretøj {
    private String regNummer;
    private KøretøjsKategori køretøjsKategori;

    public Køretøj(String regNummer, KøretøjsKategori køretøjsKategori) {
        this.regNummer = regNummer;
        this.køretøjsKategori = køretøjsKategori;
    }

    public String getRegNummer() {
        return regNummer;
    }

    public KøretøjsKategori getKøretøjsKategori() {
        return køretøjsKategori;
    }
}
