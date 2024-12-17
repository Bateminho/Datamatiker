package model;

import java.util.ArrayList;

public class Sælger {
    private String name;
    private int studieKortNummer;
    private String mobil;

    private ArrayList<Salgsannonce> salgsannoncer = new ArrayList<>();

    public Sælger(String name, int studieKortNummer, String mobil) {
        this.name = name;
        this.studieKortNummer = studieKortNummer;
        this.mobil = mobil;
    }

    public String getName() { return name; }
    public int getStudieKortNummer() { return studieKortNummer; }
    public String getMobil() { return mobil; }

    @Override
    public String toString() {
        return name + " " + studieKortNummer + " " + mobil;
    }

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
}
