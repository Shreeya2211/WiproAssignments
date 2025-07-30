package myjavademos;

import java.util.ArrayList;
import java.util.List;

/*
 * | Feature           | `<? extends T>`        | `<? super T>`                |
| ----------------- | ---------------------- | ---------------------------- |
| Meaning           | T or any **subclass**  | T or any **superclass**      |
| Direction         | Upper Bound (extends)  | Lower Bound (super)          |
| Used for          | **Reading** (Producer) | **Writing** (Consumer)       |
| Can Add Elements  | ❌ No                   | ✅ Yes (of type T or subtype) |
| Can Read Elements | ✅ As type T            | ✅ Only as `Object`           |

Producer — use extends
Consumer — use super
 */
/*
 * 1.List<?>=>unbounded wild card 
 * 
 * 2.List<? extends Throwable>=>upper bounded wildcard
 * Throwable and the sub classes of Throwable
 * ex:List<? extends Number>
 * Number+all wrapper classes
 * 
 * 3.List<? super Integer>=>Lower bounded wildcard
 * Integer and its super type(like Number,Object)!
 */
abstract class Shopping11 extends Object
{
	abstract void offers();
}
class Myntra11 extends Shopping11
{
	@Override
	void offers() 
	{
		System.out.println("Myntra::: 30%-50% discount");	
	}
}
class ShoppersStop11 extends Shopping11
{
	@Override
	void offers() 
	{
		System.out.println("ShoppersStop::: 30%-50% discount");	
	}
}
public class Generics3 {
	//this method only accept sub classes of Shopping11
	//2 subclasses:Myntra11,ShoppersStop11
	static void display(List<? extends Shopping11> obj1)
	{
		for(Shopping11 i : obj1)
		{
			i.offers();
		}
	}
	public static void main(String[] args) {
		ArrayList<Myntra11> obj=new ArrayList<>();
		obj.add(new Myntra11());//2 objects 
		obj.add(new Myntra11());
		ArrayList<ShoppersStop11> obj1=new ArrayList<>();
		obj1.add(new ShoppersStop11());
		obj1.add(new ShoppersStop11());

		display(obj);//? is replaced by Myntra11 extends Shopping11
		display(obj1);//? is replaced by ShoppersStop11 extends Shopping11
		
		@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
		ArrayList<String> obj2=new ArrayList();
		//display(obj2);//String is not a direct subclass of Shopping11 so invalid!

		@SuppressWarnings({ "unchecked", "rawtypes", "unused" })
		ArrayList<Integer> obj3=new ArrayList();
		//display(obj3);//Integer is not a direct subclass of Shopping11 so invalid!
	}
	}

/*
 * Myntra::: 30%-50% discount
Myntra::: 30%-50% discount
ShoppersStop::: 30%-50% discount
ShoppersStop::: 30%-50% discount

 * */

