package junitassignment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise3Test
{

    // Test with correct username and password
    @Test
    public void testValidLogin()
    {
        assertTrue(Exercise3.validateLogin("admin", "password123"));
    }

    // Test with incorrect username
    @Test
    public void testInvalidUsername()
    {
        assertFalse(Exercise3.validateLogin("user", "password123"));
    }

    // Test with incorrect password
    @Test
    public void testInvalidPassword()
    {
        assertFalse(Exercise3.validateLogin("admin", "wrongpass"));
    }

    // Test with both username and password incorrect
    @Test
    public void testInvalidCredentials()
    {
        assertFalse(Exercise3.validateLogin("user", "12345"));
    }

    // Test with empty username
    @Test
    public void testEmptyUsername()
    {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Exercise3.validateLogin("", "password123");
        });
        assertEquals("Username and password must not be null or empty", exception.getMessage());
    }

    // Test with empty password
    @Test
    public void testEmptyPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Exercise3.validateLogin("admin", "");
        });
        assertEquals("Username and password must not be null or empty", exception.getMessage());
    }

    // Test with null username
    @Test
    public void testNullUsername() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Exercise3.validateLogin(null, "password123");
        });
        assertEquals("Username and password must not be null or empty", exception.getMessage());
    }

    // Test with null password
    @Test
    public void testNullPassword() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Exercise3.validateLogin("admin", null);
        });
        assertEquals("Username and password must not be null or empty", exception.getMessage());
    }
}
