
# 🧠 Group Anagrams — Java Solution, Notes & Deep Dive

## 📌 Problem Statement

Given an array of strings `strs`, group the **anagrams** together. You can return the answer in any order.

An **anagram** is formed by rearranging the letters of another word, using all the original letters exactly once.

---

## 🔍 Example

### Example 1

```
Input: ["eat","tea","tan","ate","nat","bat"]
Output: [["eat","tea","ate"],["tan","nat"],["bat"]]
```

---

### Example 2

```
Input: [""]
Output: [[""]]
```

---

### Example 3

```
Input: ["a"]
Output: [["a"]]
```

---

## 🧩 Understanding the Problem

This is NOT a pairwise comparison problem.

You are not checking if two strings are anagrams.

You are grouping **many strings** into clusters where:

> Every string inside a group is an anagram of the others.

---

### Key Properties of Anagrams

Two strings are anagrams if:

✔ Same characters
✔ Same frequency
✔ Order does NOT matter

---

### What This Problem Is Actually Asking

You must:

> Partition the input list into buckets such that all strings in each bucket are anagrams.

---

## 🧠 Mental Model

Think in terms of **buckets**.

Every string goes into exactly one bucket.

All anagrams land in the same bucket.

---

### Example

```
["eat","tea","tan","ate","nat","bat"]
```

Buckets:

```
["eat","tea","ate"]
["tan","nat"]
["bat"]
```

---

## 🐢 Brute Force Approach

### Idea

Compare every string with every other string.

If two strings are anagrams, put them in the same group.

---

### Steps

1. Maintain a `visited[]` array
2. For each string:

    * Compare with every unvisited string
    * If they are anagrams → group them
3. Mark grouped strings as visited

---

### Why This Is Terrible

Let:

* `n` = number of strings
* `k` = average string length

Anagram check (sorting) = `O(k log k)`

Total comparisons:

```
O(n² * k log k)
```

This explodes fast.

---

## 🧠 Optimization Insight

We must avoid pairwise comparison.

Instead, we give each string a **canonical identity**.

All anagrams share the same identity.

---

## 🔑 What Is a Signature?

A **signature** is a representation that is:

✔ Identical for all anagrams
✔ Different for non-anagrams

---

### Example

```
"eat" → "aet"
"tea" → "aet"
"ate" → "aet"
```

---

## 🚀 Optimal Approach — Sorting Signature

---

### Core Idea

1. Sort each string
2. Use the sorted string as a key
3. Group strings with same key

---

### Data Structure

```
HashMap<String, List<String>>
```

Key = signature
Value = group

---

## 🧪 Step-by-Step Logic

1. Create HashMap
2. For each string:

    * Convert to char array
    * Sort
    * Convert back → signature
3. Insert into map
4. Return map values

---

## ✨ Visual Explanation

### Input

```
["eat","tea","tan","ate","nat","bat"]
```

---

### Signature Table

| Word | Sorted | Signature |
| ---- | ------ | --------- |
| eat  | aet    | "aet"     |
| tea  | aet    | "aet"     |
| tan  | ant    | "ant"     |
| ate  | aet    | "aet"     |
| nat  | ant    | "ant"     |
| bat  | abt    | "abt"     |

---

### HashMap

```
"aet" → ["eat", "tea", "ate"]
"ant" → ["tan", "nat"]
"abt" → ["bat"]
```

---

## 🔁 Dry Run

### Input

```
["eat","tea","tan","ate","nat","bat"]
```

---

### Step 1: "eat" → "aet"

```
"aet" → ["eat"]
```

---

### Step 2: "tea" → "aet"

```
"aet" → ["eat", "tea"]
```

---

### Step 3: "tan" → "ant"

```
"aet" → ["eat", "tea"]
"ant" → ["tan"]
```

---

### Step 4: "ate" → "aet"

```
"aet" → ["eat", "tea", "ate"]
"ant" → ["tan"]
```

---

### Step 5: "nat" → "ant"

```
"aet" → ["eat", "tea", "ate"]
"ant" → ["tan", "nat"]
```

