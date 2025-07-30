package myjavademos;
/*
 * In Java, there are two types of casting:

Widening or implicit Casting (automatically) - converting a smaller type to a larger type size. 
byte -> short -> char -> int -> long -> float -> double.

Narrowing or explicitCasting (manually) - converting a larger type to a smaller size type. 
double -> float -> long -> int -> char -> short -> byte.
 */

public class TypeConversion {
	//class is EMPTY->NO OBJECT
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// implicit type conversion
				int i = 100;
				long a = i;
				float b = a;
				System.out.println(i + " " + a + " " + b);

				int i1 = 34349958;
				byte b1 = (byte) i1; // explicit type casting
				System.out.println(i1 + " " + b1);	// data truncated and lost!!!

				byte b2 = 55;
				float f1 = 4343.43f;
				float f2 = b2 * f1;// expression type promotion!!
				System.out.println(b2 + " " + f1 + " " + f2);

				System.out.println(534535.453453);// by default it is Double
				System.out.println((float) 534535.453453);// convert double to float

				// valid=>convert to UNICODE CHARACTER SET(0-65535)
				// A-Z 65-90, a-z 97-122

				char a3 = 65;
				char b3 = 97;
				System.out.println("Char:: " + a3 + " " + b3);
				
				// Increment and decrement in char data type!
				a3++;
				b3++;
				System.out.println("Char(++):: " + a3 + " " + b3);

				a3--;
				b3--;
				System.out.println("Char(--):: " + a3 + " " + b3);
				 
				int n = 90;
				// char b11=n;//invalid
				char b11 = (char) n;
				System.out.println("Char:: " + b11);
				

				//char hh=43.43f;//invalid
	}

}
