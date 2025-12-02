package Day06;

/**
 * RightAlignedTriangle:
 * Prints a right-aligned triangle pattern of stars (*) for a given number of rows.

 * Example for N = 5:
 *     *
 *    **
 *   ***
 *  ****
 * *****

 * Key Concepts:
 * - Nested loops (outer loop for rows, inner loops for spaces and stars)
 * - Pattern alignment using controlled spacing
 * - Decreasing spaces and increasing stars per row
 */
public class RightAlignedTriangle {

    public static void main(String[] args) {

        // Total number of rows in the triangle
        int N = 5;

        /*
         * Outer loop: controls number of rows.
         * i = current row index (1 to N)
         */
        for (int i = 1; i <= N; i++) {

            /*
             * First inner loop:
             * Prints the required spaces before the stars.
             * Number of spaces = N - i
             */
            for (int space = 1; space <= N - i; space++) {
                System.out.print(" ");
            }

            /*
             * Second inner loop:
             * Prints the stars for the current row.
             * Number of stars = i
             */
            for (int star = 1; star <= i; star++) {
                System.out.print("*");
            }

            // Move to next line after printing one full row
            System.out.println();
        }
    }
}
