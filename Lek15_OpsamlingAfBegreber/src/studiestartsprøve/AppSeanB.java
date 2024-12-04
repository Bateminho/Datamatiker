package studiestartsprøve;

import java.util.Scanner;

public class AppSeanB {
    public static void main(String[] args) {

        Scanner inputScan = new Scanner(System.in);

        System.out.println("\n---------------------------------");
        System.out.println("---- Vi cykler til Sønderhøj ----");
        System.out.println("=================================");
        System.out.println("\nIndtast antal km. til EAAA fra hjem: ");
        int km = inputScan.nextInt();

        System.out.println("\nIndtast antal gange der er cyklet til EAAA: ");
        int antal = inputScan.nextInt();

       samletAntalKm(km, antal);


    }

    public static void samletAntalKm(int km, int antal) {
        int result = 2 * km * antal;

        if (result < 100)
            System.out.println("\nLavt");
        else if (result > 100 && result < 400)
            System.out.println("\nMellem");
        else
            System.out.println("\nHøjt");
    }
}
