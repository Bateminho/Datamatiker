package model;

import java.util.ArrayList;

public class EksempelArrayListPP {

	public static void main(String[] args) {
		ArrayList<String> list;
		list = new ArrayList<>();

		ArrayList<Integer> talene = new ArrayList<Integer>();

		talene.add(4);talene.add(2);talene.add(5);talene.add(1);
		int tal = talene.get(2);


		list.add("Hugo"); // add tilføjer bagest i listen
		list.add("Keld");
		list.add("Børge");
		list.add("Egon");

		int size = list.size(); // size returnerer listens størrelse
		System.out.println("Listen indeholder " + size + " elementer");
		System.out.println(list);
		
        System.out.println(list.get(2)); // returnerer indholdet på plads 2 i listen
        System.out.println(list.size());
        list.add("Finn"); // tilføjer Finn bagest i listen
        list.add(1, "Dan"); // indsætter Dan på plads 1. Elementerne på plads 1 og frem rykkes en plads til højre
		System.out.println(list);

		ArrayList<Person> personer = new ArrayList<>();
		Person p1 = new Person("Iv",300);
		Person p2 = new Person("Bo",100);
		Person p3 = new Person("Per",400);
		personer.add(p1);
		personer.add(p2);
		personer.add(p3);

		int sum = 0;
		for (int i = 0; i <personer.size() ; i++) {
			Person person = personer.get(i);
			sum = sum + person.getWageMonth();

		}
		System.out.println(sum);

		sum = 0;
		for(Person person: personer){
			sum = sum + person.getWageMonth();
		}
		System.out.println(sum);
		System.out.println(personer);

//		list.remove(1); // sletter elementet på indeks plads 1 og rykker elementerne en plads til venstre
//        list.set(1, "Ib"); // overskriver elemetet på plads 1 med Ib
//		System.out.println(list);
//
//		System.out.println("-------------------------------------------------");
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}

//		System.out.println("-------------------------------------------------");
//		for (String s : list) {
//			System.out.println(s);
//		}

	}

}
