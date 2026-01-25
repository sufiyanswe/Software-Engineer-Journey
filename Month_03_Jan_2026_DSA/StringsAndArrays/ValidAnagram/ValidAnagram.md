
# 🧠 Valid Anagram — Java Solution, Notes & Deep Dive

## 📌 Problem Statement

Given two strings `s` and `t`, return `true` if `t` is an **anagram** of `s`, and `false` otherwise.

An **anagram** is formed by rearranging the letters of another word, using all the original letters exactly once.

---

## 🔍 Example

```
Input: s = "anagram", t = "nagaram"
Output: true
```

```
Input: s = "rat", t = "car"
Output: false
```

---

## 🧩 Understanding the Problem

Two strings are anagrams if:

* They have the **same length**
* They contain the **same characters**
* They contain the **same frequency** of each character

Order does **not** matter.

---

## 🐢 Brute Force Approach

### Idea

Sort both strings and compare them.

If two strings are anagrams, their sorted versions will be identical.

---

### Steps

1. Convert both strings to character arrays
2. Sort both arrays
3. Compare the sorted arrays
4. If equal → return `true`
5. Else → return `false`

---

### Java Code (Brute Force)

```java
import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}
```

---

### Complexity

| Metric | Value      |
| ------ | ---------- |
| Time   | O(n log n) |
| Space  | O(n)       |

---

### Why This Is Not Optimal

Sorting is expensive. We can do better using counting.

---

## 🧠 Optimization Insight

Instead of sorting, we can **count characters**.

If two strings are anagrams, then:

> Every character must appear the **same number of times** in both strings.

---

## 🚀 Optimal Approach — Frequency Counting

### Core Idea

Use an array of size 26 (for lowercase English letters).

---

## 🧪 Step-by-Step Logic

1. If lengths differ → return `false`
2. Create an integer array `count[26]`
3. Traverse `s` → increment counts
4. Traverse `t` → decrement counts
5. If any value in `count` is not zero → return `false`
6. Else → return `true`

---

## ✨ Visual Explanation

### Example

```
s = "anagram"
t = "nagaram"
```

---

### Count after processing `s`

```
a: 3
n: 1
g: 1
r: 1
m: 1
```

---

### Subtract while processing `t`

Each character in `t` cancels out the count.

If everything becomes zero → anagram.

---

## 🔁 Dry Run

### Input

```
s = "rat"
t = "car"
```

---

### Step 1: Process `s`

```
r → +1
a → +1
t → +1
```

---

### Step 2: Process `t`

```
c → -1
a → 0
r → 0
```

---

### Final Count

`t` is not zero → ❌ Not an anagram

---

## ✅ Optimal Java Code

```java
class Solution {
    public boolean isAnagram(String s, String t) {

        // If lengths differ, they cannot be anagrams
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        // Count characters from string s
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        // Subtract characters using string t
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
}
```

---

## ⏱️ Complexity Analysis

| Approach        | Time       | Space |
| --------------- | ---------- | ----- |
| Sorting         | O(n log n) | O(n)  |
| Frequency Count | O(n)       | O(1)  |

---
## 🐞 Debug Walkthrough (IntelliJ-Style Execution)

This section simulates what you see in IntelliJ when stepping through the code line-by-line.

---

### Code Being Debugged

```java
class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i) - 'a']--;
        }

        for (int num : count) {
            if (num != 0) {
                return false;
            }
        }

        return true;
    }
}
```

---

### Example Debug Input

```
s = "anagram"
t = "nagaram"
```

---

## 🔎 Step-by-Step Execution

---

### Step 1: Length Check

```
s.length() = 7
t.length() = 7
```

Condition:

```
7 != 7 → false
```

So we **do NOT return** and move forward.

---

### Step 2: Initialize Count Array

```
int[] count = new int[26];
```

All values initialized to 0:

```
[a:0, b:0, c:0, d:0, e:0, f:0, g:0, ... z:0]
```

