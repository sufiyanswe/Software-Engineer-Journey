package authsystem.auth;

import authsystem.model.User;

/**
 * PasswordAuth class
 * ------------------
 * Implements the AuthStrategy interface to provide password-based authentication.
 *
 * Features:
 * - Compares the provided input password with the user's stored password.
 * - Tracks failed login attempts.
 * - Locks the account after exceeding maximum allowed failed attempts.
 *
 * This demonstrates the Strategy Design Pattern, where different authentication
 * mechanisms (password, OTP, biometric, etc.) can be implemented independently.
 */
public class PasswordAuth implements AuthStrategy {

    // Maximum number of failed login attempts before account is locked
    private static final int MAX_FAILED_ATTEMPTS = 3;

    // Password entered by the user during login
    private String inputPassword;

    /**
     * Constructor to initialize the input password.
     *
     * @param inputPassword The password entered by the user
     */
    public PasswordAuth(String inputPassword) {
        this.inputPassword = inputPassword;
    }

    /**
     * Authenticate the user based on password comparison.
     *
     * @param user The user object containing stored credentials and account state
     * @return true if authentication succeeds, false otherwise
     */
    @Override
    public boolean authenticate(User user) {
        // If account is already locked, deny access
        if (user.isAccountLocked()) {
            return false;
        }

        // If password matches, reset failed attempts and allow login
        if (user.getPassword().equals(this.inputPassword)) {
            user.resetFailedAttempts();
            return true;
        }

        // If password does not match, increment failed attempts
        user.incrementFailedAttempts();

        // Lock account if failed attempts exceed maximum threshold
        if (user.getFailedAttempts() >= MAX_FAILED_ATTEMPTS) {
            user.lockAccount();
        }

        // Authentication failed
        return false;
    }
}