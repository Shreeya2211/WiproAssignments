<!-- 
JSP ACTION TAGS:

| Tag                                              | Purpose                                                           |
| ------------------------------------------------ | ----------------------------------------------------------------- |
| `jsp:useBean`                                  | Creates or locates a JavaBean                                     |
| `jsp:setProperty`                              | Sets a property value of a JavaBean                               |
| `jsp:getProperty`                              | Retrieves and displays a JavaBean property                        |
| `jsp:include`                                  | Includes another resource (JSP, HTML, etc.) at **runtime**        |
| `jsp:forward`                                  | Forwards the request to another resource                          |
| `jsp:param`                                    | Used inside `jsp:include` or `jsp:forward` to pass parameters |
| `jsp:plugin`                                   | Embeds Java applets (now rarely used)                             |
| `jsp:element`, `jsp:attribute`, `jsp:body` | Used in tag file development (advanced use)                       |


 -->
<!-- jsp:param is a child tag of jsp:forward tag -->
<%
if((request.getParameter("a1")).equals("Shreeya"))
{
%>
<jsp:forward page="For1.jsp">
<jsp:param value="**Welcome Shreeya**" name="user"/>
</jsp:forward>
<%	
}
else
{	
%>
<jsp:forward page="For2.jsp">
<jsp:param value="**Invalid User! Access Denied!**" name="user1"/>
</jsp:forward>
<%	
}
%>
