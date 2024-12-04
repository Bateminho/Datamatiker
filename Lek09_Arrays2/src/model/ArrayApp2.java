package model;

import java.util.Arrays;

public class ArrayApp2 {

    // Metode der adderer 1 til alle tal i array og returnerer en kopi
    public static int[] addOne(int[] tabel) {
        int[] result = new int[tabel.length];
        for (int i = 0; i < tabel.length; i++) {
            result[i] = tabel[i] + 1;
        }
        return result;
    }

    // Metode der adderer 1 til alle tal i input array
    public static void addOne2(int[] tabel) {
        for (int i = 0; i < tabel.length; i++) {
            tabel[i] = tabel[i] + 1;
        }
    }

    public static void shiftLeft(int[] tabel) {
        int temp = tabel[0];
        for (int i = 1; i < tabel.length; i++) {
            tabel[i - 1] = tabel[i];
        }
        tabel[tabel.length - 1] = temp;
    }


    // Metode der finder antal tekster i et array der starter med et bestemt begyndelses bogstav
    public static int starterMed(String[] tabel, char c) {
        int antal = 0;
        for (int i = 0; i < tabel.length; i++) {
            if (tabel[i].charAt(0) == c) {
                antal++;
            }
        }
        return antal;
    }

    // Eksempel med forEach
    // Metode der finder antal tekster i et array der starter med et bestemt begyndelses bogstav
//    public static int starterMed2(String[] tabel, char c) {
//        int antal = 0;
//        for (String tekst : tabel) {
//            if (tekst.charAt(0) == c) {
//                antal++;
//            }
//        }
//        return antal;
//    }


    // Opgave 1.1
    public static void swapFirstLast(int[] table) {
        int lastElement = table.length - 1;
        int temp = table[0];
        table[0] = table[lastElement];
        table[lastElement] = temp;

        System.out.println(Arrays.toString(table));
    }

    // Opgave 1.2
    public static void swapEvenWithZero(int[] table) {

        for (int i = 0; i < table.length; i++) {
            if (table[i] % 2 == 0)
                table[i] = 0;
        }
        System.out.println(Arrays.toString(table));
    }

    //Opgave 1.3
    public static void minElement(int[] table) {
        int min = table[0];
        System.out.println("Jeg er første element i arrayet: " + min);

        for (int i = 1; i < table.length; i++)

            if (table[i] < min) {
                min = table[i];
                System.out.println("Jeg er nu det mindste element i arrayet: " + min);
            }
        System.out.println("Det mindste element i arrayet er ENDLIGT: " + min);
    }

    //Opgave 1.4
    public static int[] shiftOneRight(int[] table) {
        int lastElement = table[table.length - 1];

        for (int i = table.length - 1; i > 0; i--){
            table[i] = table[i-1];
        }
        table[0] = lastElement;

        return table;
    }

    //Opgave 1.5
    public static void nextHighestElement(int[] table) {
        int max = table[0];
        int nextHighest = 0;

        for (int i = 1; i < table.length; i++) {
            if (table[i] > max) {
                nextHighest = max;
                max = table[i];
            } else if (table[i] > nextHighest) {
                nextHighest = table[i];
            }
        }

        System.out.println("Det næst højeste element er: " + nextHighest);
    }

    //Opgave 1.6
    public static boolean elementRisingOrder(int[] table) {
        for (int i = 0; i < table.length - 1; i++) {
            if (table[i] > table[i + 1]) {
                return false;  // Hvis et element er større end det næste, er det ikke i stigende orden
            }
        }
        return true;  // Hvis ingen fejl blev fundet, er arrayet i stigende orden
    }

