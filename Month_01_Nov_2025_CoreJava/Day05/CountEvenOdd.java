package Day05;

/**
 * CountEvenOdd:
 * This program counts how many digits in a given integer
 * are even and how many are odd, using pure arithmetic.
 * Example:
 * Input  : 1345
 * Digits : 5 (odd), 4 (even), 3 (odd), 1 (odd)
 * Output :
 * Even: 1
 * Odd: 3
 * Key Concepts:
 * - Digit extraction using % 10
 * - Removing digits using / 10 (integer division)
 * - Using independent counters for even and odd digits
 * - Looping until all digits are processed
 */
public class CountEvenOdd {

    public static void main(String[] args) {

        // Original input number
        int N = 1345;

        // Counters for even and odd digits
        int evenCount = 0;
        int oddCount = 0;

        /*
         * Loop through the number digit-by-digit.
         * temp % 10 → last digit
         * temp / 10 → remove last digit
         */
        for (int temp = N; temp > 0; temp /= 10) {
            int digit = temp % 10;

            // Check even or odd
            if (digit % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        // Print final results
        System.out.println("Even: " + evenCount);
        System.out.println("Odd: " + oddCount);
    }
}
