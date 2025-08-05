/* 34.Create a class by name Employee with members   Employee ID, Name andyear of birth. 
 * The Employee ID is a string that contains the ID in the formatyear-designation-number. 
 * The year is represented with the last two digits.
 *  Thedesignation is a single letter code - 'F' for faculty and 'S' for staff.
 *  The numberis a 3 digit number.(Example:81-F-112     79-S-254)


 */
package myassignments;

class Employee {
    private String empId;     // Format: YY-<DesignationLetter>-<Number>
    private String name;
    private int yearOfBirth;

    public Employee(String empId, String name, int yearOfBirth) {
        this.empId = empId;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    public void printDetails() {
        System.out.println("Employee Name      : " + name);
        System.out.println("Employee ID        : " + empId);
        System.out.println("Year of Birth      : " + yearOfBirth);

        // Extract components from empId
        String[] parts = empId.split("-");
        if (parts.length == 3) {
            String yearPart = "20" + parts[0];
            String designationCode = parts[1];
            String numberPart = parts[2];

            String designation = "";
            if (designationCode.equalsIgnoreCase("F")) {
                designation = "Faculty";
            } else if (designationCode.equalsIgnoreCase("S")) {
                designation = "Staff";
            } else {
                designation = "Unknown";
            }

            System.out.println("Designation        : " + designation);
            System.out.println("Joining Year       : " + yearPart);
            System.out.println("Unique Number Code : " + numberPart);
        } else {
            System.out.println("Invalid Employee ID format.");
        }
    }
}

public class Exercise34 {
    public static void main(String[] args) {
        Employee e1 = new Employee("22-F-105", "Kim Taeri", 1998);
        Employee e2 = new Employee("23-S-207", "Goblin", 1995);

        System.out.println("Employee 1:");
        e1.printDetails();

        System.out.println("\nEmployee 2:");
        e2.printDetails();
    }
}
/*
Employee 1:
Employee Name      : Kim Taeri
Employee ID        : 22-F-105
Year of Birth      : 1998
Designation        : Faculty
Joining Year       : 2022
Unique Number Code : 105

Employee 2:
Employee Name      : Goblin
Employee ID        : 23-S-207
Year of Birth      : 1995
Designation        : Staff
Joining Year       : 2023
Unique Number Code : 207
*/
