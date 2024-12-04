package arrays;

import java.util.Arrays;

public class ArrayApp {
    public static int[] fyldArrayPP(){
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++){
            result[i] = i * 3;
        }
        return result;
    }
    public static int findMax(int[] tabel) {
        int max = -1;
        for (int i = 0; i < tabel.length; i++) {
            if (tabel[i] > max) {
                max = tabel[i];
            }
        }
        return max;
    }

    public static void printArray(int[] tabel) {
        System.out.print("{");
        for (int i = 0; i < tabel.length; i++) {
            if (i == 0) {
                System.out.print(tabel[i]);
            }
            else {
                System.out.print(", " + tabel[i]);
            }
        }
        System.out.println("}  ");
    }

    // OPGAVER


    /**
     *
     * @return et array med indhold [0,0,0,0,0,0,0,0,0,0]
     */
    public static int[] fyldArrayA() {
        int[] result = new int[10];
        return result;
    }

    /**
     *
     * @return et array med indhold [2,44,-23,99,8,-5,7,10,20,30]
     */
    public static int[] fyldArrayB() {
        //int[] result =new int[10];
        int[] result ={2,44,-23,99,8,-5,7,10,20,30};
        return result;
    }

    /**
     *
     * @return et array med indhold [0,1,2,3,4,5,6,7,8,9]
     */
    public static int[] fyldArrayC() {
        int[] result = new int[10];
        for(int i = 0; i<result.length; i++){
            result[i] = i;
        }
        return result;
    }

    /**
     *
     * @return et array med indhold [2,4,6,8,10,12,14,16,18,20]
     */
    public static int[] fyldArrayD() {
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++) {
            result[i] = i * 2 + 2;
        }
        return result;
    }

    /**
     *
     * @return et array med indhold [1,4,9,16,25,36,49,64,81,100]
     */
    public static int[] fyldArrayE() {
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++)
            result[i] = (i + 1) * (i + 1);
        return result;
    }

    /**
     *
     * @return et array med indhold [0,1,0,1,0,1,0,1,0,1]
     */
    public static int[] fyldArrayF() {
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++) {
            if (i % 2 != 0)
                result[i] = 1;
        }
        return result;
    }

    /**
     *
     * @return et array med indhold [0,1,2,3,4,0,1,2,3,4]
     */
    public static int[] fyldArrayG() {
        int[] result = new int[10];
        for (int i = 0; i < result.length; i++) {
            result[i] = i % 5;
        }
        return result;
    }

    public static int sum(int[] tabel) {

        int sum = 0;
        for (int i = 0; i < tabel.length; i++ ) {
            sum += tabel[i];
        }
        return sum;
    }

    public static int antalLige(int[] tabel) {

        int evenNumber = 0;
        for (int i = 0; i < tabel.length; i++)
        {
            if (i % 2 == 0)
                evenNumber++;
        }

        return evenNumber;
    }

    public static int antalForekomster(int[] tabel, int tal) {

        int forekomster = 0;

        for (int i = 0; i < tabel.length; i++) {
            if (tal == tabel[i])
                forekomster++;
        }
        return forekomster;
    }

    public static int[] makeSum(int[] a, int[] b) {

        int[] sum = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            sum[i] = a[i] + b[i];
        }

        return sum;
    }

    public static boolean hasUneven(int[] tabel) {
        // Loop through the array
        for (int i = 0; i < tabel.length; i++) {
            // If an odd number is found, return true
            if (tabel[i] % 2 != 0)
                return true;
        }
        // If no odd number is found, return false
        return false;
    }

    public static int[] makeSumUnEvenArrays(int[] array1, int[] array2) {

        int maxLength = Math.max(array1.length, array2.length);

        int[] sumArrays = new int[maxLength];

        for (int i = 0; i < maxLength; i++) {
            int value1 = i < array1.length ? array1[i] : 0;

            int value2 = i < array2.length ? array2[i] : 0;

            sumArrays[i] = value1 + value2;
        }

        return sumArrays;
    }



    public static void main(String[] args) {

        int tabel[] =fyldArrayPP();
        System.out.println("\nFyld Array");
        System.out.println("Forventet: [0, 3, 6, 9, 12, 15, 18, 21, 24, 27]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));

        int[] tabel2 = { 78, 23, 1, 4, 65, 3, 87, 5, 12 };
        printArray(tabel2);
        System.out.println(findMax(tabel2));

        tabel = fyldArrayA();
        System.out.println("\nOpgave A");
        System.out.println("Forventet: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = fyldArrayB();
        System.out.println("Opgave B");
        System.out.println("Forventet: [2, 44, -23, 99, 8, -5, 7, 10, 20, 30]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = fyldArrayC();
        System.out.println("Opgave C");
        System.out.println("Forventet: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = fyldArrayD();
        System.out.println("Opgave D");
        System.out.println("Forventet: [2, 4, 6, 8, 10, 12, 14, 16, 18, 20]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = fyldArrayE();
        System.out.println("Opgave E");
        System.out.println("Forventet: [1, 4, 9, 16, 25, 36, 49, 64, 81, 100]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = fyldArrayF();
        System.out.println("Opgave F");
        System.out.println("Forventet: [0, 1, 0, 1, 0, 1, 0, 1, 0, 1]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        tabel = fyldArrayG();
        System.out.println("Opgave G");
        System.out.println("Forventet: [0, 1, 2, 3, 4, 0, 1, 2, 3, 4]");
        System.out.println("Aktuelt  : " + Arrays.toString(tabel));
        System.out.println();

        int[] tabel3 = {4, 6, 7, 2, 3};
        System.out.println("\nOpgave 2 fra Opgaver.pdf");
        System.out.println("Aktuelt array: " + Arrays.toString(tabel3));
        System.out.println("Forventet sum af talene i arrayet: 22");
        System.out.println("Aktuel sum: " + sum(tabel3));

        System.out.println("\nOpgave 3 fra Opgaver.pdf");
        System.out.println("Aktuelt array: " + Arrays.toString(tabel3));
        System.out.println("Forventet antal lige tal fra arrayet: 3");
        System.out.println("Aktuel antal lige tal: " + antalLige(tabel3));

        int[] tabel4 = {4, 6, 7, 2, 7};
        System.out.println("\nOpgave 4 fra Opgaver.pdf");
        System.out.println("Aktuelt array: " + Arrays.toString(tabel4));
        System.out.println("Forventet antal forekomster af 7 i arrayet: 2");
        System.out.println("Aktuel antal forekomster: " + antalForekomster(tabel4, 7));

        int[] a = {4, 6, 7, 2, 3}, b = {3, 0, 9, 5, 5};

        System.out.println("\nOpgave 5 fra Opgaver.pdf");
        System.out.println("Aktuelt array a: " + Arrays.toString(a) + " og " + Arrays.toString(b));
        System.out.println("Forventet nyt array af 7 i arrayet: {7,6,16,7,8}");
        System.out.println("Aktuel nyt array: " + Arrays.toString(makeSum(a, b)));

        int[] c = {4, 6, 8, 2, 6};
        System.out.println("\nOpgave 6 fra Opgaver.pdf");
        System.out.println("Aktuelle arrays: " + Arrays.toString(a) + "og " + Arrays.toString(c));
        System.out.println("Forventet resultat: true og false");
        System.out.println("Aktuel resultat: " + hasUneven(a) + " og " + hasUneven(c) );

        int[] array1 = {4, 6}, array2 = {3, 2, 9, 5, 5};

        System.out.println("\nOpgave 5 fra Opgaver.pdf");
        System.out.println("Aktuelt array a: " + Arrays.toString(array1) + " og " + Arrays.toString(array2));
        System.out.println("Forventet nyt array af i arrayet: {7,8,9,5,5}");
        System.out.println("Aktuel nyt array: " + Arrays.toString(makeSumUnEvenArrays(array1, array2)));
    }



}
