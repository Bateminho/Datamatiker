package opgave5;

public class KvadratrodenUdenMathSqrt {

    public static int findSquareRootLinear(int n) {
        int heltal = -1;

         for (int r = 0; r <= n; r++) {
            if (r * r <= n && n < (r + 1) * (r + 1)) {
                heltal = r;
            }
        }
        return heltal;
    }

    public static int findSquareRootBinary(int n) {
        int heltal = -1;
        int left = 0;
        int right = n;
        while (heltal == -1 && left <= right) {
            int middle = (left + right) / 2;
            if (middle * middle <= n && n < (middle + 1) * (middle + 1)) {
                heltal = middle;
            } else if (middle * middle > n) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return heltal;
    }


    public static void main(String[] args) {

        int testtal = 144;

        /*
        1. Søgemængde: Alle heltal fra 0 til n
        2. Kandidatmængde: De heltal, der endnu ikke er udelukket.
        3. Kandidatelement: Det aktuelt testede tal.
        4. Kriterium: (r * r <= n && n < (r + 1) * (r + 1))
        5. Resultat: Returnér det største
𝑟
r, der opfylder kriteriet.
         */

        System.out.println("\nDet største heltalskvadratrod af et heltal med en liniær søgning er: " + findSquareRootLinear(testtal));
        System.out.println();
        System.out.println("Det største heltalskvadratrod af et heltal med en binær søgning er: " + findSquareRootBinary(testtal));
    }
}

