package myjavademos;
/*
 * Lambda expression::
 * --jdk 8
 * --By using lambda, we can directly provide the implementation to the 
 * interface methods
 * syntax:::
 * () -> {  
	//Body of no parameter lambda  
	}  
*/

/*
 *  * --Lambda expression are treated as a function, so the compiler
 * does not create .class file!!!!!!!!!!!!!!!!

 */
/*
 * Lambda expression can be used where a class implements a functional interface to 
 * reduce the complexity of the code.

An inner anonymous class is more powerful as we can use many methods as we want, 
whereas lambda expression can only be used where an interface has only a single 
abstract method.

For Lambda Expression at the time of compilation, no .class file fill be generated.

For the Anonymous Inner class at the time of compilation, a separate .class 
file will be generated.

The Performance of the lambda expression is better as it is pure compile-time 
activity and doesn’t incur extra cost during runtime.

However, the Performance of the anonymous inner class is lower as requires class 
loading at runtime.

If you are coding in Java 8 make sure you use lambda expression instead of anonymous
 class for implementing Comparable, Comparator,  Runnable,  Callable,  
 CommandListener,  ActionListener, and several other interfaces in Java, which got just one single method.
 */
/*
 * | Feature                      | **Anonymous Class**                                           | **Lambda Expression**                                       |
| ---------------------------- | ------------------------------------------------------------- | ----------------------------------------------------------- |
| 📖 **Definition**            | A class without a name defined inline                         | A **shorter syntax** to implement **functional interfaces** |
| 📌 **Introduced In**         | Java 1.1                                                      | Java 8                                                      |
| 🧠 **Purpose**               | To create a one-time-use subclass or interface implementation | To simplify implementation of **functional interfaces**     |
| ✍️ **Syntax**                | Verbose (needs class body, method override, etc.)             | Concise (no need to declare method name, class, etc.)       |
| 🧪 **Used For**              | Interfaces with **multiple methods** or concrete classes      | Only with **functional interfaces** (1 abstract method)     |
| 🧬 **Can have state/fields** | ✅ Yes                                                         | ❌ No (only access effectively final variables)              |
| 🔄 **'this' refers to**      | The anonymous class instance itself                           | The enclosing class                                         |
| 🛠️ **Overhead**             | Creates an inner class (slower, more memory)                  | More efficient, cleaner                                     |

 */
@FunctionalInterface
interface calc
{
	public int add(int a,int b);//abstract method
	//public int add11(int a,int b);//abstract method=>INVALID 
	default int sub(int x,int y)//default method
	{
		return x-y;
	}	
}
//non functional interface
interface calc11
{
	default int sub(int a1,int b1)
	{
		return a1-b1;
	}
}
@FunctionalInterface
interface mypi
{
	double getpi();//public abstract double getpi();
}
@FunctionalInterface
interface Formula {

    double calculate(int a);

    static double sqrt11(int a) {
        return Math.sqrt(a);
    }
}

public class LambdaExpressionDemo {
	//without implements keyword we r directly defining interface methods by using lambda
		//NO @OVERRIDE ANNOTATION

		/*
		 * Java version 8, Lambda expressions 
		 * reduce the code length and code complexity to a greater extent. 
		 */
				/*
				 * Lambda expressions can operate only on 
				 * functional interfaces (i.e. interface with only one abstract method).
		*/

	public static void main(String[] args) {
		calc a1;//VERSION 1
		a1=(a4,b6)->(a4+b6);//no return keyword. it is optional in lambda!
		System.out.println("Add(Lambda syntax):: "+a1.add(12, 12));//calc add method
		
		//datatypes are optional
		calc a2=(a3,a5)->//VERSION 2
		{
			return (a3+a5);
		};
		System.out.println("Add(Lambda syntax):: "+a2.add(1, 12));//calc add method

		calc a3=(int a31,int a5)->//VERSION 3
		{
			return (a31+a5);
		};
		System.out.println("Add(Lambda syntax):: "+a3.add(2, 12));//calc add method
		
		/*
		 NON FUNCTIONAL INTERFACE DOESNT SUPPORT LAMBDA SYNTAX!!!COMPILATION ERROR
		 calc11 j1;
		j1=(g,j)->(g+j);
		System.out.println("Add(Lambda syntax):: "+j1.sub(12, 12));//calc add method
*/

		Formula f1 =(a) -> Formula.sqrt11(a);//static method in lambda expression
        System.out.println(f1.calculate(100));

        mypi k1;
		k1=()->3.14d;
		System.out.println("Area:: "+2*2*k1.getpi());//2*2*3.14

	}

}
/*
Add(Lambda syntax):: 24
Add(Lambda syntax):: 13
Add(Lambda syntax):: 14
10.0
Area:: 12.56
*/