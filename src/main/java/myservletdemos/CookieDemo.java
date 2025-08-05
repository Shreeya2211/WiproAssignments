package myservletdemos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/*
 * Cookies are small pieces of data stored on the client side (i.e., in the user's browser) and sent to 
 * the server with every HTTP request. They are commonly used to store information such as user preferences, 
 * session IDs, or login information.
 
 Basic Characteristics of Cookies:
Stored on the client browser.

Sent to the server with every HTTP request.

Can persist beyond a single session (depending on expiration settings).

Limited in size (about 4KB per cookie).

| Type                  | Description                     |
| --------------------- | ------------------------------- |
| **Session Cookie**    | Deleted when the browser closes |
| **Persistent Cookie** | Stored until expiry date/time   |
| **Secure Cookie**     | Sent over HTTPS only            |
| **HttpOnly Cookie**   | Not accessible via JavaScript   |
| **SameSite Cookie**   | Helps prevent CSRF attacks      |

*/
@SuppressWarnings("serial")
@WebServlet("/CookieDemo")
public class CookieDemo extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        String name = request.getParameter("name");
        String roll = request.getParameter("roll");
        String email = request.getParameter("email");

        String encodedName = URLEncoder.encode(name, "UTF-8");
       
		String encodedRoll = URLEncoder.encode(roll, "UTF-8");
     
		String encodedEmail = URLEncoder.encode(email, "UTF-8");

        Cookie c1 = new Cookie("c_name", encodedName);
        Cookie c2 = new Cookie("c_roll", encodedRoll);
        Cookie c3 = new Cookie("c_email", encodedEmail);

        // Add cookies to response
        response.addCookie(c1);
        response.addCookie(c2);
        response.addCookie(c3);
        
        /*
         * setMaxAge() Value	Meaning
> 0	Cookie will persist on the client for that many seconds (i.e., a persistent cookie).
0	Deletes the cookie immediately from the browser.
< 0 (default)	Cookie is not stored persistently and will be deleted when the browser is closed (i.e., a session cookie).
         
         cookie.setMaxAge(int seconds);
         
         If you want to set a cookie that only lasts for the browser session, 
         just don t call setMaxAge() at all or pass -1.
         */
        // Set expiry time (optional)
        c1.setMaxAge(60 * 60); // 1 hour // 1 hour = 3600 seconds
        c2.setMaxAge(60 * 60);
        c3.setMaxAge(60 * 60);

        
        PrintWriter out = response.getWriter();
        out.println("<h2>Student data stored in cookies.</h2>");
        out.println("<a href='CookieView'>View Student Info</a>");


	}

}
