package myjavademos;
/* 22.Create two interfaces namely Drawable and Fillable. Create class called Line, Circle, Square and
implement following methods through interface.

<I>Drawable ------ drawingColor(), thickness ()
<I>Fillable ---------- fillingColor (), size ()
 */


//Drawable interface
interface Drawable {
 void drawingColor();
 void thickness();
}

//Fillable interface
interface Fillable {
 void fillingColor();
 void size();
}

//Line class implements only Drawable
class Line implements Drawable
{
 public void drawingColor() {
     System.out.println("Line drawing color: Black");
 }

 public void thickness()
 {
     System.out.println("Line thickness: 2px");
 }
}

//Circle class implements both Drawable and Fillable
class Circle implements Drawable, Fillable
{
 public void drawingColor()
 {
     System.out.println("Circle drawing color: Blue");
 }

 public void thickness()
 {
     System.out.println("Circle thickness: 3px");
 }

 public void fillingColor()
 {
     System.out.println("Circle filling color: Light Blue");
 }

 public void size()
 {
     System.out.println("Circle size: Radius = 10 units");
 }
}

//Square class implements both Drawable and Fillable
class Square implements Drawable, Fillable
{
 public void drawingColor()
 {
     System.out.println("Square drawing color: Green");
 }

 public void thickness()
 {
     System.out.println("Square thickness: 4px");
 }

 public void fillingColor()
 {
     System.out.println("Square filling color: Yellow");
 }

 public void size()
 {
     System.out.println("Square size: Side = 8 units");
 }
}


public class Exercise22
{
 public static void main(String[] args)
 {
     System.out.println("=== Line ===");
     Line line = new Line();
     line.drawingColor();
     line.thickness();

     System.out.println("\n=== Circle ===");
     Circle circle = new Circle();
     circle.drawingColor();
     circle.thickness();
     circle.fillingColor();
     circle.size();

     System.out.println("\n=== Square ===");
     Square square = new Square();
     square.drawingColor();
     square.thickness();
     square.fillingColor();
     square.size();
 }
}
/*
=== Line ===
Line drawing color: Black
Line thickness: 2px

=== Circle ===
Circle drawing color: Blue
Circle thickness: 3px
Circle filling color: Light Blue
Circle size: Radius = 10 units

=== Square ===
Square drawing color: Green
Square thickness: 4px
Square filling color: Yellow
Square size: Side = 8 units
*/