---

### Step 6: "bat" → "abt"

```
"aet" → ["eat", "tea", "ate"]
"ant" → ["tan", "nat"]
"abt" → ["bat"]
```

---

## ✅ Java Code — Sorting Signature

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String signature = new String(chars);

            if (!map.containsKey(signature)) {
                map.put(signature, new ArrayList<>());
            }

            map.get(signature).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
```

---

## ⏱️ Complexity (Sorting Signature)

Let:

* n = number of strings
* k = max length of string

| Metric | Value          |
| ------ | -------------- |
| Time   | O(n · k log k) |
| Space  | O(n · k)       |

---

## 🧠 Can We Do Better?

Yes.

Sorting costs `k log k`.

We can replace sorting with **frequency counting**.

---

## 🚀 Optimal Approach — Frequency Signature

---

### Core Idea

Instead of sorting:

Count character frequencies.

Use that count array as the signature.

---

### Example

```
"eat"
```

Frequency:

```
a:1, e:1, t:1
```

Encoded key:

```
#1#0#0#0#1#0#...#1...
```

---

## 🧪 Step-by-Step Logic

1. For each word:

    * Create `int[26]`
    * Count characters
    * Encode into string
2. Insert into HashMap
3. Return values

---

## ✅ Java Code — Frequency Signature

```java
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {

            int[] count = new int[26];

            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int num : count) {
                sb.append("#");
                sb.append(num);
            }

            String key = sb.toString();

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(word);
        }

        return new ArrayList<>(map.values());
    }
}
```

---

## ⏱️ Complexity (Frequency Signature)

| Metric | Value    |
| ------ | -------- |
| Time   | O(n · k) |
| Space  | O(n · k) |

---

## 🐞 Debug Walkthrough (IntelliJ-Style)

### Input

```
["eat","tea","tan","ate","nat","bat"]
```

---

### Step 1: Initialize Map

```
map = {}
```

---

### Step 2: Process "eat"

Count:

```
a:1 e:1 t:1
```

Key:

```
#1#0#0#0#1#0...#1
```

Map:

```
key → ["eat"]
```

---

### Step 3: Process "tea"

Same key → append

```
key → ["eat","tea"]
```

---

### Step 4: Process "tan"

New key:

```
a:1 n:1 t:1
```

Map:

```
key1 → ["eat","tea"]
key2 → ["tan"]
```

---

### Step 5: Continue...

Eventually:

```
["eat","tea","ate"]
["tan","nat"]
["bat"]
```

---

## ⚖️ Trade-Offs

| Method    | Time        | Simplicity | Speed  |
| --------- | ----------- | ---------- | ------ |
| Sorting   | O(nk log k) | Easy       | Slower |
| Frequency | O(nk)       | Harder     | Faster |

---

## ⚠️ Edge Cases

### 1. Empty Strings

```
["",""]
→ [["",""]]
```

---

### 2. Single Character

```
["a"]
→ [["a"]]
```

---

### 3. All Same

```
["abc","bca","cab"]
→ [["abc","bca","cab"]]
```

---

### 4. No Anagrams

```
["a","b","c"]
→ [["a"],["b"],["c"]]
```

---

## 🧪 Test Cases

### Basic

```
Input: ["eat","tea","tan","ate","nat","bat"]
Output: [["eat","tea","ate"],["tan","nat"],["bat"]]
```

---

### Single

```
Input: ["a"]
Output: [["a"]]
```

---

### Empty

```
Input: [""]
Output: [[""]]
```

---

## 🧠 Key Learnings

1. Anagrams depend on frequency, not order
2. Canonical forms enable grouping
3. HashMaps are powerful for partitioning
4. Avoid pairwise comparisons
5. Encode state into keys

---

## 🏁 Final Thoughts

This is a **pattern problem**.

It teaches:

* Canonical representation
* Hash-based grouping
* Frequency encoding
* Time complexity optimization

This pattern appears in:

• Isomorphic strings
• Substring grouping
• Frequency problems
• Pattern matching

---
