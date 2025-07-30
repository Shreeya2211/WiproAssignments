package myjavademos;
/*
 * | Feature                 | `Queue`                                | `Deque` (Double-Ended Queue)                               |
| ----------------------- | -------------------------------------- | ---------------------------------------------------------- |
| 💡 Full Name            | Queue                                  | Double Ended Queue                                         |
| 🔁 Insertion/Removal    | Only at **one end** (FIFO)             | At **both ends** (head and tail)                           |
| 🧭 Direction            | **Single-ended**                       | **Double-ended**                                           |
| 🔢 Example Methods      | `add()`, `remove()`, `peek()`          | `addFirst()`, `addLast()`, `removeFirst()`, `removeLast()` |
| 🧰 Implementations      | `LinkedList`, `PriorityQueue`          | `ArrayDeque`, `LinkedList`                                 |
| ⚙️ Behavior             | Follows **FIFO** (First In, First Out) | Can be **FIFO or LIFO** (Stack behavior)                   |
| ♻️ Null Element Support | `LinkedList` allows `null`             | `ArrayDeque` does **not** allow `null`                     |

 */
/*
 * Deque is an acronym for “double-ended queue”. 
 * Java Deque Interface is a linear collection 
 * that supports 
 * element insertion and removal at both ends. The class which implements this interface is 
 * ArrayDeque. 
 * It extends the Queue interface. Deque is an interface and has two implementations: 
 * LinkedList and ArrayDeque.
 * 
 * Creating a Deque
Syntax : Deque dq = new LinkedList();
               Deque dq = new ArrayDeque();
 */
/*
 * A queue is a simple data structure where the insertion and deletion of elements take place from the one end, 
 * whereas Deque is a hybrid data structure serving the purpose of both the stack and queue and 
 * insertion and deletion of elements can take place from both the ends according to the requirements of the user.
 * 
 * --Insertion and deletion of elements are more efficient as the 
 * resources are completely utilized in the case of the deque.
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeueDemo {

	public static void main(String[] args) {
		   Deque<Integer> numbers = new ArrayDeque<>();
	        // add elements to the Deque
	        // add elements to the Deque
	        numbers.offer(1);
	        numbers.offer(11);
	        numbers.offerLast(2);
	        numbers.offerFirst(3);
	        System.out.println("Deque: " + numbers);

	        
	        // Access elements of the Deque
	        int firstElement = numbers.peekFirst();
	        System.out.println("First Element: " + firstElement);

	        int lastElement = numbers.peekLast();
	        System.out.println("Last Element: " + lastElement);
	        
	        // Remove elements from the Deque
	        int removedNumber1 = numbers.pollFirst();
	        System.out.println("Removed First Element: " + removedNumber1);
	        
	        int removedNumber2 = numbers.pollLast();
	        System.out.println("Removed Last Element: " + removedNumber2);
	        
	        System.out.println("Updated Deque: " + numbers);



	}

}
/*
Deque: [3, 1, 11, 2]
First Element: 3
Last Element: 2
Removed First Element: 3
Removed Last Element: 2
Updated Deque: [1, 11]
*/