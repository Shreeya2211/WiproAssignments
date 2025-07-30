package myjunitdemos;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/*
 * The @Ignore test annotation is used to ignore particular tests or group 
 * of tests in order to skip the build failure.

@Ignore annotation can be used in two scenarios as given below:

    If you want to ignore a test method, use @Ignore along with @Test annotation.
    If you want to ignore all the tests of class, use @Ignore annotation at 
    the class level.

 */

//@Ignore//ignore all test cases!
@SuppressWarnings("unused")
public class MyCalcTest {

	/*
	 * @BeforeClass annotation specifies that method will be invoked only once,
	 * before starting all the tests.
	 */

	int first;
	int second;
	int expectedresult;
	MyCalc obj1;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@RunOnceBeforeClass-Program Started");
	}

	// @AfterClass annotation specifies that method will be invoked only once,
	// after finishing all the tests.

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@RunOnceAfterClass-Program Ended");
	}

	// @Before annotation specifies that method will be invoked before each test
	// case!

	@Before
	public void setUp() throws Exception {
		System.out.println("@Before: start of the test case");
		obj1 = new MyCalc();
		expectedresult = obj1.sum(12, 12);// 24
		System.out.println("@BeforeExpected:: " + expectedresult);
	}
	// @After annotation specifies that method will be invoked after each test.

	@After
	public void tearDown() throws Exception {
		System.out.println("@After: END of the test case");
	}

	//NO PUBLIC STATIC VOID MAIN()
	
	// first test case!!!!!!!!!!!!!!!!!!!!
	@Test
	public void test()  // Testing the MyCalc.java
	{
		System.out.println("My First Test Case!");
		MyCalc obj2 = new MyCalc();
		assertEquals(expectedresult, obj2.sum(12, 12));//24(expected),24(actual)=>success
		//assertEquals(expectedresult,obj2.sum(12,11));//24(expected),23(actual)=>failed
		System.out.println("@Test(Expectedresult):: " + expectedresult);
		
	}
	// second test case
	@Test // Student.java
	public void test1()
	{
		System.out.println("Student Test Case!");
		Student s1 = new Student();
		s1.setSid(1001);
		s1.setSname("Thananya");
		// expectedresult,actualresult
		assertEquals(1001, s1.getSid());
		assertEquals("Thananya", s1.getSname());
	}

	// third test case
		Division obj = new Division(10, 2);
		Division obj4 = new Division(10, 0);
		@Test // Division.java
		public void test4() 
		{
			System.out.println("Division Test Case!");
			assertEquals(5, obj.divide());//5,5
			//assertEquals(5,obj4.divide());
		}
		/*
		 * | 🔍 Aspect            | ✅ **Failure**                                   | ❌ **Error**                                               |
| -------------------- | ----------------------------------------------- | --------------------------------------------------------- |
| **Definition**       | A **test fails** when an **assertion fails**    | A **test errors** when an **unexpected exception** occurs |
| **Cause**            | Expected output ≠ actual output                 | Unhandled exception / bug during test run                 |
| **Who is at fault?** | The **test logic is incorrect**                 | The **code under test is broken**                         |
| **Detected by**      | `assert` methods (like `assertEquals`)          | Exceptions (e.g., `NullPointerException`)                 |
| **Example**          | `assertEquals(5, add(2, 2));` fails (returns 4) | `add(null, 2)` throws `NullPointerException`              |
| **Handled?**         | Yes — it's a controlled test failure            | No — unexpected crash or bug in code                      |
*/
		// fourth test case
		@Test(expected=ArithmeticException.class)
		public void test5()
		{
					System.out.println("Division Another Test Case!");
					assertEquals(5,obj4.divide());//passed=>Expecting ArithmeticException					
		}
		
		//fifth test case
		@Test(expected=Exception.class)
		//@Ignore//this test case alone ignored/skipped
		public void test6()
		{
			throw new NullPointerException();
		}

		
		
		 

}
/*
@RunOnceBeforeClass-Program Started
@Before: start of the test case
@BeforeExpected:: 24
My First Test Case!
@Test(Expectedresult):: 24
@After: END of the test case
@Before: start of the test case
@BeforeExpected:: 24
Student Test Case!
@After: END of the test case
@Before: start of the test case
@BeforeExpected:: 24
Division Test Case!
@After: END of the test case
@Before: start of the test case
@BeforeExpected:: 24
Division Another Test Case!
@After: END of the test case
@Before: start of the test case
@BeforeExpected:: 24
@After: END of the test case
@RunOnceAfterClass-Program Ended
*/