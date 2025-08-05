package springex8;

public class ShoppingService {

    public void addToCart(String item)
    {
        System.out.println("Adding item to cart: " + item);
    }

    public void makePayment(double amount) 
    {
        System.out.println("Processing payment of amount: " + amount);
    }

    public void placeOrder()
    {
        System.out.println("Placing the order...");
    }
}
