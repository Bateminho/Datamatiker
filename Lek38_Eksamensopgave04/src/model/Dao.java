package model;

import java.util.ArrayList;

public class Dao {
    private static final ArrayList<Gruppe> grupper = new ArrayList<>();
    private static final ArrayList<Facilitet> faciliteter = new ArrayList<>();

    public static ArrayList<Gruppe> getGrupper() { return new ArrayList<>(grupper); }

    public static void addGruppe(Gruppe gruppe) {
        if (!grupper.contains(gruppe)) {
            grupper.add(gruppe);
        }
    }

    public static void updateGruppe(Gruppe gruppe) {
        int index = grupper.indexOf(gruppe);
        if (index != -1) {
            grupper.set(index, gruppe);
        }
    }

    public static ArrayList<Facilitet> getFaciliteter() { return new ArrayList<>(faciliteter); }

    public static void addFacilitet(Facilitet facilitet) {
        if (!faciliteter.contains(facilitet)) {
            faciliteter.add(facilitet);
        }
    }

    public static void updateFacilitet(Facilitet facilitet) {
        int index = faciliteter.indexOf(facilitet);
        if (index != -1) {
            faciliteter.set(index, facilitet);
        }
    }


}