    //Opgave 1.7
    public static boolean doubleElements(int[] table) {
        // To for-loops. Den første hvor 'i' går igennem hvert element,
        //mens J starter fra i + 1 for at sammenligne aktuelt med efterfølgene element
        for (int i = 0; i < table.length; i++) {
            for (int j = i + 1; j < table.length; j++) {
                if (table[i] == table[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    //Opgave 2.1
    public static int lengthFour(String[] table) {

        int result = 0;
        for (String s : table) {
            if (s.length() == 4)
                result++;
        }
        return result;
    }

    //Opgave 2.2
    public static int lengthOfStrings(String[] table, int stringLength) {

        int result = 0;

        for (String s : table) {
            if (s.length() == stringLength)
                result++;
        }

        return result;
    }

    //Opgave 2.3
    public static String[] turnFirstToUpper(String[] stringArray) {

//        String[] result = new String[stringArray.length];
//
//        for (int i = 0; i < stringArray.length; i++) {
//            result[i] = stringArray[i].toUpperCase();
//        }
//        for (int i = 0; i < stringArray.length; i++) {
//            result[i] = result[i].charAt(0) + stringArray[i].substring(1);
//        }
//
//        return result;
//    }

        String[] result = new String[stringArray.length];
        int index = 0; // to keep track of the index in the result array

        for (String s : stringArray) {
            if (s != null && !s.isEmpty()) { // Check for null or empty strings
                // Convert the whole string to uppercase first
                String upper = s.toUpperCase();

                // Then, ensure the first letter is uppercase and concatenate with the rest
                result[index] = upper.charAt(0) + s.substring(1);
            } else {
                result[index] = s; // For null or empty strings, keep the original
            }
            index++; // Move to the next index
        }

        return result;
    }



    public static void main(String[] args) {
        int[] tal = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(tal));
        int[] newTabel = addOne(tal);
        System.out.println("Gamle: " + Arrays.toString(tal));
        System.out.println("Nye  : " + Arrays.toString(newTabel));
        System.out.println();
        addOne2(tal);
        System.out.println("Gamle: " + Arrays.toString(tal));
//
//        int[] copy = new int[tal.length];
//        for (int i = 0; i < tal.length; i++) {
//            copy[i] = tal[i];
//        }

        System.out.println();
        shiftLeft(tal);
        System.out.println(Arrays.toString(tal));

        System.out.println();
        String[] navne = {"Maria", "Mette", "Lene", "Mona", "Jane"};
        System.out.println("Starter med M: " + starterMed(navne, 'M'));
        //System.out.println("Starter med M: " + starterMed2(navne,'M'));


        System.out.println("\nOpgave 1");
        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Aktuelt array [1, 2, 3, 4, 5]");
        System.out.println("Forventet array [5, 2, 3, 4, 1]");
        swapFirstLast(numbers);

        System.out.println("\nOpgave 1.2");
        int[] evenNumbers = {1, 2, 3, 4, 5,};
        System.out.println("Aktuelt array [1, 2, 3, 4, 5]");
        System.out.println("Forventet array [1, 0, 3, 0, 5]");
        swapEvenWithZero(evenNumbers);

        System.out.println("\nOpgave 1.3");
        int[] minNumber = {5, 2, 3, 4, 1,};
        System.out.println("Aktuelt array [5, 2, 3, 4, 1]");
        System.out.println("Forventet udskrifter vil være: 5, 2 og endeligt 1");
        minElement(minNumber);

        System.out.println("\nOpgave 1.4");
        int[] shiftArray = {1, 4, 9, 16, 25};
        System.out.println("Aktuelt array [1, 4, 9, 16, 25]");
        System.out.println("Forventet array [25, 1, 4, 9, 16]");
        System.out.println("Resultat er: " + Arrays.toString(shiftOneRight(shiftArray)));

        System.out.println("\nOpgave 1.5");
        int[] nextE = {10, 2, 45, 4, 99};
        System.out.println("Aktuelt array [10, 2, 45, 4, 99]");
        System.out.println("Forventet udskrift vil være: 45");
        nextHighestElement(nextE);

        System.out.println("\nOpgave 1.6");
        int[] raising = {1, 2, 3, 4, 5};
        System.out.println("Aktuelt array [1, 2, 3, 4, 5]");
        System.out.println("Forventet resultat: True");
        System.out.println("Resultat er: " + elementRisingOrder(raising));
        int[] notRaising = {1, 2, 5, 4, 5};
        System.out.println("\nAktuelt array [1, 2, 5, 4, 5]");
        System.out.println("Forventet resultat: False");
        System.out.println("Resultat er: " + elementRisingOrder(notRaising));

        System.out.println("\nOpgave 1.7");
        int[] tableDouble = {2, 5, 8, 5};
        int[] tableNoDouble = {2, 5, 8, 6};
        System.out.println("Aktuelt array [2, 5, 8, 5]");
        System.out.println("Forventet resultat: True");
        System.out.println("Resultat er: " + doubleElements(tableDouble));
        System.out.println("\nAktuelt array [2, 5, 8, 6]");
        System.out.println("Forventet resultat: False");
        System.out.println("Resultat er: " + doubleElements(tableNoDouble));

        System.out.println("\nOpgave 2.1");
        String[] strings = {"Hejsa", "Nørd", "Dart", "Hej", "Hjem"};
        System.out.println("Aktuelt array: [Hejsa, Nørd, Dart, Hej, Hjem]");
        System.out.println("Forvente resultat: 3");
        System.out.println(lengthFour(strings));

        System.out.println("\nOpgave 2.2");
        String[] strings2 = {"Hejsa", "Nørd", "Dart", "Hej", "Hjem", "Hejsa", "Nørd", "Dart", "Hej", "Hjem"};
        System.out.println("Aktuelt array: [Hejsa, Nørd, Dart, Hej, Hjem, Hejsa, Nørd, Dart, Hej, Hjem}");
        System.out.println("Forvente resultat: 2");
        System.out.println(lengthOfStrings(strings2, 5));

        System.out.println("\nOpgave 2.3");
        String[] strings3 = {"hejsa", "nørd", "dart", "hej", "hjem"};
        System.out.println("Aktuelt array: [hejsa, nørd, dart, hej, hjem]");
        System.out.println("Forvente resultat: [Hejsa, Nørd, Dart, Hej, Hjem]");
        System.out.println("Resultatet er: " + (Arrays.toString(turnFirstToUpper(strings3))));

   }

}
