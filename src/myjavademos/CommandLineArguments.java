package myjavademos;
/*
 * CommandLineArguments:
 * -Passing some argument or input during the execution(runtime) of the program
 * --Runtime input(Array of Strings)
 * --default delimiter is white space!
 * 
 *ex:ping 192.168.133.232
 *
 *Use Cases of Command-Line Arguments:
1.Passing configuration (e.g. file paths, server port)
2.Automating scripts
3.Quick testing without user prompts
4.Batch processing (like bulk conversions)
*/
/*
Real-Life Analogy:
Program = Taxi Driver

Command-line argument = Destination you tell the driver when you get in

If you just say "drive" with no destination (no arguments), 
they don’t know where to go. But if you say "Take me to the airport", 
now the driver knows exactly what to do — just like your program.
*/
/*
 * | Feature           | **Command-Line Arguments**        | **Scanner**                              |
| ----------------- | --------------------------------- | ---------------------------------------- |
| Input method      | Passed at launch                  | Typed during program execution           |
| Interactive?      | ❌ No                              | ✅ Yes                                    |
| Input flexibility | Limited (fixed at start)          | High (can ask repeatedly)                |
| Common use        | Simple configs, file names, flags | Games, quizzes, forms, user inputs       |
| Data types        | All args are `String[]`           | Can read `int`, `double`, `String`, etc. |

When to Use What?
Use command-line arguments when:

You want to run something once with known input (e.g., filenames, batch jobs).

Use Scanner when:

You want to ask the user questions or gather multiple inputs interactively.
 */

/*
 * Primitive Type	Wrapper classes
 * 
	boolean			Boolean
	char			Character
	byte			Byte
	short			Short
	int				Integer
	long			Long
	float			Float
	double			Double
 */

public class CommandLineArguments {

	public static void main(String[] a)//a is a Object of String class
	{

		//Rightclick->Run as ->Run configurations->Click Arguments tab->In program arguments give value=>click run button!

		//String ->class 
		//int->Primitive data type

		System.out.println("CmdLine Length:: "+a.length);//objectname.datamember
		if(a.length==0)
		{
			System.out.println("No Inputs passed!");
		}
		else
		{
			for(int i=0;i<a.length;i++)
			{
				System.out.println("Argument["+i+"]:"+a[i]);
			}
		}		
		System.out.println("Add:: "+(a[0]+a[1]));//STRING CONCATENATION

		//Integer Wrapper classes:: Convert String Object to Integer Object(finally=>int PRIMITIVE)
		//parseInt is a static method
		//NON STATIC METHOD :: OBJECTNAME.METHODNAME
		//STATIC METHOD :: CLASSNAME.METHODNAME

		System.out.println("Add:: "+(((Integer.parseInt(a[0]))+(Integer.parseInt(a[1])))));//classname.methodname


	}

}
/*
CmdLine Length:: 4
Argument[0]:12
Argument[1]:343
Argument[2]:chennai
Argument[3]:java
Add:: 12343
Add:: 355
*/