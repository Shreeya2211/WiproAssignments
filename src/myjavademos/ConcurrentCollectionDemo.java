package myjavademos;
/*
 * | Collection Type         | Concurrent Variant             | Description                                 |
| ----------------------- | ------------------------------ | ------------------------------------------- |
| **List**                | `CopyOnWriteArrayList`         | Best for frequent reads, rare writes        |
| **Set**                 | `CopyOnWriteArraySet`          | Backed by `CopyOnWriteArrayList`            |
| **Queue** (FIFO)        | `ConcurrentLinkedQueue`        | Non-blocking, thread-safe queue             |
|                         | `LinkedBlockingQueue`          | Blocking queue – good for producer-consumer |
|                         | `PriorityBlockingQueue`        | Ordered, blocking queue                     |
|                         | `ArrayBlockingQueue`           | Fixed-size blocking queue                   |
| **Deque**               | `ConcurrentLinkedDeque`        | Thread-safe double-ended queue              |
|                         | `LinkedBlockingDeque`          | Blocking double-ended queue                 |
| **Map**                 | `ConcurrentHashMap`            | Highly scalable concurrent map              |
| **Skip List Map / Set** | `ConcurrentSkipListMap`, `Set` | Sorted concurrent collections               |

 */

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * 
| Feature                         | `Collections.synchronizedXXX()`              | Concurrent Collections                 |
| ------------------------------- | -------------------------------------------- | -------------------------------------- |
| Thread Safety                   | Yes (via external synchronization)           | Yes (via internal concurrency control) |
| Performance in High Concurrency | Poor                                         | High                                   |
| Iterator Safety                 | Fails with `ConcurrentModificationException` | Weakly consistent, no exception        |
| Blocking Behavior               | No                                           | Yes (for BlockingQueues)               |

 */

/*
 * Real-Time Use Cases
Web server thread pools sharing request data

Order processing systems (queues for jobs)

Inventory systems (concurrent access to product list/map)

Logging frameworks (log message queues)

Chat servers (users/messages queues)


 */
/*
 * Order: Represents a customer order.

OrderProcessor: Consumes orders from a queue.

LinkedBlockingQueue: Thread-safe queue to hold orders.

 */
/*
 * Two threads: one for adding orders (Producer), and another for processing orders (Consumer).

 */
//Order class
class Order {
 private int orderId;
 private String product;

 public Order(int orderId, String product) {
     this.orderId = orderId;
     this.product = product;
 }

 public String toString() {
     return "Order{id=" + orderId + ", product='" + product + "'}";
 }
}

/*
 * 
LinkedBlockingQueue ensures that:

Orders wait in line (FIFO),

Thread-safe access without synchronized,

No ConcurrentModificationException.

 */
public class ConcurrentCollectionDemo {

	public static void main(String[] args) //parent thread
	{
        // Concurrent collection: Blocking queue
        BlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

        // Producer: places orders->Runnable Interface(Functional Interface)->Override run() method
        
        //You give a worker (Thread) a task sheet (Runnable) to execute.
        
        Runnable orderProducer = () -> {
            int orderId = 1;
            String[] products = {"Laptop", "Phone", "Tablet", "Camera"};
            for (String product : products) {
                try {
                    Order order = new Order(orderId++, product);
                    orderQueue.put(order);  // blocks if full
                    System.out.println(Thread.currentThread().getName() + " placed " + order);
                    Thread.sleep(1000); // simulate time between orders in milliseconds i.e 100oms =1 seconds
                } catch (InterruptedException e) //checked exception
                {
                    Thread.currentThread().interrupt();
                }
            }
        };
        
        // Consumer: processes orders
        Runnable orderConsumer = () -> {
            try {
                while (true) {
                    Order order = orderQueue.take();  // blocks if empty
                    System.out.println(Thread.currentThread().getName() + " processing " + order);
                    Thread.sleep(1500); // simulate time to process
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // Start threads
        Thread producerThread = new Thread(orderProducer, "OrderProducer_Wipro");
        Thread consumerThread = new Thread(orderConsumer, "OrderProcessor_Wipro");

        producerThread.start();
        consumerThread.start();

	}

}
/*
OrderProducer_Wipro placed Order{id=1, product='Laptop'}
OrderProcessor_Wipro processing Order{id=1, product='Laptop'}
OrderProducer_Wipro placed Order{id=2, product='Phone'}
OrderProcessor_Wipro processing Order{id=2, product='Phone'}
OrderProducer_Wipro placed Order{id=3, product='Tablet'}
OrderProcessor_Wipro processing Order{id=3, product='Tablet'}
OrderProducer_Wipro placed Order{id=4, product='Camera'}
OrderProcessor_Wipro processing Order{id=4, product='Camera'}
*/