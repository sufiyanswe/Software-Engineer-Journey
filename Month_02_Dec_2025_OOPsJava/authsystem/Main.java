package authsystem;

import authsystem.model.User;
import authsystem.service.AuthService;
import authsystem.auth.PasswordAuth;

/**
 * Main class
 * ----------
 * Entry point for the authentication system demo.
 *
 * Demonstrates:
 * - Creating a User with credentials.
 * - Using AuthService with PasswordAuth strategy.
 * - Handling successful login, failed attempts, and account lock.
 */
public class Main {
    public static void main(String[] args) {
        // Create a user with userId and password
        User user = new User("zayn", "zayn01");

        // Attempt login with incorrect password
        AuthService authService = new AuthService(new PasswordAuth("zayn"));
        authService.login(user); // Wrong password

        // Second failed attempt
        authService = new AuthService(new PasswordAuth("zayn00"));
        authService.login(user);

        // Third failed attempt
        authService = new AuthService(new PasswordAuth("zayn0"));
        authService.login(user);

        // Fourth failed attempt (account should lock here)
        authService = new AuthService(new PasswordAuth("zayn1"));
        authService.login(user);

        // Attempt login with correct password after account is locked
        authService = new AuthService(new PasswordAuth("zayn01"));
        authService.login(user); // Will fail because account is locked
    }
}