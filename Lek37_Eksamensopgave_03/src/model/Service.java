package model;

import java.util.ArrayList;

public class Service {

    public static ArrayList<Hold> findStoreHold(int antal) {
        ArrayList<Hold> result = new ArrayList<>();
        for (Hold hold : Dao.getAlleHold()) {
            if (hold.getMaxAntal() >= antal) {
                result.add(hold);
            }
        }
        return result;
    }
}
