<body bgcolor=pink>
<h1>
<!-- The jsp:useBean action tag is used to declare and use a JavaBean in JSP. It allows you to create a new bean or 
access an existing one, and use its properties without writing Java code inside the JSP. -->

<!-- NO JAVA CODE!!!! COMPLETELY JSP TAG ORIENTED PROGRAM  -->
<!-- With """"scriptless JSP""", embedding too much code in the page 
can be avoided thus resulting in a neat JSP page. -->

<!-- Scriptletless JSP (No  Java code in JSP) -->

<!-- 
| USE BEAN Attribute | Description                                                                 |
| --------- | --------------------------------------------------------------------------- |
| `id`      | Variable name to access the bean in the JSP                                 |
| `class`   | Full class name (with package) of the bean                                  |
| `scope`   | Scope of the bean: `page` (default), `request`, `session`, or `application` |

 -->
 
<jsp:useBean id="bobj" class="myservletdemos.Supplier"/>

 <!-- instead of setter methods, use jsp:setProperty tag -->
 
 <jsp:setProperty name="bobj" property="supplierid" value="1001"/>
<jsp:setProperty name="bobj" property="suppliername" value="ARISTA"/>
 
 <!-- instead of getter methods to display, use jsp:getProperty tag -->
<!-- getProperty print the result directly! -->
 
<jsp:getProperty name="bobj" property="supplierid"/>
<jsp:getProperty name="bobj" property="suppliername"/>
