package myjunitdemos;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import junit.framework.TestResult;
import junit.framework.TestSuite;

public class TestingData {

	public static void main(String[] args) {
		Result rs=JUnitCore.runClasses(MyCalcTest.class);//used to run the test method classes at command prompt
		for(Failure fa:rs.getFailures())
		{
			System.out.println("Failures:: "+fa);
			//This will print message only in case of failure
			System.out.println(fa.getMessage());
		}
		if (rs.wasSuccessful()) {
	        System.out.println("All tests finished successfully...");
	    }
		System.out.println("Success?? "+rs.wasSuccessful());
		System.out.println("RunCount?? "+rs.getRunCount());//how  many test cases @Test

		/*
		 * TestSuite can be run in 2 ways:: 1. TestSuite class 2. Annotation based
		 */

		//A test suite is a collection of one or more test cases CLASSES. 
		TestSuite suiteobj=new TestSuite(JUNITAssertionsDemo.class,MyCalcTest.class);//1+5=6
		//2 testing classes(5+1 test case methods)
		TestResult result11 =new TestResult();
		suiteobj.run(result11);//running multiple test cases
		System.out.println("Test Suite---RunCount?? "+result11.runCount());//2 testing classes

	}

}
/*
//2 testing classes(5+1 test case methods)
TestResult result11 =new TestResult();
suiteobj.run(result11);//running multiple test cases
System.out.println("Test Suite---RunCount?? "+result11.runCount());//2 testing classes
*/

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
All tests finished successfully...
Success?? true
RunCount?? 5
Test Suite---RunCount?? 2
*/