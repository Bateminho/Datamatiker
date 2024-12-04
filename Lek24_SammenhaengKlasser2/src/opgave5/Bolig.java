package opgave5;

import java.time.LocalDate;
import java.util.ArrayList;

public class Bolig {
    private int kvm;
    private String adresse;
    private int prisPrMaaned;
    private final ArrayList<Lejeaftale> lejeaftaler = new ArrayList<>();
    private Kollegie kollegie;

    public Bolig(int kvm, String adresse, int prisPrMaaned) {
        this.kvm = kvm;
        this.adresse = adresse;
        this.prisPrMaaned = prisPrMaaned;
    }

    public int getKvm() {
        return kvm;
    }

    public void setKvm(int kvm) {
        this.kvm = kvm;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse){
        this.adresse = adresse;
    }

    public int getPrisPrMaaned(){
        return prisPrMaaned;
    }

    public void setPrisPrMaaned(int prisPrMaaned) {
        this.prisPrMaaned = prisPrMaaned;
    }

    public Lejeaftale createLejeaftale(LocalDate fraDato) {
        Lejeaftale newLejeaftale = new Lejeaftale(fraDato);
        newLejeaftale.setBolig(this);
        lejeaftaler.add(newLejeaftale);
        return newLejeaftale;
    }

    public void removeLejeaftale(Lejeaftale lejeaftale) {
        if (lejeaftaler.contains(lejeaftale)) {
            lejeaftaler.remove(lejeaftale);
            lejeaftale.setBolig(null);
        }
    }

    public ArrayList<Lejeaftale> getLejeaftaler() {
        return new ArrayList<>(lejeaftaler);
    }

    public Kollegie getKollegie() {
        return kollegie;
    }

    public void setKollegie(Kollegie kollegie) {
        this.kollegie = kollegie;
    }

    @Override
    public String toString() {
        return "Bolig{" +
                "kvm=" + kvm +
                ", adresse='" + adresse + '\'' +
                ", prisPrMaaned=" + prisPrMaaned +
                ", lejeaftaler=" + lejeaftaler +
                '}';
    }


}
