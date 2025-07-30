package myjunitdemos;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArraylistTestingDemo {
	ArrayListDemo obj=new ArrayListDemo();
	@Test  
    public void testAdd()
	{  
        obj.add_1("Devi");  
        obj.add_1("Abi");  
        obj.add_1("Thananya");  
        obj.add_1("Raja");  
        assertEquals("Adding 4 employee to list", 4, obj.sizeOfEmployee_1()); //4,4
	}
	 @Test  
	    public void testSize() 
	 {  
	       obj.add_1("Devi");  
	        obj.add_1("Abi");  
	        obj.add_1("Thananya");  
	        assertEquals("Checking size of List", 3, obj.sizeOfEmployee_1());
	}


@Test  
   public void testRemove() {  
       obj.add_1("Devi");  
       obj.add_1("Abi");  
       obj.remove_1("Devi");  
       assertEquals("Removing 1 student from list", 1, obj.sizeOfEmployee_1());  
   }

@Test  
public void removeAll() {  
    obj.removeAll_1();  //clear all values!
    assertEquals( 0, obj.sizeOfEmployee_1());  
}     

}