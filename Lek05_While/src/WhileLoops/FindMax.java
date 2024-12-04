package WhileLoops;

import java.util.Scanner;

public class FindMax {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int max = 0;

        System.out.println("Indtast tal slut med 0");
        int input = scan.nextInt();
        while(input != 0){
            if (input > max){
                max = input;
            }
            System.out.println("Indtast tal slut med 0");
            input = scan.nextInt();
        }
        System.out.println(max);


    }
}
