<!-- 

| Feature     | **Servlet**                                            | **JSP (JavaServer Page)**                                         |
| ----------- | ------------------------------------------------------ | ----------------------------------------------------------------- |
| What is it? | A Java class that handles HTTP requests and responses. | A text-based document (HTML + Java) used for dynamic web content. |
| File Type   | `.java` (compiled into `.class`)                       | `.jsp` (compiled into Servlet internally)  
       
| Feature        | **Servlet**                                                | **JSP**                                              |
| -------------- | ---------------------------------------------------------- | ---------------------------------------------------- |
| Logic or View? | Mostly used for **business logic** and request processing. | Mostly used for **presentation layer (UI)**.         |
| Output Type    | Generates HTML using `PrintWriter` (manual).               | Mixes HTML with embedded Java (simpler to write UI). |
                |
| Feature        | **Servlet**                                   | **JSP**                                                |
| -------------- | --------------------------------------------- | ------------------------------------------------------ |
| Who writes it? | Developer writes full Java code.              | Developer writes mostly HTML with embedded Java.       |
| Compiled by    | Developer (via `javac` or servlet container). | JSP engine (automatically converted to servlet first). |
| Execution      | Already a Java class.                         | First converted to servlet, then compiled to class.    |

Best Practice (MVC Architecture)::

Servlet → Acts as Controller (handles request/response)

JSP → Acts as View (displays UI)

Java Beans/POJOs → Acts as Model (holds data)
 
 JSP LIFECYCLE:
 
 | Step | Phase                | Description                                                                   |
| ---- | -------------------- | ----------------------------------------------------------------------------- |
| 1️⃣  | **Translation**      | JSP file (`.jsp`) is converted into a **Java Servlet** source file (`.java`). |
| 2️⃣  | **Compilation**      | The `.java` file is compiled into a `.class` file (Servlet class).            |
| 3️⃣  | **Loading**          | Servlet class is **loaded** into the memory by the container.                 |
| 4️⃣  | **Instantiation**    | An **instance** of the Servlet is created.                                    |
| 5️⃣  | **Initialization**   | The `jspInit()` method is called once.                                        |
| 6️⃣  | **Request Handling** | Each request calls `jspService()` method.                                     |
| 7️⃣  | **Destruction**      | The `jspDestroy()` method is called when the JSP is removed or server stops.  |
 
 Step-by-step flow:
hello.jsp ➡ translated to hello_jsp.java

hello_jsp.java ➡ compiled to hello_jsp.class

jspInit() runs (once)

Every request ➡ jspService() runs

On shutdown or update ➡ jspDestroy() runs

JSPDemo_jsp.java
JSPDemo_jsp.class
 
 
JSP IMPLICIT OBJECTS:

 | Object Name   | Class / Type          | Description                                                              |
| ------------- | --------------------- | ------------------------------------------------------------------------ |
| `request`     | `HttpServletRequest`  | Represents the client request (form data, headers, etc.)                 |
| `response`    | `HttpServletResponse` | Used to generate response (headers, cookies, redirect, etc.)             |
| `out`         | `JspWriter`           | Used to write output to the client (HTML/response).                      |
| `session`     | `HttpSession`         | Stores user-specific data across multiple requests.                      |
| `application` | `ServletContext`      | Used to share data across the whole application.                         |
| `config`      | `ServletConfig`       | Provides configuration info for the JSP.                                 |
| `pageContext` | `PageContext`         | Provides access to all JSP scopes (page, request, session, application). |
| `page`        | `Object` (this)       | Refers to the current JSP page as a Java object.                         |
| `exception`   | `Throwable`           | Captures unhandled exceptions (only in error pages).                     |
 
 SCRIPTING TAG:
 -->
 <body bgcolor=lightgreen>
 <hr color=red>
 
 <%!
 //more than one declaration tag is also allowed
 //used for declaring variables and methods
//variable are accessed by all lifecycle methods
//declaration tag variables and methods are GLOBAL
int a1=100;
int add(int a, int b)
{
	return a+b;
}
 %>
   <%! 
 
   //second declaration tag
 int sub(int a,int b)
 {
	 return a-b;
 }
 %>
 
    <%
    //doget and dopost(scriptlet tag)
    //service method
    //more than one SCRIPTLET TAG is allowed
    //JSPDemo_jsp.java=>TRANSLATED SERVLET FILE NAME
    
    //LOCATION OF JSP TRANSLATED SERVLET:
    	
    //C:\Users\Administrator\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\WIPROServletsDemo2025\org\apache\jsp
  out.println("<H1><font color=red>Hello JSP");
  int dummy=100;//PRESENT ONLY IN _jspService() method
  out.println("Add:: "+add(12,12));
  out.println("<font color=blue>Declaration tag variables:: "+a1 + " "+dummy + "</font>");
   %>

 <%
 //second scriptlet
 out.println("Sub:: "+sub(12,10));
 %>

 <h1>Expression Tag</h1>
 <!-- expression tag(print the result) are 
 converted to code and are placed inside the _jspService method.-->
 Add:: <%=12+12%>
 <%="Good day" %>
 <%=dummy %>
 Calling add method:: <%= add(55,10) %>
 
 