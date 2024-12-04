package opgave1BubbleSort;


import java.util.Arrays;

public class BubbleSort {

    private static void swap(String[] list, int i, int j) {
        String temp = list[i];
        list[i] = list[j];
        list[j] = temp;
    }

    public static void bubbleSort(String[] list) {
        for (int i = list.length - 1; i >= 0; i--) {
            for (int j = 0; j <= i - 1; j++) {
                if (list[j].charAt(0) > list[j + 1].charAt(0))
                    swap(list, j, j + 1);
            }
        }
    }


    public static void main(String[] args) {

        String[] names = {"Erna", "Elly", "Laurits", "Bertha", "Christian",
                "August", "Marius", "John", "Tove", "Poul", "Torkild"};

        bubbleSort(names);

        System.out.println(Arrays.toString(names));


    }
}
