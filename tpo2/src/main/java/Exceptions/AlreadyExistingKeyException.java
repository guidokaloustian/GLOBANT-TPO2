package Exceptions;

public class AlreadyExistingKeyException extends RuntimeException {

    public AlreadyExistingKeyException() {
    }

    public AlreadyExistingKeyException(String message) {
        super(message);
    }

    public AlreadyExistingKeyException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlreadyExistingKeyException(Throwable cause) {
        super(cause);
    }
}
