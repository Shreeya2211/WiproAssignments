package mymockito;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
/*
 * many frameworks available in Java for mocking, but Mockito is the most popular framework among them.

Need for mocking::::::::::::::::::::::::::
1.If we want to test a component that depends on the other component, but it is under development.
 It generally uses when working in a team and parts are divided between several team-mates. 
 In this case, mocking plays an essential role in the testing of that component. 
 Without mocking, we need to wait for the completion of the required elements for testing.
2.If the real components perform slow operations while dealing with database connections or 
another complex read/ write operation. Sometimes the database queries can take 10, 20, or more 
seconds to execute. In such cases, we require mock objects to perform testing, and it can be 
done via mocking.
3.If there is an infrastructure concern that makes the testing impossible. It is very similar 
to the first case. For example, when we create a connection to the database, some issues related 
to configurations occur. It requires mocking for creating mock components to provide unit testing.


 */
//@RunWith attaches a runner with the test class to initialize the test data
/*
 * | Feature              | `@Mock`                    | `@InjectMocks`                                 |
| -------------------- | -------------------------- | ---------------------------------------------- |
| Creates Mock?        | ✅ Yes                      | ❌ No (creates real object with mocks injected) |
| Used For             | Mocking dependencies       | Class under test                               |
| Dependency Injection | ❌ Not applicable           | ✅ Automatically injects mocks                  |
| Typical Usage        | Interfaces, services, DAOs | Service or controller classes                  |

 */
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)//enable mockito
public class CalcApplicationMockitoTester 
{
	//@InjectMocks annotation is used to create and inject the mock object
	@InjectMocks //this class refers or holds your interface
	CalcApplication mathApplication = new CalcApplication();//

	//@Mock annotation is used to create the mock object to be injected
	@Mock//interface name
	CalcService calcService;

	@Test
	public void testAdd()
	{
		/*
		 * The when(...).thenReturn(...) method chain is be used to specify a
		 *  condition and a return value for this condition.
		 */
		   //add the behavior of calc service to add two numbers
	
		//STUBBING BEHAVIOUR
		   Mockito.when(calcService.add(10,20)).thenReturn(30);//interface method
		   Mockito.when(calcService.add(10,10)).thenReturn(20);//interface method
	
		   //test the add functionality
		   assertEquals(mathApplication.add_1(10, 20),30);//internally calling interface method
		   assertEquals(mathApplication.add_1(10, 10),20);

		   //assertEquals(mathApplication.add_1(10, 21),31);//NO STUBBING

	}
}
