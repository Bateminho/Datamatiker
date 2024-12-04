package WhileLoops;

public class Pattern {

    public static void main(String[] args) {
        // Print pattern up to 5
        displayPattern(5);
    }

    public static void displayPattern(int n) {

        // Start from row 1
        int row = 1;

        // Outer loop for each row
        while (row <= n) {

            // Inner loop to print numbers in increasing order from 1 to row
            int number = 1;
            while (number <= row) {
                // Print numbers in increasing order
                System.out.print(number + " ");
                number++;
            }

            // Move to the next line after each row
            System.out.println();
            row++;
        }

    }

}
