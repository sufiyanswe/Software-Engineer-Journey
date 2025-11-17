package Day02;

import java.util.Scanner;



public class HealthCalculator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // ─────────────────────────────────────────────
        // HEADER
        // ─────────────────────────────────────────────
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║         PERSONAL HEALTH CALCULATOR v1.0        ║");
        System.out.println("║        Evidence-Based Wellness Insights        ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");

        // ─────────────────────────────────────────────
        // USER INPUT
        // ─────────────────────────────────────────────
        System.out.print("Enter your name: ");
        String name = input.nextLine().trim();

        System.out.print("Enter your age (years): ");
        int age = input.nextInt();

        System.out.print("Enter your height (meters): ");
        double height = input.nextDouble();

        System.out.print("Enter your weight (kg): ");
        double weight = input.nextDouble();

        // ─────────────────────────────────────────────
        // VALIDATION
        // ─────────────────────────────────────────────
        if (age <= 0 || height <= 0 || weight <= 0) {
            System.out.println("\n❌ Error: Age, height, and weight must be positive values.");
            input.close();
            return;
        }

        // ─────────────────────────────────────────────
        // CALCULATIONS
        // ─────────────────────────────────────────────
        double bmi = weight / (height * height);
        double minHealthyWeight = 18.5 * (height * height);
        double maxHealthyWeight = 24.9 * (height * height);
        double dailyWaterMl = weight * 35;
        double dailyWaterLiters = dailyWaterMl / 1000.0;

        // ─────────────────────────────────────────────
        // DISPLAY RESULTS
        // ─────────────────────────────────────────────
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("📊 HEALTH SUMMARY FOR: " + name.toUpperCase());
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.printf("Age:                %d years\n", age);
        System.out.printf("Height:             %.2f m\n", height);
        System.out.printf("Weight:             %.2f kg\n", weight);
        System.out.println("────────────────────────────────────────────────");

        // BMI RESULT
        System.out.printf("Your BMI:           %.2f\n", bmi);

        // Color-coded BMI category (ANSI escape codes)
        String bmiCategory;
        String colorReset = "\u001B[0m";
        String colorBlue = "\u001B[34m";   // Underweight
        String colorGreen = "\u001B[32m";  // Normal
        String colorYellow = "\u001B[33m"; // Overweight
        String colorRed = "\u001B[31m";    // Obese

        if (bmi < 18.5) {
            bmiCategory = colorBlue + "Underweight" + colorReset;
        } else if (bmi < 25) {
            bmiCategory = colorGreen + "Normal Weight ✓" + colorReset;
        } else if (bmi < 30) {
            bmiCategory = colorYellow + "Overweight" + colorReset;
        } else {
            bmiCategory = colorRed + "Obese ⚠️" + colorReset;
        }

        System.out.println("BMI Category:       " + bmiCategory);

        // Ideal weight range
        System.out.printf("Healthy Weight:     %.2f kg – %.2f kg\n", minHealthyWeight, maxHealthyWeight);

        // Water intake
        System.out.printf("Recommended Water:  %.2f L/day (%.0f ml)\n", dailyWaterLiters, dailyWaterMl);

        // ─────────────────────────────────────────────
        // SUMMARY
        // ─────────────────────────────────────────────
        System.out.println("\n💡 SUMMARY:");
        if (bmi < 18.5) {
            System.out.println("• Try increasing calorie intake and include strength training.");
        } else if (bmi < 25) {
            System.out.println("• Great job! Maintain your current lifestyle.");
        } else if (bmi < 30) {
            System.out.println("• Consider regular exercise and a balanced diet to manage weight.");
        } else {
            System.out.println("• Consult a healthcare provider for a personalized health plan.");
        }

        System.out.println("• Stay hydrated: Aim for at least " + String.format("%.2f", dailyWaterLiters) + " liters daily.");
        System.out.println("• Remember: Consistency and sleep are key to long-term health.");

        // ─────────────────────────────────────────────
        // FOOTER
        // ─────────────────────────────────────────────
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("   Thank you for using the Personal Health Calculator!");
        System.out.println("   Stay active, stay healthy 💪");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        input.close();
    }
}
