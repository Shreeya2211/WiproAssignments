/*
 * 41.Create a class called BookStore with fields Bookid and Bookname.  Sort using comparator and 
display the output by sorting based on book name and book id.
 */
package myassignments;

import java.util.*;

// BookStore class
class BookStore
{
    private int bookId;
    private String bookName;

    public BookStore(int bookId, String bookName)
    {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public int getBookId()
    {
        return bookId;
    }

    public String getBookName()
    {
        return bookName;
    }

    @Override
    public String toString()
    {
        return "BookStore [Book ID=" + bookId + ", Book Name=" + bookName + "]";
    }
}

// Comparator to sort by book name
class BookNameComparator implements Comparator<BookStore> {
    public int compare(BookStore b1, BookStore b2) {
        return b1.getBookName().compareToIgnoreCase(b2.getBookName());
    }
}

// Comparator to sort by book ID
class BookIdComparator implements Comparator<BookStore> {
    public int compare(BookStore b1, BookStore b2) {
        return Integer.compare(b1.getBookId(), b2.getBookId());
    }
}

public class Exercise41 {
    public static void main(String[] args) {
        List<BookStore> books = new ArrayList<>();
        books.add(new BookStore(103, "Java Programming"));
        books.add(new BookStore(101, "Data Structures"));
        books.add(new BookStore(105, "Algorithms"));
        books.add(new BookStore(102, "Operating Systems"));

        // Sorting by book name
        System.out.println("Books sorted by Book Name:");
        Collections.sort(books, new BookNameComparator());
        for (BookStore b : books) {
            System.out.println(b);
        }

        System.out.println("\nBooks sorted by Book ID:");
        // Sorting by book ID
        Collections.sort(books, new BookIdComparator());
        for (BookStore b : books) {
            System.out.println(b);
        }
    }
}
/*
Books sorted by Book Name:
BookStore [Book ID=105, Book Name=Algorithms]
BookStore [Book ID=101, Book Name=Data Structures]
BookStore [Book ID=103, Book Name=Java Programming]
BookStore [Book ID=102, Book Name=Operating Systems]

Books sorted by Book ID:
BookStore [Book ID=101, Book Name=Data Structures]
BookStore [Book ID=102, Book Name=Operating Systems]
BookStore [Book ID=103, Book Name=Java Programming]
BookStore [Book ID=105, Book Name=Algorithms]
*/