package model;

public class Vare {
    private Varekategori kategori;
    private String navn;
    private int udbudspris;
    private boolean solgt;

    private Salgsannonce salgsannonce;

    public Vare(Varekategori kategori, String navn, int udbudspris) {
        this.kategori = kategori;
        this.navn = navn;
        this.udbudspris = udbudspris;
        solgt = false;
    }

    public Varekategori getKategori() {
        return kategori;
    }

    public String getNavn() {
        return navn;
    }

    public int getUdbudspris() {
        return udbudspris;
    }

    public boolean isSolgt() {
        return solgt;
    }

    public void setSolgt() {
        solgt = true;
    }

    public Salgsannonce getSalgsannonce() { return salgsannonce; }

    public void setSalgsannonce(Salgsannonce salgsannonce) {
        if (this.salgsannonce != salgsannonce) {
            Salgsannonce oldSalgsannonce = this.salgsannonce;
            if (oldSalgsannonce != null) {
                oldSalgsannonce.removeVare(this);
            }
            this.salgsannonce = salgsannonce;
            if(salgsannonce != null) {
                salgsannonce.addVare(this);
            }
        }

    }
}
