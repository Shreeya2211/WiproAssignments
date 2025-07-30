package javademos;

/* 20.Write a Java program to create an abstract class Vehicle with abstract methods startEngine() and stopEngine(). Create subclasses Car and Motorcycle that extend the Vehicle class and implement the respective methods to start and stop the engines for each vehicle type.
 */
abstract class Vehicle
{
 String brand;

 public Vehicle(String brand)
 {
     this.brand = brand;
 }

 public abstract void startEngine();
 public abstract void stopEngine();
}

//Car class
class Car extends Vehicle
{
 public Car(String brand)
 {
     super(brand);
 }

 @Override
 public void startEngine()
 {
     System.out.println(brand + " car engine started with key ignition.");
 }

 @Override
 public void stopEngine()
 {
     System.out.println(brand + " car engine stopped.");
 }
}

//Motorcycle class
class Motorcycle extends Vehicle
{
 public Motorcycle(String brand)
 {
     super(brand);
 }

 @Override
 public void startEngine()
 {
     System.out.println(brand + " motorcycle engine started with kick-start.");
 }

 @Override
 public void stopEngine()
 {
     System.out.println(brand + " motorcycle engine stopped.");
 }
}


public class Exercise20
{
 public static void main(String[] args)
 {
     Vehicle car = new Car("Toyota");
     Vehicle bike = new Motorcycle("Yamaha");

     System.out.println("== Car Actions ==");
     car.startEngine();
     car.stopEngine();

     System.out.println("\n== Motorcycle Actions ==");
     bike.startEngine();
     bike.stopEngine();
 }
}
/*
 == Car Actions ==
Toyota car engine started with key ignition.
Toyota car engine stopped.

== Motorcycle Actions ==
Yamaha motorcycle engine started with kick-start.
Yamaha motorcycle engine stopped.
*/
