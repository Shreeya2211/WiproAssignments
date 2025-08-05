/* 35.Write a program to read the employee details and validate the employee code.
 * If the employee code is incorrect throw a user-defined exception"InvalidEmployeeCode" else 
 * create the Employee object and display the detailsof the employee.
 */

package myassignments;

@SuppressWarnings("serial")
//Custom Exception Class
class InvalidEmployeeCode extends Exception {
 public InvalidEmployeeCode(String message) {
     super(message);
 }
}

//Renamed Employee class to EmpDetails to avoid conflict
class EmpDetails {
 private String empCode;
 private String name;
 private String department;

 public EmpDetails(String empCode, String name, String department) {
     this.empCode = empCode;
     this.name = name;
     this.department = department;
 }

 public void printDetails() {
     System.out.println("Employee Code : " + empCode);
     System.out.println("Employee Name : " + name);
     System.out.println("Department    : " + department);
 }
}


public class Exercise35 {
 public static void main(String[] args) {
     String empCode = "EMP123";  
     String name = "Kim Taeri";
     String department = "HR";

     try {
         if (!empCode.matches("EMP\\d{3}")) {
             throw new InvalidEmployeeCode("Invalid Employee Code: Must start with 'EMP' followed by 3 digits.");
         }

         EmpDetails emp = new EmpDetails(empCode, name, department);
         emp.printDetails();

     } catch (InvalidEmployeeCode e) {
         System.out.println("Exception: " + e.getMessage());
     }
 }
}
/*
Employee Code : EMP123
Employee Name : Kim Taeri
Department    : HR
*/