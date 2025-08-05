package springex9;

public class Purchase {
    private String purchaseId;
    private String purchaseDate;
    private Product product;

    // Constructor for autowiring
    public Purchase(String purchaseId, String purchaseDate, Product product) {
        this.purchaseId = purchaseId;
        this.purchaseDate = purchaseDate;
        this.product = product;
    }

    public void displayDetails() {
        System.out.println("Purchase ID: " + purchaseId);
        System.out.println("Purchase Date: " + purchaseDate);
        System.out.println("Product Details: " + product);
    }
}
