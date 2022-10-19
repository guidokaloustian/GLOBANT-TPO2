package Exceptions;

public class NonExistingValueException extends RuntimeException {

    public NonExistingValueException() {
    }

    public NonExistingValueException(String message) {
        super(message);
    }

    public NonExistingValueException(String message, Throwable cause) {
        super(message, cause);
    }

    public NonExistingValueException(Throwable cause) {
        super(cause);
    }
}
