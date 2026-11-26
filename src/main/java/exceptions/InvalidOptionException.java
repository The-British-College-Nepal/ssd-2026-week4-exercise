package exceptions;

/**
 * An exception used to report invalid menu option selection.
 * 
 * In Step 2, you will complete this class by:
 * 1. Extending java.lang.Exception (making it a Checked Exception).
 * 2. Providing standard constructors that pass messages and causes to super.
 * 3. Adding proper Javadoc documentation with @author tags.
 * 
 * @author mdixon
 */
public class InvalidOptionException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new InvalidOptionException with null message.
     */
    public InvalidOptionException() {
        super();
    }

    /**
     * Constructs a new InvalidOptionException with a descriptive error message.
     * 
     * @param message description of why the option was invalid.
     */
    public InvalidOptionException(String message) {
        super(message);
    }

    /**
     * Constructs a new InvalidOptionException with a message and causing exception.
     * 
     * @param message description of the error.
     * @param cause underlying cause.
     */
    public InvalidOptionException(String message, Throwable cause) {
        super(message, cause);
    }
}
