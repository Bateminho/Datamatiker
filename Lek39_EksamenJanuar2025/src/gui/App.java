package gui;

import controller.Controller;
import model.*;
import storage.Storage;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {
        initStorage();

    }

    public static void initStorage() {
        Færge jutlandica = Controller.createFærge("Jutlandica", 3000, 500, 50);
        Færge danica = Controller.createFærge("Danica", 4000, 600, 70);

        Køretøj ah12223 = Controller.createKøretøj("AH12223", KøretøjsKategori.PERSONBIL);
        Køretøj de33123 = Controller.createKøretøj("DE33123", KøretøjsKategori.PERSONBIL_LARGE);
        Køretøj gh33444 = Controller.createKøretøj("GH33444", KøretøjsKategori.LASTBIL);
        Køretøj jk55434 = Controller.createKøretøj("JK55434", KøretøjsKategori.BUS);

        Afgang j1 = Controller.createAfgang(Havn.FREDERIKSHAVN, Havn.GØTEBORG, LocalDate.of(2025, 1, 10), LocalTime.of(8,0), 1200, jutlandica);
        Afgang j2 = Controller.createAfgang(Havn.FREDERIKSHAVN, Havn.GØTEBORG, LocalDate.of(2025, 2, 3), LocalTime.of(8,0), 1200, jutlandica);
        Afgang j3 = Controller.createAfgang(Havn.GØTEBORG, Havn.FREDERIKSHAVN, LocalDate.of(2025, 2, 3), LocalTime.of(13,0), 1200, jutlandica);
        Afgang j4 = Controller.createAfgang(Havn.FREDERIKSHAVN, Havn.GØTEBORG, LocalDate.of(2025, 2, 3), LocalTime.of(18,0), 1200, jutlandica);
        Afgang j5 = Controller.createAfgang(Havn.GØTEBORG, Havn.FREDERIKSHAVN, LocalDate.of(2025, 2, 3), LocalTime.of(23,0), 1200, jutlandica);

        Afgang d1 = Controller.createAfgang(Havn.FREDERIKSHAVN, Havn.GØTEBORG, LocalDate.of(2025, 2, 10), LocalTime.of(8,0), 1200, danica);
        Afgang d2 = Controller.createAfgang(Havn.GØTEBORG, Havn.FREDERIKSHAVN, LocalDate.of(2025, 2, 10), LocalTime.of(13,0), 1200, danica);
        Afgang d3 = Controller.createAfgang(Havn.FREDERIKSHAVN, Havn.GØTEBORG, LocalDate.of(2025, 2, 10), LocalTime.of(18,0), 1000, danica);
        Afgang d4 = Controller.createAfgang(Havn.GØTEBORG, Havn.FREDERIKSHAVN, LocalDate.of(2025, 2, 10), LocalTime.of(23,0), 1000, danica);

        ArrayList<Køretøj> jensesKøretøjer = new ArrayList<>();
        jensesKøretøjer.add(ah12223);
        jensesKøretøjer.add(de33123);

        Booking b1 = Controller.createBooking("Jens Jensen", 8, j2, jensesKøretøjer);
        Booking b2 = Controller.createBooking("Jens Jensen", 8, d2, jensesKøretøjer);




    }
}
