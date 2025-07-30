package myjavademos;

/*2.Now, solve the above question using assignment operators (eg. +=, -=, *=).*/


public class Exercise2
{
	public static void main(String[] args)
	{
        int number = 2345;
        number += 8;
        number /= 3;
        number %= 5;
        number *= 5;
        System.out.println("Final result using assignment operators: " + number);
}
}
/*
Final result: 20
*/