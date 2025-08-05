<body bgcolor="lightgreen">

<h1>MVC APPLICATION ( MODEL(STUDENT) + VIEW(JSP) +CONTROLLER (SERVLET) + MYSQL CRUD)</h1>
<%@ page import="myservletdemos.Student" %>
<%
    Student s = (Student) request.getAttribute("student");
    boolean isEdit = (s != null);
%>

<h2><%= isEdit ? "Edit" : "Add" %> Student</h2>

<form action="StudentJDBC_CRUDSERVLET" method="post">
    <input type="hidden" name="action" value="<%= isEdit ? "UPDATE" : "INSERT" %>">
    <% if (isEdit) { %>
        <input type="hidden" name="id" value="<%= s.getId() %>">
    <% } %>
    Name: <input type="text" name="name" value="<%= isEdit ? s.getName() : "" %>"><br>
    Email: <input type="email" name="email" value="<%= isEdit ? s.getEmail() : "" %>"><br>
    <input type="submit" value="<%= isEdit ? "Update" : "Add" %>">
</form>
