package gui;

import controller.Controller;
import javafx.application.Application;
import model.*;


import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Application.launch(Gui.class);
        initStorage();
    }


    public static void initStorage() {
       Konference havOgHimmel = Controller.createKonference("Hav og Himmel",
                "Odense Universitet",
                1500, LocalDate.of(2024, 12, 18),
                LocalDate.of(2024, 12,20));

       Controller.createUdflugt(havOgHimmel, "Egeskov", 75, LocalDate.of(2024,12,19));
       Controller.createUdflugt(havOgHimmel,"Trapholt Museum, Kolding (inkl. frokost)", 200, LocalDate.of(2024,12,20));
       Controller.createUdflugt(havOgHimmel,"Byrundtur, Odense (inkl. frokost)", 125, LocalDate.of(2024,12,18));


       Hotel denHvideSvane =  Controller.createHotel("Den Hvide Svane", 1050, 1250);

       Controller.createTilvalg(denHvideSvane,"WIFI", 50);


       //------------------------------------

        Deltager finMadsen = Controller.createDeltager("Fin Madsen", "Store Torv 3", "Aarhus C", "DK", "12345678", null, null);

        Tilmelding tilmeldingFinMadsen = Controller.createTilmelding(havOgHimmel, null, finMadsen, null,
                LocalDate.of(2024, 12, 18),
                LocalDate.of(2024, 12, 20), false);



        System.out.println("Samlet pris for Fin Madsen: " + Controller.beregnSamletPris(tilmeldingFinMadsen) + " kr");


        //-------------------------------------------------------------



        Deltager nielsPetersen = Controller.createDeltager("Niels Petersen", "Brogade 4", "Vejle", "DK", "87654321", null, null);

        Tilmelding tilmeldingNielsPetersen = Controller.createTilmelding(havOgHimmel, denHvideSvane, nielsPetersen, null,
                LocalDate.of(2024, 12, 18),
                LocalDate.of(2024, 12, 20), false);


        System.out.println("Samlet pris for Niels Petersen: " + Controller.beregnSamletPris(tilmeldingNielsPetersen) + " kr");


        //-----------------------------------------------------------------------

        Deltager peterSommer = Controller.createDeltager("Peter Sommer", "Roskildevej 122", "KBH", "DK", "55554748", null,null);
        Ledsager mieSommer = Controller.createLedsager("Mie Sommer");


        Tilmelding tilmeldingPeterSommmer = Controller.createTilmelding(havOgHimmel, denHvideSvane, peterSommer, mieSommer,
                LocalDate.of(2024, 12, 18),
                LocalDate.of(2024, 12, 20), false);

        Controller.vælgTilvalg(tilmeldingPeterSommmer, denHvideSvane, "WIFI");
        Controller.vælgUdflugt(tilmeldingPeterSommmer, havOgHimmel, "Egeskov");
        Controller.vælgUdflugt(tilmeldingPeterSommmer, havOgHimmel, "Trapholt Museum, Kolding (inkl. frokost)");


        System.out.println("Samlet pris for Peter Sommer: " + Controller.beregnSamletPris(tilmeldingPeterSommmer) + " kr");


        //--------------------------------------------------------------------------------

        Deltager loneJensen = Controller.createDeltager("Lone Jensen", "Rådhuspladsen 5", "Aalborg", "DK", "23232424", null, null);
        Ledsager janMadsen = Controller.createLedsager("Jan Madsen");

        Tilmelding tilmeldingLoneJensen = Controller.createTilmelding(havOgHimmel, denHvideSvane, loneJensen, janMadsen,
                LocalDate.of(2024, 12, 18),
                LocalDate.of(2024, 12, 20), true);

        Controller.vælgTilvalg(tilmeldingLoneJensen, denHvideSvane, "WIFI");
        Controller.vælgUdflugt(tilmeldingLoneJensen, havOgHimmel, "Egeskov");
        Controller.vælgUdflugt(tilmeldingLoneJensen, havOgHimmel, "Byrundtur, Odense (inkl. frokost)");


        System.out.println("Samlet pris for Lone Jensen: " + Controller.beregnSamletPris(tilmeldingLoneJensen) + " kr");
    }
}
