package Day05;

/**
 * CountDivisibleBy3:
 * This program counts how many numbers from 1 to N
 * are divisible by 3.
 * Example:
 * N = 20
 * Numbers divisible by 3 → 3, 6, 9, 12, 15, 18
 * Output → 6
 * Key Concepts:
 * - Basic for-loop iteration
 * - Conditional check using modulo operator (%)
 * - Counter-based accumulation
 * - Clean separation between logic and output
 */
public class CountDivisibleBy3 {

    public static void main(String[] arg) {

        // Upper limit for the range 1 to N
        int N = 20;

        // Counter to track how many numbers are divisible by 3
        int count = 0;

        /*
         * Loop from 1 through N:
         * If a number is divisible by 3, increment the counter.
         */
        for (int i = 1; i <= N; i++) {
            if (i % 3 == 0) {
                count++;
            }
        }

        // Print final total count
        System.out.println(count);
    }
}
