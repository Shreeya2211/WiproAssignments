/*
 * 50.List<Employee> employees = Arrays.asList(
    new Employee(101, "Ravi", "HR", 50000),
    new Employee(102, "Priya", "IT", 60000),
    new Employee(103, "Arun", "HR", 55000),
    new Employee(104, "Kavya", "IT", 70000),
    new Employee(105, "Divya", "Sales", 45000)
);
Q1. Print all employee names using Stream
Q2. Filter and print employees with salary > 55000
Q3. Count the number of employees in "HR" department
Q4. Sort employees by salary in descending order
Q5. Find the highest paid employee (use max)
Q6. Find the average salary of all employees
Q7. Collect all names into a List
Q8. Group employees by department (use Collectors.groupingBy)
Q9. Calculate total salary per department
Q10. Find names of employees in IT department sorted by salary
Q11. Check if any employee earns less than 40000
Q12. Get a comma-separated string of all employee names
Q13. Get a list of top 2 highest earning employees
Q14. Skip first 2 employees and print the rest
Q15. Limit to first 3 employees and print their names
Q16. Get employee with minimum salary in HR department
Q17. Partition employees into two groups: salary > 55000 and <= 55000
Q18. Create a Map<Department, AverageSalary>
Q19. Sort employees by name and then by salary
Q20. Convert List<Employee> into Map<Id, Name>
🔹 Challenge 1: Get employees whose name starts with “D” and ends with “a”
🔹 Challenge 2: List departments with more than 1 employee
🔹 Challenge 3: Find the second highest salary using streams
(Hint: Use distinct(), sorted(), skip(1), findFirst())

 */
package myassignments;
import java.util.*;
import java.util.stream.*;

class Employee50
{
    private int id;
    private String name;
    private String department;
    private double salary;

    public Employee50(int id, String name, String department, double salary)
    {
        this.id = id;
        this.name = name;
        this.department = department;
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
    public String getDepartment()
    { 
    	return department;
    }
    public double getSalary()
    { 
    	return salary;
    	}

    @Override
    public String toString()
    {
        return id + " - " + name + " - " + department + " - " + salary;
    }

    public static void main(String[] args)
    {
        List<Employee50> employees = Arrays.asList(
            new Employee50(101, "Ravi", "HR", 50000),
            new Employee50(102, "Priya", "IT", 60000),
            new Employee50(103, "Arun", "HR", 55000),
            new Employee50(104, "Kavya", "IT", 70000),
            new Employee50(105, "Divya", "Sales", 45000)
        );

        // Q1
        System.out.println("Q1:");
        employees.stream().map(Employee50::getName).forEach(System.out::println);

        // Q2
        System.out.println("\nQ2:");
        employees.stream().filter(e -> e.getSalary() > 55000).forEach(System.out::println);

        // Q3
        System.out.println("\nQ3: HR Count = " + employees.stream().filter(e -> e.getDepartment().equals("HR")).count());

        // Q4
        System.out.println("\nQ4:");
        employees.stream().sorted(Comparator.comparingDouble(Employee50::getSalary).reversed()).forEach(System.out::println);

        // Q5
        System.out.println("\nQ5:");
        employees.stream().max(Comparator.comparingDouble(Employee50::getSalary)).ifPresent(System.out::println);

        // Q6
        System.out.println("\nQ6: Average Salary = " +
                employees.stream().mapToDouble(Employee50::getSalary).average().orElse(0));

        // Q7
        System.out.println("\nQ7:");
        List<String> names = employees.stream().map(Employee50::getName).collect(Collectors.toList());
        System.out.println(names);

        // Q8
        System.out.println("\nQ8:");
        Map<String, List<Employee50>> grouped = employees.stream().collect(Collectors.groupingBy(Employee50::getDepartment));
        grouped.forEach((dept, list) -> System.out.println(dept + ": " + list));

        // Q9
        System.out.println("\nQ9:");
        Map<String, Double> totalByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee50::getDepartment, Collectors.summingDouble(Employee50::getSalary)));
        System.out.println(totalByDept);

        // Q10
        System.out.println("\nQ10:");
        employees.stream().filter(e -> e.getDepartment().equals("IT"))
                .sorted(Comparator.comparingDouble(Employee50::getSalary))
                .map(Employee50::getName).forEach(System.out::println);

        // Q11
        System.out.println("\nQ11: Any salary < 40000? " +
                employees.stream().anyMatch(e -> e.getSalary() < 40000));

        // Q12
        System.out.println("\nQ12:");
        String joinedNames = employees.stream().map(Employee50::getName).collect(Collectors.joining(", "));
        System.out.println(joinedNames);

        // Q13
        System.out.println("\nQ13:");
        employees.stream().sorted(Comparator.comparingDouble(Employee50::getSalary).reversed()).limit(2).forEach(System.out::println);

        // Q14
        System.out.println("\nQ14:");
        employees.stream().skip(2).forEach(System.out::println);

        // Q15
        System.out.println("\nQ15:");
        employees.stream().limit(3).map(Employee50::getName).forEach(System.out::println);

        // Q16
        System.out.println("\nQ16:");
        employees.stream().filter(e -> e.getDepartment().equals("HR"))
                .min(Comparator.comparingDouble(Employee50::getSalary)).ifPresent(System.out::println);

        // Q17
        System.out.println("\nQ17:");
        Map<Boolean, List<Employee50>> partition = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 55000));
        partition.forEach((key, val) -> System.out.println((key ? "Above 55K" : "Below/Equal 55K") + ": " + val));

        // Q18
        System.out.println("\nQ18:");
        Map<String, Double> avgByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee50::getDepartment, Collectors.averagingDouble(Employee50::getSalary)));
        System.out.println(avgByDept);

        // Q19
        System.out.println("\nQ19:");
        employees.stream()
                .sorted(Comparator.comparing(Employee50::getName).thenComparing(Employee50::getSalary))
                .forEach(System.out::println);

        // Q20
        System.out.println("\nQ20:");
        Map<Integer, String> idNameMap = employees.stream()
                .collect(Collectors.toMap(Employee50::getId, Employee50::getName));
        System.out.println(idNameMap);

        // Challenge 1
        System.out.println("\nChallenge 1:");
        employees.stream()
                .filter(e -> e.getName().startsWith("D") && e.getName().endsWith("a"))
                .forEach(System.out::println);

        // Challenge 2
        System.out.println("\nChallenge 2:");
        employees.stream()
                .collect(Collectors.groupingBy(Employee50::getDepartment, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .forEach(System.out::println);

        // Challenge 3
        System.out.println("\nChallenge 3:");
        employees.stream().map(Employee50::getSalary).distinct()
                .sorted(Comparator.reverseOrder()).skip(1).findFirst()
                .ifPresent(s -> System.out.println("Second highest salary: " + s));
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