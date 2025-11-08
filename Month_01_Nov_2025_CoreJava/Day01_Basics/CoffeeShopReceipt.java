// Coffee Shop Receipt Generator

public class CoffeeShopReceipt {
    public static void main(String[] args) {
        // Declare customer name
        String customerName = "Alex";

        // Declare item prices and counts
        int coffeePrice = 5;   // price per coffee in dollars
        int coffeeCount = 2;   // number of coffees
        int muffinPrice = 3;   // price per muffin in dollars
        int muffinCount = 1;   // number of muffins

        // Declare tax rate
        double taxRate = 0.08; // 8% tax

        // Calculate subtotal
        int subTotal = (coffeePrice * coffeeCount) + (muffinPrice * muffinCount);

        // Calculate tax amount
        double taxAmount = subTotal * taxRate;

        // Calculate total cost
        double totalCost = subTotal + taxAmount;

        // Create message strings
        String welcomeMessage = "Customer: " + customerName;
        String itemMessage = "Items: " + coffeeCount + " Coffee(s), " + muffinCount + " Muffin(s)";
        String subtotalMessage = "Subtotal: $" + subTotal;
        String taxMessage = "Tax: $" + taxAmount;
        String totalMessage = "Total: $" + totalCost;

        // Print receipt
        System.out.println("===== COFFEE SHOP RECEIPT =====");
        System.out.println(welcomeMessage);
        System.out.println(itemMessage);
        System.out.println(subtotalMessage);
        System.out.println(taxMessage);
        System.out.println(totalMessage);
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
