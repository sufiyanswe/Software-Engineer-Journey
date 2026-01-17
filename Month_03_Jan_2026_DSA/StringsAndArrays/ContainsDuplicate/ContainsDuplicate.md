
# 🧠 Contains Duplicate — Java Solution, Notes & Deep Dive

## 📌 Problem Statement

Given an integer array `nums`, return `true` if any value appears **at least twice** in the array, and return `false` if every element is **distinct**.

---

## 🔍 Example

```
Input:  nums = [1, 2, 3, 1]
Output: true
```

```
Input:  nums = [1, 2, 3, 4]
Output: false
```

---

## 🧩 Understanding the Problem

We are checking if **any number appears more than once**.

We do NOT need:

* The duplicate value
* The index

We only need:

* `true` → if duplicate exists
* `false` → if all values are unique

---

## 🐢 Brute Force Approach

### Idea

Compare every element with every other element.

---

### Steps

1. Use two nested loops
2. Compare `nums[i]` with `nums[j]`
3. If `i != j` and values match → return `true`
4. If no match found → return `false`

---

### Java Code (Brute Force)

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
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

For large inputs, this is extremely slow.

Example:
If `n = 100,000`, comparisons ≈ **10 billion**

---

## 🧠 Optimization Insight

We don’t need to compare everything.

We only need to know:

> Have I seen this number before?

If yes → duplicate found.

---

## 🚀 Optimal Approach — HashSet

### Core Idea

Use a `HashSet` to track seen values.

A set:

* Stores only unique values
* Rejects duplicates
* Allows O(1) lookup

---

## 🧪 Step-by-Step Logic

1. Create a HashSet
2. Loop through the array
3. If the current number already exists in the set → return `true`
4. Otherwise, add it to the set
5. If loop finishes → return `false`

---

## ✨ Visual Explanation

### Example

```
nums = [1, 2, 3, 1]
```

---

### Step 1

```
Set = {}
Current = 1
Not in set → add
Set = {1}
```

---

### Step 2

```
Current = 2
Not in set → add
Set = {1, 2}
```

---

### Step 3

```
Current = 3
Not in set → add
Set = {1, 2, 3}
```

---

### Step 4

```
Current = 1
Already in set → duplicate found
```

✅ Return `true`

---

## 🔁 Dry Run

### Input

```
nums = [4, 5, 6, 4]
```

---

| Step | Current | Set Before | Found Duplicate? |
| ---- | ------- | ---------- | ---------------- |
| 1    | 4       | {}         | No               |
|      |         | {4}        |                  |
| 2    | 5       | {4}        | No               |
|      |         | {4,5}      |                  |
| 3    | 6       | {4,5}      | No               |
|      |         | {4,5,6}    |                  |
| 4    | 4       | {4,5,6}    | ✅ Yes            |

---

## ✅ Optimal Java Code

```java
import java.util.HashSet;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums) {
            if(set.contains(num)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }
}
```

---

## ⏱️ Complexity Analysis

| Approach    | Time  | Space |
| ----------- | ----- | ----- |
| Brute Force | O(n²) | O(1)  |
| HashSet     | O(n)  | O(n)  |

---

## ⚖️ Trade-Offs

| Brute Force | HashSet          |
| ----------- | ---------------- |
| No memory   | Extra memory     |
| Very slow   | Very fast        |
| Simple      | Slightly complex |

We trade **space** for **speed**.

---

## ⚠️ Edge Cases

### 1. Empty Array

```
nums = []
Output: false
```

---

### 2. Single Element

```
nums = [1]
Output: false
```

---

### 3. All Duplicates

```
nums = [2,2,2,2]
Output: true
```

---

### 4. Negative Numbers

```
nums = [-1, -2, -3, -1]
Output: true
```

---

## 🧪 Test Cases

### Basic

```
Input: [1,2,3,1]
Output: true
```

---

### No Duplicates

```
Input: [1,2,3,4]
Output: false
```

---

### Large Input

```
Input: [100000 elements]
Output: Depends
```

---

## 🧠 Key Learnings

1. Sets automatically handle uniqueness
2. Avoid nested loops when possible
3. Think: “Have I seen this before?”
4. Hashing is a powerful optimization tool

---

## 🏁 Final Thoughts

This problem teaches you how to:

* Detect duplicates efficiently
* Use HashSet correctly
* Optimize naive solutions

---
