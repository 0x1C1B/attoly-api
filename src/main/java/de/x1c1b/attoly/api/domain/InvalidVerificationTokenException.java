package de.x1c1b.attoly.api.domain;

/**
 * Thrown when an invalid verification token is used to activate a user account or verify an email address.
 */
public class InvalidVerificationTokenException extends RuntimeException {

    public InvalidVerificationTokenException() {
    }

    public InvalidVerificationTokenException(String message) {
        super(message);
    }

    public InvalidVerificationTokenException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidVerificationTokenException(Throwable cause) {
        super(cause);
    }
}
