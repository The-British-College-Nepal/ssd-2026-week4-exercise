package exceptions;

/**
 * Driver class demonstrating defensive execution and exception handling.
 * 
 * @author mdixon
 */
public class Driver {

    public static void main(String[] args) {
        System.out.println("=== SSD Week 4: Exception Handling Lab ===");

        // Part 1: ArrayProcessor Demo
        ArrayProcessor ap = new ArrayProcessor();
        int len = ap.getArrayLength(new String[]{"alpha", "bravo", "charlie"});
        System.out.println("Array length calculated: " + len);

        // Part 2 & 3: Menu Demo with defensive try-catch
        Menu menu = new Menu();

        int[] optionsToTest = {1, 2, 3, 4, 0, -1};

        for (int opt : optionsToTest) {
            try {
                System.out.print("Attempting to display option " + opt + ": ");
                menu.displayMenuOption(opt);
            } catch (InvalidOptionException e) {
                System.err.println("CAUGHT EXPECTED ERROR: " + e.getMessage());
            } finally {
                System.out.println("  [finally] Finished processing attempt for option " + opt);
            }
        }
    }
}
