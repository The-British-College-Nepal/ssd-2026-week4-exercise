package exceptions;

/**
 * A Menu class which handles menu selection and validation.
 * 
 * In Step 3, you will implement:
 * 1. displayMenuOption(int opt): validates that opt is between 1 and 3 (inclusive).
 *    If outside 1..3, it throws InvalidOptionException with message:
 *    "The option must be between 1 and 3"
 * 2. selectOption(String optStr): parses an option string, throws InvalidOptionException
 *    if the string is not a valid number or outside 1..3.
 * 
 * @author mdixon
 * @see InvalidOptionException
 */
public class Menu {

    /**
     * Displays a selected menu option.
     * 
     * @param opt the option selected.
     * @throws InvalidOptionException if the given option is outside the valid range 1..3.
     */
    public void displayMenuOption(int opt) throws InvalidOptionException {
        // TODO: In Step 3, validate opt and throw InvalidOptionException if opt < 1 || opt > 3
        System.out.println("Menu option " + opt + " selected");
    }

    /**
     * Helper method to parse and display an option from text input.
     * 
     * @param optStr the string representation of the option.
     * @throws InvalidOptionException if the string is non-numeric or outside 1..3.
     */
    public void selectOption(String optStr) throws InvalidOptionException {
        if (optStr == null || optStr.trim().isEmpty()) {
            throw new InvalidOptionException("Menu option cannot be empty or null");
        }
        try {
            int opt = Integer.parseInt(optStr.trim());
            displayMenuOption(opt);
        } catch (NumberFormatException e) {
            throw new InvalidOptionException("Menu option must be a valid integer: " + optStr, e);
        }
    }
}
