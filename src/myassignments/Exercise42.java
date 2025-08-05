/*
 * 42.(Rethrowing Exceptions) Write a program that illustrates rethrowing an exception. 
Define methods someMethod and someMethod2. Method someMethod2 should initially 
throw an exception. Method someMethod should call someMethod2, catch the exception 
and rethrow it. Call someMethod from method main, and catch the rethrown exception. 
Print the stack trace of this exception.
*/
 
package myassignments;

public class Exercise42 {

    // Method that throws the initial exception
    public static void someMethod2() throws Exception {
        throw new Exception("Exception thrown in someMethod2");
    }

    // Method that catches and rethrows the exception
    public static void someMethod() throws Exception {
        try {
            someMethod2();
        } catch (Exception e) {
            System.out.println("Caught exception in someMethod, rethrowing...");
            throw e;  // Rethrow the same exception
        }
    }

    public static void main(String[] args) {
        try {
            someMethod();
        } catch (Exception e) {
            System.out.println("Caught rethrown exception in main:");
            e.printStackTrace(); // Print full stack trace
        }
    }
}
/*
Caught exception in someMethod, rethrowing...
Caught rethrown exception in main:
java.lang.Exception: Exception thrown in someMethod2
	at myassignments.Exercise42.someMethod2(Exercise42.java:15)
	at myassignments.Exercise42.someMethod(Exercise42.java:21)
	at myassignments.Exercise42.main(Exercise42.java:30)
*/