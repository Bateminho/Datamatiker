package Lek_03_OpgaverMedVariablerOgStrings;

import java.util.Locale;

public class FunWithStrings {
    public static void main(String[] args) {
        String word1 = "Datamatiker";
        String word2 = "Uddannelsen";

        System.out.println(String.format("\nOrd1 er %s og ord2 er %s: %n" , word1, word2));

        System.out.println("Opgave A ord1 toUppercase er: " + word1.toUpperCase());
        System.out.println("Opgave B ord2 toLowercase er: " + word2.toLowerCase());
        System.out.println("Opgave C ord1 og ord2 sammensat med mellemrum er: " + word1 + " " + word2);

        String word3 = word1 + word2.toLowerCase();
        System.out.println("Opgave D ord3 er: " + word3);

        System.out.println("Opgave E længden af ord3 er: " + word3.length());

        System.out.println("Opgave F de første syv bogstaver er ord1 er: " + word1.substring(0,7));
        System.out.println("Opgave G bogstav 3-7 i ord2 er: " + word2.substring(2,7));

        int lengthWord3 = word3.length();
        int halflengthWord3 = lengthWord3/2;

        System.out.println("Opgave H 2. havldel udskrevet af ord3 er: " + word3.substring(halflengthWord3, lengthWord3 ));


    }
}
