package StringsAndArrays.ContainsDuplicate;

import java.util.*;

/**
 * This class provides a method to check whether an array
 * contains any duplicate elements.
 */
public class ContainsDuplicate {

    /**
     * Checks if the given array contains any duplicate values.
     *
     * @param nums the input array of integers
     * @return true if any value appears more than once, false otherwise
     */
    public static boolean containsDuplicate(int[] nums) {

        // HashSet is used because it only stores unique values
        // and provides O(1) average-time lookup
        Set<Integer> set = new HashSet<>();

        // Traverse through each element in the array
        for (int num : nums) {

            // If the number is already in the set,
            // it means we found a duplicate
            if (set.contains(num)) {
                return true;
            }

            // Otherwise, add the number to the set
            set.add(num);
        }

        // If no duplicates were found, return false
        return false;
    }

    public static void main(String[] args) {

        // Sample input array
        int[] nums = {1, 2, 3, 3};

        // Calling the containsDuplicate method and printing the result
        System.out.println(containsDuplicate(nums));
    }
}
