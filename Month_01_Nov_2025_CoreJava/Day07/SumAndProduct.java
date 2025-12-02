/*
 * Problem Statement:
 * ------------------
 * Given an array of integers, calculate both:
 * 1. The sum of all elements
 * 2. The product of all elements
 *
 * If the array is empty, print "Array is empty".
 *
 * Example:
 * Input:  {1, 2, 3, 4, 5}
 * Output: Sum = 15, Product = 120
 *
 * Explanation:
 * Sum = 1 + 2 + 3 + 4 + 5 = 15
 * Product = 1 * 2 * 3 * 4 * 5 = 120
 */

package Day07;

public class SumAndProduct {

    public static void main(String[] args) {
        // Example input array
        int[] arr = {1, 2, 3, 4, 5};

        // Call the method to calculate sum and product
        calculateSumAndProduct(arr);

        // Example with empty array
        int[] emptyArr = {};
        calculateSumAndProduct(emptyArr);
    }

    /**
     * Method to calculate and print both sum and product of array elements.
     * Handles the edge case when the array is empty.
     *
     * @param arr The input array of integers
     */
    public static void calculateSumAndProduct(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Array is empty");
            return;
        }

        int sum = 0;       // variable to store sum
        int product = 1;   // variable to store product

        // Iterate through each element
        for (int num : arr) {
            sum += num;       // accumulate sum
            product *= num;   // accumulate product
        }

        // Print results
        System.out.println("Sum = " + sum + ", Product = " + product);
    }
}