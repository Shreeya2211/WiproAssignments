package myjavademos;

import java.util.ArrayList;

public class Collection_List2 {

	//NO @SuppressWarnings !!!!!!!!!!!!!!!!!!!!
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		//Collection_Set2.java
		Employees4 obj=new Employees4(11,"Diya",40405.43f);
		Employees4 obj1=new Employees4(61,"Abinaya",50405.43f);
		Employees4 obj2=new Employees4(33,"Dada",80405.43f);
		Employees4 obj3=new Employees4(26,"Kumar",20405.43f);
		Employees4 obj4=new Employees4(97,"Rupa",96405.43f);
	
		//Non generic arraylist! heterogenous(any object)!
		
		//ArrayList aobj=new ArrayList();//insertion order is maintained
		//ARRAY LIST INDEX STARTS FROM 0.....
				
		ArrayList<Object> aobj=new ArrayList<Object>();//valid=>compiler happy!
		aobj.add(obj);//0
		aobj.add(obj1);//1
		aobj.add(obj2);//2
		aobj.add(obj3);//3
		aobj.add(obj4);//4
		aobj.add(new ExceptionPropagationDemo1());//no compiler error

		for(Object i : aobj)
		{
			System.out.println(i.toString());
		}
		Object gobj=aobj.get(3);//index position-retrieve
		System.out.println("Get(3):::"+gobj);

		//generic arraylist! homogeneous(only EMPLOYEE4 OBJECT)
		ArrayList<Employees4> aobj1=new ArrayList<Employees4>();//COMPILER HAPPY!!!
		ArrayList<Employees4> aobj3=new ArrayList<>();//valid:: LHS MANDATORY RHS OPTIONAL
		
		
		aobj1.add(obj);//add method only allows Employees4 objects!!!!
		aobj1.add(obj1);
		aobj1.add(obj2);
		aobj1.add(obj3);
		aobj1.add(obj4);
		//aobj1.add(new ExceptionPropagationDemo1());//COMPILE ERROR=>here it is not valid bcos aobj1 is generic(Employees4)!	
		
		System.out.println("Generic ArrayList for loop 1:: ");
		for(Object i : aobj1)
		{
			System.out.println(i.toString());
		}
		System.out.println("Generic ArrayList for loop 2:: ");
		for(Employees4 i : aobj1)
		{
			System.out.println(i.toString());
		}

	}
	}

/*
11 Diya 40405.43
61 Abinaya 50405.43
33 Dada 80405.43
26 Kumar 20405.43
97 Rupa 96405.43
myjavademos.ExceptionPropagationDemo1@28a418fc
Get(3):::26 Kumar 20405.43
Generic ArrayList for loop 1:: 
11 Diya 40405.43
61 Abinaya 50405.43
33 Dada 80405.43
26 Kumar 20405.43
97 Rupa 96405.43
Generic ArrayList for loop 2:: 
11 Diya 40405.43
61 Abinaya 50405.43
33 Dada 80405.43
26 Kumar 20405.43
97 Rupa 96405.43
*/