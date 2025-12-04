/*
 * Problem Statement:
 * ------------------
 * Write a program to copy the contents of one array into another.
 * After copying, verify that the two arrays are independent by modifying
 * the copy and showing that the original remains unchanged.
 *
 * Example:
 * Input:  {10, 20, 30, 40, 50}
 * Output:
 * Original: [10, 20, 30, 40, 50]
 * Copy: [10, 20, 30, 40, 50]
 *
 * After modifying copy[0] = 999:
 * Original: [10, 20, 30, 40, 50]
 * Copy: [999, 20, 30, 40, 50]
 */

package Day07;

import java.util.Arrays;

public class CopyArray {

    public static void main(String[] args) {
        // Initialize the original array
        int[] original = {10, 20, 30, 40, 50};

        // Create a new array of the same size
        int[] copy = new int[original.length];

        // Copy each element from original to copy
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i];
        }

        // Print both arrays
        System.out.println("Original: " + Arrays.toString(original));
        System.out.println("Copy: " + Arrays.toString(copy));

        // Modify the copy to verify independence
        copy[0] = 999;
        System.out.println("\nAfter modifying copy[0] = 999:");
        System.out.println("Original: " + Arrays.toString(original)); // Unchanged
        System.out.println("Copy: " + Arrays.toString(copy));         // Changed
    }
}