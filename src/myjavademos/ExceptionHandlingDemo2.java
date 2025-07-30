package myjavademos;
//nested try and multiple catch blocks
//nested try and multiple catch blocks
public class ExceptionHandlingDemo2 {
	public static void main(String[] args) {
		//outer try block
		try
			{
			System.out.println("Outer Try Block::: ");
			System.out.println("Divide:: "+(12/2));
			//System.out.println("Divide:: "+(12/0));//if any error in outer try , it will goto outer catch block!
			//inner try block
			try
			{
				System.out.println("Inner Try Block!!");
				System.out.println("Inner Try Block(Divide):: "+(12/2));
				/*
				 * If inner try block encounters any error, if there is no matching 
				 * inner catch block then
				 * automatically calls outer catch block!
				 */
				int a[]=new int[6];
				a[14]=549;//SIZE OUT OF BOUNDS
			}
			//In Java 7, we can catch multiple exceptions in a single catch block
			//inner catch
			//modern multiple catch block
			
			//catch(Exception | ArrayIndexOutOfBoundsException  | ArithmeticException | NullPointerException e) //invalid
			//catch(ArrayIndexOutOfBoundsException  | ArithmeticException | NullPointerException | Exception e)//invalid
			
			catch(ArrayIndexOutOfBoundsException  | ArithmeticException | NullPointerException  e)//valid
			//catch(ArithmeticException e)
			{
				System.out.println("Inner Catch Block:: "+e);
			}
			catch(Exception e)
			{
				System.out.println("General Exception");					
			}
			finally
			{
				System.out.println("Inner Finally Block!!!!");
			}
		}//OUTER TRY CLOSED
		//outer catch
		catch(Exception e)
		{
			System.out.println("Outer Catch Block::: "+e);
		}
		finally
		{
			System.out.println("Outer Finally Block!!!!");
		}
		System.out.println("Program Continues!!!");
	
	}

}
/*
Outer Try Block::: 
Divide:: 6
Inner Try Block!!
Inner Try Block(Divide):: 6
Inner Catch Block:: java.lang.ArrayIndexOutOfBoundsException: Index 14 out of bounds for length 6
Inner Finally Block!!!!
Outer Finally Block!!!!
Program Continues!!!
*/