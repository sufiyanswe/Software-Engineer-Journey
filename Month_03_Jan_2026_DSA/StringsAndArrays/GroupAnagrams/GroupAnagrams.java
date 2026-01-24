package StringsAndArrays.GroupAnagrams;

import java.util.*;

public class GroupAnagrams {

    // Groups words that are anagrams of each other
    public static List<List<String>> groupAnagrams(String[] strs) {

        // Map where:
        // Key   = frequency signature of a word (e.g., "#1#0#0#2...")
        // Value = list of words that share this same signature
        HashMap<String, List<String>> map = new HashMap<>();

        // Iterate through each word in the input array
        for (String str : strs) {

            // Array to store frequency of each character ('a' to 'z')
            // Index 0 -> 'a', Index 1 -> 'b', ..., Index 25 -> 'z'
            char[] charFreq = new char[26];

            // Count the frequency of each character in the current word
            for (char c : str.toCharArray()) {
                charFreq[c - 'a']++;  // Convert character to index
            }

            // Build a unique string key from the frequency array
            // Example: "#1#0#0#2#0..."
            // This avoids collisions like [1,11] vs [11,1]
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++) {
                sb.append("#").append(charFreq[i]);
            }

            // Convert the StringBuilder to a String to use as a key
            String key = sb.toString();

            // If this frequency pattern has not been seen before,
            // initialize a new list for it
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            // Add the current word to its corresponding anagram group
            map.get(key).add(str);
        }

        // Return all grouped anagram lists
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        // Sample input
        String[] strs = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};

        // Print grouped anagrams
        System.out.println(groupAnagrams(strs));
    }
}
