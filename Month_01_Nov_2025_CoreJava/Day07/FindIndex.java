/*
 * Problem Statement:
 * ------------------
 * Write a program to find the index of a given target element in an array.
 * If the target element exists in the array, return its index.
 * If the target element does not exist, return -1.
 *
 * Example:
 * Input: arr = {2, 4, 5, 8, 20}, target = 4
 * Output: Index of target is: 1
 *
 * Explanation:
 * The element 4 is present at index 1 (0-based indexing).
 */

package Day07;

public class FindIndex {

    public static void main(String[] args) {
        // Initialize an array of integers
        int[] arr = {2, 4, 5, 8, 20};

        // Define the target element to search for
        int target = 4;

        // Call the findIndex method to search for the target
        int result = findIndex(arr, target);

        // Print the result (index of target or -1 if not found)
        System.out.println("Index of target is: " + result);
    }

    /**
     * Method to find the index of a target element in an array.
     *
     * @param arr    The array of integers
     * @param target The element to search for
     * @return Index of target if found, otherwise -1
     */
    public static int findIndex(int[] arr, int target) {
        // Loop through each element of the array
        for (int i = 0; i < arr.length; i++) {
            // If current element matches the target, return its index
            if (arr[i] == target) {
                return i;
            }
        }
        // If target not found, return -1
        return -1;
    }
}