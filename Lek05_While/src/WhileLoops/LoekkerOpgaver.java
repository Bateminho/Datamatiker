package WhileLoops;

import javax.sound.sampled.ReverbType;

public class LoekkerOpgaver {

    public static void main(String[] args) {

//        Kald af metoder der afprøver opgave 1

//        System.out.println(summerEven(100));
//        System.out.println(summerSquare(10));
//        System.out.println(sumOdd(3, 19));
//        allPowers(20);
//        System.out.println(sumDigits(1234));
//        System.out.println(sumOddDigits(32677));
        fizzBuzz(49);
       // reverse(6543);

    }

    // Metoden returnerer summen af alle lige tal mellem 2 og n
    public static int summerEven(int n) {
        int i = 2;
        int sum = 0;

        while (i <= n)
        {
            if (i % 2 == 0) {
                sum = sum + i;
            }
            i++;
        }

        return sum;
    }

    // Metoden returnerer summen af alle kvdrater mellem 1*1 og n*n
    public static int summerSquare(int n) {
        int i = 1;
        int sum = 0;

        while (i <= n)
        {
            sum = sum + i * i;
            i++;
        }
        return sum;
    }

    // Metoden returnerer summen af alle ulige tal mellem a og b
    public static int sumOdd(int a, int b) {
        int i = a;
        int sum = 0;

        while (i <= b)
        {
            if (i % 2 == 1) {
                sum = sum + i;
            }
            i++;
        }


        return sum;
    }

    // Metoden udskriver 2 potenser
    public static void allPowers(int n) {
        int i = 0;
        int sum = 1;

        while (i <= n)
        {
            System.out.println(sum);
            sum = sum * 2 ;
            i++;
        }

    }

    public static int sumDigits (int n)
    {
        int sum = 0;
        int digit;

        while (n > 0 )
        {
            digit = n % 10;
            n = n /10;
            sum += digit;
        }
        return sum;
    }

    public static int sumOddDigits(int number)
    {
        int sum = 0;
        int digit;

        while (number > 0 )
        {
            digit = number % 10;
            number = number /10;
            if (digit %2 != 0 )
                sum += digit;

        }

        return sum;
    }

    public static void fizzBuzz(int number) {
        int i = 1;

        while (i <= number) {
            if (i % 15 == 0 )
                System.out.println("FizzBuzz");
            else if (i % 5 == 0)
                System.out.println("Buzz");
            else if (i % 3 == 0)
                System.out.println("Fizz");
            else
                System.out.println(i);
            i++;
        }
    }

    public static void reverse(int number)
    {
        int result = 0;

        while (number > 0) {
            result = result * 10 + (number % 10);
            number /= 10;
        }

        System.out.println(result);
    }

}
