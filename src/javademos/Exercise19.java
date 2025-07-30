/* 19.The following are the superclass Bank and its subclasses Saving and Current.
Super class : Bank
public class Bank 
{
String accNo;  //customer account number with Bank
String custName; //customer name
int custGender;  //customer gender 1 = Male, 2 =Female
String custJob;  //customer job positions
double curBal;  //customer balance in the bank account
public String toString();
public abstract double calcBalance();
}

Subclass : Saving
public class Saving 
{
double savRate;  //percent interest rate per year
}

Subclass : Current
public class Current
{
boolean fixedDep;  //whether the customer keeps the fixed// deposit with the bank of not
double curRate;  //percent interest rate per year
}

The  above  classes  show  that  Bank  can  have  two  different  types  of  account  which  are Saving  and  Current  account.
  The  balance amount  in the  bank for  each account  is basedon the following calculation :

Saving :Balance =  current balance + (savRate * current balance)
Current :Balance = current balance + (curRate * current balance)

If the customer has a fixed deposit with the bank, then the bank will charge RM150for the service fee.  
The amount will be deducted automatically yearly.

a)  Write a method of calcBalance() for both subclasses.
b)  Search  a  customer  based  on  the  account  number  entered  then  display  detailinformation  of  him/her.  If  the  customer  account  number  is  not  found,  display  anappropriate message.
c)  Count how many customers that have the current account with the bank and the totalbalance.  
 */
package javademos;
import java.util.Scanner;



abstract class Bank
{
 String accNo;
 String custName;
 int custGender; // 1 = Male, 2 = Female
 String custJob;
 double curBal;

 Bank(String accNo, String custName, int custGender, String custJob, double curBal)
 {
     this.accNo = accNo;
     this.custName = custName;
     this.custGender = custGender;
     this.custJob = custJob;
     this.curBal = curBal;
 }

 public String toString()
 {
     String gender = (custGender == 1) ? "Male" : "Female";
     return "Account No: " + accNo + "\n" +
            "Name: " + custName + "\n" +
            "Gender: " + gender + "\n" +
            "Job: " + custJob + "\n" +
            "Current Balance: " + curBal;
 }

 public abstract double calcBalance();
}

//Saving account subclass
class Saving extends Bank
{
 double savRate;

 Saving(String accNo, String custName, int custGender, String custJob, double curBal, double savRate)
 {
     super(accNo, custName, custGender, custJob, curBal);
     this.savRate = savRate;
 }

 @Override
 public double calcBalance()
 {
     return curBal + (savRate * curBal / 100);
 }
}

//Current account subclass
class Current extends Bank
{
 boolean fixedDep;
 double curRate;

 Current(String accNo, String custName, int custGender, String custJob, double curBal, boolean fixedDep, double curRate)
 {
     super(accNo, custName, custGender, custJob, curBal);
     this.fixedDep = fixedDep;
     this.curRate = curRate;
 }

 @Override
 public double calcBalance()
 {
     double balance = curBal + (curRate * curBal / 100);
     if (fixedDep) {
         balance -= 150; // Deduct service fee
     }
     return balance;
 }
}


public class Exercise19
{
 public static void main(String[] args)
 {
     Bank[] customers = new Bank[5];
     customers[0] = new Saving("A101", "Raj", 1, "Engineer", 10000, 4.5);
     customers[1] = new Current("C102", "Priya", 2, "Doctor", 15000, true, 3.0);
     customers[2] = new Saving("A103", "Arun", 1, "Teacher", 12000, 5.0);
     customers[3] = new Current("C104", "Divya", 2, "Manager", 20000, false, 2.5);
     customers[4] = new Current("C105", "Kiran", 1, "Accountant", 18000, true, 2.8);

     Scanner sc = new Scanner(System.in);

     // Search by account number
     System.out.print("Enter account number to search: ");
     String searchAcc = sc.nextLine();
     boolean found = false;

     for (Bank cust : customers)
     {
         if (cust.accNo.equalsIgnoreCase(searchAcc))
         {
             found = true;
             System.out.println("\nCustomer Details:");
             System.out.println(cust.toString());
             System.out.println("Calculated Balance: " + cust.calcBalance());
             break;
         }
     }

     if (!found)
     {
         System.out.println("Customer with account number " + searchAcc + " not found.");
     }

     // Count current account holders and total balance
     int currentCount = 0;
     double totalCurrentBalance = 0;

     for (Bank cust : customers)
     {
         if (cust instanceof Current)
         {
             currentCount++;
             totalCurrentBalance += cust.calcBalance();
         }
     }

     System.out.println("\nTotal Current Account Holders: " + currentCount);
     System.out.println("Total Balance of Current Accounts: " + totalCurrentBalance);

     sc.close();
 }
}
/*
Enter account number to search: a101

Customer Details:
Account No: A101
Name: Raj
Gender: Male
Job: Engineer
Current Balance: 10000.0
Calculated Balance: 10450.0

Total Current Account Holders: 3
Total Balance of Current Accounts: 54154.0
*/