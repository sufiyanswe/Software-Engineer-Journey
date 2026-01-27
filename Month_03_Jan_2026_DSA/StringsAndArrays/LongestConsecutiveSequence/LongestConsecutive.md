
# 🧠 Longest Consecutive Sequence — Java Solution, Notes & Deep Dive

### FULL DEPTH EDITION — Part 1

---

## 📌 Problem Statement

You are given an **unsorted** array of integers `nums`.

Your task is to return the **length** of the longest sequence of **consecutive integers**.

A sequence is considered **consecutive** if:

> Each number differs from the previous one by exactly **1**.

---

### Important Conditions

* The numbers do **not** need to be next to each other in the array.
* The order of elements in the array does **not matter**.
* You must design an algorithm that runs in **O(n)** time.

---

### Example 1

```
Input: [100,4,200,1,3,2]
Output: 4
```

Explanation:

The longest consecutive sequence is:

```
[1, 2, 3, 4]
```

Length = 4

---

### Example 2

```
Input: [0,3,7,2,5,8,4,6,0,1]
Output: 9
```

Explanation:

The longest consecutive sequence is:

```
[0,1,2,3,4,5,6,7,8]
```

Length = 9

---

### Example 3

```
Input: []
Output: 0
```

---

## 🧩 Understanding the Problem

Let’s slow down and clarify what this problem **actually** wants.

This problem is **not** asking for:

❌ A subarray
❌ A subsequence
❌ A sorted range
❌ A contiguous block of indices

It is asking for:

✅ A **set of values**
✅ That differ by exactly 1
✅ Regardless of their positions
✅ And we only care about the **length**

---

### What does "consecutive" actually mean?

Consecutive means:

```
x, x+1, x+2, x+3, ...
```

Examples:

```
[3,4,5] → consecutive
[10,11,12,13] → consecutive
```

Non-examples:

```
[3,5,6] → NOT consecutive (missing 4)
[1,2,4] → NOT consecutive (missing 3)
```

---

### Why “unsorted” matters

If the input was already sorted, the problem would be trivial.

But the input is:

> UNSORTED

Which means:

```
[100, 4, 200, 1, 3, 2]
```

The sequence `[1,2,3,4]` is **scattered**.

So we cannot rely on index adjacency.

---

### What is the output?

You do **not** return the sequence.

You return the **length** of the longest one.

---

### So the real problem is:

> From a random collection of numbers, find the largest chain of numbers where each next number is exactly +1 from the previous.

---

## 📏 Constraint Analysis

Even though the problem statement might not always explicitly list constraints, this is a **LeetCode-style** problem, which implies:

---

### Likely Constraints

| Property                          | Implication               |
| --------------------------------- | ------------------------- |
| n can be very large (10⁵ or more) | O(n²) will TLE            |
| Values can be large               | Cannot use indexed arrays |
| Negative numbers possible         | Index tricks fail         |
| Duplicates possible               | Must handle them          |
| O(n) required                     | Sorting is not optimal    |

---

### What does O(n) requirement tell us?

If the problem explicitly demands O(n), it means:

❌ Nested loops are forbidden
❌ Sorting is too slow
❌ Brute force is not acceptable

So we must think in terms of:

✔ Hashing
✔ Constant-time lookups
✔ Single pass
✔ Avoiding recomputation

---

### What must our solution guarantee?

* Each number is processed only once
* We never re-scan long sequences
* We avoid redundant work

---

## 🧭 Recognizing the Pattern

This step is important. This is how you stop solving problems from scratch every time.

---

### Pattern Family

This problem belongs to:

> **Set-based chain detection**

Other names:

* Longest band
* Longest streak
* Longest run
* Longest chain

---

### Key Words That Signal This Pattern

| Keyword     | What it suggests      |
| ----------- | --------------------- |
| Longest     | Optimization problem  |
| Consecutive | Sequence / chain      |
| Unsorted    | Can't rely on order   |
| O(n)        | Hashing likely needed |

---

### Similar Problems

* Longest band
* Longest increasing streak
* Longest arithmetic run
* Longest chain problems

---

### What this is NOT

This is not:

❌ Sliding window
❌ Two pointers
❌ Prefix sum
❌ Binary search
❌ Dynamic programming

Because:

* There is no continuous index range
* There is no ordering
* There is no subproblem structure

---

## 🧠 Mental Model

Let’s build the correct mental picture.

---

### Think in terms of chains

Each number belongs to a **chain**.

For example:

