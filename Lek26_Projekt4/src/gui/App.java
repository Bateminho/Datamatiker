package gui;

import application.controller.Controller;
import java.time.LocalDate;

import javafx.application.Application;
import application.model.Forestilling;
import application.model.Kunde;
import application.model.Plads;
import application.model.PladsType;
import storage.Storage;


public class App {
    public static void main(String[] args) {
        initStorage();
        Application.launch(Gui.class);
//        testPrint();
    }

    public static void initStorage() {
        Controller.createForestilling("Evita", LocalDate.of(2023, 8, 10), LocalDate.of(2023, 8, 20));
        Controller.createForestilling("Lykke Per", LocalDate.of(2023, 9, 1), LocalDate.of(2023, 8, 21));
        Controller.createForestilling("Chess", LocalDate.of(2023, 8, 21), LocalDate.of(2023, 8, 30));


        Controller.createKunde("Anders Hansen", "11223344");
        Controller.createKunde("Peter Jensen", "12345678");
        Controller.createKunde("Niels Madsen", "12341234");

//        jonasForestilling();
        createPladser();
    }




    public static void testPrint() {

        System.out.println("Forestillinger:");
        for (Forestilling forestilling : Storage.getForestillinger()) {
            System.out.printf(" Navn: %s, Startdato: %s, Slutdato: %s%n",
                    forestilling.getNavn(), forestilling.getStartDato(), forestilling.getSlutDato());

        }

        System.out.println("\nKunder:");
        for (Kunde kunde : Storage.getKunder()) {
            System.out.printf(" Navn: %s, Mobil: %s%n", kunde.getNavn(), kunde.getMobil());
        }

        System.out.println("\nPladser:");
        for (Plads plads : Storage.getPladser()) {
            System.out.printf(" Række: %d, Nr: %d, Pris: %d, Type: %s%n", plads.getRække(), plads.getNr(), plads.getPris(), plads.getPladsType());
        }
    }

    public static void createPladser(){
        for (int i = 0; i < (20 * 15); i++) {
            //første 5 rækker
            if (i / 20 <= 5) {
                if (i % 20 <= 1) {
                    Controller.createPlads((i / 20) + 1, (i % 20) + 1, 450, PladsType.STANDARD);
                } else if (i % 20 <= 17) {
                    Controller.createPlads((i / 20) + 1, (i % 20) + 1, 500, PladsType.STANDARD);
                } else {
                    Controller.createPlads((i / 20) + 1, (i % 20) + 1, 450, PladsType.STANDARD);
                }
                //rækker 6-9
            } else if (i / 20 <= 8) {
                if (i % 20 <= 1) {
                    Controller.createPlads((i / 20) + 1, (i % 20) + 1, 400, PladsType.STANDARD);
                } else if (i % 20 <= 17) {
                    Controller.createPlads((i / 20) + 1, (i % 20) + 1, 450, PladsType.STANDARD);
                } else {
                    Controller.createPlads((i / 20) + 1, (i % 20) + 1, 400, PladsType.STANDARD);
                }
            } else if (i / 20 == 9) {
                if (i % 20 <= 2) {
                    Controller.createPlads((i / 20) + 1, (i % 20) + 1, 400, PladsType.STANDARD);
                } else if (i % 20 <= 6) {
                    Controller.createPlads((i / 20) + 1, (i % 20) + 1, 450, PladsType.STANDARD);
                } else if (i % 20 <= 11) {
                    Controller.createPlads((i / 20) + 1, (i % 20) + 1, 450, PladsType.KØRESTOL);
                } else if (i % 20 <= 17) {
                    Controller.createPlads((i / 20) + 1, (i % 20) + 1, 450, PladsType.STANDARD);
                } else {
                    Controller.createPlads((i / 20) + 1, (i % 20) + 1, 400, PladsType.STANDARD);
                }

            } else if (i / 20 == 10) {
                if (i % 20 <= 1) {
                    Controller.createPlads((i / 20) + 1, (i % 20) + 1, 400, PladsType.STANDARD);
                } else if (i % 20 <= 6) {
                    Controller.createPlads((i / 20) + 1, (i % 20) + 1, 450, PladsType.STANDARD);
                } else if (i % 20 <= 11) {
                    Controller.createPlads((i / 20) + 1, (i % 20) + 1, 450, PladsType.EKSTRABEN);
                } else if (i % 20 <= 17) {
                    Controller.createPlads((i / 20) + 1, (i % 20) + 1, 450, PladsType.STANDARD);
                } else {
                    Controller.createPlads((i / 20) + 1, (i % 20) + 1, 400, PladsType.STANDARD);
                }

            }   else {
                Controller.createPlads((i / 20) + 1, (i % 20) + 1, 400, PladsType.STANDARD);
            }
        }
    }
}




