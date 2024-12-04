package opgave4;

import java.util.Scanner;

public class FindTheIndex {
    public static void main(String[] args) {

        Scanner inputScan = new Scanner(System.in);

        System.out.println("Dette program fortæller, hvilket indeks det største tal har og viser selve tallet!");
        double[] numbers = new double[10];  // Array til 10 tal
        System.out.println("Indtast 10 decimaltal:");

        // Indlæs 10 tal fra brugeren
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = inputScan.nextDouble();
        }

        // Find det største tal og dets indeks
        int index = indexOfLargestElement(numbers);

        // Vis resultatet
        System.out.println("Det største tal er " + numbers[index] + " ved element " + index);
    }

    // Metode til at finde indekset for det største element i arrayet
    public static int indexOfLargestElement(double[] array) {

        int maxIndex = 0;

        // Loop gennem arrayet og find det største element
        for (int i = 1; i < array.length; i++) {
            if (array[i] >= array[maxIndex]) {  // >= for at få det højeste indeks i tilfælde af ens værdier
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
