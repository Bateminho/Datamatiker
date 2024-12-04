package Lek_03_OpgaverMedVariablerOgStrings;

import java.util.Scanner;

public class ComputeGratuityAndTotal {public static void main(String[] args) {
    // Opret en scanner til at læse input fra brugeren
    Scanner input = new Scanner(System.in);

    // Bed brugeren om at indtaste subtotal og drikkepengeprocent (gratuity rate)
    System.out.print("Enter the subtotal and a gratuity rate: ");
    double subtotal = input.nextDouble();
    double gratuityRate = input.nextDouble();

    // Beregn drikkepengene (gratuity)
    double gratuity = subtotal * (gratuityRate / 100);

    // Beregn den samlede total
    double total = subtotal + gratuity;

    // Vis drikkepengene og den samlede total
    System.out.printf("The gratuity is $%.2f and total is $%.2f\n", gratuity, total);
}
}