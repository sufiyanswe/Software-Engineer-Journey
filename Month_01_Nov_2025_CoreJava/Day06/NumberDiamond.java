package Day06;

/**
 * NumberDiamond:
 * Prints a full number diamond pattern consisting of an upper and lower pyramid.

 * Example for N = 5:

 *     1
 *    1 2
 *   1 2 3
 *  1 2 3 4
 * 1 2 3 4 5
 *  1 2 3 4
 *   1 2 3
 *    1 2
 *     1

 * Key Concepts:
 * - Nested loops
 * - Controlled spacing for center alignment
 * - Symmetric top and bottom pyramid construction
 * - Increasing and decreasing sequences
 */
public class NumberDiamond {
    public static void main(String[] args) {

        int N = 5; // Total number of rows

        // Upper pyramid (increasing)
        for (int i = 1; i <= N; i++) {

            // Print leading spaces
            for (int space = 1; space <= N - i; space++) {
                System.out.print(" ");
            }

            // Print numbers 1 to i
            for (int num = 1; num <= i; num++) {
                System.out.print(num + " ");
            }

            System.out.println();
        }

        // Lower pyramid (decreasing)
        for (int i = N - 1; i >= 1; i--) {

            // Print leading spaces
            for (int space = 1; space <= N - i; space++) {
                System.out.print(" ");
            }

            // Print numbers 1 to i
            for (int num = 1; num <= i; num++) {
                System.out.print(num + " ");
            }

            System.out.println();
        }
    }
}
