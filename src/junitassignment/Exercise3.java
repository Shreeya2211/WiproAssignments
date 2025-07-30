
/*3.Test a login validation method 
 Validate correct username/password.

Test for empty, null, or invalid inputs.
 */
 
package junitassignment;

public class Exercise3
{

    // Method to validate login credentials
    public static boolean validateLogin(String username, String password)
    {
        // Check for null or empty input
        if (username == null || password == null || username.isEmpty() || password.isEmpty())
        {
            throw new IllegalArgumentException("Username and password must not be null or empty");
        }

        // Expected correct credentials (can be replaced with DB later)
        String validUsername = "admin";
        String validPassword = "password123";

        // Return true only if both username and password match
        return username.equals(validUsername) && password.equals(validPassword);
    }
}