```
[100,4,200,1,3,2]
```

Chains are:

```
1 → 2 → 3 → 4
100
200
```

---

### Our job is NOT to build chains from everywhere.

Our job is to:

> Identify where chains START
> Then walk forward
> Then measure their length

---

### Important idea

Every number is either:

• A start of a chain
• A middle of a chain
• An end of a chain

---

### Example

```
1 → 2 → 3 → 4
```

* 1 = start
* 2,3 = middle
* 4 = end

---

### Key realization

If a number has a predecessor, then it **cannot** be the start of a chain.

Example:

```
3
```

If 2 exists, then 3 is NOT a start.

---

### Why this matters

If we start counting chains from every number, we will:

❌ Recount the same chains
❌ Waste time
❌ Blow up to O(n²)

So we need a way to:

> Only start from legitimate chain heads

---

### Visual Metaphor

Think of dominoes:

```
1 → 2 → 3 → 4
```

If you start pushing from 2, you will still fall 3 and 4.

But the true start is 1.

---

### So we need to find all the “1s” of chains.

---
Good. Continuing with the same **full-depth**, **teaching-grade** style.

---
### FULL DEPTH EDITION — Part 2

---

## 🐢 Brute Force Approach

Before we jump to clever tricks, we must first think:

> “What is the most natural, obvious way to solve this problem?”

This is important because:

* It shows we understand the problem
* It gives us a baseline
* It reveals where inefficiency comes from

---

### Brute Force Idea

For **every number**, try to build the longest consecutive sequence starting from that number.

In other words:

> Pick a number → check if the next number exists → then the next → then the next → and so on.

---

### Example

Input:

```
[100, 4, 200, 1, 3, 2]
```

Let’s say we start from 1:

```
1 → 2 → 3 → 4 → stop
```

Length = 4

Now start from 2:

```
2 → 3 → 4 → stop
```

Length = 3

Now start from 3:

```
3 → 4 → stop
```

Length = 2

Now start from 4:

```
4 → stop
```

Length = 1

You can already see a problem:
We are re-walking the same chain again and again.

---

### Brute Force Pseudocode

```
maxLength = 0

For each number x in nums:
    current = x
    length = 1

    While (current + 1 exists in nums):
        current = current + 1
        length++

    maxLength = max(maxLength, length)

Return maxLength
```

---

### Why This Works (Logically)

This brute-force logic is correct because:

* It tries all possible starting points
* It builds every possible consecutive chain
* It tracks the longest one

So in terms of **correctness**, brute force is fine.

The issue is not correctness.

The issue is **performance**.

---

## ❌ Why Brute Force Fails

Let’s analyze its time complexity.

---

### Worst Case Scenario

Consider this input:

```
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
```

Now what happens?

From 1:

```
Check 2, 3, 4, 5, 6, 7, 8, 9, 10 → 9 checks
```

From 2:

```
Check 3, 4, 5, 6, 7, 8, 9, 10 → 8 checks
```

From 3:

```
7 checks
```

From 4:

```
6 checks
```

...

Total checks:

```
9 + 8 + 7 + 6 + ... + 1
```

Which is:

```
O(n²)
```

---

### Why This Is Bad

The problem explicitly requires:

> O(n) time

So O(n²) is unacceptable.

---

### What is the real inefficiency?

We are:

❌ Re-counting the same chains
❌ Walking the same sequences again and again
❌ Doing repeated work

---

### Root Cause of Inefficiency

The brute force approach does not ask:

> “Should I start a chain from here?”

It blindly starts from **every** number.

---

## 🧠 Optimization Insight

This is the most important section.

We now ask:

> Why are we recomputing the same chains?

Let’s inspect a chain:

```
1 → 2 → 3 → 4
```

If I start from 1 → I get the full chain.

If I start from 2 → I get a smaller suffix.

If I start from 3 → I get an even smaller suffix.

If I start from 4 → I get only one element.

---

### Observation

Every chain has exactly **one true start**.

For:

```
1 → 2 → 3 → 4
```

The true start is:

```
1
```

---

### How do we detect a true start?

A number is a **true start** of a chain if:

> Its predecessor does NOT exist.

In math terms:

```
x is a start if (x - 1) does not exist
```

---

### Example

Chain:

```
1 → 2 → 3 → 4
```

Check:

| Number | x - 1 exists?    | Start? |
| ------ | ---------------- | ------ |
| 1      | 0 does not exist | ✅      |
| 2      | 1 exists         | ❌      |
| 3      | 2 exists         | ❌      |
| 4      | 3 exists         | ❌      |

