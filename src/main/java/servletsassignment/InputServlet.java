package servletsassignment;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@SuppressWarnings("serial")
@WebServlet("/InputServlet")

public class InputServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        int marks = Integer.parseInt(request.getParameter("marks"));

        request.setAttribute("studentName", name);
        request.setAttribute("studentMarks", marks);

        RequestDispatcher dispatcher = request.getRequestDispatcher("grade");
        dispatcher.forward(request, response);
    }
}
