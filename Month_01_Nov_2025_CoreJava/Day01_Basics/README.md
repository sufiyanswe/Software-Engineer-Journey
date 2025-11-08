# Day 1 - Java Fundamentals Practice

## 📚 What I Learned Today
- Java syntax and structure
- Variables and data types (int, double, String, boolean)
- Reference types vs primitive types
- Getting user input with Scanner
- String concatenation
- Basic arithmetic operations

## 💻 Programs Created

### 1. CoffeeShopReceipt.java
Calculates a coffee shop order with tax using predefined variables.
- **Concepts used:** variables, data types, arithmetic, String concatenation

## 🎓 Key Takeaways
- Always use appropriate data types (int for whole numbers, double for decimals)
- Remember to import Scanner and close it when done
- Use descriptive variable names for better code readability
- String concatenation with + is simple and effective

## 🐛 Challenges Faced
Challenge: Wrong Variable in Tax Message
Problem: I accidentally printed the tax rate (0.08) instead of the calculated tax amount (1.04) in my receipt.

What happened: I wrote String taxMessage = "Tax: $" + taxRate; when it should have been taxAmount.

Why it happened: I had two similar variables (taxRate and taxAmount) and used the wrong one when creating the message string. The code compiled fine because both were valid variables, but the output showed \$.08 instead of $1.04.

How I fixed it: Changed the line to use the correct variable: String taxMessage = "Tax: $" + taxAmount;

## 📈 Next Steps
- Practice more with loops and conditionals
- Learn about methods/functions
- Explore arrays

---
**Date:** 06 Nov 2025