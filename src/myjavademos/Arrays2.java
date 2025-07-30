package myjavademos;

//two dimensional array or multi dimensional array
/*
* 
* (0,0) (0,1) (0,2)
* (1,0) (1,1) (1,2)
* (2,0) (2,1) (2,2)
*/
public class Arrays2 {

	public static void main(String[] args) {
		int[][] k= 
			{
				{1,2,4},
				{56,87,45,576,76767},
				{45,76,5656}				
			};//row 3 column size vary!In array initialization,new keyword is optional

		@SuppressWarnings("unused")
		int[] k2[]= 
			{
				{1,2,4},
				{56,87,45,576,76767},
				{45,76,5656}				
			};	//row 3 column size vary!In array initialization,new keyword is optional

		int[][] k1= new int[][]
				{
			{1,2,4},
			{56,87,45,576,76767},
			{45,76,5656}				
				};//row 3 column size vary!

				//nested for loop
				for(int i=0;i<k.length;i++)//row size==3
				{
					//k[0].length=3
					//k[1].length=5
					//k[2].length=3
					for(int j=0;j<k[i].length;j++)//column size
					{
						System.out.print(k[i][j]+ " ");
						
					}
					System.out.println();//next row							
				}

				//nested for each loop
				System.out.println("2D array:: For each loop:: ");

				for(int i[]:k1)//convert 2d to 1d
				{
					for(int j:i)//convert 1d to printing
					{
						System.out.print(j + " ");
					}
					System.out.println();//next row
					
				}

	}

}
