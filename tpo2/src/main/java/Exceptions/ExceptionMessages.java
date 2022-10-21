package Exceptions;

public class ExceptionMessages extends RuntimeException{

    public ExceptionMessages() {}

    public ExceptionMessages(String message) {
        super(message);
    }

    public ExceptionMessages(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceptionMessages(Throwable cause) {
        super(cause);
    }
}
