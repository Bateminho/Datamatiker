package storage;

import model.*;

import java.util.ArrayList;

public class Storage {
   private static ArrayList<Færge> færger = new ArrayList<>();
   private static ArrayList<Booking> bookinger = new ArrayList<>();
   private static ArrayList<Køretøj> køretøjer = new ArrayList<>();

    //-------------------------- Færge --------------------------------------

    public static void addFærge(Færge færge) {
        if (!færger.contains(færge)) {
            færger.add(færge);
        }
    }

    public static void removeFærge(Færge færge) {
        if (færger.contains(færge)) {
            færger.remove(færge);
        }
    }

    public static ArrayList<Færge> getFærger() {
        return new ArrayList<>(færger);
    }

    //-------------------------- Booking --------------------------------------

    public static void addBooking(Booking booking) {
        if (!bookinger.contains(booking)) {
            bookinger.add(booking);
        }
    }

    public static void removeBooking(Booking booking) {
        if (bookinger.contains(booking)) {
            bookinger.remove(booking);
        }
    }

    public static ArrayList<Booking> getBookinger() {
        return new ArrayList<>(bookinger);
    }

    //-------------------------- Køretøj --------------------------------------

    public static void addKøretøj(Køretøj køretøj) {
        if (!køretøjer.contains(køretøj)) {
            køretøjer.add(køretøj);
        }
    }

    public static void removeKøretøj(Køretøj køretøj) {
        if (køretøjer.contains(køretøj)) {
            køretøjer.remove(køretøj);
        }
    }

    public static ArrayList<Køretøj> getKøretøjer() {
        return new ArrayList<>(køretøjer);
    }

}
