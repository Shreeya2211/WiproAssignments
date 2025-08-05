package myassignments;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

public class StreamActivity
{
    
    static class Product
    {
        Long id;
        String name;
        String category;
        Double price;

        Product(Long id, String name, String category, Double price)
        {
            this.id = id;
            this.name = name;
            this.category = category;
            this.price = price;
        }

        public String toString()
        {
            return name + " (" + category + ", ₹" + price + ")";
        }
    }

    static class Customer
    {
        Long id;
        String name;
        Integer tier;

        Customer(Long id, String name, Integer tier)
        {
            this.id = id;
            this.name = name;
            this.tier = tier;
        }

        public String toString()
        {
            return name + " (Tier " + tier + ")";
        }
    }

    static class Order
    {
        Long id;
        String status;
        LocalDate orderDate;
        LocalDate deliveryDate;
        List<Product> products;
        Customer customer;

        Order(Long id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products, Customer customer) {
            this.id = id;
            this.status = status;
            this.orderDate = orderDate;
            this.deliveryDate = deliveryDate;
            this.products = products;
            this.customer = customer;
        }

        public String toString()
        {
            return "Order#" + id + " [" + customer + "] " + products;
        }
    }

    public static void main(String[] args)
    {
  
        List<Product> products = Arrays.asList(
            new Product(1L, "Java Book", "Books", 150.0),
            new Product(2L, "Python Book", "Books", 90.0),
            new Product(3L, "Baby Shampoo", "Baby", 60.0),
            new Product(4L, "Toy Car", "Toys", 300.0),
            new Product(5L, "Building Blocks", "Toys", 500.0)
        );

        Customer cust1 = new Customer(1L, "Ravi", 2);
        Customer cust2 = new Customer(2L, "Anu", 1);

        List<Order> orders = Arrays.asList(
            new Order(1L, "Shipped", LocalDate.of(2021, 2, 5), LocalDate.of(2021, 2, 10), Arrays.asList(products.get(0), products.get(3)), cust1),
            new Order(2L, "Delivered", LocalDate.of(2021, 3, 15), LocalDate.of(2021, 3, 20), Arrays.asList(products.get(2)), cust2),
            new Order(3L, "Processing", LocalDate.of(2021, 4, 10), LocalDate.of(2021, 4, 18), Arrays.asList(products.get(4)), cust1)
        );

        //1. Books > 100
        System.out.println("\n1. Books > 100:");
        products.stream()
            .filter(p -> p.category.equals("Books") && p.price > 100)
            .forEach(System.out::println);

        // 2. Orders with products in Baby
        System.out.println("\n2. Orders with Baby products:");
        orders.stream()
            .filter(o -> o.products.stream().anyMatch(p -> p.category.equals("Baby")))
            .forEach(System.out::println);

        // 3. Toys with 10% discount
        System.out.println("\n3. Toys with 10% discount:");
        products.stream()
            .filter(p -> p.category.equals("Toys"))
            .map(p -> new Product(p.id, p.name, p.category, p.price * 0.9))
            .forEach(System.out::println);

        // 4. Products ordered by tier 2 between Feb–Apr 2021
        System.out.println("\n4. Tier 2 customers Feb–Apr 2021:");
        orders.stream()
            .filter(o -> o.customer.tier == 2 &&
                         o.orderDate.isAfter(LocalDate.of(2021, 1, 31)) &&
                         o.orderDate.isBefore(LocalDate.of(2021, 4, 2)))
            .flatMap(o -> o.products.stream())
            .forEach(System.out::println);

        // 5. Cheapest Book
        System.out.println("\n5. Cheapest Book:");
        products.stream()
            .filter(p -> p.category.equals("Books"))
            .min(Comparator.comparingDouble(p -> p.price))
            .ifPresent(System.out::println);

        // 6. 3 most recent orders
        System.out.println("\n6. 3 Most recent orders:");
        orders.stream()
            .sorted((o1, o2) -> o2.orderDate.compareTo(o1.orderDate))
            .limit(3)
            .forEach(System.out::println);

        // 7. Total value of Feb 2021 orders
        System.out.println("\n7. Total value of Feb 2021 orders:");
        double febTotal = orders.stream()
            .filter(o -> o.orderDate.getMonthValue() == 2 && o.orderDate.getYear() == 2021)
            .flatMap(o -> o.products.stream())
            .mapToDouble(p -> p.price)
            .sum();
        System.out.println("₹" + febTotal);

        // 8. Summary stats for Books
        System.out.println("\n8. Book stats:");
        DoubleSummaryStatistics stats = products.stream()
            .filter(p -> p.category.equals("Books"))
            .mapToDouble(p -> p.price)
            .summaryStatistics();
        System.out.println(stats);

        //  9. Most expensive product by category
        System.out.println("\n9. Most expensive product by category:");
        Map<String, Optional<Product>> expensiveByCategory = products.stream()
            .collect(Collectors.groupingBy(
                p -> p.category,
                Collectors.maxBy(Comparator.comparingDouble(p -> p.price))
            ));
        expensiveByCategory.forEach((category, product) -> System.out.println(category + ": " + product.get()));
    }
}
/*

1. Books > 100:
Java Book (Books, ₹150.0)

2. Orders with Baby products:
Order#2 [Anu (Tier 1)] [Baby Shampoo (Baby, ₹60.0)]

3. Toys with 10% discount:
Toy Car (Toys, ₹270.0)
Building Blocks (Toys, ₹450.0)

4. Tier 2 customers Feb–Apr 2021:
Java Book (Books, ₹150.0)
Toy Car (Toys, ₹300.0)

5. Cheapest Book:
Python Book (Books, ₹90.0)

6. 3 Most recent orders:
Order#3 [Ravi (Tier 2)] [Building Blocks (Toys, ₹500.0)]
Order#2 [Anu (Tier 1)] [Baby Shampoo (Baby, ₹60.0)]
Order#1 [Ravi (Tier 2)] [Java Book (Books, ₹150.0), Toy Car (Toys, ₹300.0)]

7. Total value of Feb 2021 orders:
₹450.0

8. Book stats:
DoubleSummaryStatistics{count=2, sum=240.000000, min=90.000000, average=120.000000, max=150.000000}

9. Most expensive product by category:
Toys: Building Blocks (Toys, ₹500.0)
Baby: Baby Shampoo (Baby, ₹60.0)
Books: Java Book (Books, ₹150.0)
*/