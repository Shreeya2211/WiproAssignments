package springex9;

public class Product {
    private String productId;
    private String productName;
    private double price;

    // Constructor
    public Product(String productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public String getProductId() { return productId; }
    public String getProductName() { return productName; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Product [productId=" + productId + ", productName=" + productName + ", price=" + price + "]";
    }
}
