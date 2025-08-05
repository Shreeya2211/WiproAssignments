package mymainfiles;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.*;

public class BookAuthorMain {
    @SuppressWarnings({ "deprecation", "rawtypes", "rawtypes" })
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SessionFactory factory = new Configuration()
                .configure("wiprohibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Author.class)
                .buildSessionFactory();

        while (true) {
            System.out.println("\n1. Add Book with Authors\n2. View All Books\n3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    Session session1 = factory.openSession();
                    org.hibernate.Transaction tx1 = session1.beginTransaction();

                    Book book = new Book();
                    System.out.print("Enter book ID: ");
                    book.setBookId(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Enter book title: ");
                    book.setTitle(sc.nextLine());

                    System.out.print("Enter number of authors: ");
                    int count = sc.nextInt();
                    sc.nextLine();

                    Set<Author> authors = new HashSet<>();

                    for (int i = 0; i < count; i++) {
                        Author author = new Author();
                        System.out.print("Enter author ID: ");
                        author.setAuthorId(sc.nextInt());
                        sc.nextLine();
                        System.out.print("Enter author name: ");
                        author.setName(sc.nextLine());

                        authors.add(author);
                        session1.save(author); // Persist each author
                    }

                    book.setAuthors(authors); // Set authors
                    session1.save(book); // Persist book

                    tx1.commit();
                    session1.close();
                    break;

                case 2:
                    Session session2 = factory.openSession();
                    List books = session2.createQuery("from Book").list(); // Hibernate 4.x, no generics

                    for (Object obj : books) {
                        Book b = (Book) obj;
                        System.out.println("\nBook ID: " + b.getBookId() + ", Title: " + b.getTitle());
                        for (Author a : b.getAuthors()) {
                            System.out.println("  → Author ID: " + a.getAuthorId() + ", Name: " + a.getName());
                        }
                    }

                    session2.close();
                    break;

                case 3:
                    factory.close();
                    sc.close();
                    System.exit(0);
            }
        }
    }
}
