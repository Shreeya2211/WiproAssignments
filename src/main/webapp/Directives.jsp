 <!-- 
 PAGE DIRECTIVE:
 
 
 | Attribute      | Typical Value                                 | Purpose                                                             |
| -------------- | --------------------------------------------- | ------------------------------------------------------------------- |
| `language`     | `"java"` *(only valid option)*                | Specifies the scripting language used.                              |
| `contentType`  | `"text/html"` or `"text/html; charset=UTF-8"` | Defines MIME type and character encoding of the response.           |
| `pageEncoding` | `"UTF-8"`                                     | Defines the character encoding for the JSP source file.             |
| `import`       | `"java.util.*, java.io.*"`                    | Imports Java classes/packages.                                      |
| `session`      | `"true"` or `"false"`                         | Specifies if the page uses `HttpSession`.                           |
| `buffer`       | `"8kb"`, `"16kb"`                             | Sets the response output buffer size.                               |
| `autoFlush`    | `"true"` or `"false"`                         | Whether to automatically flush the buffer.                          |
| `isThreadSafe` | `"true"` or `"false"`                         | Controls thread safety (generally `"true"`).                        |
| `errorPage`    | `"error.jsp"`                                 | Redirects to this JSP when an uncaught exception occurs.            |
| `isErrorPage`  | `"true"` or `"false"`                         | Marks this page as an error handler.                                |
| `extends`      | `"some.custom.BaseJspClass"`                  | Specifies a superclass to extend instead of `HttpJspBase`.          |
| `info`         | `"This is my JSP page"`                       | Gives a short description (can be accessed via `getServletInfo()`). |
 
  -->
   <!-- there are  more than one page directive in jsp -->
  
  <%@page import="java.util.*,java.sql.*" buffer="17kb" autoFlush="false" %>
  
  <jsp:directive.page import="java.util.*,java.sql.*"/>
  
     <%@page import="myservletdemos.Supplier" %>
     
    
    
 <%
 Supplier obj=new Supplier();

  obj.setSupplierid(100);
 obj.setSuppliername("Dell");
 out.println("Suppliers:: "+obj.getSupplierid() + " "+obj.getSuppliername());
 %>