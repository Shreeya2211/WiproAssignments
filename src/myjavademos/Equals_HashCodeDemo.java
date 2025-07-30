package myjavademos;

import java.util.HashSet;

/*
* The equals() and hashcode() are the two important methods provided by the Object 
* class for comparing objects. 
* equals():::
--The java equals() is a method of lang.Object class, and it is used to 
compare two objects.
--To compare two objects that whether they are the same, 
it compares the values of both the object's attributes.
--By default, two objects will be the same only if stored in the 
same memory location.

The hashcode() method returns the same hash value when called on two objects, 
which are equal according to the equals() method. 
And if the objects are unequal, it usually returns different hash values.

If two objects are the same as per the equals(Object) method, 
then if we call the hashCode() method on each of the two objects, 
it must provide the same integer result.

As per the Java documentation, both the methods should be overridden 
to get the complete equality mechanism; using equals() alone is not sufficient. 
It means, if we override the equals(), we must override the hashcode() method.
*/
/*
In general, we would want to override either both equals() and hashCode() method or neither.
 Both these methods co-exist and without one other would result in errors specifically when we 
 working with custom objects within large-scale applications. In summary,

--If two objects are equal, they must have the same hash code.
--If two objects have the same hash code, it does not necessarily mean they are equal.
--Overriding the equals() method alone would fail with hashing data structures like Map, Set, etc.
--Overriding the hashCode() method alone would not help in comparing objects.
*/

/*
 * hashCode() is used to narrow down where to look in a hash-based collection (like HashMap, HashSet, Hashtable).

It's possible for two unequal objects to produce the same hash code   this is called a hash collision.

Therefore, after comparing hash codes, Java still calls equals() to confirm equality.


 */
class Student62
{
	int id;
	String name;
	public Student62(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override
	public String toString() 
	{
		return id +  " "+ name;
	}
	//Rightclick->Source->Generate Hashcode and Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student62 other = (Student62) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
public class Equals_HashCodeDemo {
	public static void main(String[] args) {
		Student62 s1=new Student62(1,"devi");
		Student62 s2=new Student62(1,"devi");
		Student62 s3=new Student62(2,"abi");
		Student62 s4=new Student62(3,"rajan");
		Student62 s5=new Student62(31,"rajan");
		Student62 s6=new Student62(31,"rajan");

		HashSet<Student62> obj=new HashSet<>();//unordered collection
		obj.add(s1);//custom object s1 and s2 address are different but values are same!!!
		obj.add(s2);
		obj.add(s3);
		obj.add(s4);
		obj.add(s5);
		obj.add(s6);
		System.out.println("Size:: "+obj.size());
		for(Student62 i:obj)
		{
			System.out.println(i);
		}
		System.out.println("S1 EQUALS S2:: "+s1.equals(s2));
		System.out.println("S1 EQUALS S3:: "+s1.equals(s3));
System.out.println("Hashcode:: "+s1.hashCode() + " "+s2.hashCode() +" " + s3.hashCode());	
if(s1.hashCode()==s2.hashCode())
{
	if(s1.equals(s2))
	{
		System.out.println("Both Objects are equal");
	}
	else
	{
		System.out.println("Both objects are not equal");
	}
}
else
{
	System.out.println("May or may not equal");
}

	}

}
/*
 *  BEFORE OVERRIDING EQUALS AND HASHCODE METHOD::

Size:: 6
1 devi
1 devi
31 rajan
2 abi
31 rajan
3 rajan
S1 EQUALS S2:: false
S1 EQUALS S3:: false
Hashcode:: 925858445 798154996 681842940
May or may not equal
*/

/*
 *  AFTER OVERRIDING EQUALS AND HASHCODE METHOD::

 
Size:: 4
3 rajan
2 abi
1 devi
31 rajan
S1 EQUALS S2:: true
S1 EQUALS S3:: false
Hashcode:: 3080916 3080916 97383
Both Objects are equal
*/