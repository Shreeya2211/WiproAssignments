package myjavademos;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

/*
 * PURPOSE OF STREAM API:::

 * | Purpose              | Description                                                                     |
| -------------------- | ------------------------------------------------------------------------------- |
| **Data Processing**  | Perform operations like `filter`, `map`, `sort`, `reduce`, etc. on collections. |
| **Clean Code**       | Replace verbose loops with **concise, readable** code.                          |
| **Functional Style** | Embrace **lambda expressions** and **method references**.                       |
| **Lazy Evaluation**  | Streams process elements **only when needed**.                                  |
| **Parallelism**      | Easily support **parallel operations** with `parallelStream()`.                 |

 */
/*
 * 
 Traditional Loop vs Stream:::

List<String> names = List.of("John", "Jospeh", "Janaki");
for (String name : names) {
    if (name.startsWith("J")) {
        System.out.println(name.toUpperCase());
    }
}
Stream Way::

names.stream()
     .filter(n -> n.startsWith("J"))
     .map(String::toUpperCase)
     .forEach(System.out::println);

📌 Stream is not a data structure – it's a view of data for processing.
 */

/*
Java 8, the Stream API is used to 
process collections of objects. 
--Designed for lambdas
--Do not support indexed access
--Can easily be outputted as arrays or lists
 */
//select max(salary) from renault_emps;
//select count(*) from renault_emps;
/*
 * Stream Operations::::
 * 
Intermediate Stream Operations:::
filter()
map()
flatMap()
distinct()
sorted()
peek()
limit()
skip()

Terminal Stream Operations:::
forEach()
forEachOrdered()
toArray()
reduce()
collect()
min()
max()
count()
anyMatch()
allMatch()
noneMatch()
findFirst()
findAny()

The terminal operations return a result of a certain type and intermediate operations return the stream itself 
so we can chain multiple methods in a row to perform the operation in multiple steps.

Streams are created on a source, e.g. a java.util.Collection like List or Set.
The Map is not supported directly, we can create stream of map keys, values or entries.

Stream operations can either be executed sequentially or parallel. when performed parallelly, 
it is called a parallel stream.
 */

class ItemsData1 {
	int itemid;
	String itemname;
	float rate;
	public ItemsData1(int itemid, String itemname, float rate) {
		super();
		this.itemid = itemid;
		this.itemname = itemname;
		this.rate = rate;
	}
	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return itemid + " " + itemname + " " + rate;
	}

}

public class StreamAPIOperations {

