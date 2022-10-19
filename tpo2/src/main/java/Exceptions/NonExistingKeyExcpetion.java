package Exceptions;

public class NonExistingKeyExcpetion extends RuntimeException {

    public NonExistingKeyExcpetion() {
    }

    public NonExistingKeyExcpetion(String message) {
        super(message);
    }

    public NonExistingKeyExcpetion(String message, Throwable cause) {
        super(message, cause);
    }

    public NonExistingKeyExcpetion(Throwable cause) {
        super(cause);
    }
}
