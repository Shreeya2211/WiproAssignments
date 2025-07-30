package myjavademos;

import java.util.Scanner;

/*
Userdefined Exception::
--class must inherit from either Throwable or Exception
*/

@SuppressWarnings("serial")
class WIPRONameFormatException extends Throwable
{
	public String toString()
	{
		return "Invalid Doctor Name Format!";//error msg
	}
}

@SuppressWarnings("serial")
class WIPROAgeRangeException extends Exception
{
	public String toString()
	{
		return "Age must be between 21 to 50! Kindly reenter the age!";//error msg
	}
}

class Doctor
{
	int docid;
	String docname;
	String specialization;
	int age;
	void display()
	{
		System.out.println("Doctor details:: "+docid + " "+docname + " "+age+ " "+specialization);
	}
	Doctor(int a,String dname,String d,int dage)
	{
		this.docid=a;
		this.specialization=d;
		int l,temp=0;
		//CHECKING DOCTOR NAME!
		l=dname.length();//length of a name
		for(int i=0;i<l;i++)
		{
			char ch;
			ch=dname.charAt(i);//extract a character one by one 
			if(ch < 'A' || ch > 'Z' && ch < 'a' || ch>'z')
			{
				temp=1;
			}		
		}
		//throw keyword:: throw or raise an user defined or built in exception explicitly
		//You can throw "only one exception" with the help of throw keyword!
			
		/*
		 * throw keyword::
		 * --throw followed by Object ex: throw new AgeRangeException
		 * --throw keyword is used within the method or block!
		 * --throw keyword cannot throw multiple exception
		 * ex: throw new AgeRangeException,NameValidationException //invalid!!
		 * 
		 */
		
		try
		{
			if(temp==1)
			{
				throw  new WIPRONameFormatException();//lookup the catch block
			}
			else
			{
				this.docname=dname;//docname validation is correct
			}
		}
		catch(WIPRONameFormatException e)
		{
		System.out.println("Name Error:: "+e);//e.toString()	
		}
		
		//checking age
		try
		{
					if(dage>=21 && dage<=50)
					{
						this.age=dage;//age is correct
					}
					else
					{
						throw new WIPROAgeRangeException();//lookup the catch block
					}
		}
		catch(WIPROAgeRangeException e)
		{
				System.out.println("Age Error:: "+e);//toString()
		}
	}
}
public class UserDefinedException {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner s1=new Scanner(System.in);
		System.out.println("Docid:: ");
		int a=s1.nextInt();
		System.out.println("DocName:: ");
		String b=s1.next();
		System.out.println("DocAge:: ");
		int age=s1.nextInt();
		System.out.println("DocSpecialization:: ");
		String s11=s1.next();

		Doctor d1=new Doctor(a,b,s11,age);//calling parameterized constructor
		d1.display();

	}

}
/*
Docid:: 
1001
DocName:: 
Thananya
DocAge:: 
45
DocSpecialization:: 
Heart
Doctor details:: 1001 Thananya 45 Heart
*/
/*
Docid:: 
1001
DocName:: 
Devi@#13423
DocAge:: 
43
DocSpecialization:: 
Heart
Name Error:: Invalid Doctor Name Format!
Doctor details:: 1001 null 43 Heart
*/
/*
Docid:: 
1001
DocName:: 
Thananya
DocAge:: 
7
DocSpecialization:: 
Heart
Age Error:: Age must be between 21 to 50! Kindly reenter the age!
Doctor details:: 1001 Thananya 0 Heart
*/
/*
Docid:: 
11
DocName:: 
Devi@2133
DocAge:: 
8
DocSpecialization:: 
Heart
Name Error:: Invalid Doctor Name Format!
Age Error:: Age must be between 21 to 50! Kindly reenter the age!
Doctor details:: 11 null 0 Heart
*/