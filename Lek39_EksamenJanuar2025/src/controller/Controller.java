package controller;

import model.*;
import storage.Storage;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Controller {

    // ---------------------------- Færge ------------------------------------------------

    public static Færge createFærge(String navn, int maxAntalPassagerer, int maxAntalBiler, int maxAntalLastbiler) {
        Færge færge = new Færge(navn, maxAntalPassagerer, maxAntalBiler, maxAntalLastbiler);
        Storage.addFærge(færge);
        return færge;
    }

    public static ArrayList<Færge> getFærger() { return Storage.getFærger(); }

    // ---------------------------- Afgang ------------------------------------------------

    public static Afgang createAfgang(Havn fraDestination, Havn tilDestination, LocalDate date, LocalTime klokkeslet, double grundPris, Færge færge) {
        return new Afgang(fraDestination, tilDestination, date, klokkeslet, grundPris, færge);
    }

    // ---------------------------- Booking ------------------------------------------------

    public static Booking createBooking(String kundeNavn, int antalPassagerer, Afgang afgang, ArrayList<Køretøj> køretøjer) {
        Booking booking = new Booking(kundeNavn, antalPassagerer, afgang, køretøjer);
        Storage.addBooking(booking);
        return booking;
    }

    public static ArrayList<Booking> getBookinger() { return Storage.getBookinger(); }

//    public static Booking updateBooking(Booking booking, Afgang afgang) {
//
//        return
//    }

    // ---------------------------- Køretøj ------------------------------------------------

    public static Køretøj createKøretøj(String regNummer, KøretøjsKategori køretøjsKategori) {
        Køretøj køretøj = new Køretøj(regNummer, køretøjsKategori);
        Storage.addKøretøj(køretøj);
        return køretøj;
    }

    public static ArrayList<Køretøj> getKøretøjer() { return Storage.getKøretøjer(); }



    // ---------------------------------

    public static void skrivFærgeOversigtTilFil(ArrayList<Færge> færger) {

        String filePath = "C:\\Users\\Sean\\Documents\\Uddannelse\\Datamatiker\\1. semester\\Programmering\\textfiler\\Januar2025.txt";

        try {
            File file = new File(filePath);

            if (file.createNewFile()) {
                System.out.println("Filen blev oprettet: " + file.getName());
            } else {
                System.out.println("Filen eksisterer allerede.");
            }

            try (PrintWriter printWriter = new PrintWriter(file)) {
                for (Færge færge : færger) {
                    // Skriv færgens navn
                    printWriter.println(færge.getNavn());

                    // Initialiser summeringsvariabler
                    int totalPassagerer = 0;
                    int totalLedigePersonbilPladser = 0;
                    int totalLedigeLastbilPladser = 0;

                    // Skriv oplysninger om færgens afgange
                    for (Afgang afgang : færge.getAfgange()) {
                        int passagerer = afgang.antalPassagerer();
                        int ledigePersonbilPladser = afgang.antalLedigePersonbilPladser();
                        int ledigeLastbilPladser = afgang.antLedigeLastbilPladser();

                        totalPassagerer += passagerer;
                        totalLedigePersonbilPladser += ledigePersonbilPladser;
                        totalLedigeLastbilPladser += ledigeLastbilPladser;

                        printWriter.printf("%s-%s: %s kl %s Antal passagerer: %d Ledige pladser, personbiler: %d Ledige pladser, lastbiler: %d%n",
                                afgang.getFraDestination(), afgang.getTilDestination(),
                                afgang.getDate(), afgang.getKlokkeslet(),
                                passagerer, ledigePersonbilPladser, ledigeLastbilPladser);
                    }

                    // Skriv færgens samlede statistik
                    printWriter.printf("Antal passagerer i alt: %d. Samlet antal ledige personbilpladser: %d. Samlet antal ledige lastbilpladser: %d.%n%n",
                            totalPassagerer, totalLedigePersonbilPladser, totalLedigeLastbilPladser);
                }

                System.out.println("Færgeoversigten blev skrevet til filen.");
            }

        } catch (IOException e) {
            System.out.println("Der opstod en fejl: " + e.getMessage());
        }
    }
}
