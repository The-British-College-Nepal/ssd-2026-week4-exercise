package exceptions;

/**
 * ArrayProcessor provides array manipulation methods.
 * 
 * In this initial version, getArrayLength demonstrates a notorious ANTI-PATTERN:
 * using ArrayIndexOutOfBoundsException for normal loop control termination.
 * 
 * Your task in Step 1 is to:
 * 1. Benchmark and understand why this anti-pattern destroys performance and hides bugs.
 * 2. Refactor getArrayLength to clean, idiomatic Java using defensive null checking.
 * 
 * @author mdixon
 */
public class ArrayProcessor {

    /**
     * Gets the length of the given array.
     * 
     * ANTI-PATTERN IMPLEMENTATION:
     * Iterates until an ArrayIndexOutOfBoundsException is thrown and caught.
     * 
     * @param a the array for which the length is required.
     * @return the length of the array, or 0 if array is null.
     */
    public int getArrayLength(Object[] a) {
        int count = 0;

        try {
            while (true) {
                @SuppressWarnings("unused")
                Object t = a[count];
                count++;
            }
        } catch (Exception e) {
            // Anti-pattern: do nothing, used to find end of the array.
            // In practice, this creates massive CPU overhead and masks NullPointerException!
        }

        return count;
    }
}
