# Array Utility Programs – README

This README documents eight foundational Java programs focused on core array operations. These programs build the essential logic patterns required for DSA and interview preparation.

Included Programs:

* `ArraySum.java`
* `CountElements.java`
* `FindIndex.java`
* `FindMax.java`
* `FirstAndLastElement.java`
* `SumAndProduct.java`
* `CopyArray.java`
* `ReverseArray.java`

---

## 📘 Overview

These programs cover the fundamental operations needed for working with arrays including traversal, searching, copying, reversing, arithmetic operations, and boundary index retrieval.

Each program uses **clean method design**, **clear loop logic**, and **simple pattern-based problem solving**.

---

## 🔹 Program: ArraySum.java

### **Description**

Calculates the sum of all elements in the array.

### Concepts Learned:

* Array traversal
* Accumulator variables
* Basic arithmetic

### Example Output

```
Sum of array elements: 45
```

---

## 🔹 Program: CountElements.java

### **Description**

Counts the total number of elements in the array using an enhanced for-loop.

### Concepts Learned:

* Enhanced for-loop
* Counting logic

### Example Output

```
Array has 6 elements
```

---

## 🔹 Program: FindIndex.java

### **Description**

Searches for a target value in the array and returns its index, or -1 if not found.

### Concepts Learned:

* Linear search
* Early exit (`return` inside loop)
* Index-based traversal

### Example Output

```
Element found at index: 3
```

---

## 🔹 Program: FindMax.java

### **Description**

Finds and returns the maximum value in the array.

### Concepts Learned:

* Tracking state (`max` value)
* Comparisons inside loop
* Single-pass optimization

### Example Output

```
Maximum value: 30
```

---

## 🔹 Program: FirstAndLastElement.java

### **Description**

Retrieves and prints the first and last elements of the array.

### Concepts Learned:

* Boundary indexing (`arr[0]` and `arr[arr.length-1]`)
* Input validation

### Example Output

```
First element: 5
Last element: 30
```

---

## 🔹 Program: SumAndProduct.java

### **Description**

Computes both the sum and product of all array elements.

### Concepts Learned:

* Multiple accumulator variables
* Handling multiplication safely

### Example Output

```
Sum = 15
Product = 120
```

---

## 🔹 Program: CopyArray.java

### **Description**

Creates a new array and copies all elements from the original array.

### Concepts Learned:

* Manual copying with loops
* Difference between reference assignment vs true copy

### Example Output

```
Original: 1 2 3
Copy:     1 2 3
```

---

## 🔹 Program: ReverseArray.java

### **Description**

Generates a new array whose elements are in reverse order.

### Concepts Learned:

* Reverse indexing
* Working with two positions at once
* Array reconstruction

### Example Output

```
Reversed array: 4 3 2 1
```

---

## 🛠️ How to Run Any Program

1. Save the file (e.g., `ArraySum.java`).
2. Compile:

```
javac FileName.java
```

3. Run:

```
java FileName
```

---

## 💡 Skills Strengthened

* Array traversal (forward & reverse)
* Searching and index logic
* Working with boundaries and lengths
* Copying and reversing patterns
* Tracking values while scanning

These are the **core foundations** required before moving into Two-Pointer Technique, Sliding Window, Prefix Sum, and other DSA patterns.

---