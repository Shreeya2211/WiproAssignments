package myassignments;


public class Product {
    public Long id;
    public String name;
    public String category;
    public Double price;

    public Product(Long id, String name, String category, Double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String toString() {
        return name + " (" + category + ", " + price + ")";
    }
}
