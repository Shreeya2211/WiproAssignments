package junitassignment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise1Test {

    @Test
    public void testFactorial_ValidInputs() {
        assertEquals(1, Exercise1.factorial(0));   // 0! = 1
        assertEquals(1, Exercise1.factorial(1));   // 1! = 1
        assertEquals(2, Exercise1.factorial(2));   // 2! = 2
        assertEquals(6, Exercise1.factorial(3));   // 3! = 6
        assertEquals(24, Exercise1.factorial(4));  // 4! = 24
        assertEquals(120, Exercise1.factorial(5)); // 5! = 120
    }

    @Test
    public void testFactorial_NegativeInput_ThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Exercise1.factorial(-1);
        });
        assertEquals("Factorial is not defined for negative numbers", exception.getMessage());
    }
}
