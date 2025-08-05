package myassignments;

/*
 44.
Custom Sorting with Comparator
Problem:
You are given a list of Employee objects with attributes: id, name, and salary.
Store them in a List<Employee>.
Sort by salary in descending order using Comparator.
Then sort by name alphabetically using a lambda expression.

 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class EmployeeData44
{
    private int id;
    private String name;
    private double salary;

    public EmployeeData44(int id, String name, double salary)
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId()
    { 
    	return id;
    }
    public String getName()
    { 
    	return name;
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

public class Exercise44
{
    public static void main(String[] args)
    {
        List<EmployeeData44> employees = new ArrayList<>();
        employees.add(new EmployeeData44(101, "Andy", 50000));
        employees.add(new EmployeeData44(102, "Ben", 70000));
        employees.add(new EmployeeData44(103, "Charlotte", 60000));
        employees.add(new EmployeeData44(104, "Daemon", 70000));

        // Sort by salary in descending order
        employees.sort(new Comparator<EmployeeData44>()
        {
            public int compare(EmployeeData44 e1, EmployeeData44 e2)
            {
                return Double.compare(e2.getSalary(), e1.getSalary());
            }
        });

        System.out.println("Sorted by salary (descending):");
        for (EmployeeData44 e : employees)
        {
            System.out.println(e);
        }

        // Sort by name alphabetically using lambda
        employees.sort((e1, e2) -> e1.getName().compareToIgnoreCase(e2.getName()));

        System.out.println("\nSorted by name (alphabetically):");
        for (EmployeeData44 e : employees) {
            System.out.println(e);
        }
    }
}
/*
Sorted by salary (descending):
Employee [ID=102, Name=Ben, Salary=70000.0]
Employee [ID=104, Name=Daemon, Salary=70000.0]
Employee [ID=103, Name=Charlotte, Salary=60000.0]
Employee [ID=101, Name=Andy, Salary=50000.0]

Sorted by name (alphabetically):
Employee [ID=101, Name=Andy, Salary=50000.0]
Employee [ID=102, Name=Ben, Salary=70000.0]
Employee [ID=103, Name=Charlotte, Salary=60000.0]
Employee [ID=104, Name=Daemon, Salary=70000.0]
*/