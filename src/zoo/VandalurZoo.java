package zoo;

import org.animals.*;

public class VandalurZoo
{
    public void displayAnimalDetails()
{
        Lion lion = new Lion();
        System.out.println("Lion - Color: " + lion.color + ", Weight: " + lion.weight + ", Age: " + lion.age + 
            ", Veg: " + lion.isVegetarian() + ", Climb: " + lion.canClimb() + ", Sound: " + lion.sound());

        Tiger tiger = new Tiger();
        System.out.println("Tiger - Color: " + tiger.color + ", Weight: " + tiger.weight + ", Age: " + tiger.age + 
            ", Veg: " + tiger.isVegetarian() + ", Climb: " + tiger.canClimb() + ", Sound: " + tiger.sound());

        Deer deer = new Deer();
        System.out.println("Deer - Color: " + deer.color + ", Weight: " + deer.weight + ", Age: " + deer.age + 
            ", Veg: " + deer.isVegetarian() + ", Climb: " + deer.canClimb() + ", Sound: " + deer.sound());

        Monkey monkey = new Monkey();
        System.out.println("Monkey - Color: " + monkey.color + ", Weight: " + monkey.weight + ", Age: " + monkey.age + 
            ", Veg: " + monkey.isVegetarian() + ", Climb: " + monkey.canClimb() + ", Sound: " + monkey.sound());

        Elephant elephant = new Elephant();
        System.out.println("Elephant - Color: " + elephant.color + ", Weight: " + elephant.weight + ", Age: " + elephant.age + 
            ", Veg: " + elephant.isVegetarian() + ", Climb: " + elephant.canClimb() + ", Sound: " + elephant.sound());

        Giraffe giraffe = new Giraffe();
        System.out.println("Giraffe - Color: " + giraffe.color + ", Weight: " + giraffe.weight + ", Age: " + giraffe.age + 
            ", Veg: " + giraffe.isVegetarian() + ", Climb: " + giraffe.canClimb() + ", Sound: " + giraffe.sound());
    }
}
