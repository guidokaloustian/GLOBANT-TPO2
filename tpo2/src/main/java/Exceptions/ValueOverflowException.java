package Exceptions;

public class ValueOverflowException extends RuntimeException {

    public ValueOverflowException() {
    }

    public ValueOverflowException(String message) {
        super(message);
    }

    public ValueOverflowException(String message, Throwable cause) {
        super(message, cause);
    }

    public ValueOverflowException(Throwable cause) {
        super(cause);
    }
}
