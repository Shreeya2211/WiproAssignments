package house;

import java.util.Arrays;

public class Kitchen
{
    public void showAppliances()
    {
        String[] appliances = {"Fridge", "Oven", "Mixer", "Toaster"};

        System.out.println("Kitchen Appliances:");
        for (String appliance : appliances)
        {
            System.out.println(appliance);
        }

        // Copying to another array
        String[] copiedAppliances = Arrays.copyOf(appliances, appliances.length);

        System.out.println("Copied Appliances:");
        for (String appliance : copiedAppliances)
        {
            System.out.println(appliance);
        }
    }
}
