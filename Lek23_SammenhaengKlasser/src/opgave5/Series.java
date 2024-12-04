package opgave5;

import java.util.ArrayList;

public class Series {

    private final String title;
    private ArrayList<String> castMembers;
    private ArrayList<Episode> episodes = new ArrayList<>();

    public Series(String title, ArrayList<String> cast) {
            this.title = title;
        this.castMembers = cast;
    }

    public String getTitle() {
        return title;
    }

    public int totalLength() {
        if (episodes.isEmpty()) { // Kontroller, om der er episoder
            System.out.println("Ingen episoder tilføjet endnu.");
            return 0; // Returner 0, hvis der ikke er nogen episoder
        }
        int totalLengthResult = 0;
        for (Episode episode : episodes) {
            totalLengthResult += episode.getLengthMinutes();
        }
        return totalLengthResult;
    }


    public ArrayList<String> getGuestActors() {
        ArrayList<String> allGuestActors = new ArrayList<>();

        for (Episode episode : episodes) {
            for (String guest : episode.getGuestCast()) {
                if (!allGuestActors.contains(guest)) { // Tjek, om gæsten allerede er tilføjet
                    allGuestActors.add(guest);
                }
            }
        }

        return allGuestActors;
    }



    public ArrayList<String> getCast() {
        return new ArrayList<>(castMembers);
    }

    public void createEpisode(int number, ArrayList<String> guests, int lengthMinutes) {
        Episode newEpisode = new Episode(number, guests, lengthMinutes);
        episodes.add(newEpisode);
    }

    public void addEpisode(Episode episode) {
        if (!episodes.contains(episode)) {
            episodes.add(episode);
        }
    }

    public void removeEpisode(Episode episode) {
        if (episodes.contains(episode)) {
            episodes.remove(episode);
        }
    }

    public ArrayList<Episode> getEpisodes() {return new ArrayList<>(episodes); }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Serie: ").append(title).append("\n");
        sb.append("Faste skuespillere: ").append(castMembers).append("\n");
        sb.append("Episoder:\n");
        for (Episode episode : episodes) {
            sb.append(episode).append("\n");
        }
        return sb.toString();
    }

}
