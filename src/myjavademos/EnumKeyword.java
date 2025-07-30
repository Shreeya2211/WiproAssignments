package myjavademos;
/*
 * class Order {
    String status; // could be any string – "done", "pending", "oops", etc.
}
This is not type-safe. Any wrong string is accepted.

enum Status {
    PENDING, PROCESSING, COMPLETED
}

class Order {
    Status status;//Chennai not allowed
}
 */
/*
 * Real-Life Use Cases
Days of week → MONDAY, TUESDAY, ...

Status codes → PENDING, APPROVED, REJECTED

Directions → NORTH, SOUTH, EAST, WEST

Traffic light → RED, YELLOW, GREEN


 */
/*
 * | Reason                     | Benefit                                                                   |
| -------------------------- | ------------------------------------------------------------------------- |
| 📌 **Fixed set of values** | Defines a group of related constants (e.g., `MONDAY`, `TUESDAY`, ...)     |
| 🛑 **Type safety**         | Prevents assigning invalid values (e.g., no `"someday"` typo for a `Day`) |
| 🧼 **Clean and readable**  | More readable than using strings or integers for constants                |
| 📦 **Feature-rich**        | Enums can have methods, constructors, and implement interfaces            |
| ✅ **Switch support**       | Easily usable in `switch` statements for cleaner logic                    |

 */
/*
 * /*
 * Enum::
--user defined data type to store a fixed set of constants
--enum constants can be used in conditional statements(if,switch..)
--more type safe than java constants
--constants defined in enum are public static and final
--cannot create an instance of enum
--***********can be defined within or outside the class.

 */

enum OSTYPES
{
	WINDOWS,UNIX,LINUX,MAC,APPLE_IOS,android;
}
enum Color 
{
    RED,GREEN,BLUE;
	// enum constructor called separately for each constant
    private Color()//ENUM CONSTRUCTOR
    {
        System.out.println("Constructor called for : "+ this.toString());
    }
    public void colorInfo()//ENUM METHOD
    {
        System.out.println("Universal Color");
    }
}
public class EnumKeyword {
	enum Dresssize
	{
		SMALL,MEDIUM,LARGE;
	}
	Dresssize d1;//ENUM REFERENCE VARIABLE
	public EnumKeyword(Dresssize a)//constructor taking enum constant
	{
		this.d1=a;
	}
	public void placeorder()
	{
		switch(d1)//3 constants
		{
		//case "SMALL"://STRING=>invalid
		case SMALL:	
			System.out.println("Dresssize::Small");break;
		case MEDIUM:
			System.out.println("Dresssize::Medium");break;
		case LARGE:
			System.out.println("Dresssize::Large");break;
		}
	}	
	
	public static void main(String[] args) {
		//Dresssize obj=new Dresssize();//invalid
		System.out.println("Enum value:: "+OSTYPES.UNIX);
		System.out.println("Enum value:: "+OSTYPES.android);
		System.out.println("Enum value:: "+Dresssize.MEDIUM);
		
		OSTYPES[] obj=OSTYPES.values();
		for(OSTYPES i:obj)//OSTYPES is a user defined data type
		{
			System.out.println(i);
		}
		Dresssize[] obj1=Dresssize.values();
		for(Dresssize i:obj1)//DressSize is a user defined data type
		{
			System.out.println(i);
		}
		EnumKeyword obj2=new EnumKeyword(Dresssize.LARGE);
		//EnumKeyword obj2=new EnumKeyword(OSTYPES.android);//INVALID
		obj2.placeorder();	
		
		
		Color c1 = Color.RED;
		System.out.println("C1:::: "+c1);
	     c1.colorInfo();//ENUM METHOD


	}

}
/*
Enum value:: UNIX
Enum value:: android
Enum value:: MEDIUM
WINDOWS
UNIX
LINUX
MAC
APPLE_IOS
android
SMALL
MEDIUM
LARGE
Dresssize::Large
Constructor called for : RED
Constructor called for : GREEN
Constructor called for : BLUE
C1:::: RED
Universal Color
*/