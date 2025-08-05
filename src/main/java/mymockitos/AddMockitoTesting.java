package mymockitos;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)//Integrate MOCKITO AND JUNIT
public class AddMockitoTesting {

	   /*
	     * Sometimes, the test case classes are already been annotated with a @RunWith annotation and Mockito’s 
	     * annotation won’t have any effect. 
	     * In order to correct this, you have to call MockitoAnnotations.initMocks manually like
	     */
	    @Before
	    public void setup_123() 
	    {
	        MockitoAnnotations.initMocks(this);//Integrate MOCKITO AND JUNIT
	    }

		@Mock
	    AddService mathService;//INTERFACE


		   @InjectMocks
		   AddServiceImpl mathServiceImpl = new AddServiceImpl();//IMPLEMENTATION CLASS

		    @Test
		    public void test_doubleLong_Pass() 
		    {
		    	
		    	/*
		    	 * when a Mock is used, the actual method implementation is not called. 
		    	 */
		        long expected = 20;
		        //if..else
		        Mockito.when(mathService.doubleLong(Mockito.anyLong())).thenReturn(expected);//NO BUSINESS logic
		 
		        long actual = mathService.doubleLong(Mockito.anyLong());//20 IS THE RETURN VALUE
		        Assert.assertEquals(expected, actual);

		        long actual1 = mathService.doubleLong(4);//20 IS THE RETURN VALUE
		        Assert.assertEquals(expected, actual1);
		
		        long actual2 = mathService.doubleLong(3334);//20 IS THE RETURN VALUE
		        Assert.assertEquals(expected, actual2);
		
		    }
		    
		    @Test
		    public void test_doubleLong_Inject() 
		    {
		        long expected = 20;
		        //this method is actually called
		        long actual = mathServiceImpl.doubleLong(10);//2*10=20//ORIGINAL BUSINESS LOGIC
		 
		        Assert.assertEquals(expected, actual);//2*10=20//ORIGINAL BUSINESS LOGIC
		   	 
		    }
		    @Test  
		    public void testList_ReturnsSingle_value() 
		    {  
		  
		        List mocklist = Mockito.mock(List.class); //YOU CAN MOCK ANY BUILT IN CLASSES ALSO 
		                           
		        Mockito.when(mocklist.size()).thenReturn(1);  //stubbing
		  
		        Assert.assertEquals(1, mocklist.size());  
		        Assert.assertEquals(1, mocklist.size());  
		          
		        System.out.println( "Mockito List size:: "+mocklist.size());  //1
		        System.out.println("Mockito List Object contains:: "+mocklist);  
		    }  
		    @Test   
		    public void testList_get() 
		    {  
		  
		    	List mocklist = Mockito.mock(List.class);  
		  
		    	Mockito.when(mocklist.get(0)).thenReturn("Thananya");  //stubbing
		 
		    	Assert.assertEquals("Thananya", mocklist.get(0)); //verify/assert 
		    	System.out.println("Mocklist Object:: "+mocklist.get(0));  
		    }

		    @Test  
		    public void testList_Argument_Matchers() {  

		      List<String> mocklist = Mockito.mock(List.class);  

		      Mockito.when(mocklist.get(Mockito.anyInt())).thenReturn("Java");  
		        
		      Assert.assertEquals("Java", mocklist.get(0));  
		      Assert.assertEquals("Java", mocklist.get(16)); 

}
}