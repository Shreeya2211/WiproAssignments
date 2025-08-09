<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
    <h2>User Form</h2>
    <form:form method="post" modelAttribute="user" action="/save">
        Name: <form:input path="name"/> <br/>
        Email: <form:input path="email"/> <br/>
        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>
