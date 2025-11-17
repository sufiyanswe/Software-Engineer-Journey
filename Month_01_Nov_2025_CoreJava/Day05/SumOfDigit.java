package Day05;

/**
 * SumOfDigits:
 * This program calculates the sum of digits of a given integer.
 * Example:
 * Input  : 293
 * Process: 2 + 9 + 3
 * Output : 14
 * Core Concepts Used:
 * - for-loop without traditional initialization/update
 * - Digit extraction using modulus (%) and division (/)
 * - Safe use of a temporary variable (temp) to avoid mutating original input
 */
public class SumOfDigit {

    public static void main(String[] arg) {

        // Original input number (not mutated during processing)
        int N = 293;

        // Variable to store cumulative digit sum
        int sum = 0;

        /*
         * Extract each digit using a for-loop:
         * temp % 10 → gives last digit
         * temp / 10 → removes the last digit
         * Loop runs until temp becomes 0.
         * Example breakdown for N = 293:
         * 293 % 10 = 3 → sum = 3
         * 29  % 10 = 9 → sum = 12
         * 2   % 10 = 2 → sum = 14
         */
        for (int temp = N; temp > 0; temp /= 10) {
            int digit = temp % 10;   // extract last digit
            sum += digit;            // add to sum
        }

        // Final result after processing all digits
        System.out.println(sum);
    }
}
