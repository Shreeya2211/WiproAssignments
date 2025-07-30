package myjavademos;
//No GOTO statement but Label concept available

//Java allows labels with break and continue — which is not the same as goto, 
//but can simulate limited jump behavior in loops.

public class LabelDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1;i<=3;i++)
		{
			for(int j=1;j<=4;j++)
			{
				if (j==3)
				{
					break;//break the current inner for loop
				}
				System.out.println("Value i:: "+i + " "+ "Value j:: "+j);
			}
			System.out.println("Outside Inner For Loop");
		}//outer for loop completion
		System.out.println("Completed!");

		System.out.println();
		
		for(int i=1;i<=3;i++)
		{
			for(int j=1;j<=4;j++)
			{
				if (j==3)
				{
					continue;
				}
				System.out.println("Value i:: "+i + " "+ "Value j:: "+j);
			}
			System.out.println("Outside Inner For Loop");
		}//outer for loop completion
		System.out.println("Completed!");
		
		System.out.println();

		System.out.println("BREAK WITH LABEL:::::::::::");
		//Labeled blocks can only be used with break and continue statements.
		WIPRO://label name of the outer for loop
		for(int i=1;i<=3;i++)
		{
			for(int j=1;j<=4;j++)
			{
				if (j==3)
				{
					break WIPRO;
				}
				System.out.println("Value i:: "+i + " "+ "Value j:: "+j);
			}
			System.out.println("Outside Inner For Loop");
		}//outer for loop completion
		System.out.println("Completed!");
		
		System.out.println();


		System.out.println("CONTINUE WITH LABEL:::::::::::");
		FIS_GLOBAL://label name of the outer for loop
		for(int i=1;i<=3;i++)
		{
			for(int j=1;j<=4;j++)
			{
				if (j==3)
				{
					continue FIS_GLOBAL;
				}
				System.out.println("Value i:: "+i + " "+ "Value j:: "+j);
			}
			System.out.println("Outside Inner For Loop");
		}//outer for loop completion
		System.out.println("Completed!");
	}

}
