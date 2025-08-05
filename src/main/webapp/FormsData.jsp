<body bgcolor="orange">
<!-- implicit objects:: out,request,response,session,config,application(ServletContext),exception -->
<h1>
<%
String a=request.getParameter("a1");
String b=request.getParameter("b1");

String c[]=request.getParameterValues("c1");

out.println("<p>Username & Password :: "+a + " "+b);

for(int i=0;i<c.length;i++)
{
	out.println("<p>Location:: "+c[i]);
}
%>

<p>Username:: <%=a %>