---

### Step 3: First Loop — Processing `s = "anagram"`

We increment frequency.

---

#### i = 0

```
s.charAt(0) = 'a'
'a' - 'a' = 0
count[0]++
```

Now:

```
a:1
```

---

#### i = 1

```
s.charAt(1) = 'n'
'n' - 'a' = 13
count[13]++
```

Now:

```
a:1, n:1
```

---

#### i = 2

```
s.charAt(2) = 'a'
count[0]++
```

Now:

```
a:2, n:1
```

---

#### i = 3

```
s.charAt(3) = 'g'
count[6]++
```

Now:

```
a:2, n:1, g:1
```

---

#### i = 4

```
s.charAt(4) = 'r'
count[17]++
```

Now:

```
a:2, n:1, g:1, r:1
```

---

#### i = 5

```
s.charAt(5) = 'a'
count[0]++
```

Now:

```
a:3, n:1, g:1, r:1
```

---

#### i = 6

```
s.charAt(6) = 'm'
count[12]++
```

Final count after `s`:

```
a:3, n:1, g:1, r:1, m:1
```

---

### Step 4: Second Loop — Processing `t = "nagaram"`

Now we decrement.

---

#### i = 0

```
t.charAt(0) = 'n'
count[13]--
```

Now:

```
n:0
```

---

#### i = 1

```
t.charAt(1) = 'a'
count[0]--
```

Now:

```
a:2
```

---

#### i = 2

```
t.charAt(2) = 'g'
count[6]--
```

Now:

```
g:0
```

---

#### i = 3

```
t.charAt(3) = 'a'
count[0]--
```

Now:

```
a:1
```

---

#### i = 4

```
t.charAt(4) = 'r'
count[17]--
```

Now:

```
r:0
```

---

#### i = 5

```
t.charAt(5) = 'a'
count[0]--
```

Now:

```
a:0
```

---

#### i = 6

```
t.charAt(6) = 'm'
count[12]--
```

Now:

```
m:0
```

---

### Step 5: Final Validation Loop

Now we check:

```java
for (int num : count) {
    if (num != 0) {
        return false;
    }
}
```

We scan all 26 values.

Every value is `0`.

So:

```
No mismatches found
```

---

### Step 6: Return Result

```
return true;
```

---

## ✅ Debug Conclusion

Every increment was perfectly canceled by a decrement.

That means:

✔ Same characters
✔ Same frequency
✔ Same length

➡ Therefore, **anagram confirmed**.

---

## ⚖️ Trade-Offs

| Sorting           | Frequency Count     |
| ----------------- | ------------------- |
| Easy to implement | Slightly more logic |
| Slower            | Faster              |
| Uses extra memory | Constant memory     |

We trade **simplicity** for **performance**.

---

## ⚠️ Edge Cases

### 1. Different Lengths

```
s = "abc"
t = "abcd"
Output: false
```

---

### 2. Empty Strings

```
s = ""
t = ""
Output: true
```

---

### 3. Single Character

```
s = "a"
t = "a"
Output: true
```

---

### 4. Same Letters, Different Frequency

```
s = "aabb"
t = "ab"
Output: false
```

---

## 🧪 Test Cases

### Basic

```
Input: s = "anagram", t = "nagaram"
Output: true
```

---

### Not Anagram

```
Input: s = "rat", t = "car"
Output: false
```

---

### Case Sensitive

```
Input: s = "aA", t = "Aa"
Output: false
```

---

## 🧠 Key Learnings

1. Anagrams are about **frequency**, not order
2. Counting is often faster than sorting
3. ASCII math (`char - 'a'`) is powerful
4. Think in terms of constraints (26 letters)

---

## 🏁 Final Thoughts

Valid Anagram is a foundational problem that teaches:

* Frequency counting
* Hashing alternatives
* Optimization thinking

This pattern appears in many string problems.

---

