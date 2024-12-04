package OpgaverMedIFOgElse;

import java.util.Scanner;

public class AdditionQuiz {
    public static void main(String[] args) {

        // Lav tre tilfældige tal mellem 1 og 10
        int number1 = (int) ((Math.random() * 10) + 1);
        int number2 = (int) ((Math.random() * 10) + 1);
        int number3 = (int) ((Math.random() * 10) + 1);

        // Create a Scanner
        Scanner input = new Scanner(System.in);

        System.out.print(
                "What is " + number1 + " * " + number2 + " * " + number3 + "?");

        int answer = input.nextInt();

        boolean correct = number1 * number2 * number3 == answer;

        System.out.println(number1 + " * " + number2 + " * " + number3 + " = " + answer + " is: " + correct);
    }
}