	public static void main(String[] args) {
		List<ItemsData1> itemsobj = new ArrayList<ItemsData1>();
		itemsobj.add(new ItemsData1(11, "Laptop", 95000f));
		itemsobj.add(new ItemsData1(22, "Bluetooth", 8000f));
		itemsobj.add(new ItemsData1(33, "Inverter", 28000f));
		itemsobj.add(new ItemsData1(44, "Harddisk", 8000f));
		itemsobj.add(new ItemsData1(55, "Laptop", 90000f));
		for (ItemsData1 o : itemsobj) {
			System.out.println(o);
		}

		//select distinct itemname from item;
		itemsobj.stream().map(ItemsData1::getItemname)// intermediate
		.distinct()// intermediate--eliminate duplicates
		.forEach(System.out::println);//select distinct(itemname) from items;
		
		
		/*
		 * In Java 8, stream().map() lets you convert an object to something else.
		 * collect() - Returns the result of the intermediate operations performed on
		 * the original stream
		 */
		//select rate from itemsobj where rate > 30000;
		List<Float> itemsobj1 = itemsobj.stream().filter(p -> p.rate > 30000)// filtering data
				.map(p -> p.rate) // fetching price
				.collect(Collectors.toList()); // collecting as list
		System.out.println("> 30000:: " + itemsobj1);


		//select * from itemsobj where rate > 30000;
		itemsobj.stream().filter(p1 -> p1.rate > 30000)
		.forEach(p1 -> System.out.println(" > 30000::: " + p1.itemid + " " + p1.itemname + " " + p1.rate));

		//select count(*) from itemsobj where itemname="Laptop"
		// count number of products based on the filter
		long count = itemsobj.stream().filter(pro -> pro.itemname == "Laptop").count(); // terminal
		System.out.println("How Many Laptop??" + count);

		// count number of products based on the filter
		long count1 = itemsobj.stream().filter(pro -> pro.rate > 20000).count();
		System.out.println(">20000??" + count1 + " " + " items! ");
		
		
		// Map-Unordered collection
		// Converting into a Map
		Map<Integer, String> Map11 = itemsobj.stream().collect(Collectors.toMap(p -> p.itemid, p -> p.itemname)); // key,value
		System.out.println(Map11);


		/*
		 * Stream Collectors::::
		 * 
		 * After performing the intermediate operations on elements in the stream, we
		 * can collect the processed elements again into a Collection using the stream
		 * Collector methods.
		 */
		/*
		 * Collectors.groupingBy() method which takes two arguments. We pass
		 * ItemsData1::getItemname as first argument which groups the input elements
		 * based on itemname and Collectors.counting() as second argument which counts
		 * the number of items in each item
		 */
//select count(*) from itemsobj group by itemname;
		Map<String, Long> noofproducts = itemsobj.stream()
				.collect(Collectors.groupingBy(ItemsData1::getItemname, Collectors.counting()));

		System.out.println("Total No of each products:: " + noofproducts);
		
		double totalPrice3 = itemsobj.stream().collect(Collectors.summingDouble(pr -> pr.rate)); // similar to sum()
		System.out.println("Sum::" + totalPrice3);

		// limit() returns the first n elements in the encounter order.
		List<ItemsData1> newList = itemsobj.stream().limit(3).collect(Collectors.toList());
		System.out.println(newList);
		
		/*
		 * skip method returns a stream consisting of the remaining elements of this stream after 
		 * discarding the first n elements of the stream. 
		 * If this stream contains fewer than n elements then an empty stream will be returned.
		 */
		
		// skip+limit
		List<ItemsData1> newList2 = itemsobj.stream().skip(2).limit(2).collect(Collectors.toList());
		System.out.println(newList2);

		/*
		 * OptionalDouble:: A container object which may or may not contain a double
		 * value. If a value is present, isPresent() will return true and getAsDouble()
		 * will return the value.
		 */

		/* Minimum item rate */
		OptionalDouble minrate = itemsobj.stream().mapToDouble(ItemsData1::getRate).min();// select min(rate) from items
		System.out.println("Minimum Item Rate : " + minrate.getAsDouble());
		
		/* Maximum item rate */
		OptionalDouble maxrate = itemsobj.stream().mapToDouble(ItemsData1::getRate).max();
		System.out.println("Maximum Item Rate : " + maxrate.getAsDouble());

		/* Average item rate */
		OptionalDouble avgrate = itemsobj.stream().mapToDouble(ItemsData1::getRate).average();
		System.out.println("Average Item Rate : " + avgrate.getAsDouble());

		// select * from itemsdata where rate=(select max(rate) from itemsdata);
		Optional<ItemsData1> Maxitem = itemsobj.stream().max(Comparator.comparingDouble(ItemsData1::getRate));
		ItemsData1 i66 = Maxitem.get();
		System.out.println("Max Item:: " + i66.getItemid() + " " + i66.getItemname() + " " + i66.getRate());

		// select * from itemsdata where rate=(select min(rate) from itemsdata);
		Optional<ItemsData1> Minitem = itemsobj.stream().min(Comparator.comparingDouble(ItemsData1::getRate));
		ItemsData1 i666 = Minitem.get();
		System.out.println("Min Item:: " + i666.getItemid() + " " + i666.getItemname() + " " + i666.getRate());


		
	}

}
/*
11 Laptop 95000.0
22 Bluetooth 8000.0
33 Inverter 28000.0
44 Harddisk 8000.0
55 Laptop 90000.0
Laptop
Bluetooth
Inverter
Harddisk
> 30000:: [95000.0, 90000.0]
 > 30000::: 11 Laptop 95000.0
 > 30000::: 55 Laptop 90000.0
How Many Laptop??2
>20000??3  items! 
{33=Inverter, 22=Bluetooth, 55=Laptop, 11=Laptop, 44=Harddisk}
Total No of each products:: {Inverter=1, Harddisk=1, Laptop=2, Bluetooth=1}
Sum::229000.0
[11 Laptop 95000.0, 22 Bluetooth 8000.0, 33 Inverter 28000.0]
[33 Inverter 28000.0, 44 Harddisk 8000.0]
Minimum Item Rate : 8000.0
Maximum Item Rate : 95000.0
Average Item Rate : 45800.0
Max Item:: 11 Laptop 95000.0
Min Item:: 22 Bluetooth 8000.0
*/