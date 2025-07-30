package myjavademos;
/*
 * | Feature                 | `Thread`                | `ThreadLocal`                          |
| ----------------------- | ----------------------- | -------------------------------------- |
| Purpose                 | Run a task concurrently | Store data private to a thread         |
| Controls Execution?     | Yes                     | No (it just stores data)               |
| Scope                   | Entire thread/task      | Data inside the thread                 |
| Synchronization needed? | Often yes               | No (each thread has its own value)     |
| Example use case        | Parallel processing     | Per-thread user session, DB connection |

 */
/*
 * Simple Analogy:
Thread is like a worker doing a job.

ThreadLocal is like a private notebook that each worker carries — only they can see and write in it.


 */
/*
 * Why use ThreadLocal?
To avoid sharing mutable data between threads.

To maintain thread safety without synchronization.

To store per-thread data like user sessions, DB connections, etc.
 
 The ThreadLocal class in Java provides thread-local variables — meaning each thread has its own isolated copy of a variable. 
 This is useful when you want to share a value within a single thread but not across threads.


 */

/*
 * | Method       | Description                        |
| ------------ | ---------------------------------- |
| `set(value)` | Sets the current thread's copy     |
| `get()`      | Gets the current thread's value    |
| `remove()`   | Removes the current thread's value |

 */
class Student89 {
    private String name;
    private int marks;

    public Student89(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    public void display() {
        System.out.println(Thread.currentThread().getName() + " -> Name: " + name + ", Marks: " + marks);
    }
}

public class ThreadLocalDemo {
    // Each thread gets its own Student object
    private static ThreadLocal<Student89> studentThreadLocal = new ThreadLocal<>();
/*
 * No need for synchronization.

ThreadLocal.remove() is important in thread pools to avoid memory leaks.

Ideal for handling per-thread login info, transaction context, etc.
 */
	public static void main(String[] args) {

        Runnable task1 = () -> {
        	Student89 student = new Student89("Gayu", 85);
            studentThreadLocal.set(student);  // Thread-local storage
            studentThreadLocal.get().display();
            studentThreadLocal.remove();  // Best practice to prevent memory leak
        };
        

        Runnable task2 = () -> {
        	Student89 student = new Student89("Gopi", 92);
            studentThreadLocal.set(student);
            studentThreadLocal.get().display();
            studentThreadLocal.remove();
        };
        

        Thread t1 = new Thread(task1, "WIPROThread-A");
        Thread t2 = new Thread(task2, "WIPROThread-B");

        t1.start();
        t2.start();


	}

}
/*
WIPROThread-A -> Name: Gayu, Marks: 85
WIPROThread-B -> Name: Gopi, Marks: 92
*/