# 📘 Day 05 – Loop Fundamentals & Digit-Based Problems

This folder contains four foundational Java programs designed to build mastery over **for-loops**, **digit extraction**, **arithmetic operations**, and **conditional logic**. These problems sharpen the core skills required for coding interviews and backend development.

Each program uses **pure arithmetic** (no Strings, no shortcuts) to strengthen mathematical loop thinking.

---

## 1️⃣ SumOfDigit.java

**Goal:** Compute the sum of all digits of a number using a loop.

**Concepts Practiced:**

* `%` to extract digits
* `/` to remove digits
* Accumulators
* Loop design without mutating the original number

**Example:**

```
Input: 293
Output: 14
```

---

## 2️⃣ CountDivisibleBy3.java

**Goal:** Count how many numbers from `1` to `N` are divisible by 3.

**Concepts Practiced:**

* Loop boundaries
* Conditional checks (`i % 3 == 0`)
* Counter variables
* Clean loop structure

**Example:**

```
N = 20
Output: 6
```

---

## 3️⃣ ReverseNumber.java

**Goal:** Reverse a number using only arithmetic (no Strings).

**Concepts Practiced:**

* Digit extraction
* Place-value reconstruction (`rev = rev * 10 + digit`)
* Using a temporary variable
* Understanding integer division

**Example:**

```
Input: 1234
Output: 4321
```

---

## 4️⃣ CountEvenOdd.java

**Goal:** Count even and odd digits in a number.

**Concepts Practiced:**

* Digit classification (even/odd)
* Branching logic
* Looping through digits
* Accumulator variables

**Example:**

```
Input: 1345
Output:
Even: 1
Odd: 3
```

---

# 🎯 Key Takeaways from Day 05

* Loop traversal from right → left using `%` and `/`
* Avoiding mutation of input while processing
* Correct use of counters
* Clean printing (output only what matters)
* Solid understanding of loop flow, iteration, and termination
* Foundations for solving medium/hard loop problems

---

# 📂 File List

```
Day05/
│
├── CountDivisibleBy3.java
├── CountEvenOdd.java
├── ReverseNumber.java
├── SumOfDigit.java
└── README.md
```
