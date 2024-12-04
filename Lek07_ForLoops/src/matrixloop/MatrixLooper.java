package matrixloop;

public class MatrixLooper {
    public static void main(String[] args) {

        printMatrix(5);
    }

    public static void printMatrix(int n) {
        
        int row; //Init row
        int column; //init column

        //For loop to make rows = n
        for (row = 1; row <= n; row++) {

            //For loop to make columns = n
            for (column = n; column > 0; column--) {

                //Random number generator
                int number = (int) (Math.random() * 2);
                System.out.print(number + " ");
            }
            //Print a new line for a new row
            System.out.println();
        }

    }
}
