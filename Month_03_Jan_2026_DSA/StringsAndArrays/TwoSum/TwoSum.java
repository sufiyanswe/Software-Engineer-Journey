package StringsAndArrays.TwoSum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * TwoSum class
 * ------------
 * Provides a solution to the classic "Two Sum" problem:
 * Given an array of integers and a target value, find two indices
 * such that the numbers at those indices add up to the target.
 *
 * Approach:
 * - Use a HashMap to store numbers and their indices as we iterate.
 * - For each number, check if its complement (target - current number)
 *   already exists in the map.
 * - If found, return the pair of indices.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class TwoSum {

    /**
     * Finds two indices in the array whose values sum up to the target.
     *
     * @param nums   The input array of integers
     * @param target The target sum
     * @return An array of two indices if a solution exists, otherwise null
     */
    public static int[] twoSum(int[] nums, int target) {
        // Map to store number → index
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate complement needed to reach target
            int complement = target - nums[i];

            // If complement already exists in map, return indices
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Otherwise, store current number with its index
            map.put(nums[i], i);
        }

        // Return null if no solution found
        return null;
    }

    /**
     * Main method to test the TwoSum solution.
     */
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};   // Example array
        int target = 9;                // Target sum

        // Expected output: [0, 1] because nums[0] + nums[1] = 2 + 7 = 9
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }
}