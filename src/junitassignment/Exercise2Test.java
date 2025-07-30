package junitassignment;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise2Test
{

    // Test reversing a normal string
    @Test
    public void testReverseString_RegularInput() {
        assertEquals("dcba", Exercise2.reverseString("abcd"));  // Expected reversed
        assertEquals("4321", Exercise2.reverseString("1234"));  // Expected reversed
        assertEquals("a", Exercise2.reverseString("a"));        // Single character
    }

    // Test reversing an empty string
    @Test
    public void testReverseString_EmptyString()
    {
        assertEquals("", Exercise2.reverseString(""));  // Should return empty string
    }

    // Test null input should throw IllegalArgumentException
    @Test
    public void testReverseString_NullInput_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Exercise2.reverseString(null);
        });

        // Validate the exception message
        assertEquals("Input string cannot be null", exception.getMessage());
    }
}

