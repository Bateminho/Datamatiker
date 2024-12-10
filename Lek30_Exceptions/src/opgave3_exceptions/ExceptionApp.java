package opgave3_exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionApp {
    public static void main(String[] args) {
        int[] prim = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        try (Scanner scan = new Scanner(System.in)) {
            try {
                System.out.print("Hvilket nr. primtal skal vises?: ");

                int n = scan.nextInt();

                if (n < 1 || n > 10) {
                    throw new ArrayIndexOutOfBoundsException("Tallet skal være mellem 1 og 10");
                }
                System.out.println("Primtal nr. " + n + " er " + prim[n - 1] + "\n");

            } catch (ArrayIndexOutOfBoundsException e) {

                System.out.println("Fejl: " + e.getMessage());
                System.out.println("Prøv igen");
            } catch (InputMismatchException e) {
                System.out.println("Fejl: Du skal indtaste et heltal!");
            }

        }

    }
}
