package Day07;

/**
 * Problem: Count Elements in an Array
 * Author: Zayn
 * Description:
 *   Given an integer array, count and return the number of elements in it.
 *   This demonstrates basic array traversal using an enhanced for-loop.
 */

public class CountElements {

    public static void main(String[] args) {
        int[] arr = {5, 10, 15, 20, 25, 30};
        System.out.println("Array has " + countElements(arr) + " elements");
    }

    /**
     * Counts how many elements the array contains.
     *
     * @param arr input integer array (may be empty)
     * @return the total number of elements
     */
    static int countElements(int[] arr) {
        int count = 0;

        for (int num : arr) {
            count++;
        }

        return count;
    }
}
