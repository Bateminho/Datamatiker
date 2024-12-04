package opgave3InsertionSort;

import model.Customer;

import java.util.ArrayList;
import java.util.Arrays;

public class insertionSort {

    public static void insertioneSortArray(String[] list) {
        for (int i = 1; i < list.length; i++) {
            String next = list[i];
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.compareTo(list[j - 1]) >= 0) {
                    found = true;
                } else {
                    list[j] = list[j - 1];
                    j--;
                }
            }
            list[j] = next;
        }
    }

    public static void insertionSortArrayList(ArrayList<Customer> list) {
        for (int i = 1; i < list.size(); i++) {
            Customer next = list.get(i);
            int j = i;
            boolean found = false;
            while (!found && j > 0) {
                if (next.getFirstName().compareTo(list.get(i).getFirstName()) >= 0) {
                    found = true;
                } else {
                    list.set(i, list.get(j-1));
                    j--;
                }
            }
            list.set(j, next);
        }
    }

    public static void main(String[] args) {
        Customer customer1 = new Customer("Sean", "Bateman", 41);
        Customer customer2 = new Customer("Henning", "Riber", 42);
        Customer customer3 = new Customer("Mark", "Hansen", 42);
        Customer customer4 = new Customer("Clive", "Bateman", 64);
        Customer customer5 = new Customer("Dorthe", "Jensen", 63);

        String[] customerlist = new String[5];

        customerlist[0] = String.valueOf(customer1);
        customerlist[1] = String.valueOf(customer2);
        customerlist[2] = String.valueOf(customer3);
        customerlist[3] = String.valueOf(customer4);
        customerlist[4] = String.valueOf(customer5);

        System.out.println(Arrays.toString(customerlist));

        insertioneSortArray(customerlist);

        System.out.println(Arrays.toString(customerlist));

        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);

        System.out.println("\nArrayList");
        System.out.println(customers);
        insertionSortArrayList(customers);
        System.out.println(customers);

    }
}
