package mymainfiles;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;  // ✅ Correct Hibernate Transaction
import org.hibernate.cfg.Configuration;

import mypojos.Item;

public class Exercise1Hib
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        @SuppressWarnings("deprecation")
		SessionFactory factory = new Configuration()
                .configure("wiprohibernate.cfg.xml")
                .buildSessionFactory();

        while (true) 
        {
            System.out.println("\nHIBERNATE:\n");
            System.out.println("1. Add");
            System.out.println("2. View All");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Get by ID");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice)
            {
                case 1: 
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();
                    Session s1 = factory.openSession();
                    Transaction tx1 = s1.beginTransaction();
                    Item newItem = new Item(name, price);
                    s1.save(newItem);
                    tx1.commit();
                    s1.close();
                    System.out.println("Item added.");
                    break;

                case 2: 
                    Session s2 = factory.openSession();
                    @SuppressWarnings("unchecked") List<Item> items = s2.createQuery("from Item").list();

                    for (Item item : items)
                    {
                        System.out.println("ID: " + item.getId() + " | Name: " + item.getName() + " | Price: " + item.getPrice());
                    }
                    s2.close();
                    break;

                case 3: 
                    System.out.print("Enter ID to update: ");
                    int upId = sc.nextInt();
                    sc.nextLine();
                    Session s3 = factory.openSession();
                    Transaction tx3 = s3.beginTransaction();
                    Item itemToUpdate = (Item) s3.get(Item.class, upId);

                    if (itemToUpdate != null)
                    {
                        System.out.print("Enter new name: ");
                        itemToUpdate.setName(sc.nextLine());
                        System.out.print("Enter new price: ");
                        itemToUpdate.setPrice(sc.nextDouble());
                        s3.update(itemToUpdate);
                        tx3.commit();
                        System.out.println("Item updated.");
                    } 
                    else
                    {
                        System.out.println("Item not found.");
                        tx3.rollback();
                    }
                    s3.close();
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();
                    Session s4 = factory.openSession();
                    Transaction tx4 = s4.beginTransaction();
                    Item itemToDelete = (Item) s4.get(Item.class, delId);
                    if (itemToDelete != null)
                    {
                        s4.delete(itemToDelete);
                        tx4.commit();
                        System.out.println("Item deleted.");
                    } else
                    {
                        System.out.println("Item not found.");
                        tx4.rollback();
                    }
                    s4.close();
                    break;

                case 5: 
                	System.out.print("Enter ID to fetch: ");
                	int fetchId = sc.nextInt();
                	Session s5 = factory.openSession();
                	Item singleItem = (Item) s5.get(Item.class, fetchId);
                	if (singleItem != null) {
                	    System.out.println("ID: " + singleItem.getId() + " | Name: " + singleItem.getName() + " | Price: " + singleItem.getPrice());
                	} else {
                	    System.out.println("Item not found.");
                	}
                	s5.close();

                    break;

                case 0:
                    factory.close();
                    sc.close();
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
