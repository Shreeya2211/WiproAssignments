/* 32.By using multiple catch blocks, write a class to demonstrate the order of the execution of the 
catch blocks usingNegativeArraySizeException,ArrayIndexOutOfBoundsException, 
StringIndexOutOfBoundsException, IndexOutOfBoundsException, NullPointerException,          
ArithmeticException and print the stack trace for each exception. */
package myassignments;

public class Exercise32
{
    public static void main(String[] args)
    {
        try {
            // Triggering NegativeArraySizeException
            @SuppressWarnings("unused")
			int[] arr = new int[-15];

        } catch (NegativeArraySizeException e)
        {
            System.out.println("Caught NegativeArraySizeException");
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Caught ArrayIndexOutOfBoundsException");
            e.printStackTrace();
        } catch (StringIndexOutOfBoundsException e)
        {
            System.out.println("Caught StringIndexOutOfBoundsException");
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e)
        {
            System.out.println("Caught IndexOutOfBoundsException");
            e.printStackTrace();
        } catch (NullPointerException e)
        {
            System.out.println("Caught NullPointerException");
            e.printStackTrace();
        } catch (ArithmeticException e)
        {
            System.out.println("Caught ArithmeticException");
            e.printStackTrace();
        }

        System.out.println("\nNow triggering another exception...\n");

        try {
            // Triggering ArithmeticException
            @SuppressWarnings("unused")
			int result = 15 / 0;

        } catch (NegativeArraySizeException e)
        {
            System.out.println("Caught NegativeArraySizeException");
            e.printStackTrace();
            
        } catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Caught ArrayIndexOutOfBoundsException");
            e.printStackTrace();
        } catch (StringIndexOutOfBoundsException e)
        {
            System.out.println("Caught StringIndexOutOfBoundsException");
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e)
        {
            System.out.println("Caught IndexOutOfBoundsException");
            e.printStackTrace();
        } catch (NullPointerException e)
        {
            System.out.println("Caught NullPointerException");
            e.printStackTrace();
        } catch (ArithmeticException e)
        {
            System.out.println("Caught ArithmeticException");
            e.printStackTrace();
        }
    }
}
/* 
Caught NegativeArraySizeException
java.lang.NegativeArraySizeException: -15
	at myassignments.Exercise32.main(Exercise32.java:14)

Now triggering another exception...

Caught ArithmeticException
java.lang.ArithmeticException: / by zero
	at myassignments.Exercise32.main(Exercise32.java:47)
*/
