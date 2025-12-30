package authsystem.model;

/**
 * User class
 * ----------
 * Represents a user in the authentication system.
 *
 * Features:
 * - Stores user credentials (userId and password).
 * - Tracks failed login attempts.
 * - Supports account lock functionality after too many failed attempts.
 *
 * This class works together with authentication strategies (e.g., PasswordAuth)
 * to manage login security.
 */
public class User {

    // Unique identifier for the user
    private String userId;

    // User's stored password
    private String password;

    // Number of consecutive failed login attempts
    private int failedAttempts;

    // Flag indicating whether the account is locked
    private boolean accountLocked;

    /**
     * Constructor to initialize a new user with credentials.
     *
     * @param userId   Unique identifier for the user
     * @param password User's password
     */
    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
        this.failedAttempts = 0;     // Initially no failed attempts
        this.accountLocked = false;  // Account starts unlocked
    }

    // ------------------- Getters -------------------

    /** @return the user's unique identifier */
    public String getUserId() {
        return this.userId;
    }

    /** @return the user's password */
    public String getPassword() {
        return this.password;
    }

    /** @return the number of failed login attempts */
    public int getFailedAttempts() {
        return this.failedAttempts;
    }

    /** @return true if the account is locked, false otherwise */
    public boolean isAccountLocked() {
        return this.accountLocked;
    }

    // ------------------- State Management -------------------

    /** Increment the failed login attempts counter by 1 */
    public void incrementFailedAttempts() {
        this.failedAttempts++;
    }

    /** Reset the failed login attempts counter to 0 */
    public void resetFailedAttempts() {
        this.failedAttempts = 0;
    }

    /** Lock the account to prevent further login attempts */
    public void lockAccount() {
        this.accountLocked = true;
    }
}