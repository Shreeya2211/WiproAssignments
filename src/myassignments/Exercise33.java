/* 33.Create a class with following specifications.                                                                         
Class Emp                                                                                                           
           
empId              int                   
empName        string      
designation      string             
basic                double              
hra                   double readOnly

Methods
printDET()
printDET() methods will show details of the EMP.                                             
calculateHRA() method will calculate HRA based on basic.

There will 3 designations supported by the application.                                                                                            
If designation  is  Manager   - HRA will be 10% of BASIC
if designation  is  TeamLeader   - HRA will be 12% of BASIC
if category is "HR"  - HRA will be 5% of BASIC

Have constructor to which you will pass, empId, designation, basic and price.

And checks whether the BASIC is less than 50000 or not. If it is less than 50000 raise a custom Exception as given below

Create LowSalException class with proper user message to handle BASIC less than 50000.    */

package myassignments;

import java.text.DecimalFormat;

@SuppressWarnings("serial")
//Custom Exception for low salary
class LowSalException extends Exception {
 public LowSalException(String message) {
     super(message);
 }
}

//Emp class with required fields and methods
class Emp {
 private int empId;
 private String empName;
 private String designation;
 private double basic;
 private final double hra;

 // Constructor
 public Emp(int empId, String empName, String designation, double basic) throws LowSalException {
     if (basic < 50000) {
         throw new LowSalException("Basic salary must be at least 50000!");
     }
     this.empId = empId;
     this.empName = empName;
     this.designation = designation;
     this.basic = basic;
     this.hra = calculateHRA();
 }

 // Method to calculate HRA
 private double calculateHRA() {
     switch (designation.toLowerCase()) {
         case "manager":
             return basic * 0.10;
         case "teamleader":
             return basic * 0.12;
         case "hr":
             return basic * 0.05;
         default:
             return 0;
     }
 }

 // Method to print employee details
 public void printDET() {
     DecimalFormat df = new DecimalFormat("0.00");
     System.out.println("Employee ID      : " + empId);
     System.out.println("Employee Name    : " + empName);
     System.out.println("Designation      : " + designation);
     System.out.println("Basic Salary     : ₹" + df.format(basic));
     System.out.println("HRA              : ₹" + df.format(hra));
 }
}


public class Exercise33 {
 public static void main(String[] args) {
     try {
         Emp e1 = new Emp(101, "Ravi", "Manager", 60000);
         e1.printDET();

         System.out.println("\n---\n");

         Emp e2 = new Emp(102, "Meena", "HR", 45000); // Will throw custom exception
         e2.printDET();

     } catch (LowSalException e) {
         System.out.println("Exception Caught: " + e.getMessage());
     }
 }
}
/*
Employee ID      : 101
Employee Name    : Ravi
Designation      : Manager
Basic Salary     : ₹60000.00
HRA              : ₹6000.00

---

Exception Caught: Basic salary must be at least 50000!
*/