Only 1 is a valid start.

---

### This changes everything

Now instead of starting from **every** number, we start from **only valid starts**.

This ensures:

✔ Each chain is counted once
✔ No recomputation
✔ Linear time

---

## 🧰 Choosing the Correct Data Structure

Now we ask:

> What operations do we need to perform efficiently?

---

### Required Operations

| Operation                   | Why                   |
| --------------------------- | --------------------- |
| Check if a number exists    | To extend chain       |
| Check if predecessor exists | To detect chain start |
| Insert all numbers          | For lookup            |
| Ignore duplicates           | Avoid double counting |

---

### What data structure supports these?

We need:

✔ Fast lookup
✔ Unordered storage
✔ No duplicates
✔ Large range of values

---

### Candidate Structures

| Structure | Why it fails        |
| --------- | ------------------- |
| Array     | Needs index bounds  |
| List      | O(n) lookup         |
| TreeSet   | O(log n) lookup     |
| HashSet   | O(1) average lookup |

---

### Correct Choice: HashSet

Why HashSet?

| Requirement   | HashSet |
| ------------- | ------- |
| Fast lookup   | ✅ O(1)  |
| No duplicates | ✅       |
| Large range   | ✅       |
| Unordered     | ✅       |

---

### Why not sorting?

Sorting takes:

```
O(n log n)
```

But the problem asks for:

```
O(n)
```

So sorting violates constraints.

---

## ⚙️ Choosing the Correct Algorithm

Now we must pick the right **strategy**, not just a data structure.

---

### Candidate Approaches

| Approach            | Why it fails          |
| ------------------- | --------------------- |
| Brute force         | O(n²)                 |
| Sorting + scan      | O(n log n)            |
| Dynamic programming | No subproblems        |
| Two pointers        | Needs sorted order    |
| Sliding window      | No continuous indices |

---

### Correct Algorithm

> HashSet + chain-start detection + forward expansion

---

### High-Level Algorithm

1. Put all numbers in a HashSet
2. For each number:

    * If (num - 1) does not exist → start chain
3. Expand forward until chain breaks
4. Track maximum length

---

This guarantees:

✔ Each number is visited once
✔ No recomputation
✔ O(n) time

---
Continuing immediately.

---

### FULL DEPTH EDITION — Part 3

---

## 🧾 Pseudocode (Before Code)

Before touching Java, we must be **100% clear** on the logic.

Pseudocode forces us to think about **behavior**, not syntax.

---

### Step-by-Step Pseudocode

```
If nums is empty:
    return 0

Create an empty HashSet called set

For each number in nums:
    add it to set

maxLength = 0

For each number num in set:
    If (num - 1) is NOT in set:
        // num is a valid start of a chain

        current = num
        count = 1

        While (current + 1) is in set:
            current = current + 1
            count = count + 1

        maxLength = max(maxLength, count)

Return maxLength
```

---

### Important Notes

* We iterate over the **set**, not the original array
  → This automatically removes duplicates.
* We only start counting from **valid chain heads**.
* Each number participates in counting **once**.

---

## 🚀 Optimal Approach (Deep Explanation)

Now let’s explain the idea *slowly* and *carefully*.

---

### What are we really doing?

We are:

1. Storing all numbers for fast lookup
2. Identifying where chains **begin**
3. Walking forward until the chain breaks
4. Measuring how long the chain is
5. Tracking the maximum

---

### Why does this avoid recomputation?

Because:

* If `x - 1` exists, then `x` is not a start.
* That chain has already been counted.
* So we skip it.

This guarantees:

✔ No duplicate chain counting
✔ No wasted loops
✔ Linear behavior

---

### Let’s visualize

Input:

```
[1, 2, 3, 4, 100, 200]
```

Set:

```
{1, 2, 3, 4, 100, 200}
```

Now:

* Start from 1 → valid start → count 1,2,3,4 → length 4
* Skip 2 → has predecessor
* Skip 3 → has predecessor
* Skip 4 → has predecessor
* Start from 100 → length 1
* Start from 200 → length 1

---

## 🧪 Step-by-Step Logic

Let’s write this in a human way:

---

### Step 1: Handle Edge Case

If the input array is empty:

```
Return 0
```

Because there are no numbers.

---

### Step 2: Store Numbers

Put every number into a HashSet.

Why?

Because we want to check:

