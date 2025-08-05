/*
 * 47.Create a custom checked exception class InvalidSalaryException that extends Exception.

Create a class EmployeeService with the following methods:

validateSalary(double salary) → throws InvalidSalaryException if salary is < 0
processSalary(Employee emp) → calls validateSalary()
startProcess(Employee emp) → calls processSalary()

The main method should:

Create an Employee object with negative salary
Call startProcess()
Catch and handle InvalidSalaryException using try-catch in main()

 */
package myassignments;

@SuppressWarnings("serial")
// Custom checked exception
class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String message) {
        super(message);
    }
}

// Employee class
class Employee47 {
    private int id;
    private String name;
    private double salary;

    public Employee47(int id, String name, double salary)
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public double getSalary()
    {
        return salary;
    }

    @Override
    public String toString()
    {
        return "Employee [ID=" + id + ", Name=" + name + ", Salary=" + salary + "]";
    }
}

// Service class to process employee
class EmployeeService {
    public void validateSalary(double salary) throws InvalidSalaryException
    {
        if (salary < 0) {
            throw new InvalidSalaryException("Salary cannot be negative!");
        }
    }

    public void processSalary(Employee47 emp) throws InvalidSalaryException
    {
        validateSalary(emp.getSalary());
        System.out.println("Salary is valid for: " + emp);
    }

    public void startProcess(Employee47 emp) throws InvalidSalaryException
    {
        processSalary(emp);
    }
}


public class Exercise47
{
    public static void main(String[] args)
    {
        Employee47 emp = new Employee47(101, "John", -85000);  

        EmployeeService service = new EmployeeService();

        try
        {
            service.startProcess(emp);
        } catch (InvalidSalaryException e)
        {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
/* Error: Salary cannot be negative!
myassignments.InvalidSalaryException: Salary cannot be negative!
	at myassignments.EmployeeService.validateSalary(Exercise47.java:57)
	at myassignments.EmployeeService.processSalary(Exercise47.java:63)
	at myassignments.EmployeeService.startProcess(Exercise47.java:69)
	at myassignments.Exercise47.main(Exercise47.java:84)
*/
