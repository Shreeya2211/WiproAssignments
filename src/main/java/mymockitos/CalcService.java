package mymockitos;
/*
 * 
 */
/*
 * | **Aspect**              | **JUnit**                                                 | **Mockito**                                          |
| ----------------------- | --------------------------------------------------------- | ---------------------------------------------------- |
| **Purpose**             | Framework for writing and running unit tests              | Library for creating mock objects in unit tests      |
| **Type**                | Testing framework                                         | Mocking framework                                    |
| **Primary Use**         | Define test cases, assertions, and test lifecycle methods | Simulate behavior of dependencies or collaborators   |
| **Dependency Handling** | Does **not** handle mocking by itself                     | Specifically designed for mocking classes/interfaces |
| **Assertion Support**   | Provides `assertEquals`, `assertTrue`, etc.               | Relies on JUnit/TestNG for assertions                |
| **Test Execution**      | Executes test methods annotated with `@Test`              | Does not run tests; used **inside** test methods     |
| **Common Annotations**  | `@Test`, `@BeforeEach`, `@AfterEach`, `@BeforeAll`, etc.  | `@Mock`, `@InjectMocks`, `@Spy`, `@Captor`, etc.     |
| **Integration**         | Base framework   integrates with Mockito easily           | Works **with** JUnit (or TestNG) to write test logic |
| **Example**             | `assertEquals(expected, actual)`                          | `when(mock.method()).thenReturn(value)`              |

 */
/*
 * Why Use a Mocking Framework?
Avoid real external dependencies (e.g., DB calls)

Control behavior of dependencies (e.g., force exceptions)

Focus on testing only your class logic

Improve test performance

Easily verify interactions (method calls, arguments)
 */

/*
 * | **Framework** | **Key Features**                                      |
| ------------- | ----------------------------------------------------- |
| **Mockito**   | Most widely used; simple syntax                       |
| **EasyMock**  | Earlier framework, but less popular now               |
| **PowerMock** | Extends Mockito/EasyMock to mock static/final/private |
| **JMock**     | Allows mock-based TDD                                 |

 */
/*
 * | **Concept**           | **Explanation**                             |
| --------------------- | ------------------------------------------- |
| **Mocking**           | Creating fake objects to isolate test logic |
| **Mock Object**       | Simulated object that mimics real behavior  |
| **Mocking Framework** | Tool to easily create and manage mocks      |
| **Mockito**           | Most common Java mocking framework          |
*/
 
/*
 * Mock Creation
Method							Description
mock(Class<T> classToMock)	Creates a mock object.
spy(T object)				Creates a spy (partial mock) of a real object.
 */
/*
Stubbing 	Methods::::

Method											Description

when(mock.method()).thenReturn(value)	Stub a method to return a value.
when(mock.method()).thenThrow(exception)	Stub a method to throw an exception.
doReturn(value).when(mock).method()	Alternate syntax to avoid calling real methods (esp. for spies).
doThrow(exception).when(mock).method()	Stub a void method to throw an exception.
doAnswer(answer).when(mock).method()	Stub with custom behavior.
*/
/*
Verification methods:

Method							Description

verify(mock).method()			Verify that a method was called.
verify(mock, times(n)).method()	Verify the number of invocations.
verify(mock, never()).method()	Verify method was never called.
verify(mock, atLeast(n)).method()	At least n times.
verify(mock, atMost(n)).method()	At most n times.
verifyNoMoreInteractions(mock...)	Ensure no other interactions happened.
verifyZeroInteractions(mock...)		Verify that no interactions occurred.
*/

/*
 *  Argument Matchers::: 

Matcher										Description

any() / any(Class)					Matches any value.
anyInt(), anyString(), anyList()	Type-specific matchers.
eq(value)							Matches exact value.
isA(Class)							Matches argument of given class.
argThat(customMatcher)				Custom argument matcher.
 */
public interface CalcService 
{
	   public int add(int input1, int input2);
	   public int subtract(int input1, int input2);
	   public int multiply(int input1, int input2);
	   public int divide(int input1, int input2);

}
