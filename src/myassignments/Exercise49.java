/*
 * 49.Create a class Employee with optional fields for email and department. Use Optional to:

Safely access employee details.

Provide default values when data is absent.

Throw custom exceptions if required fields are missing
 */
package myassignments;

import java.util.Optional;

@SuppressWarnings("serial")
// Custom exception for missing required fields
class MissingFieldException extends Exception
{
    public MissingFieldException(String message)
    {
        super(message);
    }
}

// Employee class with optional fields
class Employee49
{
    private int id;
    private String name;
    private Optional<String> email;
    private Optional<String> department;

    public Employee49(int id, String name, Optional<String> email, Optional<String> department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public Optional<String> getEmail()
    {
        return email;
    }

    public Optional<String> getDepartment()
    {
        return department;
    }
}


public class Exercise49
{
    public static void main(String[] args)
    {
        // Employee with all details
        Employee49 emp1 = new Employee49(1, "Ananya",
                Optional.of("ananya@example.com"),
                Optional.of("HR"));

        // Employee missing department
        Employee49 emp2 = new Employee49(2, "Babu",
                Optional.of("babu@example.com"),
                Optional.empty());

        // Employee missing email and department
        Employee49 emp3 = new Employee49(3, "Chaitanya",
                Optional.empty(),
                Optional.empty());

        try {
            printEmployeeDetails(emp1);
            printEmployeeDetails(emp2);
            printEmployeeDetails(emp3);
        } 
        catch (MissingFieldException e)
        {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Method to print employee details with Optional handling
    public static void printEmployeeDetails(Employee49 emp) throws MissingFieldException
    {
        System.out.println("\nEmployee ID: " + emp.getId());
        System.out.println("Name: " + emp.getName());

        // Provide default email if not present
        String email = emp.getEmail().orElse("Email not provided");
        System.out.println("Email: " + email);

        // Throw exception if department is missing
        String department = emp.getDepartment()
                .orElseThrow(() -> new MissingFieldException("Department is required for employee: " + emp.getName()));
        System.out.println("Department: " + department);
    }
}
/*

Employee ID: 1
Name: Ananya
Email: ananya@example.com
Department: HR

Employee ID: 2
Name: Babu
Email: babu@example.com
Error: Department is required for employee: Babu
*/