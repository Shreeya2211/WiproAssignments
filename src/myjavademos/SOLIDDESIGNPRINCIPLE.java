package myjavademos;
/*
 * SOLID Acronym Explained:
Principle	Description
S - Single Responsibility	A class should have only one reason to change. (Do one thing well.)
O - Open/Closed	Software entities should be open for extension but closed for modification.
L - Liskov Substitution	Subtypes should be substitutable for their base types.
I - Interface Segregation	No client should be forced to depend on methods it does not use.
D - Dependency Inversion	Depend on abstractions, not on concrete implementations.

 */
/*
 * | **Reason**                       | **Explanation**                                                              |
| -------------------------------- | ---------------------------------------------------------------------------- |
| **1. Reduce Code Complexity**    | Helps break down large classes and methods into smaller, manageable units.   |
| **2. Improve Maintainability**   | Changes in one part of the code affect fewer other parts.                    |
| **3. Enhance Reusability**       | Code components become more modular and reusable across projects.            |
| **4. Make Code Scalable**        | Easier to add new features without touching existing, stable code.           |
| **5. Easier Testing**            | Smaller, well-defined classes/functions are easier to test individually.     |
| **6. Prevent Tight Coupling**    | Promotes loosely coupled components that can work independently.             |
| **7. Follow Industry Standards** | Widely accepted in professional development, making code more team-friendly. |

 */
/*I - Interface Segregation::
 * 
 * bad example::
 * 
 * interface Worker {
    void work();
    void eat();
}

class Robot implements Worker {
    public void work() { }
    public void eat() { } // not applicable
}

Good Example:


interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class Human implements Workable, Eatable {
    public void work() { }
    public void eat() { }
}

class Robot implements Workable {
    public void work() { }
}
Smaller, role-specific interfaces.
 */

/*
 * D   Dependency Inversion Principle (DIP)
 * 
High-level modules should depend on abstractions, not on concrete classes.

Bad Example:

 class MySQLDatabase {
    void connect() {}
}

class App {
    MySQLDatabase db = new MySQLDatabase();
    void run() {
        db.connect();
    }
}

Good Example:

interface Database {
    void connect();
}

class MySQLDatabase implements Database {
    public void connect() {}
}

class App {
    Database db;

    App(Database db) {
        this.db = db;
    }

    void run() {
        db.connect();
    }
}
Why DIP?
Your app can now work with any database, not just MySQL.
 */
public class SOLIDDESIGNPRINCIPLE {

}
