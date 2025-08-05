package springmain;

import org.springframework.stereotype.Component;

@Component
public class CategoryX {
    private int categoryId = 101;
    private String categoryName = "Stationery";

    public String getDetails() {
        return "[Category] ID: " + categoryId + ", Name: " + categoryName;
    }
}
