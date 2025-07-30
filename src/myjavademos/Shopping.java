package myjavademos;

/*
 *1. An object is a unique entity that has some state, attributes as well as behavior. It is a physical entity.

2.Class is a Blueprint of an object, i.e., It can be thought of as a design by which different objects of similar 
type are created. It is a logical entity. It doesn’t have a physical existence of itself like an object.

3.Interfaces are the Blueprint of a class and can be considered the Big Picture.

4.Interfaces Define the behavior of the class itself whereas a class defines the behavior of an object.

5.Interfaces in Java are a great tool that supports Multiple Inheritance.

6.The interface cannot contain its own body, they only contain declarations of abstract fields and functions 
that are to be overridden in subclasses.

7.The Idea behind Interface is to allow every subclass to use the inherited method in its own desired way i.e., 
Polymorphism.

8.Interfaces are dependent on the classes.

9.Classes are independent of everything.

10.Classes focus on Entity Structure whereas Interfaces emphasize Entity’s behavior.
 */

//Rightclick=>new=>interface->Shopping

/*
 * Interface::
 * --encapsulation and data abstraction is implemented
 * --**************Setting the protocol or contract to a class
 * --contains only method signatures and variables! NO METHOD DEFINITIONS!!
 * --By default::: Methods=>public and abstract, 
 * Variables=>public static and final
 * Interfaces, objects cannot be created(NO IMPLEMENTATION/BUSINESSLOGIC)!
 */

public interface Shopping //byte code=>Shopping.class! 
{

	//interface methods cannot have implementation
		/*public void reviews()
		{
				
		}*/
	/*
	 * In a class, you cannot declare any method but you can define any method!
	 * In a interface, you can declare the methods
	 */
	public void discounts();//method declaration
	void creditpoints();//public abstract void creditpoints();
	public abstract void paymentgateway();//so here public and abstract is optional!
	
}
