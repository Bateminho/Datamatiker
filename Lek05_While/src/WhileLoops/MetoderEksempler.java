package WhileLoops;

import java.util.Scanner;

public class MetoderEksempler {


    public static int sumDigits(int tal){
        int digit1 = tal%10;
        tal = tal/10;

        int digit2 = tal%10;
        tal = tal/10;

        int digit3 = tal%10;
        return digit1 + digit2 + digit3;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Indtast heltal mellem 0 og 1000: ");
        int input = scan.nextInt();
        int result = sumDigits(input);

        System.out.println("Summen af tallene er: " + result);

    }
}
