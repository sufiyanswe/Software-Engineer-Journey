/*
 * Problem Statement:
 * ------------------
 * Write a program to calculate the sum of all elements in an integer array.
 * The program should iterate through the array, accumulate the values,
 * and return the total sum.
 *
 * Example:
 * Input: values = {10, 20, 30, 40}
 * Output: Sum = 100
 *
 * Explanation:
 * The sum of 10 + 20 + 30 + 40 = 100
 */

package Day07;

public class ArraySum {

    public static void main(String[] args) {
        // Initialize an array of integers
        int[] values = {10, 20, 30, 40};

        // Call the sumArray method and print the result
        System.out.println("Sum = " + sumArray(values)); // Expected Output: Sum = 100
    }

    /**
     * Method to calculate the sum of integers in an array.
     *
     * @param numbers The array of integers
     * @return The total sum of all elements in the array
     */
    public static int sumArray(int[] numbers) {
        int sum = 0; // variable to store accumulated sum

        // Enhanced for-loop to iterate through each element
        for (int num : numbers) {
            sum += num;  // add current element to sum
        }

        return sum; // return the final sum
    }
}