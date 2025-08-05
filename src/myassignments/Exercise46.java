/*
 * 46.Create a generic class Repository<T, ID> with the following methods:

void save(ID id, T entity)
T findById(ID id)
List<T> findAll()
void deleteById(ID id)

Create an Employee class with fields:

int id
String name
double salary

Instantiate Repository<Employee, Integer> in main() and:

Add 3 employees
Retrieve and print all employees
Retrieve a specific employee by ID
Delete an employee and print remaining data

 */
package myassignments;

import java.util.*;

// Generic Repository class
class Repository<T, ID>
{
    private Map<ID, T> store = new HashMap<>();

    public void save(ID id, T entity)
    {
        store.put(id, entity);
    }

    public T findById(ID id)
    {
        return store.get(id);
    }

    public List<T> findAll()
    {
        return new ArrayList<>(store.values());
    }

    public void deleteById(ID id)
    {
        store.remove(id);
    }
}

// Employee entity class
class EmployeeRepo46
{
    private int id;
    private String name;
    private double salary;

    public EmployeeRepo46(int id, String name, double salary)
    {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return "Employee [ID=" + id + ", Name=" + name + ", Salary=" + salary + "]";
    }
}


public class Exercise46
{
    public static void main(String[] args)
    {
        Repository<EmployeeRepo46, Integer> repo = new Repository<>();

        // Adding 3 employees
        EmployeeRepo46 e1 = new EmployeeRepo46(1, "Andy", 50000);
        EmployeeRepo46 e2 = new EmployeeRepo46(2, "Ben", 60000);
        EmployeeRepo46 e3 = new EmployeeRepo46(3, "Charlotte", 55000);

        repo.save(e1.getId(), e1);
        repo.save(e2.getId(), e2);
        repo.save(e3.getId(), e3);

        // Retrieve and print all employees
        System.out.println("All Employees:");
        repo.findAll().forEach(System.out::println);

        // Retrieve a specific employee
        System.out.println("\nEmployee with ID 2:");
        System.out.println(repo.findById(2));

        // Delete an employee
        repo.deleteById(1);
        System.out.println("\nAfter deleting employee with ID 1:");
        repo.findAll().forEach(System.out::println);
    }
}
/*
 * All Employees:
Employee [ID=1, Name=Andy, Salary=50000.0]
Employee [ID=2, Name=Ben, Salary=60000.0]
Employee [ID=3, Name=Charlotte, Salary=55000.0]

Employee with ID 2:
Employee [ID=2, Name=Ben, Salary=60000.0]

After deleting employee with ID 1:
Employee [ID=2, Name=Ben, Salary=60000.0]
Employee [ID=3, Name=Charlotte, Salary=55000.0]
*/
