package myjavademos;

import java.util.HashSet;
import java.util.LinkedHashSet;

class Employees4
{
	int id;
	String name;
	float salary;
	public Employees4(int id, String name, float salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	@Override
	public String toString() 
	{
		return id +" "  + name + " "  + salary ;
	}

}
public class Collection_Set2 {
	//disable/hiding compilation warnings
	@SuppressWarnings({"unchecked","rawtypes"})//Method level annotation
	public static void main(String[] args) {
		Employees4 obj=new Employees4(1,"Devi",40405.43f);
		Employees4 obj1=new Employees4(6,"Abi",50405.43f);
		Employees4 obj2=new Employees4(3,"Daya",80405.43f);
		Employees4 obj3=new Employees4(2,"Kani",20405.43f);
		Employees4 obj4=new Employees4(9,"Raja",96405.43f);

		HashSet hobj=new HashSet();//no size!
		hobj.add(obj);//heterogenous objects
		hobj.add(obj1);
		hobj.add(obj2);
		hobj.add(obj3);
		hobj.add(obj4);
		System.out.println("HashSet Size:: "+hobj.size());

		System.out.println("HashSet::RANDOM ORDER::");
		for(Object i:hobj)
		{
			System.out.println(i);//i.toString()=>Random order output
		}
		
		LinkedHashSet hobj1=new LinkedHashSet();//ordered
		hobj1.add(obj);
		hobj1.add(obj1);
		hobj1.add(obj2);
		hobj1.add(obj3);
		hobj1.add(obj4);

		System.out.println("LinkedHashSet::ORDERED COLLECTION::");
		for(Object i:hobj1)
		{
			System.out.println(i);
		}

	}

}
/*
HashSet Size:: 5
HashSet::RANDOM ORDER::
1 Devi 40405.43
6 Abi 50405.43
9 Raja 96405.43
3 Daya 80405.43
2 Kani 20405.43
LinkedHashSet::ORDERED COLLECTION::
1 Devi 40405.43
6 Abi 50405.43
3 Daya 80405.43
2 Kani 20405.43
9 Raja 96405.43
*/