package springbootassi12.dao;

import springbootassi12.model.Book;
import java.util.List;

public interface BookDAO {
    List<Book> getAllBooks();
    String saveBook(Book book);
    String updateBook(Book book);
    String deleteBook(int id);
}


