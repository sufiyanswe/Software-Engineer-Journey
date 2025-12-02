package Day06;

/**
 * NumberPyramid:
 * Prints a centered number pyramid for a given value of N.

 * Example for N = 5:
 *     1
 *    1 2
 *   1 2 3
 *  1 2 3 4
 * 1 2 3 4 5

 * Key Concepts:
 * - Nested loops
 * - Controlled spacing for alignment
 * - Increasing numeric sequence per row
 */
public class NumberPyramid {
    public static void main(String[] args) {

        int N = 5; // Total number of rows

        // Outer loop controls the rows
        for (int i = 1; i <= N; i++) {

            // Print leading spaces to align the pyramid to the right
            for (int space = 1; space <= N - i; space++) {
                System.out.print(" ");
            }

            // Print numbers for the current row
            for (int num = 1; num <= i; num++) {
                System.out.print(num + " ");
            }

            // Move to the next row
            System.out.println();
        }
    }
}
