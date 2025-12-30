package authsystem.service;

import authsystem.auth.AuthStrategy;
import authsystem.model.User;

/**
 * AuthService class
 * -----------------
 * Provides authentication services using a chosen AuthStrategy.
 *
 * Features:
 * - Delegates authentication logic to the injected strategy (e.g., PasswordAuth).
 * - Handles login attempts and prints appropriate messages.
 * - Notifies if login is successful, credentials are invalid, or account is locked.
 *
 * This class demonstrates the use of the Strategy Design Pattern,
 * allowing flexible authentication mechanisms without changing service logic.
 */
public class AuthService {

    // Reference to the chosen authentication strategy
    private AuthStrategy authStrategy;

    /**
     * Constructor to initialize AuthService with a specific strategy.
     *
     * @param authStrategy The authentication strategy to be used (e.g., PasswordAuth)
     */
    public AuthService(AuthStrategy authStrategy) {
        this.authStrategy = authStrategy;
    }

    /**
     * Attempts to log in the given user using the configured authentication strategy.
     *
     * @param user The user attempting to log in
     */
    public void login(User user) {
        // Delegate authentication to the strategy
        boolean authenticated = authStrategy.authenticate(user);

        if (authenticated) {
            // Successful login
            System.out.println("Login successful for the user: " + user.getUserId());
        } else {
            // Failed login
            if (user.isAccountLocked()) {
                // Account locked after too many failed attempts
                System.out.println("Account is locked for the user: " + user.getUserId() + ". Please contact support.");
            } else {
                // Invalid credentials but account still active
                System.out.println("Invalid credentials.");
            }
        }
    }
}