package myjavademos;
/* 23.Create a Package called house. Create 2 classes namely Hall and Kitchen.

1.  In the Hall class print the message “This is the first room while entering the house” without using the class name System explicitly in the println statement.
2. In the Kitchen class create an array called appliances and initialize with values and print the same. 
3. After printing copy that array into a different array.
 */
import house.Hall;
import house.Kitchen;

public class Exercise23
{
    public static void main(String[] args)
    {
        Hall hall = new Hall();
        hall.showMessage();

        System.out.println();

        Kitchen kitchen = new Kitchen();
        kitchen.showAppliances();
    }
}
/*
This is the first room while entering the house

Kitchen Appliances:
Fridge
Oven
Mixer
Toaster
Copied Appliances:
Fridge
Oven
Mixer
Toaster
*/