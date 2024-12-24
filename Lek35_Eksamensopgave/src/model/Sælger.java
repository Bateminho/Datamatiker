package model;

import java.util.ArrayList;

public class Sælger {
    private String navn;
    private int studieKortNummer;
    private String mobil;

    private ArrayList<Salgsannonce> salgsannoncer = new ArrayList<>();

    public Sælger(String name, int studieKortNummer, String mobil) {
        this.navn = name;
        this.studieKortNummer = studieKortNummer;
        this.mobil = mobil;
    }

    public String getNavn() { return navn; }
    public int getStudieKortNummer() { return studieKortNummer; }
    public String getMobil() { return mobil; }

    @Override
    public String toString() { return navn ; }

    public ArrayList<Salgsannonce> getSalgsannoncer() {
        return new ArrayList<>(salgsannoncer);
    }

    public Salgsannonce createSalgsannoce(Sælger sælger) {
        Salgsannonce salgsannonce = new Salgsannonce(sælger);
        salgsannoncer.add(salgsannonce);
        return salgsannonce;
    }

    public void addSalgsannonce(Salgsannonce salgsannonce) {
        if (salgsannoncer.contains(salgsannonce)) {
            salgsannoncer.add(salgsannonce);
        }
    }

    public void removeSalgsannonce(Salgsannonce salgsannonce) {
        if (salgsannoncer.contains(salgsannonce)) {
            salgsannoncer.remove(salgsannonce);
        }
    }

    public ArrayList<Vare> alleIkkeSolgteVarerIKategori(Varekategori kategori) {

        ArrayList<Vare> ikkeSolgteVarer = new ArrayList<>();

        // Iterér over salgsannoncer for sælgeren.
        //Sælger har en liste af salgsannoncer i attributten salgsannoncer.





        for (Salgsannonce annonce : salgsannoncer) {
            //Kontrollér om salgsannoncen er aktiv.
            //Brug metoden isAktiv() fra klassen Salgsannonce.
            if (annonce.isAktiv()) {
                //Få fat i varerne fra salgsannoncen.
                //Brug metoden getVarer() fra klassen Salgsannonce for at hente en liste af varer.
                for (Vare vare : annonce.getVarer()) {
                 //   Kontroller, om varen hører til den ønskede kategori (brug getKategori() fra Vare).
                 //   Kontroller, om varen ikke er solgt (brug isSolgt() fra Vare).
                    if (vare.getKategori() == kategori && !vare.isSolgt()) {
                        //Tilføj de relevante varer til en liste.
                        //Returnér listen med de filtrerede varer.
                        ikkeSolgteVarer.add(vare);
                    }
                }
            }
        }
        return ikkeSolgteVarer;
    }
}