> “Does x exist?”
> “Does x+1 exist?”
> “Does x-1 exist?”

All of these must be O(1).

---

### Step 3: Iterate Through Each Unique Number

For each number `num` in the set:

---

### Step 4: Check If It’s a Start

Check:

```
if (num - 1) is NOT in set
```

If true → this is a valid start.

---

### Step 5: Expand the Chain

Now we expand forward:

```
current = num
count = 1

while (current + 1 exists):
    current++
    count++
```

---

### Step 6: Update Maximum

```
maxLength = max(maxLength, count)
```

---

### Step 7: Return Result

After processing all starts:

```
return maxLength
```

---

## ✨ Visual Explanation

Let’s visually walk through this.

---

### Input

```
[100,4,200,1,3,2]
```

---

### Step 1: Convert to Set

```
{1,2,3,4,100,200}
```

---

### Step 2: Identify Valid Starts

| Number | num - 1 exists? | Start? |
| ------ | --------------- | ------ |
| 1      | 0 ❌             | ✅      |
| 2      | 1 ✅             | ❌      |
| 3      | 2 ✅             | ❌      |
| 4      | 3 ✅             | ❌      |
| 100    | 99 ❌            | ✅      |
| 200    | 199 ❌           | ✅      |

---

### Step 3: Expand Chains

From 1:

```
1 → 2 → 3 → 4
length = 4
```

From 100:

```
100
length = 1
```

From 200:

```
200
length = 1
```

---

### Step 4: Final Answer

```
max = 4
```

---

## 🔁 Full Dry Run

Now we will simulate exactly what happens.

---

### Input

```
nums = [100,4,200,1,3,2]
```

---

### Step 1: Create Set

We insert each number:

```
set = {1,2,3,4,100,200}
```

---

### Step 2: Initialize maxLength

```
maxLength = 0
```

---

### Step 3: Loop through set

---

#### num = 1

Check:

```
1 - 1 = 0
0 not in set → valid start
```

Now:

```
current = 1
count = 1
```

Check:

```
2 in set → yes
```

So:

```
current = 2
count = 2
```

Check:

```
3 in set → yes
```

So:

```
current = 3
count = 3
```

Check:

```
4 in set → yes
```

So:

```
current = 4
count = 4
```

Check:

```
5 in set → no → stop
```

Now:

```
maxLength = max(0, 4) = 4
```

---

#### num = 2

Check:

```
2 - 1 = 1
1 in set → not a start
```

Skip.

---

#### num = 3

Check:

```
3 - 1 = 2
2 in set → not a start
```

Skip.

---

#### num = 4

Check:

```
4 - 1 = 3
3 in set → not a start
```

Skip.

---

#### num = 100

Check:

```
100 - 1 = 99
99 not in set → start
```

Expand:

```
current = 100
count = 1
```

Check:

```
101 in set? No
```

Stop.

```
maxLength = max(4,1) = 4
```

---

#### num = 200

Same logic:

```
length = 1
```

---

### Final Answer

```
4
```

---
Continuing immediately.

---

### FULL DEPTH EDITION — Part 4

This part will be heavy and slow on purpose—just like your Valid Anagram deep dive.

We will cover:

• Full Java code
• Line-by-line explanation
• Why each line exists
• IntelliJ-style debugging walkthrough
• Variable state tracking

---

## ✅ Optimal Java Code

First, here is the complete solution. Do NOT rush—this will be dissected in detail.

```java
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {

        // Edge case: empty array
        if (nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();

        // Step 1: Insert all elements into the set
        for (int num : nums) {
            set.add(num);
        }

        int maxLength = 0;

        // Step 2: Iterate through the set
        for (int num : set) {

            // Step 3: Check if this is the start of a sequence
            if (!set.contains(num - 1)) {

                int current = num;
                int count = 1;

                // Step 4: Expand forward
                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                // Step 5: Update max
                maxLength = Math.max(maxLength, count);
            }
        }

        return maxLength;
    }
}
```

---

## 🧠 Line-by-Line Explanation

Now we will go through this **slowly** and **deeply**.

---

### Line 1–2: Imports

```java
import java.util.HashSet;
import java.util.Set;
```

We need a `HashSet` because:

• O(1) average lookup
• No duplicates
• Order does not matter
• Large number range supported

---

### Class Definition

```java
class Solution {
```

Standard LeetCode wrapper.

---

### Method Signature

```java
public int longestConsecutive(int[] nums) {
```

Input:
• An integer array `nums`

