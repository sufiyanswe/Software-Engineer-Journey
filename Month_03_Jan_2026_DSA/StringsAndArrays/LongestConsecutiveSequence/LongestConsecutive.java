package StringsAndArrays.LongestConsecutiveSequence;
import java.util.*;
public class LongestConsecutive {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int maxLength = 0;
        int current;
        for(int numSet: nums) {
            current = numSet;
            set.add(numSet);
            if(set.contains(current -1)) {
                continue;
            }
            while(set.contains(current + 1)) {
                maxLength++;
            }
        }
        return maxLength;

    }
    public static void main(String[] args) {
        int[]  nums = {100,4,200,1,3,2};

        System.out.println(longestConsecutive(nums));
    }
}
