package myjavademos;

import java.util.LinkedList;

/*
 * LinkedList::
 * --Ordered collection
 * --internally uses DOUBLY LINKED LIST(previous node+data+next node) 
 * to store the elements
 * --DML operations are very fast compared to arraylist
 * --class LinkedList implements List,""Queue(Interface)(Ticket counter)""

 * --Java LinkedList class allows storing duplicate elements.
 * --Insertion and removal of elements in the LinkedList are fast because, 
 * in the linked list, there is no shifting of elements after each adding and removal. 
 * The only reference for next and previous elements changed.
 --LinkedList is the best choice if your frequent operation is insertion or deletion in the middle.

 --Retrieval (getting) of elements is very slow in LinkedList because 
it traverses from the beginning or ending to reach the element.
--We can iterate linked list elements by using ListIterator.
 */
/*
 * What is best Case Scenario to Use LinkedList in Java application?
 * 
 * Java LinkedList is the best choice to use when your frequent operation is adding or removing elements in the 
 * middle of the list because the adding and
 *  removing of elements in the linked list is faster as compared to ArrayList.
 *  
 *  But in the case of linked list, if we remove 50th element from the linked list, no shifting of elements 
 *  will take place after removal. 
 *  Only the reference of the next and previous node will change.
 *  
 *  What is Worst Case Scenario to Use LinkedList?
Java LinkedList is the worst choice to use when your frequent operation is retrieval (getting) of elements 
from the 
linked list because retrieval of elements is very slow in the LinkedList as compared to ArrayList.
 */
/*
 * | Feature                           | `ArrayList`                       | `LinkedList`                                 |
| --------------------------------- | --------------------------------- | -------------------------------------------- |
| 🔗 **Underlying Data Structure**  | Dynamic **array**                 | **Doubly linked list**                       |
| ⚡ **Access Time (get/set)**       | **Fast** (O(1)) – uses index      | **Slow** (O(n)) – traverses from start       |
| ➕ **Insertion/Deletion (middle)** | **Slow** (O(n)) – shifting needed | **Fast** (O(1) if position is known)         |
| 🔚 **Insertion/Deletion (ends)**  | End: Fast; Beginning: Slow (O(n)) | Beginning & End: **Fast** (O(1))             |
| 🧠 **Memory Usage**               | Less memory (just data)           | More memory (stores data + pointers)         |
| 🔁 **Iteration Performance**      | Better for random access          | Better for sequential access (via iterator)  |
| 🚀 **Performance**                | Better for searching              | Better for frequent insert/delete operations |

 */
public class Collection_List3 {

	public static void main(String[] args) {
		//Collection_Set2.java
		Employees4 obj=new Employees4(1,"Devi",40405.43f);
		Employees4 obj1=new Employees4(6,"Abi",50405.43f);
		Employees4 obj2=new Employees4(3,"Daya",80405.43f);
		Employees4 obj3=new Employees4(2,"Kani",20405.43f);
		Employees4 obj4=new Employees4(9,"Raja",96405.43f);
		Employees4 obj5=new Employees4(19,"Thananya",209405.43f);

		//non generic 
		@SuppressWarnings({ "rawtypes", "unused" })
		LinkedList aobj=new LinkedList();

		//generic
		LinkedList<Employees4> aobj1=new LinkedList<>();//valid
		aobj1.add(obj);
		aobj1.add(obj1);
		aobj1.add(obj2);
		aobj1.add(obj3);
		aobj1.add(obj4);
		aobj1.addFirst(obj5);//add in first position
		
		for(Employees4 i : aobj1)
		{
			System.out.println(i.toString());
		}
/*
 * If you frequently access elements by index, consider using an ArrayList instead (which offers O(1) access time).
 * In a LinkedList, get(index) is O(n) time complexity.
 */
		System.out.println("First Employee Object:: "+aobj1.getFirst());
		System.out.println("Last Employee Object:: "+aobj1.getLast());

		
	}

}
/*
19 Thananya 209405.44
1 Devi 40405.43
6 Abi 50405.43
3 Daya 80405.43
2 Kani 20405.43
9 Raja 96405.43
First Employee Object:: 3 Daya 80405.43
Last Employee Object:: 9 Raja 96405.43
*/