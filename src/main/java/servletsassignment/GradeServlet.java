package servletsassignment;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class GradeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = (String) request.getAttribute("studentName");
        int marks = (int) request.getAttribute("studentMarks");

        String grade;
        if (marks >= 90) grade = "A+";
        else if (marks >= 75) grade = "A";
        else if (marks >= 60) grade = "B";
        else if (marks >= 40) grade = "C";
        else grade = "F";

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Grade Result</title>");
        out.println("<link href='https://fonts.googleapis.com/css2?family=Poppins&display=swap' rel='stylesheet'>");
        out.println("<style>");
        out.println("body { font-family: 'Poppins', sans-serif; background: #f0f0f0; display: flex; height: 100vh; justify-content: center; align-items: center; }");
        out.println(".result-box { background: white; padding: 30px; border-radius: 12px; box-shadow: 0 6px 15px rgba(0,0,0,0.1); width: 350px; }");
        out.println(".result-box h2 { color: #1a237e; margin-bottom: 20px; }");
        out.println(".result-box p { font-size: 16px; margin: 10px 0; }");
        out.println("</style></head><body>");

        out.println("<div class='result-box'>");
        out.println("<h2>Grade Summary</h2>");
        out.println("<p><strong>Name:</strong> " + name + "</p>");
        out.println("<p><strong>Marks:</strong> " + marks + "</p>");
        out.println("<p><strong>Grade:</strong> " + grade + "</p>");
        out.println("</div>");

        out.println("</body></html>");
    }
}
