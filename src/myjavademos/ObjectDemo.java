package myjavademos;

/*
 * Object Class::
 *
 **/
/*
 * | Method                              | Purpose                                       |
| ----------------------------------- | --------------------------------------------- |
| `toString()`                        | Returns a string representation of the object |
| `equals(Object obj)`                | Checks if two objects are equal               |
| `hashCode()`                        | Returns a hash code for the object            |
| `getClass()`                        | Returns the class of the object               |
| `clone()`                           | Creates and returns a copy of the object      |
| `finalize()`                        | Called by garbage collector before destroying |
| `wait()`, `notify()`, `notifyAll()` | Thread communication methods                  |

 */

//class User extends Object
class User//sub class
{
	String name;
	String address;
	//Rightclick=>Source=>Generate Constructor using fields=>select all fields->click ok.
	public User(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	//built in method of Object class
		//Overriding toString() from Object Class

		//Source->Generate toString()
	/*
	 * The @Override annotation indicates that the child class method is over-writing 
	 * its base class method. 
	 * 
	 * The @Override annotation can be useful for two reasons. 
	 * It extracts a warning from the compiler if the annotated method doesn't actually 
	 * override anything.
	 *  It can improve the readability of the source code
	 */
	@Override//Annotation starts with @symbol
//	public String toString4545454545() //invalid
	public String toString() 
	{
		//return "User [name=" + name + ", address=" + address + "]";
		return "Happy Learning!";//valid	
	}	

}

public class ObjectDemo {
	public static void main(String[] args) {
		User obj=new User("Thananya","Chennai");
		System.out.println(obj.name + " "+obj.address);	
		//By default Object Class(toString()) will print the heap memory address(hashcode) of a class
				System.out.println("Printing the object:: "+obj);//implicitly calling toString()
				System.out.println("Printing the object:: "+obj.toString());//VALID	
		}

}
