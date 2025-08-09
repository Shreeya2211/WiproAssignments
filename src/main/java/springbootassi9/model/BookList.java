package springbootassi9.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "List")
public class BookList {

    private List<Book> books;

    public BookList() {}

    public BookList(List<Book> books) {
        this.books = books;
    }

    @XmlElement(name = "item")
    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
