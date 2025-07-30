package myjavademos;
/* 14.Create a class called shape with the following methods
1. area
2. perimeter

                    Overload the area and perimeter method to calculate for both square and rectangle.
                    Create a main class and invoke the area method to calculate the area of the square and 
rectangle. Also invoke the perimeter method to calculate the perimeter of the square 
and rectangle.
 */
class Shape
{

    public void area(int side)
    {
        int area = side * side;
        System.out.println("Area of Square: " + area);
    }

    public void area(int length, int breadth)
    {
        int area = length * breadth;
        System.out.println("Area of Rectangle: " + area);
    }

    
    public void perimeter(int side)
    {
        int perimeter = 4 * side;
        System.out.println("Perimeter of Square: " + perimeter);
    }

    public void perimeter(int length, int breadth)
    {
        int perimeter = 2 * (length + breadth);
        System.out.println("Perimeter of Rectangle: " + perimeter);
    }
}

public class Exercise14
{
    public static void main(String[] args)
    {
        Shape shape = new Shape();

        // Square calculations
        int squareSide = 5;
        shape.area(squareSide);
        shape.perimeter(squareSide);

        System.out.println();

        // Rectangle calculations
        int rectLength = 6;
        int rectBreadth = 4;
        shape.area(rectLength, rectBreadth);
        shape.perimeter(rectLength, rectBreadth);
    }
}
