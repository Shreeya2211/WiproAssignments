<!-- 
| Aspect        | EL                                          | JSTL                            |
| ------------- | ------------------------------------------- | ------------------------------- |
| Stands For    | Expression Language                         | JSP Standard Tag Library        |
| Function      | Output data (read only)                     | Control logic and iteration     |
| Used For      | Accessing variables, session, request, etc. | Loops, conditionals, formatting |
| Example       | `${user.name}`                              | `c:if`, `c:forEach`         |
| Dependency    | Built into JSP                              | Requires taglib declaration     |
| Scriptletless | Yes                                         | Yes                             |
 
 Main Reasons to Use JSTL:
1. Avoid Java Code in JSP (Scriptlet-Free)

2.Simplify Loops and Conditions
JSTL provides forEach, if, choose, when, otherwise:

3.Support for Common Tasks
JSTL includes tags for:
Core logic (loops, if-else)
Formatting (dates, numbers)
Internationalization (i18n)
XML processing
SQL (use with caution)

4.MVC Friendly
JSTL + EL encourages separation of concerns:
Java logic → Servlet/Controller
Data access → DAO
View (JSP) → Only display data using JSTL

5.Better Maintenance
Easier for UI developers to understand
No need to understand Java syntax
Less risk of errors or mixing logic with layout


There JSTL mainly provides five types of tags:

Tag Name	Description

Core tags	The JSTL core tag provide variable support, URL management, flow control, etc. The URL for the core tag is http://java.sun.com/jsp/jstl/core. The prefix of core tag is c.
Function tags	The functions tags provide support for string manipulation and string length. The URL for the functions tags is http://java.sun.com/jsp/jstl/functions and prefix is fn.
Formatting tags	The Formatting tags provide support for message formatting, number and date formatting, etc. The URL for the Formatting tags is http://java.sun.com/jsp/jstl/fmt and prefix is fmt.
XML tags	The XML tags provide flow control, transformation, etc. The URL for the XML tags is http://java.sun.com/jsp/jstl/xml and prefix is x.
SQL tags	The JSTL SQL tags provide SQL support. The URL for the SQL tags is http://java.sun.com/jsp/jstl/sql and prefix is sql. 

| Tag Library                            | URI                                      | Prefix Example |
| -------------------------------------- | ---------------------------------------- | -------------- |
| **Core Tags**                          | `http://java.sun.com/jsp/jstl/core`      | `c`            |
| **Formatting**                         | `http://java.sun.com/jsp/jstl/fmt`       | `fmt`          |
| **SQL** (not recommended in real apps) | `http://java.sun.com/jsp/jstl/sql`       | `sql`          |
| **XML**                                | `http://java.sun.com/jsp/jstl/xml`       | `x`            |
| **Functions**                          | `http://java.sun.com/jsp/jstl/functions` | `fn`           |

 -->
    <body bgcolor=lightblue>
   <!-- taglib directive -->
   <%@page isELIgnored="false"%>
  
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="wipro"%>
 
 <%@ taglib prefix="dxc_fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>  
 
   <!-- print the value -->
 <h1><font color=red>
 
  <wipro:out value="Hello JSTL"/>
 
 
  <wipro:set var="Company" value="ZOHO Corporation"/>
 <!-- EL SYNTAX -->
 <wipro:out value="${Company}"/>
 <br>
 
 <!-- for loop -->
 <wipro:forEach var="i" begin="2" end="10" step="2">
 <wipro:out value="${i}"/><br>
  </wipro:forEach>
 
  <!-- The c:when and c:otherwise works like if-else statement. 
  But it must be placed inside c:choose tag. -->
 <h1>JSTL c:when, c:otherwise, c:choose
 <wipro:set value="10" var="num"></wipro:set>  
<wipro:choose>  
<wipro:when test="${num%2==0}">  
<wipro:out value="${num} is even number"></wipro:out>  
</wipro:when>  
<wipro:otherwise>  
<wipro:out value="${num} is odd number"></wipro:out>  
</wipro:otherwise>  
</wipro:choose>  
 
  <!-- JSTL FORMAT TAGS -->
 <wipro:set var="Date_1" value="<%=new java.util.Date()%>" />  
<p>  
Formatted Time :  
<dxc_fmt:formatDate type="time" value="${Date_1}" />  
</p>  
<p>  
Formatted Date :  
<dxc_fmt:formatDate type="date" value="${Date_1}" />  
</p>  
 
 