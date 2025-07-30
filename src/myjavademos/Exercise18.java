/*
 * 18.Create a package named org.animals. In that create various classes like Lion, Tiger, Deer, Monkey, Elephant and Giraffe. In each class create data members like color, weight,age etc. Create methods like isVegetarian, canClimb, sound etc..
Then Create a package called zoo and create a class called VandalurZoo and create objects for the animals that are existing in zoo and print the characteristic of each animal.*/

package myjavademos;

import zoo.VandalurZoo;

public class Exercise18 {
    public static void main(String[] args) {
        VandalurZoo zoo = new VandalurZoo();
        zoo.displayAnimalDetails();
    }
}
