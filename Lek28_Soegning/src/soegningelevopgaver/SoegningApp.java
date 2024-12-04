package soegningelevopgaver;

import java.sql.SQLOutput;

public class SoegningApp {

	public static boolean findUlige(int[] tabel) {
		boolean result = false;
		int i = 0; // kanditmændge fra 0 til resten af arrayet
		while (!result && i < tabel.length) {
			if (tabel[i] % 2 == 1) {
				result = true;
			} else {
				i++;
			}
		}
		return result;
	}

	public static int linearSearchInRange(int[] table, int[] bounds) {
		int index = -1;
		int i = 0;

        while(index == -1 && i < table.length) {
			int k = table[i];
			if (k >= bounds[0] && k <= bounds[1]) {
				index = table[i];
			} else {
				i++;
			}
		}

		return index;
	}

	public static boolean linearSearchIsThereTwoEquals(int[] table) {
		boolean foundMatch = false;

		int i = 1; // Konstant foskel mellem elementerne
		int j = 0; // Start ved det første element

		// Forsæt, indtil enten et match findes eller hele arrayet er gennemsøgt
		while(!foundMatch && j < table.length - 1) {
			int k = table[i + j]; // Sammenlign element j med det næste
			if (k == table[j])
				foundMatch = true;
			else
				j++;
		}
		return foundMatch;
	}

	// her skriver du metoder til opgaverne 2,3,5,6 og 7
	
	public static void main(String[] args) {
		// Kode til afprøvning af opgave 1
		int[] talArray = {2,4,8,2};
		System.out.println("Er der et ulige tal i talArray ? " + findUlige(talArray));
		talArray[2] = 15;
		System.out.println("Er der et ulige tal i talArray ? " + findUlige(talArray));

		// Her tilføjes kode til at afprøve opgaverne 2,3,5,6 og 7

		// Opgave 2
		System.out.println("\nOpgave 2");
		talArray = new int[]{7, 56, 34, 3, 7, 14, 13, 4};

		int[] inRange = {10,15};

		System.out.println("Hvilket tal findes der mellem 10 og 15 i arrayet?: " + linearSearchInRange(talArray, inRange));

		// Opgave 3
		System.out.println("\nOpgave 3");
		int[] numberArray = {7, 9, 13, 7, 9, 13};
		System.out.println("Står der to ens i arrayet [7 9 13 7 9 13]?:" + linearSearchIsThereTwoEquals(numberArray));

		int[] numberArray2 = {7, 9, 13, 13, 9, 7};
		System.out.println("Står der to ens i arrayet [7 9 13 13 9 7]?:" + linearSearchIsThereTwoEquals(numberArray2));
	}

}
