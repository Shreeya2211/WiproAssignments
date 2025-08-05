<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Books List</title></head>
<body>
<h2>Books List</h2>
<a href="book-form.jsp">Add New Book</a><br/><br/>
<table border="1">
    <tr>
        <th>ID</th><th>Title</th><th>Author</th><th>Price</th>
    </tr>
    <c:forEach var="book" items="${listBook}">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.price}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
