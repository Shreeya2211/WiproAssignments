package springprograms;
/*
 * AOP allows you to separate cross-cutting concerns (like logging, security, transactions, etc.) from your business logic.

AOP (Aspect-Oriented Programming) is used to separate cross-cutting concerns like:
1.Logging
2.Security
3.Transactions
4.Performance Monitoring
These are not part of core business logic, but they are needed in multiple places.

Think of a bank:

Business logic: deposit, withdraw, check balance
Cross-cutting logic: logging, authentication, validation, auditing

| Feature                | Without AOP                                  | With AOP                               |
| ---------------------- | -------------------------------------------- | -------------------------------------- |
| Code Reusability       | Low (duplicate logging, etc.)                | High (common logic reused via aspect)  |
| Separation of Concerns | Mixed with business logic                    | Clean separation                       |
| Maintainability        | Harder to update logging/security            | Easier – change in one aspect          |
| Coupling               | Tight (logger/security logic inside service) | Loose – logic moved to separate aspect |
| Code Size              | Bigger – repeated logic                      | Smaller – centralized logic            |

Instead of putting logging code in every method, you "inject" it separately using AOP.

| Advantage                           | Description                                                                             |
| ----------------------------------- | --------------------------------------------------------------------------------------- |
| **1. Code Reusability**             | Common logic (like logging or security) is written once and reused across many classes. |
| **2. Separation of Concerns (SoC)** | Clean separation between business logic and cross-cutting concerns.                     |
| **3. Easy Maintenance**             | Changes to logging/security/etc. are done in one place — not in every class.            |
| **4. Declarative Programming**      | You can declare "what" to apply (via XML or annotations) without changing actual code.  |
| **5. Reduced Boilerplate**          | No need to repeat the same logging, security, transaction logic in every method.        |
| **6. Improves Readability**         | Business methods stay focused — no clutter from logging or exception handling.          |
| **7. Dynamic Behavior**             | You can apply behavior to existing classes without modifying their source.              |

| AOP Advice Type   | When it runs                                          | Use Case                               |
| ----------------- | ----------------------------------------------------- | -------------------------------------- |
| `@Before`         | Before method call                                    | Logging, authentication                |
| `@After`          | After method finishes (success or fail)               | Cleanup, notification                  |
| `@AfterReturning` | After method returns successfully                     | Audit, result logging                  |
| `@AfterThrowing`  | If method throws exception                            | Error logging, alerting                |
| `@Around`         | Around entire method execution (control input/output) | Performance logging, permission checks |


| **Advice Type**   | **When It Executes**                                  | **Method Name**       | **Use Case (Real Life)**                | **Code Example Snippet**                        |
| ----------------- | ----------------------------------------------------- | --------------------- | --------------------------------------- | ----------------------------------------------- |
| `@Before`         | Before the actual method runs                         | `logBefore()`         | Log start of a bank transaction         | `System.out.println("Start transaction");`      |
| `@AfterReturning` | After method returns successfully                     | `logAfterReturning()` | Log transaction result                  | `System.out.println("Transaction successful");` |
| `@AfterThrowing`  | If method throws an exception                         | `logException()`      | Log errors, alert support               | `System.out.println("Error occurred: " + ex);`  |
| `@After`          | Runs after method finishes (whether success or error) | `logAfter()`          | Always log method end (success/failure) | `System.out.println("Transaction ended");`      |
| `@Around`         | Runs before and after method execution (full control) | `logExecutionTime()`  | Measure performance, manage permissions | Timer logic, conditionally run method           |

 */

public class BankServiceAOPDemo {
	 private double balance = 0.0;

	    public String deposit(double amount) {
	        balance += amount;
	        System.out.println("Deposited: ₹" + amount);
	        return "New Balance: ₹" + balance;
	    }

	    public String withdraw(double amount) {
	        if (amount > balance) {
	            throw new RuntimeException("Insufficient funds");
	        }
	        balance -= amount;
	        System.out.println("Withdrawn: ₹" + amount);
	        return "New Balance: ₹" + balance;
	    }

	    public String checkBalance() {
	        System.out.println("Current Balance: ₹" + balance);
	        return "Balance: ₹" + balance;
	    }

}
