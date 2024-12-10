package opgave1_fletCustomer;

import java.util.ArrayList;
import model.Customer;

public class FletCustomer {
    public static void main(String[] args) {

        Customer customer1 = new Customer("Sean", "Bateman", 41);
        Customer customer2 = new Customer("Henning", "Riber", 42);
        Customer customer3 = new Customer("Mark", "Hansen", 42);
        Customer customer4 = new Customer("Clive", "Bateman", 64);
        Customer customer5 = new Customer("Dorthe", "Jensen", 63);

        Customer customer6 = new Customer("Jeanett", "Lykke", 42);
        Customer customer7 = new Customer("Dan", "Stærk", 38);
        Customer customer8 = new Customer("Janni", "Stærk", 34);
        Customer customer9 = new Customer("Carlos", "Lind", 39);
        Customer customer10 = new Customer("Kasper", "Kurup", 41);

        ArrayList<Customer> customerList1 = new ArrayList<>();
        customerList1.add(customer1);
        customerList1.add(customer2);
        customerList1.add(customer3);
        customerList1.add(customer4);
        customerList1.add(customer5);

        ArrayList<Customer> customerList2 = new ArrayList<>();
        customerList2.add(customer6);
        customerList2.add(customer7);
        customerList2.add(customer8);
        customerList2.add(customer9);
        customerList2.add(customer10);

        System.out.println(customerList1);
        System.out.println(customerList2);

        insertionSortArrayList(customerList1);
        insertionSortArrayList(customerList2);

        System.out.println();

        System.out.println(fletAlleKunder(customerList1, customerList2));

    }

    public static ArrayList fletAlleKunder(ArrayList<Customer> l1, ArrayList<Customer> l2) {
        ArrayList<Customer> result = new ArrayList<>();

        int i1 = 0;
        int i2 = 0;

        while (i1 < l1.size() && i2 < l2.size()) {
            if (l1.get(i1).getFirstName().compareTo(l2.get(i2).getFirstName()) <= 0 ) {
                result.add(l1.get(i1));
                i1++;
            } else {
                result.add(l2.get(i2));
                i2++;
            }
        }

        while (i1 < l1.size()) {
            result.add(l1.get(i1));
            i1++;
        }

        while (i2 < l2.size()) {
            result.add(l2.get(i2));
            i2++;
        }

        return result;
    }

    public static void insertionSortArrayList(ArrayList<Customer> list) {
        for (int i = 1; i < list.size(); i++) {
            Customer next = list.get(i);
            int j = i;
            boolean found = false;

            while (!found && j > 0) {
                if (next.getFirstName().compareTo(list.get(j - 1).getFirstName()) >= 0) {
                    found = true; // Placering fundet
                } else {
                    list.set(j, list.get(j - 1)); // Flyt elementet til højre
                    j--;
                }
            }

            list.set(j, next); // Placer elementet korrekt
        }
    }

}
