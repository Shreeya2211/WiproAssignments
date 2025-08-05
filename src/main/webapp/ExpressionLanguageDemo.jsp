
<!--
Expression Language(EL) was added to JSP 2.0 specification. 
The purpose of EL is to 
produce scriptless JSP pages(NO SCRIPTLET,NO DECLARATION,NO EXPRESSION TAG)

EL is used in JSF,SPRING,SPRING BOOT..... 

EL Implicit Objects(only access in EL SYNTAX NOT IN GENERAL JSP!!!!):::::


| Feature                  | **Scriptlets (`% %`)**                               | **Scriptless JSP (EL + JSTL)**                            |
| ------------------------ | ------------------------------------------------------ | --------------------------------------------------------- |
| **Definition**           | Java code inside JSP using `% %`                     | Uses **Expression Language (EL)** `` and **JSTL** tags |
| **Syntax**               | `% out.println(name); %`                             | `${name}` or `c:out value="${name}"`                   |
| **Code Type**            | Embeds Java directly in JSP                            | No Java code, only tags and expressions                   |
| **Example (print name)** | `% String name = "Karpagavalli"; out.print(name); %` | `c:set var="name" value="Karpagavalli"  Hello ${name}` |
| **MVC Compliance**       | ❌ Mixes logic with view (bad separation)               | ✅ Good separation of view and logic                       |
| **Readability**          | ❌ Harder to read for designers                         | ✅ Clean and readable                                      |
| **Maintainability**      | ❌ Difficult to maintain as logic grows                 | ✅ Easier to manage and update                             |
| **Security**             | ❌ Risk of logic misuse in JSP                          | ✅ Safer, only accesses attributes                         |
| **Tooling Support**      | Limited support for debugging/view separation          | Modern tools work better with EL/JSTL                     |
| **Best Practice**        | ❌ Deprecated for modern JSP apps                       | ✅ Recommended by Java EE standards                        |

Implicit Objects in EL

Object	Description

${pageScope}	Page-scoped attributes
${requestScope}	Request-scoped attributes
${sessionScope}	Session-scoped attributes
${applicationScope}	Application-wide attributes
${param}	Request parameters (form/query)
${paramValues}	Multiple values of request parameter
${header}	HTTP headers
${cookie}	Cookies
${initParam}	Context init parameters
 -->
 
 <body bgcolor="yellow" text="red">
<h1>
<!-- EL SYNTAX(cannot work in Scriptlet,declaration,expression tag -->

  <!-- 
Default value of isELIgnored is false(Allows EL)
isELIgnored =true means Not Allows EL
  -->
<%@page isELIgnored="false"%>
 
 
 ${16+124}
 ${"Daemon"}
${54>57}
 
 <!-- EL IMPLICIT OBJECT -->
${header["host"]}
 