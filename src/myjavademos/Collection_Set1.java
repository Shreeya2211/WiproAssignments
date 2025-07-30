package myjavademos;
/*
 * | Feature                   | **Arrays**                               | **Collections** (`ArrayList`, `HashSet`, etc.)         |
| ------------------------- | ---------------------------------------- | ------------------------------------------------------ |
| 📏 **Size**               | Fixed-size (decided at creation)         | Dynamic size (can grow/shrink)                         |
| 📦 **Type of elements**   | Can store both **primitive** and objects | Only stores **objects** (not primitives)               |
| 🧰 **Utility methods**    | No built-in methods (manual code needed) | Rich APIs (add, remove, sort, search, etc.)            |
| ⚙️ **Data structures**    | Simple linear structure                  | Supports List, Set, Map, Queue, Stack, etc.            |
| 🔁 **Iteration support**  | With loops only                          | Can use advanced iterators like `Iterator`, `forEach`  |
| 🔄 **Performance tuning** | Faster access (no overhead)              | Slight overhead due to extra functionality             |
| 📄 **Array type**         | `int[]`, `String[]`, etc.                | `List<Integer>`, `Set<String>`, `Map<String, Integer>` |
| 📚 **Class Hierarchy**    | Part of core language                    | Part of `java.util` package (Collections Framework)    |

 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

//int a[]=new int[4];=>Homogenous
/*
* Collection interface(java.util)::
* 
ex:Emp obj->Integer(eno),String(ename),Float(salary),Date(dob)
* --Heterogenous objects
* --Everything stored as OBJECT rather than VALUE!
* --grow DYNAMICALLY
* --Purely ALGORITHM BASED FRAMEWORK
* --READYMADE ARCHITECTURE API
* --*****easily do the DML(Update,insert,delete,select) Operations
*/
/*
* Difference between Arrays & Collections in Java
The difference between arrays and collections are as follows:

1. Arrays are fixed in size but collections are growable in nature. We can increase or decrease size.

2. Arrays are not recommended to use with respect to memory whereas collections are recommended to use with respect to memory.

3. Arrays are recommended to use with respect to performance but collections are not recommended to use with respect to performance.

4. Arrays can store only homogeneous data elements (similar type of data) but collections can hold both homogeneous and heterogeneous elements.

5. Arrays do not support any method but collections support various kinds of methods.

6. Arrays can have both hold primitives and object types but collections can hold only objects but not primitive.
*/

/*
* Set  Interface::
* --Unordered(Random order)(does not preserve the insertion order)
* --unsorted
* --does not allow DUPLICATE objects
* --It can be iterated by using Iterator but cannot be iterated by using ListIterator.
* --Set is not an indexed-based structure like a list in Java. 
* Therefore, we cannot access elements by their index position.
* --Set Interface Implementation classes::: HashSet(RANDOM),LinkedHashSet(ORDERED),
* TreeSet(SORTED)
*/
/*
 * | Implementation  | Maintains Order?        | Allows Null?            | Sorted?                      |
| --------------- | ----------------------- | ----------------------- | ---------------------------- |
| `HashSet`       | ❌ No                    | ✅ Yes                   | ❌ No                         |
| `LinkedHashSet` | ✅ Yes (insertion order) | ✅ Yes                   | ❌ No                         |
| `TreeSet`       | ✅ Yes (sorted)          | ❌ No (null not allowed) | ✅ Yes (ascending by default) |
*/

 

public class Collection_Set1 {
	//disable/hiding compilation warnings
	@SuppressWarnings({"unchecked","rawtypes", "removal"})//Method level annotation

	public static void main(String[] args) {
		//Set s1=new Set();//interfaces cannot be instantiated
		
		HashSet obj=new HashSet();//random order output
		@SuppressWarnings("unused")
		Set obj1=new HashSet();	//Polymorphic Object

		obj.add("Java");//String=>obj.add(new String("Java"));
		obj.add(new String("ANDROID"));
		obj.add(45454.545f);//Float WRAPPER CLASS=>obj.add(new Float(45454.5454f));
		obj.add(54545.343d);//new Double(436343.56456d);
		obj.add('A');//new Character('A');
		obj.add('A');//NO DUPLICATES
		obj.add(new Integer(4540450));//obj.add(4540450);
		obj.add(34234);
		
		
		System.out.println("HashSet(Unordered::Randomorder):: "+obj);//obj.toString()
		System.out.println("HashSet Size:: "+obj.size());//NUMBER OF OBJECT
		System.out.println("HashSet Empty??:: "+obj.isEmpty());	
		
		System.out.println("HashSet Objects:: ");
		//Iterator is a built in interface. used for displaying heterogenous objects
		//FOR LOOP=>HOMOGENEOUS

		Iterator i1=obj.iterator();	//obj is HashSet (random order )
		while(i1.hasNext())
		{
			System.out.println(i1.next());//PRINT THE CURRENT ELEMENT
		}

		obj.clear();//all the OBJECTS removed
		System.out.println("HashSet Empty??:: "+obj.isEmpty());


		//LinkedHashSet obj21=new LinkedHashSet();//valid
		Set obj2=new LinkedHashSet();
		obj2.add("Java");
		obj2.add(3434.3434);
		obj2.add("JSP");
		obj2.add(453.431f);
		obj2.add(453.431f);//no duplicates

		System.out.println("LinkedHashSet(Ordered COLLECTION):: "+obj2);	

		//Sorted Collection(Homegenous data)
		TreeSet t1=new TreeSet();	
		t1.add("Java");
		t1.add("Ejb");
		t1.add("Mainframe");
		t1.add("ASP.NET");
		t1.add("C++");
		t1.add("33435.545");
		t1.add("3434.334");
		//t1.add(33435.545);//RUNTIME ERROR=>java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Double
				System.out.println("TreeSet(Sorted):: "+t1);
			
				//SortedSet Interface inherits Set interface
				//SortedSet  implements TreeSet class!

				//SUBSET AND TAILSET HEADSET WORKS based on """""TreeSet sorting results"""""""

				SortedSet ts1=t1.subSet("C++", "Mainframe");//between operator in mysql,ORACLE last one(Mainframe) is exclusive
				System.out.println("SubSet:: "+ts1);
		
				SortedSet ts11=t1.tailSet("Ejb");//After Ejb till END
				System.out.println("TailSet:: "+ts11);

				SortedSet ts12=t1.headSet("Java");//Before Java
				System.out.println("HeadSet:: "+ts12);

						
	}

}
/*
HashSet(Unordered::Randomorder):: [Java, A, 4540450, 54545.343, 34234, ANDROID, 45454.547]
HashSet Size:: 7
HashSet Empty??:: false
HashSet Objects:: 
Java
A
4540450
54545.343
34234
ANDROID
45454.547
HashSet Empty??:: true
LinkedHashSet(Ordered COLLECTION):: [Java, 3434.3434, JSP, 453.431]
TreeSet(Sorted):: [33435.545, 3434.334, ASP.NET, C++, Ejb, Java, Mainframe]
SubSet:: [C++, Ejb, Java]
TailSet:: [Ejb, Java, Mainframe]
HeadSet:: [33435.545, 3434.334, ASP.NET, C++, Ejb]
*/