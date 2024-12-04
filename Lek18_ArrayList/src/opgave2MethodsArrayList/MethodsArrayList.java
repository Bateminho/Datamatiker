package opgave2MethodsArrayList;

import java.util.ArrayList;

public class MethodsArrayList {

    /**
     * @param list
     * @return sums the numbers in the list using a for loop
     */
    public static int sumListe(ArrayList<Integer> list) {
        int resultat = 0;
        for (int i = 0; i < list.size(); i++) {
            //	int tal = list.get(i);
            resultat = resultat + list.get(i);
        }
        return resultat;
    }

    /**
     * @param list
     * @return sums the numbers in the list using a forEach loop
     */
    public static int sumListe2(ArrayList<Integer> list) {
        int resultat = 0;
        for (int tal : list) {
            resultat = resultat + tal;
        }
        return resultat;
    }

    /**
     * @param list
     * @return index at the first even number
     */
    public static int hasEvenAtIndex(ArrayList<Integer> list) {
        int index = -1;
        int i = 0;
        while (index == -1 && i < list.size()) {
            if (list.get(i) % 2 == 0) {
                index = i;
            }
            i++;
        }
        return index;

    }

    public static int min(ArrayList<Integer> list) {
        int resultMin = list.getFirst();

        for (int integer : list) {
            if (integer < resultMin)
                resultMin = integer;
        }

        return resultMin;
    }

    public static double average(ArrayList<Integer> list) {
        double resultAvg = 0;

        for (int number : list) {
            resultAvg = resultAvg + number;
        }

        return resultAvg / list.size();
    }

    public static int countZeroes(ArrayList<Integer> list) {
        int resultNumberOfZeroes = 0;

        for (int number : list) {
            if (number == 0) {
                resultNumberOfZeroes++;
            }
        }

        return resultNumberOfZeroes;
    }

    public static void swapEvenWithZeroes(ArrayList<Integer> list) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.set(i, 0);
            }

        }
    }

    public static ArrayList<Integer> aEventList(ArrayList<Integer> list) {
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        for (int number : list) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            }
        }
        
        return evenNumbers;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(19);
        list.add(35);
        list.add(14);
        list.add(7);
        System.out.println(list);
        System.out.println("Summen af tallene i listen med for "
                + sumListe(list));
        System.out.println("Summen af tallene i listen med forEach "
                + sumListe2(list));

        System.out.println("Indeks for det første lige tal: "
                + hasEvenAtIndex(list));

        //Opgave 1
        System.out.println("\nOpgave 1");
        System.out.println("Det laveste tal i listen er: " + min(list));

        //Opgave 2
        System.out.println("\nOpgave 2");
        System.out.println("Gennemsnittet af tallene i listen er: " + average(list));

        //Opgave 3
        System.out.println("\nOpgave 3");
        System.out.println("Antal gange 0 forekommer i listen er: " + countZeroes(list));
        list.add(0);
        System.out.println(countZeroes(list));

        //Opgave 4
        System.out.println("\nOpgave 4");
        for (Integer integer : list) {
            System.out.println(integer);
        }
      //  swapEvenWithZeroes(list);
        System.out.println("\nEfter metoden ser listen nu således ud: ");
        for (Integer integer : list) {
            System.out.println(integer);
        }
        
        //Opgave 5
        System.out.println("\nOpgave 5");
        System.out.println("Her er en ny liste, som kun indeholder lige tal fra den oprindelige liste: " + aEventList(list));
        
    }

}
