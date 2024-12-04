package opgave4;

import java.util.Random;

public class Array200 {
    public static void main(String[] args) {

        int[] array = new int[10];

        countOccurrencesOfNumbers(array, 200);

    }

    public static void countOccurrencesOfNumbers(int[] counts, int randomNumbers) {

        Random random = new Random();

        for (int i = 0; i < randomNumbers; i++){
            int randomNumber = random.nextInt(10);
            counts[randomNumber]++;
        }

        // Display the occurrences of each number
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                System.out.println((i) + " forekommer " + counts[i] + " gange" );
            }
        }
    }


}
