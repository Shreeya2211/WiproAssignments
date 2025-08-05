package mymainfiles;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

// IMPORTANT: Fully qualify Hibernate's Transaction to avoid conflict with your entity
public class AccountTransactionMain {
    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        SessionFactory factory = new Configuration()
                .configure("wiprohibernate.cfg.xml")
                .addAnnotatedClass(Account.class)
                .addAnnotatedClass(Transaction.class)
                .buildSessionFactory();

        while (true) {
            System.out.println("\n1. Add Account with Transactions\n2. View All Accounts\n3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    Session s1 = factory.openSession();
                    org.hibernate.Transaction tx1 = s1.beginTransaction();  // FULLY QUALIFIED

                    Account acc = new Account();
                    System.out.print("Enter account name: ");
                    acc.setAccname(sc.nextLine());

                    System.out.print("Enter number of transactions: ");
                    int count = sc.nextInt();

                    for (int i = 0; i < count; i++) {
                        sc.nextLine();  // consume newline
                        Transaction t = new Transaction();
                        System.out.print("Enter transaction type: ");
                        t.setType(sc.nextLine());
                        System.out.print("Enter amount: ");
                        t.setAmount(sc.nextDouble());
                        acc.addTransaction(t);  // add bidirectionally
                    }

                    s1.save(acc);
                    tx1.commit();
                    s1.close();
                    break;

                case 2:
                    Session s2 = factory.openSession();
                    @SuppressWarnings("unchecked")
                    List<Account> accounts = s2.createQuery("from Account").list();  // No .class here for Hibernate 4.3

                    for (Account a : accounts) {
                        System.out.println("\nAccount ID: " + a.getAccno() + ", Name: " + a.getAccname());
                        for (Transaction t : a.getTransactions()) {
                            System.out.println("  → Transaction ID: " + t.getTid() + ", Type: " + t.getType() + ", Amount: " + t.getAmount());
                        }
                    }
                    s2.close();
                    break;

                case 3:
                    factory.close();
                    sc.close();
                    System.exit(0);
            }
        }
    }
}
