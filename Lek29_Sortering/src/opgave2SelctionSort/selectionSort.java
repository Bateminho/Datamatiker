package opgave2SelctionSort;

import model.Customer;
import java.util.ArrayList;
import java.util.Arrays;

public class selectionSort {

    private static void swapArray(String[] list, int i, int j) {
        String temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static void selectionSortArray(String[] list) {
        for (int i = 0; i < list.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < list.length; j++) {
                if (list[j].compareTo(list[minPos]) < 0) {
                    minPos = j;
                }

            }
            swapArray(list, i, minPos);
        }
    }

    private static void swapArrayList(ArrayList<Customer> list, int i, int j) {
        Customer temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void selectionSortArrayList(ArrayList<Customer> list) {
        for (int i = 0; i < list.size(); i++) {
            int minPos = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).getFirstName().compareTo(list.get(minPos).getFirstName()) < 0) {
                    minPos = j;
                }

            }
            swapArrayList(list, i, minPos);
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

        selectionSortArray(customerlist);

        System.out.println(Arrays.toString(customerlist));

        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
        customers.add(customer4);
        customers.add(customer5);

        System.out.println("\nArrayList");
        System.out.println(customers);
        selectionSortArrayList(customers);
        System.out.println(customers);

    }
}
