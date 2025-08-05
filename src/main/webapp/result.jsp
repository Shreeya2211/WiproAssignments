<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Submission Result</title>
</head>
<body>
    <h2>Submitted User Information</h2>
    <p><strong>User Name:</strong> ${username}</p>
    <p><strong>Address:</strong> ${address}</p>
    <p><strong>Gender:</strong> ${gender}</p>
    <p><strong>Subscribed:</strong> ${subscribe}</p>
    <p><strong>Favorite Number:</strong> ${favoriteNumber}</p>

    <p><strong>Favorite Frameworks:</strong></p>
    <ul>
        <c:forEach var="fw" items="${frameworks}">
            <li>${fw}</li>
        </c:forEach>
    </ul>
</body>
</html>
