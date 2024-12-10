package opgave3_fletCustomerArray_ArrayList;

import model.Customer;

import java.util.ArrayList;

public class FletCustomerArrayAndArrayList {
    public static void main(String[] args) {
        Customer customer1 = new Customer("Clive", "Bateman", 64);
        Customer customer2 = new Customer("Dorthe", "Jensen", 63);
        Customer customer3 = new Customer("Henning", "Riber", 42);
        Customer customer4 = new Customer("Mark", "Hansen", 42);
        Customer customer5 = new Customer("Sean", "Bateman", 41);


        ArrayList<Customer> customerList1 = new ArrayList<>();
        customerList1.add(customer1);
        customerList1.add(customer2);
        customerList1.add(customer3);
        customerList1.add(customer4);
        customerList1.add(customer5);

        Customer[] customersBadPayers = new Customer[2];

        customersBadPayers[0] = customer3;
        customersBadPayers[1] = customer4;

        ArrayList<Customer> result = goodCustomers(customerList1, customersBadPayers);
        System.out.println("Good customers: " + result);
    }

    /**
     * Returnerer en sorteret ArrayList der indeholder alle
     * customers fra l1 der ikke er i l2
     * Krav: l1 og l2 er sorterede, indeholder ikke dubletter og
     * indeholder ikke tomme pladser
     */
    public static ArrayList<Customer> goodCustomers(ArrayList<Customer> l1, Customer[] l2) {
        ArrayList<Customer> result = new ArrayList<>();

        int i1 = 0; // Index for l1
        int i2 = 0; // Index for l2

        while (i1 < l1.size() && i2 < l2.length) {
            int comparison = l1.get(i1).getFirstName().compareTo(l2[i2].getFirstName());
            if (comparison == 0) {
                // Kunden er i begge lister (bad payer), så spring over
                i1++;
                i2++;
            } else if (comparison < 0) {
                // Kunden er kun i l1, så tilføj til resultatet
                result.add(l1.get(i1));
                i1++;
            } else {
                // Kunden i l2 er ikke i l1, gå videre i l2
                i2++;
            }
        }

        // Tilføj resterende kunder i l1, hvis l2 er gennemgået
        while (i1 < l1.size()) {
            result.add(l1.get(i1));
            i1++;
        }

        return result;
    }
}


