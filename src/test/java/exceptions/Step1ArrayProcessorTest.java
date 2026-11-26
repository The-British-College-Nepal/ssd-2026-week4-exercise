package exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Step 1: ArrayProcessor Refactoring Tests")
public class Step1ArrayProcessorTest {

    @Test
    @DisplayName("getArrayLength returns correct size for non-empty arrays")
    void testGetArrayLengthStandard() {
        ArrayProcessor ap = new ArrayProcessor();
        assertEquals(3, ap.getArrayLength(new String[]{"apple", "banana", "cherry"}));
        assertEquals(5, ap.getArrayLength(new Integer[]{1, 2, 3, 4, 5}));
        assertEquals(1, ap.getArrayLength(new Object[]{new Object()}));
    }

    @Test
    @DisplayName("getArrayLength returns 0 for empty arrays")
    void testGetArrayLengthEmpty() {
        ArrayProcessor ap = new ArrayProcessor();
        assertEquals(0, ap.getArrayLength(new Object[]{}));
    }

    @Test
    @DisplayName("getArrayLength safely handles null arrays without throwing NullPointerException")
    void testGetArrayLengthNullHandling() {
        ArrayProcessor ap = new ArrayProcessor();
        // Defensive contract: a null array should return 0, not crash
        assertDoesNotThrow(() -> {
            int len = ap.getArrayLength(null);
            assertEquals(0, len, "A null array should safely return length 0");
        });
    }

    @Test
    @DisplayName("Anti-pattern elimination: ensure getArrayLength does not rely on try-catch loop control")
    void testAntiPatternEliminated() throws IOException {
        File sourceFile = new File("src/main/java/exceptions/ArrayProcessor.java");
        assertTrue(sourceFile.exists(), "ArrayProcessor.java must exist");
        String content = Files.readString(sourceFile.toPath());

        // Students must remove the while(true) loop exception anti-pattern
        assertFalse(content.contains("while (true)") || content.contains("while(true)"),
                "Refactoring requirement: Eliminate while(true) loop termination. Use a.length or idiomatic loop bounds!");

        assertFalse(content.contains("catch (Exception e)") && content.contains("count++"),
                "Refactoring requirement: Do not use try-catch to detect the end of an array!");
    }
}
