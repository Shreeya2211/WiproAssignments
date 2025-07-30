
/* 17.Create a class called Vehicle. Create subclasses like Truck, Bus, Car etc. Add common methods 
in the base class and specific methods in the corresponding class. Create a class called Road 
and create objects for the Truck, Car, Bus etc and display the appropriate message. 

In the Vehicle class constructor initialize few variables like color, no of 
wheels, model etc. Give appropriate values for these variables from the invoking subclass. */
package myjavademos;

// Base Vehicle class
class Vehicle {
    String color;
    int wheels;
    String model;

    Vehicle(String color, int wheels, String model) {
        this.color = color;
        this.wheels = wheels;
        this.model = model;
    }

    void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Color: " + color);
        System.out.println("Number of wheels: " + wheels);
    }
}

// Subclass: Truck
class Truck extends Vehicle {
    int loadCapacity;

    Truck(String color, int wheels, String model, int loadCapacity) {
        super(color, wheels, model);
        this.loadCapacity = loadCapacity;
    }

    void showTruckInfo() {
        System.out.println("\n--- Truck Info ---");
        displayInfo();
        System.out.println("Load Capacity: " + loadCapacity + " tons");
    }
}

// Subclass: Bus
class Bus extends Vehicle {
    int seatingCapacity;

    Bus(String color, int wheels, String model, int seatingCapacity) {
        super(color, wheels, model);
        this.seatingCapacity = seatingCapacity;
    }

    void showBusInfo() {
        System.out.println("\n--- Bus Info ---");
        displayInfo();
        System.out.println("Seating Capacity: " + seatingCapacity + " passengers");
    }
}

// Subclass: Car
class Car extends Vehicle {
    boolean isAutomatic;

    Car(String color, int wheels, String model, boolean isAutomatic) {
        super(color, wheels, model);
        this.isAutomatic = isAutomatic;
    }

    void showCarInfo() {
        System.out.println("\n--- Car Info ---");
        displayInfo();
        System.out.println("Transmission: " + (isAutomatic ? "Automatic" : "Manual"));
    }
}

// Road class that creates and displays all vehicles
class Road {
    void simulateTraffic() {
        Truck truck = new Truck("Red", 6, "Tata Heavy", 20);
        Bus bus = new Bus("Blue", 4, "Ashok Leyland", 45);
        Car car = new Car("White", 4, "Hyundai i20", true);

        truck.showTruckInfo();
        bus.showBusInfo();
        car.showCarInfo();
    }
}


public class Exercise17
{
    public static void main(String[] args)
    {
        Road road = new Road();
        road.simulateTraffic(); 
    }
}
/*
--- Truck Info ---
Model: Tata Heavy
Color: Red
Number of wheels: 6
Load Capacity: 20 tons

--- Bus Info ---
Model: Ashok Leyland
Color: Blue
Number of wheels: 4
Seating Capacity: 45 passengers

--- Car Info ---
Model: Hyundai i20
Color: White
Number of wheels: 4
Transmission: Automatic
*/