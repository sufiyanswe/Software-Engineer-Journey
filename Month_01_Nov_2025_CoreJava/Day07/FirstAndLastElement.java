/*
 * Problem Statement:
 * ------------------
 * Given an array, print its first and last elements.
 * If the array is empty, print "Array is empty".
 *
 * Example 1:
 * Input:  {10, 20, 30, 40, 50}
 * Output: First: 10, Last: 50
 *
 * Example 2:
 * Input:  {}
 * Output: Array is empty
 */

package Day07;

public class FirstAndLastElement {

    public static void main(String[] args) {
        // Example 1: Non-empty array
        int[] arr1 = {10, 20, 30, 40, 50};
        printFirstAndLast(arr1);

        // Example 2: Empty array
        int[] arr2 = {};
        printFirstAndLast(arr2);
    }

    /**
     * Prints the first and last elements of the array.
     * Handles the edge case when the array is empty.
     *
     * @param arr The input array
     */
    public static void printFirstAndLast(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Array is empty");
        } else {
            System.out.println("First: " + arr[0] + ", Last: " + arr[arr.length - 1]);
        }
    }
}