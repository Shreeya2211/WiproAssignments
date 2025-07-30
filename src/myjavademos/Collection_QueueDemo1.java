package myjavademos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*
Queue(Interface)=>Ordered Collection::
--Inherits from Collection interface
--Supports FIFO(First in First out)
--Queue interface implemented by LinkedList class!!!!
--A Queue interface is implemented by several classes such as 
LinkedList, AbstractQueue, ArrayBlockingQueue, ArrayDeque, and PriorityQueue.
--Elements can be accessed and removed only from the front (head) of the queue.
--Elements can be added only from the back (tail) of the queue.
*/

public class Collection_QueueDemo1 {

	public static void main(String[] args) {
		//Queue a1=new Queue();//invallid
		Queue<Object> q1=new LinkedList<Object>();//Polymorphic Object
		q1.add("30");
		q1.add("Java");
		q1.add("20");
		q1.add(43.43f);
		q1.add(20);
		q1.add(20);//duplicates are allowed bcos Queue implements List interface!
		System.out.println("Queue(ordered collection)::"+q1);	
		
		//peek->Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
		System.out.println("Peek(First):: "+q1.peek());//display first element
		System.out.println("Poll(Remove):: "+q1.poll());//first element removed automatically
		System.out.println("Queue::"+q1);
		q1.add("PHP");//added at the end of the queue
		System.out.println("Queue::"+q1);

		Iterator<Object> ty1=q1.iterator();
		while(ty1.hasNext())
		{
			q1.poll();
		}
		System.out.println("Empty? "+q1.isEmpty());
		System.out.println("Size? "+q1.size());

		
		
		

		
	}

}
/*
Queue(ordered collection)::[30, Java, 20, 43.43, 20, 20]
Peek(First):: 30
Poll(Remove):: 30
Queue::[Java, 20, 43.43, 20, 20]
Queue::[Java, 20, 43.43, 20, 20, PHP]
Empty? true
Size? 0
*/