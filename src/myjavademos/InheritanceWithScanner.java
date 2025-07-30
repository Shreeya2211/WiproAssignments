package myjavademos;

import java.util.Scanner;

//Multilevel Inheritance
//A class can also be derived from one class, which is already derived from another class. 
class Student_X extends Object
{
    Scanner s=new Scanner(System.in);
    int no;
    String name;
    void getdata()
    {
        System.out.println("enter no::");
        no=s.nextInt();
        System.out.println("enter name::");
        name=s.next();
    }
    void putdata()
    {
        System.out.println("no is::"+no);
        System.out.println("name is::"+name);
    }
}
class Marks extends Student_X
{
    int sub1,sub2,sub3,total=0;
    void getmarks()
    {
         System.out.println("enter marks of subject 1::");
        sub1=s.nextInt();
        System.out.println("enter marks of subject 2::");
        sub2=s.nextInt();
        System.out.println("enter marks of subject 3::");
        sub3=s.nextInt();
    }
    void putmarks()
    {
        System.out.println("marks of subject 1 is::"+sub1);
        System.out.println("marks of subject 2 is::"+sub2);
        System.out.println("marks of subject 3 is::"+sub3);
    }
    void addition()
    {    	
        total=sub1+sub2+sub3;
        System.out.println("value of addition is::"+total);
    }
}
class Result extends Marks
{
    int avg;
    void getd()
    {
        avg=(total)/3;
        System.out.println("value of avg is::"+avg);
    }
}
public class InheritanceWithScanner {
	public static void main(String[] args) {
        Result r=new Result();
        r.getdata();
        r.putdata();
        r.getmarks();
        r.putmarks();
        r.addition();
        r.getd();

	}

}
/*
enter no::
1
enter name::
devi
no is::1
name is::devi
enter marks of subject 1::
98
enter marks of subject 2::
89
enter marks of subject 3::
90
marks of subject 1 is::98
marks of subject 2 is::89
marks of subject 3 is::90
value of addition is::277
value of avg is::92
*/