//package model;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//
//public class App {
//
//    public static void main(String[] args) {
//        Konference havOgHimmel = new Konference("Hav og Himmel",
//                "Odense Universitet",
//                1500, LocalDate.of(2024, 12, 18),
//                LocalDate.of(2024, 12,20));
//
//        havOgHimmel.creatUdflugt("Egeskov", 75, LocalDate.of(2024,12,19));
//        havOgHimmel.creatUdflugt("Trapholt Museum, Kolding (inkl. frokost)", 200, LocalDate.of(2024,12,20));
//        havOgHimmel.creatUdflugt("Byrundtur, Odense (inkl. frokost)", 125, LocalDate.of(2024,12,18));
//
//
//        Hotel denHvideSvane = new Hotel("Den Hvide Svane", 1050, 1250);
//
//        Tilvalg denHvideSvaneWIFI = new Tilvalg("WIFI", 50);
//
//        denHvideSvane.tilføjTilvalg(denHvideSvaneWIFI);
//
//
//        //------------------------------------
//
//        Deltager finMadsen = new Deltager("Fin Madsen", "Store Torv 3", "Aarhus C", "DK", "12345678");
//
//        Tilmelding tilmeldingFinMadsen = new Tilmelding(havOgHimmel, finMadsen,
//                LocalDate.of(2024, 12, 18),
//                LocalDate.of(2024, 12, 20), false);
//
//        finMadsen.tilføjTilmelding(tilmeldingFinMadsen);
//
//        double samletPris = tilmeldingFinMadsen.beregnSamletPris();
//        System.out.println("Samlet pris for Fin Madsen: " + samletPris + " kr");
//
//
//        //-------------------------------------------------------------
//
//
//
//        Deltager nielsPetersen = new Deltager("Niels Petersen", "Brogade 4", "Vejle", "DK", "87654321");
//
//        Tilmelding tilmeldingNielsPetersen = new Tilmelding(havOgHimmel,nielsPetersen, denHvideSvane,
//                LocalDate.of(2024, 12, 18),
//                LocalDate.of(2024, 12, 20), false);
//
//        nielsPetersen.tilføjTilmelding(tilmeldingNielsPetersen);
//
//        double samletPris2 = tilmeldingNielsPetersen.beregnSamletPris();
//        System.out.println("Samlet pris for Niels Petersen: " + samletPris2 + " kr");
//
//
//        //-----------------------------------------------------------------------
//
//        Deltager peterSommer = new Deltager("Peter Sommer", "Roskildevej 122", "KBH", "DK", "55554748");
//        Ledsager mieSommer = new Ledsager("Mie Sommer");
//
//
//
//
//
//        Tilmelding tilmeldingPeterSommmer = new Tilmelding(havOgHimmel, peterSommer, mieSommer, denHvideSvane,
//                LocalDate.of(2024, 12, 18),
//                LocalDate.of(2024, 12, 20), false, new ArrayList<>());
//
//        tilmeldingPeterSommmer.tilføjUdflugt(egeskov);
//        tilmeldingPeterSommmer.tilføjUdflugt(trapholt);
//        tilmeldingPeterSommmer.tilføjTilvalg(denHvideSvaneWIFI);
//
//        peterSommer.tilføjTilmelding(tilmeldingNielsPetersen);
//
//        double samletPris3 = tilmeldingPeterSommmer.beregnSamletPris();
//        System.out.println("Samlet pris for Peter Sommer: " + samletPris3 + " kr");
//
//
//        //--------------------------------------------------------------------------------
//
//        Deltager loneJensen = new Deltager("Lone Jensen", "Rådhuspladsen 5", "Aalborg", "DK", "23232424");
//        Ledsager janMadsen = new Ledsager("Jan Madsen");
//
//        Tilmelding tilmeldingLoneJensen = new Tilmelding(havOgHimmel, loneJensen, janMadsen, denHvideSvane,
//                LocalDate.of(2024, 12, 18),
//                LocalDate.of(2024, 12, 20), true, denHvideSvane.getTilvalg());
//
//        tilmeldingLoneJensen.tilføjUdflugt(egeskov);
//        tilmeldingLoneJensen.tilføjUdflugt(byrundtur);
//
//        loneJensen.tilføjTilmelding(tilmeldingLoneJensen);
//
//        double samletPris4 = tilmeldingLoneJensen.beregnSamletPris();
//        System.out.println("Samlet pris for Lone Jensen: " + samletPris4 + " kr");
//
//    }
//
//
//}
