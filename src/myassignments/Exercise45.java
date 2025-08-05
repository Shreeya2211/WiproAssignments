/*
 * 45.Create a class Student with fields: id, name, department.
Group the students by department using Map<String, List<Student>>.
Print all departments with their student names.
Bonus: Use Java 8 Stream and Collectors.groupingBy()

 */
package myassignments;

import java.util.*;
import java.util.stream.Collectors;

class Student45
{
    private int id;
    private String name;
    private String department;

    public Student45(int id, String name, String department)
    {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public String getDepartment()
    {
        return department;
    }

    public String getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return name + " (ID: " + id + ")";
    }
}

public class Exercise45
{
    public static void main(String[] args)
    {
        List<Student45> studentList = Arrays.asList(
            new Student45(101, "Alex", "CSE"),
            new Student45(102, "Benton", "ECE"),
            new Student45(103, "Charlotte", "CSE"),
            new Student45(104, "Daemon", "MECH"),
            new Student45(105, "Ethan", "ECE"),
            new Student45(106, "Ford", "CSE")
        );

        // Grouping by department using Java 8 Streams
        Map<String, List<Student45>> groupedByDept = studentList.stream()
            .collect(Collectors.groupingBy(Student45::getDepartment));

        // Display departments and student names
        groupedByDept.forEach((dept, students) -> {
            System.out.println("Department: " + dept);
            for (Student45 s : students) {
                System.out.println(" - " + s.getName());
            }
        });
    }
}
/*
Department: CSE
- Alex
- Charlotte
- Ford
Department: ECE
- Benton
- Ethan
Department: MECH
- Daemon
*/