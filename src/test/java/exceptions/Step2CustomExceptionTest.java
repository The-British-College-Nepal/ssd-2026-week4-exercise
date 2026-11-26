package exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Step 2: Custom InvalidOptionException Tests")
public class Step2CustomExceptionTest {

    @Test
    @DisplayName("InvalidOptionException must be a checked exception (extends Exception, not RuntimeException)")
    void testExceptionHierarchy() {
        assertTrue(Exception.class.isAssignableFrom(InvalidOptionException.class),
                "InvalidOptionException must inherit from java.lang.Exception");
        assertFalse(RuntimeException.class.isAssignableFrom(InvalidOptionException.class),
                "InvalidOptionException should be a CHECKED exception (do not extend RuntimeException)");
    }

    @Test
    @DisplayName("InvalidOptionException supports standard constructor with message")
    void testConstructorWithMessage() {
        String msg = "The option must be between 1 and 3";
        InvalidOptionException ex = new InvalidOptionException(msg);
        assertEquals(msg, ex.getMessage());
    }

    @Test
    @DisplayName("InvalidOptionException supports chained cause constructor")
    void testConstructorWithCause() {
        Throwable cause = new NumberFormatException("Invalid number input");
        InvalidOptionException ex = new InvalidOptionException("Failed to parse menu option", cause);
        assertEquals("Failed to parse menu option", ex.getMessage());
        assertSame(cause, ex.getCause(), "Exception cause should be chained via super(msg, cause)");
    }

    @Test
    @DisplayName("InvalidOptionException class has complete Javadoc with @author tag")
    void testJavadocDocumentation() throws IOException {
        File sourceFile = new File("src/main/java/exceptions/InvalidOptionException.java");
        assertTrue(sourceFile.exists());
        String content = Files.readString(sourceFile.toPath());

        assertTrue(content.contains("/**") && content.contains("@author"),
                "InvalidOptionException.java must contain Javadoc comment with @author tag");
    }
}
