
/* 21.Write a Java program to create an abstract class Person with abstract methods eat() and exercise(). Create subclasses Athlete and LazyPerson that extend the Person class and implement the respective methods to describe how each person eats and exercises.

 */
package myjavademos;

//Abstract class Person
abstract class Person {
 abstract void eat();
 abstract void exercise();
}

//Athlete class
class Athlete extends Person {
 @Override
 void eat() {
     System.out.println("Athlete eats a balanced diet with proteins and veggies.");
 }

 @Override
 void exercise() {
     System.out.println("Athlete exercises daily with intense training.");
 }
}

//LazyPerson class
class LazyPerson extends Person {
 @Override
 void eat() {
     System.out.println("Lazy person eats fast food and snacks frequently.");
 }

 @Override
 void exercise() {
     System.out.println("Lazy person avoids exercise and prefers lying down.");
 }
}


public class Exercise21 {
 public static void main(String[] args) {
     Person athlete = new Athlete();
     Person lazy = new LazyPerson();

     System.out.println("== Athlete ==");
     athlete.eat();
     athlete.exercise();

     System.out.println("\n== Lazy Person ==");
     lazy.eat();
     lazy.exercise();
 }
}
/*
== Athlete ==
Athlete eats a balanced diet with proteins and veggies.
Athlete exercises daily with intense training.

== Lazy Person ==
Lazy person eats fast food and snacks frequently.
Lazy person avoids exercise and prefers lying down.
 */
