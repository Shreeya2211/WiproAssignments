package springmain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemX {
    private int id = 2001;
    private String name = "Pen";
    private double price = 20.50;

    @Autowired
    private CategoryX category;

    public void showItemInfo() {
        System.out.println("[Item] ID: " + id + ", Name: " + name + ", Price: " + price);
        System.out.println(category.getDetails());
    }
}
