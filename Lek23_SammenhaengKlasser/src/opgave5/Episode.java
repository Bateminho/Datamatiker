package opgave5;

import java.util.ArrayList;

public class Episode {

    private int number;
    private ArrayList<String> guests;
    private int lengthMinutes;

    Episode(int number, ArrayList<String> guests, int lengthMinutes ) {
        this.number = number;
        this.guests = guests;
        this.lengthMinutes = lengthMinutes;
    }

    public int getNumber() {
        return number;
    }

    public int getLengthMinutes() {
        return lengthMinutes;
    }

    public ArrayList<String> getGuestCast() {
        return new ArrayList<>(guests);
    }

    @Override
    public String toString() {
        return "Episode " + number + " (" + lengthMinutes + " minutter), gæster: " + guests;
    }

}
