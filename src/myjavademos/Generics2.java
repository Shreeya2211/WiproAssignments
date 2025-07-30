package myjavademos;

import java.util.ArrayList;
import java.util.List;

/*
 * | Wildcard        | Meaning                                                       |
| --------------- | ------------------------------------------------------------- |
| `<?>`           | **Unbounded wildcard**: Any type                              |
| `<? extends T>` | **Upper bound**: Any class that is **T or a subclass** of T   |
| `<? super T>`   | **Lower bound**: Any class that is **T or a superclass** of T |

 */
/*
 * <?>      		// Unbounded wildcard(accept any type as a parameter)
<? extends Type>  // Upper bounded wildcard
<? super Type>    // Lower bounded wildcard

 */
public class Generics2 {

	static void disp1(List<Object> a)
	{
		for(Object i:a)
		{
			System.out.println("<Object>:: "+i);
		}
	}
	
	//runtime polymorphism
		//? is replaced by Object,Integer,String,Float......
		//1 method but works for different object types!
		//SHORTEN THE CODE!!!
		
	static void disp2(List<?> t)
	{
		for(Object i:t)
		{
			System.out.println("<?>:: "+i);
		}	}
	
	public static void main(String[] args) {
		List<Object> obj=new ArrayList<>();//Any object type
		obj.add(3434);
		obj.add("Devi");
		obj.add(434.43f);
		disp1(obj);//<Object>
		disp2(obj);//? is replaced by Object
		
	
		List<String> obj1=new ArrayList<>();
		obj1.add("Devi");
		obj1.add("JSP");
		//disp1(obj1);//invalid
		disp2(obj1);//?is replaced by String

		List<Integer> obj2=new ArrayList<>();
		obj2.add(434);
		obj2.add(3534);
		obj2.add(3234);
		//disp1(obj2);//invalid
				disp2(obj2);//? is replaced by Integer
}

}
/*
<Object>:: 3434
<Object>:: Devi
<Object>:: 434.43
<?>:: 3434
<?>:: Devi
<?>:: 434.43
<?>:: Devi
<?>:: JSP
<?>:: 434
<?>:: 3534
<?>:: 3234
*/