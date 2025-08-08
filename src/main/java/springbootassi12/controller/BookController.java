package springbootassi12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbootassi12.model.Book;
import springbootassi12.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController
{

    @Autowired
    private BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody Book book)
    {
        return bookService.saveBook(book);
    }

    @GetMapping("/all")
    public List<Book> getAllBooks() 
    {
        return bookService.getAllBooks();
    }

    @PutMapping("/update")
    public String updateBook(@RequestBody Book book) 
    {
        return bookService.updateBook(book);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id) 
    {
        return bookService.deleteBook(id);
    }
}
