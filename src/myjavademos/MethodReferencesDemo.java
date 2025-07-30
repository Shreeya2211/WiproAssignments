package myjavademos;

import java.util.Arrays;
import java.util.List;

/*
 * Before the release of Java 8, no methods were able to be passed as parameters. 
 * In such cases, if a method has to be passed, an object is required to be passed that contains the method. 
 * But, through the upgrade of the language, the methods are now being able to be passed as parameters. 
 */
/*
 * JDK 8:: Method References::
 * If you already have some other API or class who has similar implementation as 
 * what functional interface needs, 
 * then you can simply pass on method reference of that already implemented method 
 * to functional interface. 
 * With this, 
 * whenever method is called on functional interface object it will delegate it to 
 * that "method reference"".
 * 
 * The method is referred to through the use of “::”.
 */
/*
 * | Feature           | **Lambda Expression**                                    | **Method Reference**                           |
| ----------------- | -------------------------------------------------------- | ---------------------------------------------- |
| **Definition**    | An anonymous function (inline implementation)            | A shorthand syntax to call an existing method  |
| **Syntax**        | `(params) -> method(params)`                             | `objectName::methodName`                        |
| **Code Style**    | More flexible, allows custom logic                       | More concise, only if method already exists    |
| **When to Use**   | When you need to define custom logic inside the function | When an existing method can be reused directly |
| **Readability**   | May become verbose for simple operations                 | Cleaner and more readable for simple calls     |
| **Customization** | ✔️ You can write multiple lines or logic                 | ❌ Only direct method calls (no custom logic)   |

 */
@FunctionalInterface
interface code1
{
	void hexashow();	
	//void show1();//only one abstract method(public and abstract)
}
@FunctionalInterface
interface code3
{
	int hexafindMax(int a, int b);	
}
@FunctionalInterface
interface code4
{
	int hexastringLength();
}
@FunctionalInterface
interface code2
{
	void hexashow1(String a,String v);
}
public class MethodReferencesDemo {
	MethodReferencesDemo(){	}
	MethodReferencesDemo(String a,String b)
	{
		System.out.println("Constructor:: "+a + " "+b);
	}
	 public void myMethod1()
	 {
			System.out.println("Non Static Method");  	 
	 }
	 public static void myMethod()
	 {
			System.out.println("Static Method");  
	 }  

	public static void main(String[] args) {
		MethodReferencesDemo object1=new MethodReferencesDemo();

		//DONT GIVE PARENTHESES FOR METHOD REFERENCES!
		//NO IMPLEMENTS , NO @OVERRIDE
				
		code1 ob11=object1::myMethod1;//only for functional interfaces!
		ob11.hexashow();
		
		//code1 ob111=object1::myMethod;//static not applicable to interface method
		//ob111.hexashow();
	
		// Referring static method using reference  
		code1 ob=MethodReferencesDemo::myMethod;//classname::methodname
		ob.hexashow();

		//we are referring a static method of Math class. 
		code3 ob7=Math::max;//Math is a built in class
		int result=ob7.hexafindMax(34, 324);
		System.out.println("Max:: "+result);

		/*
		 * Here, we are referring length(), an instance method of String class from the stringLength() method 
		 * of JavaInterface. 
		 * The length() method is a built-in method of String that we are referring to here by our own method.
		 */

		code4 ob46="Chennai"::length;
		int result1=ob46.hexastringLength();
		System.out.println("Length:: "+result1);


		/*
		 * You can refer a constructor by using the new keyword. 
		 * Here, we are referring constructor with the help of functional interface.
		 */
		code2 ob5=MethodReferencesDemo::new;//para constructor taking 2 string arguments
		ob5.hexashow1("Java","JSP");//MethodReferencesDemo(String,String)  here!
		//ob5.hexashow1("Java");//MethodReferencesDemo(String) not here!
/*
 * | Syntax                      | Meaning                                | Example               |
| --------------------------- | -------------------------------------- | --------------------- |
| `ClassName::staticMethod`   | Reference to a static method           | `Math::abs`           |
| `object::instanceMethod`    | Reference to an instance method        | `System.out::println` |
| `ClassName::instanceMethod` | Reference to instance method of object | `String::toUpperCase` |
| `ClassName::new`            | Reference to a constructor             | `ArrayList::new`      |

 */
		List<String> names = Arrays.asList("Thananya","Devi","Abi");
		for(String i:names)
		{
			System.out.println(i);
		}
		
		System.out.println("Lambda:: ");
		names.forEach(name111 -> System.out.println(name111));
		
		System.out.println("MethodReferences(Alternative to Lambda):: ");
		names.forEach(System.out::println); 
		
		
	}	

}
/*
Non Static Method
Static Method
Max:: 324
Length:: 7
Constructor:: Java JSP
Thananya
Devi
Abi
Lambda:: 
Thananya
Devi
Abi
MethodReferences(Alternative to Lambda):: 
Thananya
Devi
Abi
*/