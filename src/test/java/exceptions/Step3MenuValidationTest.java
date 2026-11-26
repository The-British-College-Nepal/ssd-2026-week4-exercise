package exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Step 3: Menu Validation & Propagation Tests")
public class Step3MenuValidationTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("displayMenuOption succeeds for valid options (1, 2, 3)")
    void testValidOptions(int opt) {
        Menu menu = new Menu();

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        try {
            System.setOut(new PrintStream(outContent));
            assertDoesNotThrow(() -> menu.displayMenuOption(opt),
                    "Options 1, 2, and 3 must not throw an exception");
            assertTrue(outContent.toString().contains("Menu option " + opt + " selected"),
                    "Output should confirm selection of option " + opt);
        } finally {
            System.setOut(originalOut);
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -100, 4, 5, 99})
    @DisplayName("displayMenuOption throws InvalidOptionException for values outside 1..3")
    void testInvalidOptions(int opt) {
        Menu menu = new Menu();

        InvalidOptionException ex = assertThrows(InvalidOptionException.class, () -> {
            menu.displayMenuOption(opt);
        }, "Calling displayMenuOption(" + opt + ") must throw InvalidOptionException");

        assertTrue(ex.getMessage().contains("1 and 3") || ex.getMessage().contains("between 1 and 3"),
                "Exception message must mention that option must be between 1 and 3");
    }

    @Test
    @DisplayName("selectOption correctly processes numeric string input")
    void testSelectOptionString() {
        Menu menu = new Menu();
        assertDoesNotThrow(() -> menu.selectOption("2"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "one", "0", "4", "", " "})
    @DisplayName("selectOption throws InvalidOptionException for invalid text or out-of-bounds strings")
    void testSelectOptionInvalidStrings(String input) {
        Menu menu = new Menu();
        assertThrows(InvalidOptionException.class, () -> {
            menu.selectOption(input);
        });
    }
}
