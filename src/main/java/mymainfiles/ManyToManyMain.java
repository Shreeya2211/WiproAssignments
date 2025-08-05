package mymainfiles;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entity.Book;
import entity.Author;

public class ManyToManyMain {

    @SuppressWarnings("deprecation")
	public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Scanner sc = new Scanner(System.in);

        try {
            mainLoop(factory, sc);
        } finally {
            sc.close();
            factory.close();
        }
    }

    private static void mainLoop(SessionFactory factory, Scanner sc) {
        while (true) {
            System.out.println("\n--- Book-Author CRUD ---");
            System.out.println("1. Add Book with Authors");
            System.out.println("2. View Books & Authors");
            System.out.println("3. Delete Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                System.out.println("Please enter a choice.");
                continue;
            }

            int choice;
            try {
                choice = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    addBookWithAuthors(factory, sc);
                    break;
                case 2:
                    viewBooksAndAuthors(factory);
                    break;
                case 3:
                    deleteBook(factory, sc);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void addBookWithAuthors(SessionFactory factory, Scanner sc) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            System.out.print("Enter Book Title: ");
            String title = sc.nextLine().trim();
            Book book = new Book(title);

            System.out.print("How many authors? ");
            int count = 0;
            try {
                count = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, assuming 0 authors.");
            }

            for (int i = 0; i < count; i++) {
                System.out.print("Enter Author Name: ");
                String authorName = sc.nextLine().trim();
                Author author = new Author(authorName);
                book.addAuthor(author);
            }

            session.persist(book);
            tx.commit();
            System.out.println("Book & Authors saved!");
        } catch (Exception ex) {
            if (tx != null) {
                try { tx.rollback(); } catch (Throwable t) { /* ignore */ }
            }
            System.out.println("Error saving book: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    private static void viewBooksAndAuthors(SessionFactory factory) {
        Session session = factory.openSession();
        try {
            @SuppressWarnings("rawtypes")
            List rawList = session.createQuery("from Book").list();

            if (rawList == null || rawList.isEmpty()) {
                System.out.println("No books found.");
                return;
            }

            for (Object o : rawList) {
                Book b = (Book) o; // explicit cast for older Hibernate versions
                System.out.println("\nBook (id=" + b.getId() + "): " + b.getTitle());

                if (b.getAuthors() == null || b.getAuthors().isEmpty()) {
                    System.out.println("   No authors.");
                } else {
                    b.getAuthors().forEach(a ->
                        System.out.println("   Author (id=" + a.getId() + "): " + a.getName())
                    );
                }
            }
        } catch (Exception ex) {
            System.out.println("Error reading books: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    private static void deleteBook(SessionFactory factory, Scanner sc) {
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            System.out.print("Enter Book ID to delete: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            // explicit cast because older Hibernate returns Object
            Book book = (Book) session.get(Book.class, id);

            if (book != null) {
                session.delete(book);
                System.out.println("Book deleted!");
            } else {
                System.out.println("Book not found!");
            }
            tx.commit();
        } catch (Exception ex) {
            if (tx != null) {
                try { tx.rollback(); } catch (Throwable t) { /* ignore */ }
            }
            System.out.println("Error deleting book: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }
}
