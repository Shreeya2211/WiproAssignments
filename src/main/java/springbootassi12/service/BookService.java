package springbootassi12.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootassi12.dao.BookDAO;
import springbootassi12.model.Book;

import java.util.List;

@Service
public class BookService
{

    @Autowired
    private BookDAO bookDAO;

    public List<Book> getAllBooks()
    {
        return bookDAO.getAllBooks();
    }

    public String saveBook(Book book) 
    {
        return bookDAO.saveBook(book);
    }

    public String updateBook(Book book) 
    {
        return bookDAO.updateBook(book);
    }

    public String deleteBook(int id)
    {
        return bookDAO.deleteBook(id);
    }
}

