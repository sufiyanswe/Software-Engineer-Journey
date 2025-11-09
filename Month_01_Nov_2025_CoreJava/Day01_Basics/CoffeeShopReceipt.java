// Coffee Shop Receipt Generator

public class CoffeeShopReceipt {
    public static void main(String[] args) {
        // Declare customer name
        String customerName = "Alex";

        // Declare item prices and counts
        int coffeeCount = 2;   // number of coffees
        int muffinCount = 1;   // number of muffins
        double coffeePrice = 5.0; // price per coffee in dollars
        double muffinPrice = 3.0; // price per muffin in dollars

        // Declare tax rate
        double taxRate = 0.08; // 8% tax

        // Calculate subtotal
        double subTotal = (coffeePrice * coffeeCount) + (muffinPrice * muffinCount);

        // Calculate tax amount
        double taxAmount = subTotal * taxRate;

        // Calculate total cost
        double totalCost = subTotal + taxAmount;

        // Print receipt
        System.out.println("===== COFFEE SHOP RECEIPT =====");
        System.out.println("Customer: " + customerName);
        System.out.println("Items: " + coffeeCount + " Coffee(s), " + muffinCount + " Muffin(s)");
        System.out.printf("Subtotal: $%.2f%n", subTotal);
        System.out.printf("Tax: $%.2f%n", taxAmount);
        System.out.printf("Total: $%.2f%n", totalCost);
        System.out.println("===============================");
    }
}

/*
Output
===== COFFEE SHOP RECEIPT =====
Customer: Alex
Items: 2 Coffee(s), 1 Muffin(s)
Subtotal: $13
Tax: $1.04
Total: $14.04
===============================
*/