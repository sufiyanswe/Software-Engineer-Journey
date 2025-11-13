package Day04;


import java.util.Scanner;

public class BankAccountManager {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double balance = 1000.00;  // starting balance
        boolean running = true;

        System.out.println("==== Welcome to Java Bank ====");

        while (running) {
            System.out.println("\n1️⃣  Check Balance");
            System.out.println("2️⃣  Deposit Money");
            System.out.println("3️⃣  Withdraw Money");
            System.out.println("4️⃣  Exit");
            System.out.print("Choose an option (1-4): ");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("💰 Current Balance: $%.2f%n", balance);
                    break;

                case 2:
                    System.out.print("Enter deposit amount: $");
                    double deposit = input.nextDouble();
                    if (deposit > 0) {
                        balance += deposit;
                        System.out.printf("✅ Deposited: $%.2f | New Balance: $%.2f%n", deposit, balance);
                    } else {
                        System.out.println("❌ Invalid deposit amount.");
                    }
                    break;

                case 3:
                    System.out.print("Enter withdrawal amount: $");
                    double withdraw = input.nextDouble();
                    if (withdraw > 0 && withdraw <= balance) {
                        balance -= withdraw;
                        System.out.printf("✅ Withdrawn: $%.2f | New Balance: $%.2f%n", withdraw, balance);
                    } else if (withdraw > balance) {
                        System.out.println("⚠️ Insufficient balance.");
                    } else {
                        System.out.println("❌ Invalid withdrawal amount.");
                    }
                    break;

                case 4:
                    System.out.println("👋 Thank you for banking with us!");
                    running = false;
                    break;

                default:
                    System.out.println("❌ Invalid choice. Please enter 1-4.");
            }
        }

        input.close();
    }
}
