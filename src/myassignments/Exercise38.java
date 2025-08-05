/* 38.Create an object called employee whose attributes are emp_id, emp_name and emp_sal.  
 * Write a program to Serialize and deserialize the employee object except for the emp_sal attribute.
 * (Use Scanner class to  get the input from the user).
 */
package myassignments;
import java.io.*;
import java.util.Scanner;

@SuppressWarnings("serial")
class EmpData implements Serializable {
    private int emp_id;
    private String emp_name;
    private transient double emp_sal; // Will not be serialized

    public EmpData(int emp_id, String emp_name, double emp_sal) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.emp_sal = emp_sal;
    }

    public void displayDetails() {
        System.out.println("Employee ID: " + emp_id);
        System.out.println("Employee Name: " + emp_name);
        System.out.println("Employee Salary: " + emp_sal); // Will show 0.0 after deserialization
    }
}

public class Exercise38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input from user
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();

        System.out.print("Enter Employee Name: ");
        scanner.nextLine(); // Consume newline
        String name = scanner.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        EmpData emp = new EmpData(id, name, salary);

        // Serialize the object
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.ser"))) {
            out.writeObject(emp);
            System.out.println("\nEmployee object serialized successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize the object
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.ser"))) {
            EmpData deserializedEmp = (EmpData) in.readObject();
            System.out.println("\nDeserialized Employee details:");
            deserializedEmp.displayDetails(); // emp_sal will be 0.0
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
/*
Enter Employee ID: 1
Enter Employee Name: Kim Taeri
Enter Employee Salary: 80000

Employee object serialized successfully.

Deserialized Employee details:
Employee ID: 1
Employee Name: Kim Taeri
Employee Salary: 0.0
*/