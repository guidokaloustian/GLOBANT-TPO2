package Exceptions;

public class AlreadyExistingKeyException extends RuntimeException {

    String detailMessage = "La clave que esta intengando ingresar ya existe";

    public AlreadyExistingKeyException() {
        getMessage();
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
