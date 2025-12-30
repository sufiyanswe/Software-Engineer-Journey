package authsystem.auth;

import authsystem.model.User;

/**
 * AuthStrategy interface
 * ----------------------
 * Defines a contract for authentication strategies in the system.
 *
 * By using the Strategy Design Pattern, different authentication
 * mechanisms (e.g., password-based, OTP, biometric) can implement
 * this interface and provide their own logic for user authentication.
 */
public interface AuthStrategy {

     /**
      * Authenticate the given user.
      *
      * @param user The user object containing credentials or identity information.
      * @return true if authentication succeeds, false otherwise.
      */
     boolean authenticate(User user);
}