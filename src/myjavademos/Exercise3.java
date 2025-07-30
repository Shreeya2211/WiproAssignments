package myjavademos;

/*3.The total number of students in a class are 90 out of which 45 are boys. If 50% of the total students secured grade 'A' out of which 20 are boys, then write a program to calculate the total number of girls getting grade 'A'.*/

public class Exercise3
{
	public static void main(String[] args)
	{
        int totalStudents = 90;
        int totalGradeA = totalStudents / 2; // 50% of 90
        int boysGradeA = 20;
        int girlsGradeA = totalGradeA - boysGradeA;
        System.out.println("Number of girls with grade A: " + girlsGradeA);

}

}
/*
Number of girls with grade A: 25
*/