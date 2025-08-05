package servletsassignment;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = {"/BookServlet", "/insert", "/list"})
public class BookServlet extends HttpServlet {
    private BookDAO bookDAO;

    @Override
    public void init() {
        bookDAO = new BookDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String action = request.getServletPath();

        try {
            if (action.equals("/insert")) {
                insertBook(request, response);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String action = request.getServletPath();
   
        try {
            switch (action) {
                case "/list":
                    listBooks(request, response);
                    break;
                case "/":
                    response.sendRedirect("book-form.jsp");
                    break;
                default:
                    response.sendError(HttpServletResponse.SC_NOT_FOUND);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }


    private void insertBook(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        float price = Float.parseFloat(request.getParameter("price"));
        Book newBook = new Book(title, author, price);

        try {
            bookDAO.insertBook(newBook);
            response.sendRedirect("list");
        } catch (SQLException e) {
            e.printStackTrace();  // Log error
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database Error: " + e.getMessage());
        }
    }

    private void listBooks(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Book> list = bookDAO.getAllBooks();
            request.setAttribute("listBook", list);
            RequestDispatcher dispatcher = request.getRequestDispatcher("book-list.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();  // For debugging
            throw new ServletException("Database error while listing books", e);
        }
    }
}
