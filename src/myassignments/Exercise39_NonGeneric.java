/*39.Design a class that acts as a library for the following kinds of media: book, video, and 
newspaper. Provide one version of the class that uses generics and one that does not.
The class should be with add and retrieve methods in order to add and retrieve values 
from the library.
*/

package myassignments;

import java.util.ArrayList;

class Book {
    String title;
    Book(String title) {
        this.title = title;
    }
    public String toString() {
        return "Book: " + title;
    }
}

class Video {
    String title;
    Video(String title) {
        this.title = title;
    }
    public String toString() {
        return "Video: " + title;
    }
}

class Newspaper {
    String name;
    Newspaper(String name) {
        this.name = name;
    }
    public String toString() {
        return "Newspaper: " + name;
    }
}

class MediaLibrary {
    @SuppressWarnings("rawtypes")
	ArrayList items = new ArrayList();

    @SuppressWarnings("unchecked")
	public void add(Object item) {
        items.add(item);
    }

    public Object get(int index) {
        return items.get(index);
    }

    public void displayAll() {
        for (Object item : items) {
            System.out.println(item);
        }
    }
}

public class Exercise39_NonGeneric
{
    public static void main(String[] args)
    {
        MediaLibrary lib = new MediaLibrary();
        lib.add(new Book("Java Basics"));
        lib.add(new Video("Learning Generics"));
        lib.add(new Newspaper("The Times"));

        System.out.println("Non-Generic Media Library:");
        lib.displayAll();
    }
}
/*
 * Non-Generic Media Library:
Book: Java Basics
Video: Learning Generics
Newspaper: The Times
*/
