package opgave5;

import java.util.ArrayList;


public class SeriesApp {
    public static void main(String[] args) {

        ArrayList<String> cast = new ArrayList<>();
        cast.add("Jennifer Aniston");
        cast.add("David Schwimmer");
        cast.add("Matthew Perry");
        cast.add("Courteney Cox");
        cast.add("Lisa Kudrow");
        cast.add("Matt LeBlanc");

        Series friends = new Series("Friends", cast);

        ArrayList<String> guestsSeason1 = new ArrayList<>();
        guestsSeason1.add("Jill Goodacre");
        guestsSeason1.add("Morgan Fairchild");
        guestsSeason1.add("Helen Hunt");

        ArrayList<String> guestsSeason2 = new ArrayList<>();
        guestsSeason2 .add("Maggie Wheeler");
        guestsSeason2 .add("Elliot Gould");
        guestsSeason2 .add("Christina Pickle");

        // Opret episoder
        friends.createEpisode(1, guestsSeason1, 25);
        friends.createEpisode(2, guestsSeason1 , 24);
        friends.createEpisode(3, guestsSeason1, 25);
        friends.createEpisode(4, guestsSeason1 , 24);
        friends.createEpisode(5, guestsSeason1, 25);
        friends.createEpisode(6, guestsSeason1 , 24);

        friends.createEpisode(1, guestsSeason2, 25);
        friends.createEpisode(2, guestsSeason2 , 24);
        friends.createEpisode(3, guestsSeason2, 25);
        friends.createEpisode(4, guestsSeason2 , 24);
        friends.createEpisode(5, guestsSeason2, 25);
        friends.createEpisode(6, guestsSeason2 , 24);
        // Udskriv serien
        System.out.println(friends);

        // Udskriv total længde
        System.out.println("Total længde af episoder: " + friends.totalLength() + " minutter");

        // Udskriv gæste-skuespillere
        System.out.println("Alle gæsteskuespillere: " + friends.getGuestActors());
    }
}
