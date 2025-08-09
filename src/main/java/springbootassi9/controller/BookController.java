package springbootassi9.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootassi9.model.Book;
import springbootassi9.model.BookList;

import java.util.Arrays;

@RestController
public class BookController {

    @GetMapping(value = "/bookXYZ", produces = "application/xml")
    public BookList getBooks() {
        return new BookList(Arrays.asList(
            new Book(101, "Java Tutorials", "Krishna"),
            new Book(102, "Spring Tutorials", "Mahesh"),
            new Book(103, "Angular Tutorials", "Shiva")
        ));
    }
}
