package myjavademos;
/*
 * | Aspect         | `Collection`                   | `Map`                                |
| -------------- | ------------------------------ | ------------------------------------ |
| Structure      | Single elements                | Key-value pairs                      |
| Duplicates     | Allowed in `List`              | Keys - No, Values - Yes              |
| Index or Key   | Position-based (`List`)        | Key-based access                     |
| Interface Type | Part of `java.util.Collection` | Separate from `Collection` interface |

 */

import java.util.HashMap;
import java.util.Map;

/*
 * Map Interface::
 * --OBJECT key,OBJECT value pair combination
 * --Map and SortedMap are the two interfaces, and TreeMap, LinkedHashMap, and HashMap are three classes of Map.
 * --supports unique keys
 * --DML operation can be done with the help of KEY!
 * --Implementation classes:
 * HashMap,LinkedHashMap,TreeMap,HashTable
 * 
 * --HashMap(unordered)
 * --LinkedHashMap(ordered)
 * --TreeMap(sorted)
 */
/*
 * HashMap::::
Java HashMap class contains values based on the key.
It contains only unique keys.
It may have one null key and multiple null values.
It is non synchronized.
It maintains no order.
 */
/*
 * In hashing, hash functions are used to link key and value in HashMap.
 * When HashMap????
 *  ---When you can identify your data with some unique key i.e. your data can be processed in key value pair.
	---When no index based operations is required, instead key based operations are preferred.
 */

public class Collection_Map1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Map obj=new Map();//interface cannot be instantiated

		//key=>String,value=>Double
		HashMap<String,Double> obj=new HashMap<String,Double>();
	
		//no add method in Map interface
		obj.put("Devi",43343.434);;//empname(key),salary(value)
		obj.put("Abi",43434.434);
		obj.put("Daya",43436.434);
		obj.put(null,4343.434);//one null key is allowed in MAP 
		//obj.put(545,43434.434);//invalid bcos key must be String
		obj.put("Priya",43443.434);
		obj.put("Priya",88654.787);//keys cannot be duplicated
		obj.put("Priya",83454.787);//keys cannot be duplicated=>CORRECT
		//obj.put("Thananya");//invalid
		
		System.out.println("HashMap(Unordered):: "+obj.toString());//print both key and value!
		System.out.println("HashMap(Size):: "+obj.size());
				
		for(String s:obj.keySet())	//display keys
		{
					System.out.println("Key:: "+s);
		}
		for(Double d1:obj.values())//display values
		{
			System.out.println("Value:: "+d1);
		}
	
		//DML Operation can be done only based on key
				Double b1=obj.get("Devi");//43343.434
				obj.put("Devi", b1+10000);//43343.434+10000, //CURRENT SALARY+INCENTIVE->updating salary
				System.out.println("After Update:: "+obj.get("Devi"));//key
	
				//entryset return key+values
				//Entry is a inner interface(nested interface) of Map interface
				/*
				 * interface Map
				 * {
				 * 	interface Entry
				 *  {
				 *  }
				 * }
				 */
		
				for(Map.Entry<String, Double> s1: obj.entrySet())//display both key and value
				{
					System.out.println("Key&Value:: "+s1.getKey() + " "+s1.getValue());
				}
				obj.remove("Priya");//key+value will be removed
				System.out.println("After Remove:: "+obj.toString());

				
	}

}
/*
HashMap(Unordered):: {null=4343.434, Priya=83454.787, Devi=43343.434, Daya=43436.434, Abi=43434.434}
HashMap(Size):: 5
Key:: null
Key:: Priya
Key:: Devi
Key:: Daya
Key:: Abi
Value:: 4343.434
Value:: 83454.787
Value:: 43343.434
Value:: 43436.434
Value:: 43434.434
After Update:: 53343.434
Key&Value:: null 4343.434
Key&Value:: Priya 83454.787
Key&Value:: Devi 53343.434
Key&Value:: Daya 43436.434
Key&Value:: Abi 43434.434
After Remove:: {null=4343.434, Devi=53343.434, Daya=43436.434, Abi=43434.434}
*/