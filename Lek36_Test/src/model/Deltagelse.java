package model;

import java.net.http.HttpResponse;

public class Deltagelse {
    private boolean registreret;
    private DeltagerStatus status;

    // association --> 0..1 Studerende
    private Studerende studerende; //

    // composition: --> 1 Lektion
    private Lektion lektion;

    public Deltagelse(boolean registreret, DeltagerStatus status) {
        this.registreret = false;
        this.status = DeltagerStatus.TILSTEDE;
    }

    public DeltagerStatus getStatus() {
        return status;
    }

    public void setStatus(DeltagerStatus status) {
        this.status = status;
    }

    public Studerende getStuderende() {
        return studerende;
    }

    public void setStuderende(Studerende studerende) {
        if (this.studerende != studerende) {
            Studerende oldStudrende = this.studerende;
            if (oldStudrende != null) {
                oldStudrende.removeDeltager(this);
            }

            this.studerende = studerende;
            if (studerende != null) {
                studerende.addDeltager(this); }
        }
    }

    public Lektion getLektion() {
        return lektion;
    }

    public boolean erRegisteretFraværende() {

        return registreret && status != DeltagerStatus.TILSTEDE;
    }

    @Override
    public String toString() {
        return this.studerende.getNavn() + " " + status;
    }
}
