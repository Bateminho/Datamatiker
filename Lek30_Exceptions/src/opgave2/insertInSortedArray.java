package opgave2;

import model.Customer;

import java.util.ArrayList;
import java.util.Arrays;

public class insertInSortedArray {

    public static void insertionSortArray(String[] list) {
        // Start fra det andet element (index 1), da det første element (index 0) betragtes som sorteret.
        for (int i = 1; i < list.length; i++) {
            String next = list[i]; // Elementet, der skal indsættes på den korrekte position.

            // Hvis elementet er null, spring over og fortsæt med næste iteration.
            if (next == null) {
                continue;
            }

            int j = i;       // j bruges til at finde den korrekte placering for "next".
            boolean found = false; // Flag til at stoppe forskydning, når korrekt placering findes.

            // Flyt elementer, indtil "next" er på den rigtige plads.
            while (!found && j > 0) {
                // Hvis "next" er større end eller lig med det foregående element, er vi færdige.
                if (next.compareTo(list[j - 1]) >= 0) {
                    found = true;
                } else {
                    // Forskyd det foregående element én plads frem for at gøre plads til "next".
                    list[j] = list[j - 1];
                    j--;
                }
            }

            // Indsæt "next" på den korrekte plads i det sorterede segment af arrayet.
            list[j] = next;
        }
    }


    public static void insertElementAtRightPlaceInSortedArray(String[] list, Customer customer) {

        String newElement = String.valueOf(customer);
        int i = list.length - 1;

        // Start fra slutningen og find det sidste ikke-nul-element
        while (i >= 0 && list[i] == null ) {
            i--;
        }

        i++; // Flyt en plads fremad til den første ledige plads

        boolean isPlaced = false;

        // Flyt elementer baglæns, indtil korrekt position findes
        while (!isPlaced && i > 0) {
            if (newElement.compareTo(list[i - 1]) >= 0) {
                isPlaced = true; // Hvis element er større end det forrige element, stop flytning
            } else {
                list[i] = list[i - 1]; // Ellers gå videre til næste position
                i--;
            }

//
            list[i] = newElement; // Indsæt elementet på den korrekte position
        }



    }










    public static void main(String[] args) {
        Customer customer1 = new Customer("Sean", "Bateman", 41);
        Customer customer2 = new Customer("Henning", "Riber", 42);
        Customer customer3 = new Customer("Mark", "Hansen", 42);
        Customer customer4 = new Customer("Clive", "Bateman", 64);
        Customer customer5 = new Customer("Dorthe", "Jensen", 63);

        String[] customerlist = new String[7];

        customerlist[0] = String.valueOf(customer1);
        customerlist[1] = String.valueOf(customer2);
        customerlist[2] = String.valueOf(customer3);
        customerlist[3] = String.valueOf(customer4);
        customerlist[4] = String.valueOf(customer5);

        System.out.println(Arrays.toString(customerlist));

        insertionSortArray(customerlist);

        System.out.println(Arrays.toString(customerlist));


        Customer customer6 = new Customer("Emma", "Andersen",32);

        insertElementAtRightPlaceInSortedArray(customerlist, customer6);
        System.out.println();
        System.out.println(Arrays.toString(customerlist));

        Customer customer7 = new Customer("Kimberley", "Andersen",65);

        System.out.println();
        insertElementAtRightPlaceInSortedArray(customerlist, customer7);
        System.out.println(Arrays.toString(customerlist));





    }
}
