package soegningelev;

import java.util.ArrayList;

public class SoegningNote {
	public static int linearSearchList(ArrayList<String> list, String target) {
		int indeks = -1;
		int i = 0;
		while (indeks == -1 && i < list.size()) {
			String k = list.get(i);
			if (k.equals(target))
				indeks = i;
			else
				i++;
		}
		return indeks;
	}

	public static Kunde linearSearchKunde(ArrayList<Kunde> list, String name) {
		Kunde kunde = null;
		int i = 0;
		while (kunde == null && i < list.size()) {
			Kunde k = list.get(i);
			if (k.getNavn().equals(name))
				kunde = k;
			else {
				i++;
			}
		}
		return kunde;
	}

	public static int linearSearchArray(String[] list, String target) {
		int indeks = -1;
		int i = 0;
		while (indeks == -1 && i < list.length) {
			String k = list[i];
			if (k.equals(target))
				indeks = i;
			else
				i++;
		}
		return i;
	}

	public static Kunde linearSearchKundeArray(Kunde[] list, String name) {
		Kunde kunde = null;
		int i = 0;
		while (kunde == null && i < list.length) {
			Kunde k = list[i];
			if (k.getNavn().equals(name))
				kunde = k;
			else
				i++;
		}
		return kunde;
	}

	public static int binSearchArray(int[] arr, int target) {
		int indeks = -1;
		int left = 0;
		int right = arr.length - 1;
		int middle = -1;
		while (indeks == -1 && left <= right) {
			middle = (left + right) / 2;
			int k = arr[middle];
			if (k == target)
				indeks = middle;
			else if (k > target)
				right = middle - 1;
			else
				left = middle + 1;
		}
		return indeks;
	}

	public static Kunde binSearchList(ArrayList<Kunde> list, String name) {
		Kunde kunde = null;
		int left = 0;
		int right = list.size() - 1;
		int middle = -1;
		while (kunde == null && left <= right) {
			middle = (left + right) / 2;
			Kunde k = list.get(middle);
			int comp = k.getNavn().compareTo(name);
			if (comp == 0)
				kunde = k;
			else if (comp > 0)
				right = middle - 1;
			else
				left = middle + 1;
		}
		return kunde;

	}

}
