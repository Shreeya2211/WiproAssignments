package servletsassignment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    private String jdbcURL = "jdbc:mysql://localhost:3306/wiprotraining";
    private String jdbcUsername = "root";
    private String jdbcPassword = "1234";

    private static final String INSERT_BOOK_SQL = "INSERT INTO books (title, author, price) VALUES (?, ?, ?);";
    private static final String SELECT_ALL_BOOKS = "SELECT * FROM books";

    public BookDAO() {}

    protected Connection getConnection()
    {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); // For MySQL 5.x
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertBook(Book book) throws SQLException 
    {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK_SQL)) 
        {
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setFloat(3, book.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e)
        {
            printSQLException(e);
        }
    }

    public List<Book> getAllBooks() throws SQLException 
    {
        List<Book> books = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS))
        {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                float price = rs.getFloat("price");
                books.add(new Book(id, title, author, price));
            }
        } catch (SQLException e)
        {
            printSQLException(e);
        }
        return books;
    }

    private void printSQLException(SQLException ex)
    {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());

                Throwable t = ex.getCause();
                while (t != null) {
                    System.err.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
