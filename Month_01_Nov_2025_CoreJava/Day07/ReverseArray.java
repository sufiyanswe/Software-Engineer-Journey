/*
 * Problem Statement:
 * ------------------
 * Write a program to reverse an array and print its elements in reverse order.
 *
 * Example:
 * Input:  {2, 4, 5, 6, 5}
 * Output: 5 6 5 4 2
 *
 * Explanation:
 * The array is traversed from the last index to the first index,
 * printing each element in reverse order.
 */

package Day07;

public class ReverseArray {

    public static void main(String[] args) {
        // Example input array
        int[] arr = {2, 4, 5, 6, 5};

        // Print array elements in reverse order
        printReverse(arr);
    }

    /**
     * Method to print elements of an array in reverse order.
     *
     * @param arr The input array
     */
    public static void printReverse(int[] arr) {
        // Traverse array from last index to first
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}