Output:
• An integer → the length of the longest consecutive sequence

---

### Edge Case Handling

```java
if (nums.length == 0) {
    return 0;
}
```

Why do we need this?

If there are **no numbers**, then:

• There is no sequence
• Length = 0

Without this, the logic would still work, but this makes the intention explicit and safe.

---

### Creating the Set

```java
Set<Integer> set = new HashSet<>();
```

We now create a HashSet to store all numbers.

Why?

Because we will frequently ask:

• Does x exist?
• Does x+1 exist?
• Does x-1 exist?

All of these must be O(1).

---

### Inserting Elements

```java
for (int num : nums) {
    set.add(num);
}
```

This loop does two important things:

1. Copies all numbers into the set
2. Automatically removes duplicates

Example:

```
nums = [1,2,2,3]
set = {1,2,3}
```

This is good because duplicates don’t affect chain length.

---

### Initialize maxLength

```java
int maxLength = 0;
```

We will track the longest chain length found so far.

---

### Iterating Over the Set

```java
for (int num : set) {
```

Important:
We loop over the **set**, not the original array.

Why?

Because:
• No duplicates
• Clean iteration
• Each number is processed once

---

### Detecting Chain Starts

```java
if (!set.contains(num - 1)) {
```

This is the **heart of the algorithm**.

This line means:

> If there is no predecessor, then this number is a chain start.

---

### Why This Works

If `num - 1` exists, then this number is inside a chain that has already been or will be counted.

We skip it.

---

### Initializing Chain Expansion

```java
int current = num;
int count = 1;
```

We start a new chain.

• `current` = where we are in the chain
• `count` = how many elements so far

---

### Expanding the Chain

```java
while (set.contains(current + 1)) {
    current++;
    count++;
}
```

This loop keeps walking forward as long as the next number exists.

Example:

```
current = 1
check 2 → exists
current = 2
count = 2

check 3 → exists
current = 3
count = 3

check 4 → exists
current = 4
count = 4

check 5 → not exists → stop
```

---

### Updating maxLength

```java
maxLength = Math.max(maxLength, count);
```

We keep the maximum of:

• Previous longest
• Current chain length

---

### Returning the Result

```java
return maxLength;
```

After checking all possible chain starts, we return the best.

---

## 🐞 Debug Walkthrough (IntelliJ-Style)

Now we simulate exactly what you would see while debugging.

---

### Input

```
nums = [100,4,200,1,3,2]
```

---

## 🔎 Step-by-Step Execution

---

### Step 1: nums.length == 0?

```
nums.length = 6
```

So we do NOT return.

---

### Step 2: Build the Set

We insert:

```
100 → {100}
4   → {100,4}
200 → {100,4,200}
1   → {100,4,200,1}
3   → {100,4,200,1,3}
2   → {100,4,200,1,3,2}
```

Final set:

```
{1,2,3,4,100,200}
```

---

### Step 3: maxLength = 0

---

### Step 4: Loop Through Set

Order is arbitrary, but assume:

```
1 → 2 → 3 → 4 → 100 → 200
```

---

### num = 1

Check:

```
set.contains(0) → false
```

So 1 is a chain start.

Initialize:

```
current = 1
count = 1
```

---

### Expand:

Check:

```
set.contains(2) → true
```

So:

```
current = 2
count = 2
```

Check:

```
set.contains(3) → true
```

So:

```
current = 3
count = 3
```

Check:

```
set.contains(4) → true
```

So:

```
current = 4
count = 4
```

Check:

```
set.contains(5) → false
```

Stop.

Update:

```
maxLength = max(0,4) = 4
```

---

### num = 2

Check:

```
set.contains(1) → true
```

So NOT a start. Skip.

---

### num = 3

Check:

```
set.contains(2) → true
```

Skip.

---

### num = 4

Check:

```
set.contains(3) → true
```

Skip.

---

### num = 100

Check:

```
set.contains(99) → false
```

Start.

```
current = 100
count = 1
```

Check:

```
set.contains(101) → false
```

Stop.

```
maxLength = max(4,1) = 4
```

---

### num = 200

Same logic.

---

### End Loop

Return:

```
4
```

---
Continuing immediately.

---

### FULL DEPTH EDITION — Part 5 (Final Part)

This part is about **thinking like an engineer**, not just coding.

We will cover:

• Invariants (why the algorithm is correct)
• Edge cases
• Common mistakes
• Trade-offs
• Variations & follow-ups
• Interview framing
• Key learnings
• Final thoughts

