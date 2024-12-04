package opgave4MethodsArrayList;

import javax.print.DocFlavor;
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

    public static void swapFirstAndLast(ArrayList<Integer> list) {

        int temp = list.getFirst();
        list.set(0,list.getLast());
        list.set(list.size() - 1, temp);
    }

    public static void moveElementsRight(ArrayList<Integer> list) {
        list.addFirst(list.getLast());
        list.removeLast();
    }

    public static int secondLargestElement(ArrayList<Integer> list) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int number : list) {
            if (number > largest) {
                secondLargest = largest;
                largest = number;
            } else if (number > secondLargest && number < largest) {
                secondLargest = number;
            }
        }
        return secondLargest;
    }

    public static Boolean sortedInAscendingOrder(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() -1 ; i++) {
            if (list.get(i) > list.get(i + 1) ) {
                return false;
            }
        }
        return true;
    }

    public static Boolean areThereDuplicates(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static ArrayList<Character> toCharacterArray(String s) {
        ArrayList<Character> newList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            newList.add(s.charAt(i));
        }
        return newList;
    }



    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
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


        //Opgave 4.1
        System.out.println("\nOpgave 4.1");
        System.out.println(list);
        swapFirstAndLast(list);
        System.out.println(list);

        //Opgave 4.2
        System.out.println("\nOpgave 4.2");
        moveElementsRight(list);
        System.out.println(list);

        //Opgave 4.3
        System.out.println("\nOpgave 4.3");
        System.out.println("Det næststørste element er: " + secondLargestElement(list));


        //Opgave 4.4
        System.out.println("\nOpgave 4.4");
        System.out.println(list);
        System.out.println("Arraylisten er i stigende orden: " + sortedInAscendingOrder(list));

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(19);
        list2.add(35);
        list2.add(143);
        list2.add(700);
        System.out.println(list2);
        System.out.println("Arraylisten er i stigende orden: " + sortedInAscendingOrder(list2));

        //Opgave 4.5
        System.out.println("\nOpgave 4.5");
        System.out.println(list);
        System.out.println("Der findes duplikater i listen: " + areThereDuplicates(list));

        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(7);
        list3.add(9);
        list3.add(20);
        list3.add(99);
        list3.add(7);
        System.out.println(list3);
        System.out.println("Der findes duplikater i listen: " + areThereDuplicates(list3));

        //Opgave 11.18n
        System.out.println("\nOpgave 11.18");
        System.out.println("String abc til char " + toCharacterArray("abc"));
    }


}
