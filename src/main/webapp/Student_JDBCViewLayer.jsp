<body bgcolor="lightyellow">
<%@ page import="java.util.*, myservletdemos.Student" %>
<%
    List<Student> list = (List<Student>) request.getAttribute("studentList");
%>
<h2>All Students</h2>
<a href="StudentJDBC_CRUDSERVLET?action=NEW">Add New</a><br><br>
<table border="1">
    <tr><th>ID</th><th>Name</th><th>Email</th><th>Actions</th></tr>
    <% for (Student s : list) { %>
        <tr>
            <td><%= s.getId() %></td>
            <td><%= s.getName() %></td>
            <td><%= s.getEmail() %></td>
            <td>
                <a href="StudentJDBC_CRUDSERVLET?action=EDIT&id=<%= s.getId() %>">Edit</a> |
                <a href="StudentJDBC_CRUDSERVLET?action=DELETE&id=<%= s.getId() %>"
                onclick="return confirm('Are you sure you want to delete <%= s.getName() %> record? ');">Delete</a>
            </td>
        </tr>
    <% } %>
</table>
