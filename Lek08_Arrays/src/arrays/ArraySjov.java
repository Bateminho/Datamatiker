package arrays;

import java.util.Arrays;

public class ArraySjov {

    public static void main(String[] args) {

        int[] alder = new int[10];

      //  System.out.println(alder);
        System.out.println(Arrays.toString(alder));

        alder[0] = 23;
        alder[1] = 45;
        alder[2] = 36;
        alder[3] = 26;
        alder[4] = 19;
        alder[5] = 25;
        alder[6] = 24;
        alder[7] = 27;
        alder[8] = 28;
        alder[9] = 23;

        System.out.println(Arrays.toString(alder));


        // Summen af tallene i arrayet
        int sum = 0;
        for (int i = 0; i < alder.length; i++) {
            sum = sum + alder[i];
        }
        System.out.println("Summern er: " + sum);

        // Det største tal i arrayet
        int max = alder[0];
        for (int i = 0; i < alder.length; i++) {
            if (alder[i] > max) {
                max = alder[i];
            }
        }
        System.out.println("Højeste alder: " + max);

        int[] alder2 = {34, 45, 33, 21, 22, 56};
        System.out.println(Arrays.toString(alder2));

        alder2[3] = 44;
        System.out.println(Arrays.toString(alder2));

        System.out.println(alder2.length);

        // Hvad sker der her ?
        for (int i = 0; i < alder2.length; i++) {
            alder2[i] = 23;
        }

       System.out.println(Arrays.toString(alder2));

        String[] navne = new String[4];
        System.out.println(Arrays.toString(navne));
		navne[0] = "Margrethe";
		navne[1] = "Marianne";
		navne[2] = "Marlene";
		navne[3] = "Margit";
		System.out.println(Arrays.toString(navne));

//        String[] nn = {"hjf", "fdlf"};
//        System.out.println(Arrays.toString(nn));

        // Hvad sker her ?
       //System.out.println(alder2[6]);

//		int[] values = {42, 9, 37};
//        // kopier refrence til array
//        int[] moreValues = values;
//
//        moreValues[1] = 50;
//        System.out.println(values[1]);
//
//        double[] forbrug = {12.3 , 23.1, 34.2};
//        double sidsteTal = forbrug[2];
//        System.out.println(sidsteTal);
    }

}
