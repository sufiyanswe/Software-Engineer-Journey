# 🧠 Two Sum — Java Solution, Notes & Deep Dive

## 📌 Problem Statement

Given an array of integers `nums` and an integer `target`, return the **indices** of the two numbers such that they add up to `target`.

### Constraints

* Each input has **exactly one solution**
* You **may not use the same element twice**
* You can return the answer in **any order**

---

## 🔍 Example

```
Input:  nums = [2, 7, 11, 15], target = 9
Output: [0, 1]
Explanation: nums[0] + nums[1] = 2 + 7 = 9
```

---

## 🧩 Understanding the Problem

We are not returning the numbers — we are returning their **indices**.

This distinction is important.

### What we need:

* Two **different indices**
* Their values must sum to `target`
* Must be efficient for large inputs

---

## 🐢 Brute Force Approach

### Idea

Check every possible pair.

### Steps

1. Use two loops
2. Try all `(i, j)` pairs
3. If `nums[i] + nums[j] == target`, return indices

---

### Java Code (Brute Force)

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }
}
```

---

### Complexity

| Metric | Value |
| ------ | ----- |
| Time   | O(n²) |
| Space  | O(1)  |

---

### Why This Is Bad

For large inputs, this becomes very slow.

Example:
If `n = 100,000`, then comparisons ≈ **10 billion**

---

## 🧠 Optimization Insight

Instead of checking all pairs, ask:

> If the current number is `x`, what number do I need?

```
needed = target - x
```

If we can **instantly** check whether `needed` exists, we avoid the second loop.

---

## 🚀 Optimal Approach — HashMap

### Core Idea

Store numbers we've seen along with their indices.

```
value → index
```

This allows:

* Constant-time lookup
* One-pass solution

---

## 🧪 Step-by-Step Logic

1. Create a HashMap
2. Loop through array
3. For each element:

    * Compute `complement = target - nums[i]`
4. If complement exists:

    * Return stored index + current index
5. Else:

    * Store current number and index

---

## ✨ Visual Explanation

### Example

```
nums = [2, 7, 11, 15]
target = 9
```

---

### Step 1

```
i = 0
current = 2
complement = 9 - 2 = 7

map = {}
7 not in map → store 2
```

```
map = { 2 → 0 }
```

---

### Step 2

```
i = 1
current = 7
complement = 9 - 7 = 2

2 is in map!
```

✅ Found answer → `[0, 1]`

---

## 🔁 Dry Run

### Input

```
nums = [3, 2, 4]
target = 6
```

---

| i | nums[i] | complement | map before     | Found? |
| - | ------- | ---------- | -------------- | ------ |
| 0 | 3       | 3          | {}             | No     |
|   |         |            | {3 → 0}        |        |
| 1 | 2       | 4          | {3 → 0}        | No     |
|   |         |            | {3 → 0, 2 → 1} |        |
| 2 | 4       | 2          | {3 → 0, 2 → 1} | ✅ Yes  |

Answer: `[1, 2]`

---

## ✅ Optimal Java Code

```java
import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if(map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }
}
```

---

## ⏱️ Complexity Analysis

| Approach    | Time  | Space |
| ----------- | ----- | ----- |
| Brute Force | O(n²) | O(1)  |
| HashMap     | O(n)  | O(n)  |

---

## ⚖️ Trade-Offs

### Why not always use brute force?

| Brute Force | HashMap          |
| ----------- | ---------------- |
| Simple      | Slightly complex |
| No memory   | Extra memory     |
| Very slow   | Very fast        |

We trade **space** for **time**.

---

## ⚠️ Edge Cases

### 1. Duplicate Values

```
nums = [3, 3]
target = 6
```

✔ Works because indices differ

---

### 2. Negative Numbers

```
nums = [-1, -2, -3, -4]
target = -6
```

✔ HashMap handles negatives

---

### 3. Zero Values

```
nums = [0, 4, 3, 0]
target = 0
```

✔ Complement logic still works

---

### 4. Large Input

HashMap ensures performance remains linear.

---

## 🧪 Test Cases

### Basic

```
Input: [2,7,11,15], target = 9
Output: [0,1]
```

---

### With Negatives

```
Input: [-3,4,3,90], target = 0
Output: [0,2]
```

---

### With Duplicates

```
Input: [3,3], target = 6
Output: [0,1]
```

---

### With Zero

```
Input: [0,4,3,0], target = 0
Output: [0,3]
```

---

## 🧠 Key Learnings

1. Nested loops are a red flag for optimization
2. Hashing enables constant-time lookups
3. Always think in terms of:

   ```
   What do I need to reach the target?
   ```
4. This pattern appears in many problems:

    * 3Sum
    * Subarray sum
    * Pair problems

---

## 🏁 Final Thoughts

Two Sum is not about addition — it is about **pattern recognition**.

If you master this, many harder problems become easier.

---