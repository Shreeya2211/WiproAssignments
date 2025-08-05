/*
 * 48.Create a functional interface EmployeeProcessor with a method:

void process(Employee e);

Use it to print:

Name and salary of employees
Bonus calculation (10% of salary)
 */
package myassignments;


class Employee48
{
    @SuppressWarnings("unused")
	private int id;
    private String name;
    private double salary;

    public Employee48(int id, String name, double salary)
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String getName()
    {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

// Functional Interface
@FunctionalInterface
interface EmployeeProcessor
{
    void process(Employee48 e);
}


public class Exercise48
{
    public static void main(String[] args)
    {
        Employee48 emp1 = new Employee48(1, "Ananya", 50000);
        Employee48 emp2 = new Employee48(2, "Ishwarya", 65000);

        // Lambda to print name and salary
        EmployeeProcessor printDetails = (e) -> 
            System.out.println("Name: " + e.getName() + ", Salary: " + e.getSalary());

        // Lambda to print 10% bonus
        EmployeeProcessor calculateBonus = (e) -> 
            System.out.println("Bonus (10%): " + (e.getSalary() * 0.10));

        System.out.println("Employee 1 Details:");
        printDetails.process(emp1);
        calculateBonus.process(emp1);

        System.out.println("\nEmployee 2 Details:");
        printDetails.process(emp2);
        calculateBonus.process(emp2);
    }
}
/*
Employee 1 Details:
Name: Ananya, Salary: 50000.0
Bonus (10%): 5000.0

Employee 2 Details:
Name: Ishwarya, Salary: 65000.0
Bonus (10%): 6500.0
*/