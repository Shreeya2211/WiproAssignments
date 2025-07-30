package myjavademos;
/*
 * Why Use Optional Built in class?:::::::::::::::::::::
 * 
Without Optional			With Optional
NullPointerException risk	Safe null handling
Need to check if != null	Built-in methods like orElse(), ifPresent()
Code harder to read			Cleaner and more expressive
 */
//Use Optional to avoid NullPointerException when accessing fields like email, mobile number, etc.

/*
 * Optional class::
 * Optional is a container object used to contain not-null objects. 
 * Optional object is used to represent null with absent value. 
 * Java introduced a new class Optional in jdk8. It is a public final class and used to deal with 
 * NullPointerException
 * 
 *  In Java application. You must import java.util package to use this class. 
 * It provides methods which are used to check the presence of value for particular variable.
 * 
 * The purpose of Optional is not to replace every single null reference in your code base but rather to 
 * help you design better APIs in which, just by reading the signature of a method, 
 * users can tell whether to expect an optional value and deal with it appropriately.
 
 Advantages of Java 8 Optional:

Null checks are not required.
No more NullPointerException at run-time.
 */

/*
 * When to use Optional class???
 * 
 * | Field Type    | Use Optional? | Reason                  |
| ------------- | ------------- | ----------------------- |
| `id`, `name`  | ❌ No          | Always expected         |
| `description` | ✅ Yes         | Can be missing          |
| `discount`    | ✅ Yes         | Optional business value |

 */
import java.util.Optional;

class Student11 {
    private String name;//mandatory
    private Optional<String> email; // Optional field
    private Optional<String> phone;//optional field

    public Student11(String name, Optional<String> email, Optional<String> phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public Optional<String> getPhone() {
        return phone;
    }
    public static void printStudentDetails(Student11 student) 
    {
        System.out.println("Name: " + student.getName());

        // Handle optional email
        student.getEmail().ifPresentOrElse(
            email -> System.out.println("Email: " + email),
            () -> System.out.println("Email not provided")
        );

        // Handle optional phone
        String phone = student.getPhone().orElse("Phone not provided");
        System.out.println("Phone: " + phone);
    }
}
public class OptionalDemos {
	public static void main(String[] args) {
		Student11 s1 = new Student11("Ravi", Optional.of("ravi@example.com"), Optional.empty());
        Student11 s2 = new Student11("Anu", Optional.empty(), Optional.of("9876543210"));

        Student11.printStudentDetails(s1);
        System.out.println("------------------------");
        Student11.printStudentDetails(s2);
	}

}
/*
Name: Ravi
Email: ravi@example.com
Phone: Phone not provided
------------------------
Name: Anu
Email not provided
Phone: 9876543210
*/