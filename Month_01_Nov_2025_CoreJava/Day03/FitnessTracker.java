package Day03;

import java.util.Scanner;

public class FitnessTracker {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║       FITNESS GOAL TRACKER             ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        // Get user data
        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Daily step goal: ");
        int stepGoal = input.nextInt();

        System.out.print("Steps walked today: ");
        int stepsWalked = input.nextInt();

        System.out.print("Calories goal: ");
        int calorieGoal = input.nextInt();

        System.out.print("Calories consumed: ");
        int caloriesConsumed = input.nextInt();

        System.out.print("Calories burned (exercise): ");
        int caloriesBurned = input.nextInt();


        // ═══════════════════════════════════════════
        // ARITHMETIC OPERATORS (+, -, *, /)
        // ═══════════════════════════════════════════

        // Calculate remaining steps
        int stepsRemaining = stepGoal - stepsWalked;

        // Calculate percentage of goal completed
        double stepPercentage = (stepsWalked * 100.0) / stepGoal;

        // Calculate net calories (consumed - burned)
        int netCalories = caloriesConsumed - caloriesBurned;

        // Calculate calories remaining
        int caloriesRemaining = calorieGoal - netCalories;

        // Calculate distance walked (assuming 2000 steps = 1 mile)
        double milesWalked = stepsWalked / 2000.0;


        // ═══════════════════════════════════════════
        // COMPARISON OPERATORS (>, <, >=, <=, ==, !=)
        // ═══════════════════════════════════════════

        boolean stepGoalMet = stepsWalked >= stepGoal;
        boolean calorieGoalMet = netCalories <= calorieGoal;
        boolean overCalories = netCalories > calorieGoal;


        // ═══════════════════════════════════════════
        // LOGICAL OPERATORS (&&, ||, !)
        // ═══════════════════════════════════════════

        // Both goals met
        boolean perfectDay = stepGoalMet && calorieGoalMet;

        // At least one goal met
        boolean goodDay = stepGoalMet || calorieGoalMet;

        // Not meeting step goal
        boolean needsMoreSteps = !stepGoalMet;


        // ═══════════════════════════════════════════
        // TERNARY OPERATOR (? :)
        // ═══════════════════════════════════════════

        String stepStatus = (stepGoalMet) ? "✅ GOAL MET!" : "❌ Keep walking";
        String calorieStatus = (calorieGoalMet) ? "✅ GOAL MET!" : "⚠️ Over goal";
        String dayRating = (perfectDay) ? "🌟 PERFECT DAY!" :
                (goodDay) ? "👍 Good Day" : "💪 Keep pushing";


        // ═══════════════════════════════════════════
        // INCREMENT/DECREMENT OPERATORS (++, --)
        // ═══════════════════════════════════════════

        int streak = 5;  // Current streak

        if (perfectDay) {
            streak++;  // Increment streak
            System.out.println("\n🔥 Streak increased!");
        } else {
            streak--;  // Decrement streak
            System.out.println("\n📉 Streak decreased");
        }


        // ═══════════════════════════════════════════
        // COMPOUND ASSIGNMENT OPERATORS (+=, -=, *=, /=)
        // ═══════════════════════════════════════════

        int totalWeeklySteps = 25000;
        totalWeeklySteps += stepsWalked;  // Add today's steps

        int points = 100;
        if (stepGoalMet) points += 50;      // Bonus points
        if (calorieGoalMet) points += 30;   // Bonus points


        // ═══════════════════════════════════════════
        // DISPLAY RESULTS
        // ═══════════════════════════════════════════

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         FITNESS REPORT                 ║");
        System.out.println("╚════════════════════════════════════════╝");

        System.out.println("\n👤 User: " + name.toUpperCase());
        System.out.println("📊 Day Rating: " + dayRating);

        System.out.println("\n━━━━━━━━━━ STEPS ANALYSIS ━━━━━━━━━━");
        System.out.println("Goal:           " + stepGoal);
        System.out.println("Walked:         " + stepsWalked);
        System.out.println("Remaining:      " + stepsRemaining);
        System.out.printf("Percentage:     %.1f%%\n", stepPercentage);
        System.out.printf("Distance:       %.2f miles\n", milesWalked);
        System.out.println("Status:         " + stepStatus);

        System.out.println("\n━━━━━━━━━━ CALORIE ANALYSIS ━━━━━━━━━━");
        System.out.println("Goal:           " + calorieGoal);
        System.out.println("Consumed:       " + caloriesConsumed);
        System.out.println("Burned:         " + caloriesBurned);
        System.out.println("Net:            " + netCalories);
        System.out.println("Remaining:      " + caloriesRemaining);
        System.out.println("Status:         " + calorieStatus);

        System.out.println("\n━━━━━━━━━━━━ REWARDS ━━━━━━━━━━━━");
        System.out.println("Current Streak: " + streak + " days 🔥");
        System.out.println("Points Earned:  " + points + " pts");
        System.out.println("Weekly Steps:   " + totalWeeklySteps);

        // MODULUS OPERATOR (%) - Check if eligible for reward
        if (points % 100 == 0 && points > 0) {
            System.out.println("\n🎁 REWARD UNLOCKED! You've earned a badge!");
        }

        input.close();
    }
}