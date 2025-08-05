package servletsassignment;


import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/submitUserInfo")
public class SubmitUserInfoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Read form values
        String username = request.getParameter("username");
        @SuppressWarnings("unused")
		String password = request.getParameter("password");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String[] frameworks = request.getParameterValues("framework");
        String favoriteNumber = request.getParameter("favNumber");
        String subscribe = request.getParameter("subscribe");

        // Store values to request scope for EL use
        request.setAttribute("username", username);
        request.setAttribute("address", address);
        request.setAttribute("gender", gender);
        request.setAttribute("frameworks", frameworks);
        request.setAttribute("favoriteNumber", favoriteNumber);
        request.setAttribute("subscribe", subscribe != null ? "Yes" : "No");

        // Forward to a JSP page for displaying submitted data
        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        dispatcher.forward(request, response);
    }
}
