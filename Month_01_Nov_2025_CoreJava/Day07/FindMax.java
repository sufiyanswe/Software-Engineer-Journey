package Day07;

/**
 * Problem: Find Maximum in an Array
 * Author: Sufiyan
 * Description:
 *   Given an integer array, return the maximum element.
 *   This is a basic array traversal problem used in DSA.
 */

public class FindMax {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 6, 4, 7};
        System.out.println(findMax(arr));
    }

    /**
     * Returns the maximum value in the array.
     * @param arr input array (must not be empty)
     * @return largest integer in arr
     */
    static int findMax(int[] arr) {

        // Optional edge-case check (good practice)
        if (arr == null || arr.length == 0) {
            return Integer.MIN_VALUE;
        }

        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }
}