---

## 🧠 Invariants (What Must Always Be True)

An invariant is something that remains true **throughout the execution** of the algorithm.

If your invariants are correct, your algorithm is correct.

---

### Invariant 1: Every chain is counted exactly once

Why?

Because we only start counting from numbers where:

```
num - 1 does NOT exist
```

So we never start in the middle of a chain.

---

### Invariant 2: No number is part of more than one expansion

Once a chain is expanded from its start, all its internal elements are skipped in future iterations.

---

### Invariant 3: All lookups are O(1)

We only use HashSet operations:

```
contains()
add()
```

Which are O(1) average.

---

### Invariant 4: maxLength always stores the best answer so far

After every chain expansion, we update:

```
maxLength = max(maxLength, currentChainLength)
```

So it always reflects the best seen.

---

## ⚠️ Edge Cases

You must always think about these.

---

### 1. Empty Array

```
nums = []
Output = 0
```

Handled explicitly.

---

### 2. Single Element

```
nums = [7]
Output = 1
```

A single number is a chain of length 1.

---

### 3. All Duplicates

```
nums = [1,1,1,1]
Output = 1
```

HashSet removes duplicates.

---

### 4. Already Consecutive

```
nums = [1,2,3,4,5]
Output = 5
```

One big chain.

---

### 5. Negative Numbers

```
nums = [-3, -2, -1, 0, 1]
Output = 5
```

Works fine.

---

### 6. Scattered Numbers

```
nums = [10, 30, 20]
Output = 1
```

No consecutive numbers.

---

## ❌ Common Mistakes

These are very important.

---

### Mistake 1: Starting chain from every number

This leads to O(n²).

---

### Mistake 2: Sorting first

Sorting gives O(n log n), violating O(n) constraint.

---

### Mistake 3: Using an array indexed by value

Fails for large or negative values.

---

### Mistake 4: Forgetting duplicates

Duplicates should not extend chains.

---

### Mistake 5: Iterating over original array instead of set

Leads to repeated work.

---

## ⚖️ Trade-Offs

There is no free lunch in engineering.

---

### Sorting Approach

Algorithm:

1. Sort array
2. Scan linearly

| Aspect     | Value      |
| ---------- | ---------- |
| Time       | O(n log n) |
| Space      | O(1)       |
| Simplicity | High       |

---

### HashSet Approach (Our Solution)

| Aspect      | Value  |
| ----------- | ------ |
| Time        | O(n)   |
| Space       | O(n)   |
| Simplicity  | Medium |
| Performance | Best   |

---

### Trade-Off Summary

We trade:

> Extra memory → for faster execution

---

## 🔄 Variations & Follow-Ups

These are common interview twists.

---

### 1. Return the Actual Sequence

Instead of returning length, return:

```
[1,2,3,4]
```

Solution:

• Store the start point
• Rebuild the sequence later

---

### 2. Sorted Input

If array is sorted:

You can solve in O(n) without HashSet.

---

### 3. Streaming Input

If numbers arrive one by one:

• Maintain a dynamic HashSet
• Update chains dynamically

---

### 4. Memory-Constrained System

If memory is limited:

• Use sorting
• Accept O(n log n)

---

### 5. Count All Chains

Instead of longest, return all chains.

---

## 🎯 Interview Framing

This is how you should explain this problem.

---

### How to Explain the Approach

> I use a HashSet for O(1) lookups. For each number, I check if it’s the start of a sequence by verifying if its predecessor exists. If not, I expand forward to build the full chain. This ensures every chain is counted once, giving me O(n) time complexity.

---

### What the Interviewer Is Testing

• Hashing knowledge
• Optimization reasoning
• Avoiding recomputation
• Set-based thinking
• Edge case awareness

---

### Follow-Up Questions

They might ask:

• What if we need the actual sequence?
• What if input is sorted?
• What if memory is limited?
• What if input is streaming?

---

## 🧠 Key Learnings

1. Consecutive ≠ contiguous
2. Order in array doesn’t matter
3. HashSet enables O(1) existence checks
4. Always detect true starts
5. Avoid recomputation
6. Think in chains, not indices
7. Brute force reveals inefficiencies
8. Constraints guide design

---

## 🏁 Final Thoughts

This problem teaches a **fundamental pattern**:

> Chain detection using hashing.

This pattern appears in:

• Longest streak problems
• Interval merging
• Graph components
• Sequence detection
• Band problems

If you understand this deeply, you can solve many related problems.

---