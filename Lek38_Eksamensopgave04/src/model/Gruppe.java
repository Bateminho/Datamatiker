package model;

import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;

public class Gruppe {
    private int nr;
    // association: --> 1 PersonChip
    private PersonChip personChip;
    // aggregation: --> 0..* PersonChip
    private final ArrayList<PersonChip> personChips = new ArrayList<>();

    public Gruppe(int nr){
        this.nr = nr;

    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    public PersonChip findPersonChip(String navn) {
        PersonChip personChip = null;

        int i = 0;
        while (personChip == null && i < personChips.size()) {
            PersonChip p = personChips.get(i);
            if (p.getNavn().equals(navn))
                personChip = p;
            else
                i++;
        }
        return personChip;
    }

    public ArrayList<String> oversigtFaciliteter(String navn) {
        ArrayList<String> result = new ArrayList<>();

        // Find personen med det angivne navn
        PersonChip personChip = findPersonChip(navn);

        // Hvis personen ikke findes, returneres en tom liste
        if (personChip == null) {
            return result;
        }

        // Hvis personen findes, gennemgå deres faciliteter
        for (Facilitet facilitet : personChip.getFaciliteter()) {
            // Tilføj navn og pris til resultatlisten
            result.add(facilitet.getNavn() + ": " + facilitet.getPris() + " kr.");
        }

        return result;
    }

    public PersonChip getPersonChip() {
        return personChip;
    }

    public void setPersonChip(PersonChip personChip) {
        if (this.personChip != personChip) {
            this.personChip = personChip;
        }
    }

    public ArrayList<PersonChip> getPersonChips() {
        return new ArrayList<>(personChips);
    }

    public PersonChip createPersonChip(int nr, String navn, int maxSaldo, int alder) {
        PersonChip personChip = new PersonChip(nr, navn, maxSaldo, alder);
        personChips.add(personChip);
        return personChip;
    }

    public void addPersonChip(PersonChip personChip) {
        if (!personChips.contains(personChip)) {
            personChips.add(personChip);
        }
    }

    public void removePersonChip(PersonChip personChip) {
        if (personChips.contains(personChip)) {
            personChips.remove(personChip);
        }
    }

}
