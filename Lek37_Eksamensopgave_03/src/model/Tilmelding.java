package model;

public class Tilmelding {
    private boolean aktiv;
    private boolean VIPmedlem;

    // association --> 1 Medlem
    private Medlem medlem;

    public Tilmelding(boolean aktiv, boolean VIPmedlem) {
        this.aktiv = aktiv;
        this.VIPmedlem = VIPmedlem;
    }

    public boolean isAktiv() {
        return aktiv;
    }

    public void setAktiv(boolean aktiv) {
        this.aktiv = aktiv;
    }

    public boolean isVIPmedlem() {
        return VIPmedlem;
    }

    public void setVIPmedlem(boolean VIPmedlem) {
        this.VIPmedlem = VIPmedlem;
    }

    public Medlem getMedlem() {
        return medlem;
    }

    public void setMedlem(Medlem medlem) {
        if (this.medlem != medlem) {
            Medlem oldMedlem = this.medlem;
            if (oldMedlem != null) {
                oldMedlem.removeTilmelding(this);
            }
            this.medlem = medlem;

            if (medlem != null) {
                medlem.addTilmelding(this);
            }
        }
    }
}
