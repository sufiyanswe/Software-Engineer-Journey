package Day05;

/**
 * ReverseNumber:
 * This program reverses the digits of a given integer using pure arithmetic.
 * Example:
 * Input  : 1234
 * Process: 4 → 3 → 2 → 1 (using % and /)
 * Output : 4321
 * Key Concepts:
 * - Digit extraction using % 10
 * - Removing digits using / 10 (integer division)
 * - Rebuilding reversed number using rev = rev * 10 + digit
 * - Use of a temporary variable to avoid mutating the input
 */
public class ReverseNumber {

    public static void main(String[] args) {

        // Original input number (kept unchanged throughout the program)
        int N = 1234;

        // Accumulator for the reversed number
        int rev = 0;

        /*
         * We loop through the number using a temporary variable `temp`.
         * temp % 10 → gives the last digit
         * temp / 10 → removes the last digit
         * rev = rev * 10 + digit:
         *      This shifts existing digits left and adds the new extracted digit.
         */
        for (int temp = N; temp > 0; temp /= 10) {
            int digit = temp % 10;      // Extract last digit
            rev = rev * 10 + digit;     // Build reversed number
        }

        // Final output: reversed number
        System.out.println(rev);
    }
}
