<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Customer Save Page</title>
</head>
<body>
    <h2>Customer Save Form</h2>

    <form:form modelAttribute="customer" action="${pageContext.request.contextPath}/cust/save" method="post">

        Name: <form:input path="name"/>
        <form:errors path="name" cssClass="error"/><br/>

        Email: <form:input path="email"/>
        <form:errors path="email" cssClass="error"/><br/>

        Age: <form:input path="age"/>
        <form:errors path="age" cssClass="error"/><br/>

        Gender:
        <form:select path="gender">
            <form:option value="" label="--Select Gender--"/>
            <form:option value="Male"/>
            <form:option value="Female"/>
        </form:select>
        <form:errors path="gender" cssClass="error"/><br/>

        Birthday (MM/dd/yyyy): <form:input path="birthday"/>
        <form:errors path="birthday" cssClass="error"/><br/>

        Phone: <form:input path="phone"/>
        <form:errors path="phone" cssClass="error"/><br/>

        <input type="submit" value="Save Customer"/>

    </form:form>
</body>
</html>
