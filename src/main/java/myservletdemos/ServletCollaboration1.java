package myservletdemos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 *In Servlets, "RequestDispatcher Interface" is used to dispatch a request 
 *to another resource (like another Servlet, JSP, or HTML). It provides two main methods: 
 
 1.include(request, response)
Purpose: Includes content of another resource in the response of the current servlet.

Control Flow: The original servlet continues after the include.

Use Case: When you want to embed content (like a header, footer, etc.).

2.forward(request, response)
Purpose: Forwards the request to another resource without returning to the original servlet.

Control Flow: The original servlet stops execution once forward() is called.

Use Case: For routing/redirecting requests internally.

| Feature              | `forward()`                        | `include()`                            |
| -------------------- | ---------------------------------- | -------------------------------------- |
| Control flow         | Stops original servlet             | Continues original servlet             |
| Response composition | Replaces whole response            | Appends to existing response           |
| Use case             | Redirect logic, controller mapping | Include reusable views (header/footer) |
| Browser URL changes? | No                                 | No                                     |
| Response committed?  | Must be uncommitted before forward | Can be committed before include        |

 */

 /*
 * There are 2 ways to get the RequestDispatcher Object::
 * ---ServletContext Interface
 * --ServletRequest Interface
 */

/*
 * | Feature                   | `ServletRequest.getRequestDispatcher()` | `ServletContext.getRequestDispatcher()` |
| ------------------------- | --------------------------------------- | --------------------------------------- |
| Path format               | Relative or absolute (within web app)   | Must be absolute (starts with `/`)      |
| Common use location       | Inside Servlets                         | Anywhere with ServletContext            |
| Root of path resolution   | Current request context                 | Application root                        |
| Requires servlet request? | Yes                                     | No                                      |

 */
@WebServlet("/ServletCollaboration1")
public class ServletCollaboration1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");//MIME TYPE
		
		PrintWriter obj=response.getWriter();
		ServletContext sc=getServletContext();//init()=>ServletInterface
		
		//ServletContext / is mandatory for url
		
		//RequestDispatcher rs=sc.getRequestDispatcher("/Wipro_UpdateEmployee");//valid =>url pattern of servlet
		//RequestDispatcher rs=sc.getRequestDispatcher("Wipro_UpdateEmployee");//invalid bcos / is missing		
		RequestDispatcher rs=sc.getRequestDispatcher("/Login.html");
		if(rs!=null)
		{
			//rs.forward(request, response);
			rs.include(request,response);
		}
		obj.println("<h1><p>Current Servlet Running!");//this code will not be displayed in forward()
		
		
		
	}


}
