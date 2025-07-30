package myjavademos;

import java.util.Stack;

/*
 * /*
 * --Stack class inherits Vector class and also implements List interface!
 * --LIFO(Last In First Out) principle=>BACKSPACE BUTTON & CTRL+Z(UNDO)
 
 */
/*
 * Application of Stack in Real Life
Stack is used very often in real life, even normal people use the application of 
Stack in their daily life routines. Here is some example of the stack in real-life. 
Below are the 10 Applications of Stack in Real Life.

Women’s Bangles: Women wear a bangle one by one and to pull the first one they have to first pull out the last one.
Books and Clothes: Piled on top of each other is a great example of the stack.
Floors in a Building: If a person is living on the top floor and wants to go outside, he/she first needs to 
land on the ground floor.
Browsers: Web browsers use the stack to keep track of the history of websites if you click back then the previous 
site opens immediately.
Mobile Phone Call Logs: Call logs in mobiles to use the stack, to get a first-person call log you have to scroll.
Companies: When a company want to reduce its workforce. Typically they follow “last hired, first fired”
Garage: If a garage is not wide enough. To remove the first car we have to take out all the other cars after it.
Tubewell Boring Machine: Tubewell boring machines use a stack to pull or push same as a stack
Text Editors: Undo or Redo mechanism in the Text Editors(Excel, Notepad or WordPad etc.)
The CD/DVD stand
 */

public class Collection_StackDemo1 {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		Stack obj=new Stack();
		obj.push("Java");
		obj.push("JSP");
		obj.push(454);
		obj.push(454);
		obj.push(434.45f);//top of the stack
		System.out.println("Stack Object:: "+obj);
		System.out.println("Stack Size:: "+obj.size());
		
		//peek=>returns the top element of the stack
		System.out.println("Stack Top element:: "+obj.peek());
		System.out.println("Stack POP element:: "+obj.pop());//remove the top element
		System.out.println("After Stack pop:: "+obj);
		
		obj.pop();
		obj.pop();
		obj.pop();
		obj.pop();//after this stack is empty!
		//obj.pop();//throws  java.util.EmptyStackException
		System.out.println("After Stack pop:: "+obj);
		System.out.println("After All pop:: "+obj.isEmpty());

		
				
		
	}

}
/*
Stack Object:: [Java, JSP, 454, 454, 434.45]
Stack Size:: 5
Stack Top element:: 434.45
Stack POP element:: 434.45
After Stack pop:: [Java, JSP, 454, 454]
After Stack pop:: []
After All pop:: true
*/