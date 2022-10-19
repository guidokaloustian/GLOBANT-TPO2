package Exceptions;

public class NonExistingKeyException extends RuntimeException {

    public NonExistingKeyException() {
    }

    public NonExistingKeyException(String message) {
        super(message);
    }

    public NonExistingKeyException(String message, Throwable cause) {
        super(message, cause);
    }

    public NonExistingKeyException(Throwable cause) {
        super(cause);
    }
}
