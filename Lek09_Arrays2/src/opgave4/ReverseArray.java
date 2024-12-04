package opgave4;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {

    public static void main(String[] args) {

        Scanner inputScan = new Scanner(System.in);

        System.out.println("Dette program kan vende et array om");
        int[] array = new int[10];
        System.out.println("Indtast 10 heltal!");

        for (int i = 0; i < array.length; i++) {
            array[i] = inputScan.nextInt();
        }

        System.out.println(Arrays.toString(arrayReverse(array)));


    }

    public static int[] arrayReverse(int[] array) {

        int[] reversedArray = new int[array.length];

        // Reverse the array
        for (int i = 1; i <= array.length; i++) {
            reversedArray[i - 1] = array[array.length - i];
        }
        return reversedArray;
    }
}