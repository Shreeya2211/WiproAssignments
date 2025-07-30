package myjavademos;
/*
 * Real-World Use Cases:
Feature	Example
Concurrent access to accounts	Online banking APIs accessed by thousands of users
Safe updates to balances	ATM withdrawals, UPI, deposits, etc.
High performance under load	Real-time transaction processing systems

 */

import java.util.concurrent.ConcurrentHashMap;

class Bank 
{
	private ConcurrentHashMap<Integer, Integer> accounts = new ConcurrentHashMap<>();

    // Initialize some accounts
    public Bank() {
        accounts.put(101, 5000);
        accounts.put(102, 8000);
        accounts.put(103, 10000);
    }
    public void deposit(int accountNumber, int amount) 
    {
        accounts.computeIfPresent(accountNumber, (acc, balance) -> balance + amount);
        System.out.println("Deposited " + amount + " to account " + accountNumber);
    }
    
    public void withdraw(int accountNumber, int amount) {
        accounts.computeIfPresent(accountNumber, (acc, balance) -> 
        {
            if (balance >= amount) {
                System.out.println("Withdrew " + amount + " from account " + accountNumber);
                return balance - amount;
            } else {
                System.out.println("Insufficient funds in account " + accountNumber);
                return balance;
            }
        });
    }
    
    public void showBalances() {
        System.out.println("Account Balances:");
        accounts.forEach((acc, balance) ->
            System.out.println("Account " + acc + ": ₹" + balance));
    }
}





public class ConcurrentCollectionDemo2 {

	public static void main(String[] args) throws InterruptedException//parent thread
	{
		 Bank bank = new Bank();
/*
 *   accounts.put(101, 5000);
        accounts.put(102, 8000);
        accounts.put(103, 10000);
 */
	        Runnable task1 = () -> {
	            bank.deposit(101, 1000);
	            bank.withdraw(101, 3000);
	        };

	        Runnable task2 = () -> {
	            bank.withdraw(102, 2000);
	            bank.deposit(102, 4000);
	        };

	        Runnable task3 = () -> {
	            bank.deposit(103, 1500);
	            bank.withdraw(103, 5000);
	        };

	        Thread t1 = new Thread(task1);//child thread 1
	        Thread t2 = new Thread(task2);//child thread 2
	        Thread t3 = new Thread(task3);//child thread 3

	        t1.start();
	        t2.start();
	        t3.start();

	        t1.join();//main thread waiting for all child thread process to get completed
	        t2.join();
	        t3.join();

	        System.out.println("\nFinal Balances:");
	        bank.showBalances();

	}

}
/*
Deposited 1500 to account 103
Deposited 1000 to account 101
Withdrew 3000 from account 101
Withdrew 2000 from account 102
Deposited 4000 to account 102
Withdrew 5000 from account 103

Final Balances:
Account Balances:
Account 101: ₹3000
Account 102: ₹10000
Account 103: ₹6500
*/