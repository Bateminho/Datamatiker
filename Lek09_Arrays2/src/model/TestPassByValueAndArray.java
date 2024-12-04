package model;

import java.util.Arrays;

public class TestPassByValueAndArray {
    public static void swap(int n1, int n2){
        int temp = n1;
        n1 = n2;
        n2 = temp;
    }

    public static void swap(int[] tabel){
        int temp = tabel[0];
        tabel[0] = tabel[1];
        tabel[1] = temp;
    }

    public static void main(String[] args) {
        int num1 = 1;
        int num2 = 2;


        System.out.println("Før kald af swap, num1 er: " + num1 + " og num2 er: " + num2);

        // Kald swap metoden by value
        swap(num1, num2);

        System.out.println("Efter kald af swap, num1 er: " + num1 + " og num2 er: " + num2);

        int[] a = {1,2};
        System.out.println("Før kald af swap, a er: " + Arrays.toString(a) );

        // Kald swap metoden by reference
        swap(a);

        System.out.println("Efter kald af swap, a er: "  + Arrays.toString(a));


    }
}
