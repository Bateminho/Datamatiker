package ForLoopToWhileLoopToDoWhilleLoop;

import java.sql.SQLOutput;

public class LoopChanger {
    public static void main(String[] args) {

      long sum = 0;
      for (int i = 0; i <= 1000; i++) {
          sum = sum + i;

      }
        System.out.println("Sum fra for loop er: " + sum);

      int i = 0;
      int sumWhile = 0;
      while ( i <= 1000)
      {

          sumWhile = sumWhile + i;
          i++;
      }
        System.out.println("Sum fra while loop er: " + sumWhile);


        int sumDoWhile = 0;
        i = 0;

        do {
            sumDoWhile = sumDoWhile + i;
            i++;
        } while (i <= 1000);

        System.out.println("Sum fra do-while er: " + sumDoWhile);
    }



}
