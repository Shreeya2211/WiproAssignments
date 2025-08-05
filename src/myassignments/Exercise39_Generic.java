
package myassignments;

import java.util.ArrayList;

class Library<T> {
    private ArrayList<T> items = new ArrayList<>();

    public void add(T item) {
        items.add(item);
    }

    public T get(int index) {
        return items.get(index);
    }

    public void displayAll() {
        for (T item : items) {
            System.out.println(item);
        }
    }
}

public class Exercise39_Generic {
    public static void main(String[] args) {
        Library<Book> bookLibrary = new Library<>();
        bookLibrary.add(new Book("Effective Java"));

        Library<Video> videoLibrary = new Library<>();
        videoLibrary.add(new Video("Design Patterns in Java"));

        Library<Newspaper> newsLibrary = new Library<>();
        newsLibrary.add(new Newspaper("The Daily Code"));

        System.out.println("\nGeneric Book Library:");
        bookLibrary.displayAll();

        System.out.println("\nGeneric Video Library:");
        videoLibrary.displayAll();

        System.out.println("\nGeneric Newspaper Library:");
        newsLibrary.displayAll();
    }
}
/*

Generic Book Library:
Book: Effective Java

Generic Video Library:
Video: Design Patterns in Java

Generic Newspaper Library:
Newspaper: The Daily Code
*/
