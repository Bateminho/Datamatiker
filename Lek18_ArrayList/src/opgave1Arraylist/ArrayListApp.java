package opgave1Arraylist;

import java.util.ArrayList;

public class ArrayListApp {
    public static void main(String[] args) {
        //Opgave 1
        ArrayList<String> nameList = new ArrayList<>();

        //Opgave 2
        nameList.add("Hans");
        nameList.add("Viggo");
        nameList.add("Jens");
        nameList.add("Børge");
        nameList.add("Bent");

        //Opgave 3
        System.out.println("Opgave 3");
        System.out.println("Antal af elementer er: " + nameList.size());

        //Opgave 4
        nameList.add(2, "Jane");

        //Opgave 5
        System.out.println("\nOpgave 5");
        for (String s : nameList) {
            System.out.println(s);
        }

        //Opgave 6
        nameList.remove(1);

        //Opgave 7
        nameList.addFirst( "Pia");

        //Opgave 8
        nameList.add("Ib");

        System.out.println("\nOpgave 9");
        System.out.println(nameList.size());

        //Opgave 10
        nameList.set(2, "Hansi");

        //Opgave 11
        System.out.println("\nOpgave 11");
        System.out.println(nameList.size());

        //Opgave 12
        System.out.println("\nOpgave 12");
        for (String s : nameList) {
            System.out.println(s);
        }

        //Opgave 13
        System.out.println("\nOpgave 13");
        for (int i = 0; i < nameList.size(); i++) {
            System.out.println(nameList.get(i).length());
        }

        //Opgave 14
        System.out.println("\nOpgave 14");
        for (String name : nameList) {
            System.out.println(name.length());
        }



    }


}
