package removeduplicate;


import java.util.ArrayList;
import java.util.Scanner;

public class RemoveDuplicate {
    public static void main(String[] args) {

        Scanner inputScan = new Scanner(System.in);

        System.out.println("Indtast 10 tal");

        ArrayList<Integer> numberList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            int number = inputScan.nextInt();
            numberList.add(number);
        }

        removeDuplicate(numberList);

        System.out.println("Dit endelige array er: " + numberList);
    }

    public static void removeDuplicate(ArrayList<Integer> list) {
        ArrayList<Integer> newList = new ArrayList<>();

        for (int number : list) {
            if (!newList.contains(number)) {
                newList.add(number);
            }
        }

        list.clear();
        list.addAll(newList);
    }
}
