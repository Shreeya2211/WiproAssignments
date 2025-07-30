package myjunitdemos;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/*
 * In Junit, test suite allows us to aggregate all test cases from multiple classes in one place 
 * and run it together. 
 * To run the suite test, you need to annotate a class using below-mentioned annotations: 
 * @Runwith(Suite.class)
 */
//A test suite is a collection of one or more test cases. 

@RunWith(Suite.class)//Enable the TestSuite
@SuiteClasses
(
		{
			JUNITAssertionsDemo.class,//1 testcase method
			MyCalcTest.class//5 testcase  
		}
)

public class TestSuiteDemo {

}
