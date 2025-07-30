package myjavademos;
/*
 * | Feature               | **Concurrent Collection**                                                                   | **ExecutorService**                                                                |
| --------------------- | ------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- |
| **Purpose**           | Provides thread-safe data structures for sharing data between threads                       | Manages execution of tasks using a thread pool                                     |
| **Package**           | `java.util.concurrent`                                                                      | `java.util.concurrent`                                                             |
| **Examples**          | `ConcurrentHashMap`, `CopyOnWriteArrayList`, `ConcurrentLinkedQueue`, `LinkedBlockingQueue` | `Executors`, `ExecutorService`, `ScheduledExecutorService`                         |
| **Focus**             | Safe concurrent **data access and modification**                                            | Efficient **task execution and thread management**                                 |
| **Threading Control** | Does **not control threads**, just provides data safety                                     | Controls thread **creation, reuse, scheduling, shutdown**                          |
| **Use Case**          | Sharing and modifying collections (maps, queues, sets) in multi-threaded environments       | Executing tasks (e.g., processing orders, handling requests) with reusable threads |
| **Synchronization**   | Internally synchronized or lock-free                                                        | Not a collection; delegates tasks to threads                                       |
| **Common Pattern**    | Used **with** threads to pass data safely                                                   | Manages **execution** of threads that use collections                              |

==============================================================
Think of Concurrent Collections as safe containers shared between workers.

Think of ExecutorService as a smart manager who assigns tasks to workers (threads) and monitors them.

==================================================================

 */
/*
 * If you use raw threads like this:

new Thread(() -> doTask()).start();
You face several issues:

No control over the number of threads.

No thread reuse (a new thread is created every time).

No way to shut down gracefully.

Harder to handle exceptions and monitor status.


 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
✅ Benefits of ExecutorService
Feature	Description
Thread pooling	Reuses threads instead of creating new ones every time. Saves memory and improves performance.
Task scheduling	Can schedule tasks for future execution (ScheduledExecutorService).
Graceful shutdown	Easily shut down all tasks cleanly with .shutdown().
Callable support	Submit tasks that return results using Callable and Future.
Central management	All tasks run via one manager; easier to debug and monitor.
*/

/*
 * When to Use It?
Use ExecutorService when:

You want to handle multiple background tasks efficiently.

You need controlled concurrency (e.g., fixed number of threads).

You want better management of threads (monitoring, shutdown, retries, etc.).


 */

public class ExecutorServiceDemo {

	public static void main(String[] args) {
        // Create a thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName() + " is running task");
        };
        
        //NO thread.start() method
        
        // Submit tasks
        for (int i = 0; i < 5; i++) {
            executor.submit(task);
        }

        // Gracefully shutdown
        executor.shutdown();

	}

}
/*
pool-1-thread-1 is running task
pool-1-thread-2 is running task
pool-1-thread-2 is running task
pool-1-thread-2 is running task
pool-1-thread-3 is running task
*/