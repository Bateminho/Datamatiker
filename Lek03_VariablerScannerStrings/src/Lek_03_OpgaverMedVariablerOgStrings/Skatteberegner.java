package Lek_03_OpgaverMedVariablerOgStrings;

import java.util.Scanner;

public class Skatteberegner {
    public static void main(String[] args) {

        //Init scanner
        Scanner input = new Scanner(System.in);

        //Init variabler som personalTaxAllowance, lmContribution, salaryMonth, salaryYear

        double personalTaxAllowance = 48000,
                lmContribution = 0.92,
                salaryMonth,
                salaryYear,
                tax = .37,
                paidTaxMonth,
                paidTaxYear,
                taxableIncome;


        //Prompt user for salary
        System.out.println("\nDette program beregner skatten af din løn");
        System.out.println("Indtast din månedsløn.");

        //Scan input
        salaryMonth = input.nextDouble();

        //Compute tax
        salaryYear = salaryMonth * 12;
        taxableIncome = salaryYear * lmContribution - personalTaxAllowance;
        paidTaxYear = taxableIncome * tax;
        paidTaxMonth = paidTaxYear / 12;

        //Print results
        System.out.printf("Ved en årsløn på %.02f kr. skal du betale %.02f kr. i skat", salaryYear, paidTaxYear);
        System.out.printf("\nPr måned betaler du %.02f kr. i skat", paidTaxMonth);
    }
}
