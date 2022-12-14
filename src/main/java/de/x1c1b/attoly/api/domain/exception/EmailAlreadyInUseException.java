package de.x1c1b.attoly.api.domain.exception;

import lombok.Getter;

/**
 * Thrown when trying to use an email that is already being used by another user account.
 */
@Getter
public class EmailAlreadyInUseException extends RuntimeException {

    private final String email;

    public EmailAlreadyInUseException(String email) {
        this.email = email;
    }

    public EmailAlreadyInUseException(String message, String email) {
        super(message);
        this.email = email;
    }

    public EmailAlreadyInUseException(String message, Throwable cause, String email) {
        super(message, cause);
        this.email = email;
    }

    public EmailAlreadyInUseException(Throwable cause, String email) {
        super(cause);
        this.email = email;
    }
}
