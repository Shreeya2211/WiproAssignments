<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Enrollment Form</title>
    <style>
        .error { color: red; }
    </style>
</head>
<body>
<h2>Enrollment Form</h2>
<form:form method="post" modelAttribute="student">
    First Name: <form:input path="firstName"/> <form:errors path="firstName" cssClass="error"/><br/>
    Last Name: <form:input path="lastName"/> <form:errors path="lastName" cssClass="error"/><br/>
    Sex: 
    <form:radiobutton path="sex" value="Male"/>Male
    <form:radiobutton path="sex" value="Female"/>Female
    <form:errors path="sex" cssClass="error"/><br/>
    DOB: <form:input path="dob"/> <form:errors path="dob" cssClass="error"/><br/>
    Email: <form:input path="email"/> <form:errors path="email" cssClass="error"/><br/>
    Section:
    <form:radiobutton path="section" value="Graduate"/>Graduate
    <form:radiobutton path="section" value="Post Graduate"/>Post Graduate
    <form:radiobutton path="section" value="Research"/>Research
    <form:errors path="section" cssClass="error"/><br/>
    Country:
    <form:select path="country">
        <form:option value="">--Select--</form:option>
        <form:option value="INDIA">India</form:option>
        <form:option value="CANADA">Canada</form:option>
        <form:option value="USA">USA</form:option>
    </form:select>
    <form:errors path="country" cssClass="error"/><br/>
    First Attempt? <form:checkbox path="firstAttempt"/><br/>
    Subjects:
    <form:select path="subjects" multiple="true">
        <form:option value="Physics">Physics</form:option>
        <form:option value="Chemistry">Chemistry</form:option>
        <form:option value="Life Science">Life Science</form:option>
        <form:option value="Political Science">Political Science</form:option>
    </form:select>
    <form:errors path="subjects" cssClass="error"/><br/>
    <input type="submit" value="Register"/>
</form:form>
</body>
</html>
