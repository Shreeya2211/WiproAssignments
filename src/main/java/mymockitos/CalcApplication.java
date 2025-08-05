package mymockitos;

public class CalcApplication
{
	CalcService cs1;//mocking the inteface
	
	public void setCs1(CalcService cs1) 
	{
		this.cs1 = cs1;
	}
	public int add_1(int input1, int input2)// CalcApplication class method=>//interface method is hidden here!
	{
		 return cs1.add(input1, input2);
	}
	public int subtract_1(int input1, int input2)
	{
		   return cs1.subtract(input1, input2);// CalcApplication class method=>//interface method is hidden here!
	}

	 public int multiply_1(int input1, int input2)
	 {
	    return cs1.multiply(input1, input2);// CalcApplication class method=>//interface method is hidden here!
	 }
	 
	 public int divide_1(int input1, int input2)
	 {
		    return cs1.divide(input1, input2);// CalcApplication class method=>//interface method is hidden here!
	 }
}
