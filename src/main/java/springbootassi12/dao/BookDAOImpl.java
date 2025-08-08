package springbootassi12.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import springbootassi12.model.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO 
{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // ----------------- GET ALL -----------------
    @Override
    public List<Book> getAllBooks() {
        String sql = "SELECT * FROM book1";
        return jdbcTemplate.query(sql, (rs, rowNum) -> mapRowToBook(rs));
    }

    // ----------------- CREATE -----------------
    @Override
    public String saveBook(Book book) 
    {
        String sql = "INSERT INTO book1 (id, title, author, price) VALUES (?, ?, ?, ?)";
        int rows = jdbcTemplate.update(sql, book.getId(), book.getTitle(), book.getAuthor(), book.getPrice());
        return rows > 0 ? "Book inserted successfully" : "Failed to insert book";
    }

    // ----------------- UPDATE -----------------
    @Override
    public String updateBook(Book book)
    {
        String sql = "UPDATE book1 SET title=?, author=?, price=? WHERE id=?";
        int rows = jdbcTemplate.update(sql, book.getTitle(), book.getAuthor(), book.getPrice(), book.getId());
        return rows > 0 ? "Book updated successfully" : "Book not found";
    }

    // ----------------- DELETE -----------------
    @Override
    public String deleteBook(int id) 
    {
        String sql = "DELETE FROM book1 WHERE id=?";
        int rows = jdbcTemplate.update(sql, id);
        return rows > 0 ? "Book deleted successfully" : "Book not found";
    }

    // ----------------- MAPPER -----------------
    private Book mapRowToBook(ResultSet rs) throws SQLException 
    {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setPrice(rs.getDouble("price"));
        return book;
    }
}
