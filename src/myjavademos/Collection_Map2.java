package myjavademos;

import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/*
 * LinkedHashMap=>ordered collection
 * TreeMap=>sorted
 *   *  *  * Map interface implemented by another class HashTable!
 * --HashTable(Synchronized METHODS i.e thread safe class)
 * HashTable called as "LEGACY CLASS!"(OLD CLASS).
 * --HashMap(Non synchronized METHODS)
 * 
 * /*
 * Hashtable:::
A Hashtable is an array of a list.
It contains unique elements.
It doesn't allow null key or value.
It is synchronized.
 */
/*
 * The synchronizedMap() method of java.util.Collections class is used to 
 * return a synchronized (thread-safe) map backed by the specified map. 
 */

public class Collection_Map2 {

	public static void main(String[] args) {
		LinkedHashMap<Integer,String> obj=new LinkedHashMap<>();//key,value
		obj.put(3, "Devi");
		obj.put(2, "Abi");
		obj.put(6, "Sam");
		System.out.println("LinkedHashMap(Ordered):: "+obj);
		
		TreeMap<Integer,String> obj1=new TreeMap<>();
		obj1.put(3, "Devi");//Based on keys records are sorted
		obj1.put(2, "Abi");
		obj1.put(6, "Sam");
		System.out.println("TreeMap(Sorted):: "+obj1);


		//similar to HashMap(random order)
		//many synchronized methods!
		Hashtable<Integer,String> obj2=new Hashtable<>();
		obj2.put(3, "Devi");
		obj2.put(2, "Abi");
		obj2.put(6, "Sam");
		System.out.println("HashTable(Unordered):: "+obj2);


	}

}
