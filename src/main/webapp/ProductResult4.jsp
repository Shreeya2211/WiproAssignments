<%@ page language="java" import="beans.Product4" %>
<jsp:useBean id="product" class="beans.Product4" scope="request" />
<jsp:setProperty name="product" property="*" />

<!DOCTYPE html>
<html>
<head>
    <title>Product Details</title>
</head>
<body>
    <h2>Product Details Entered</h2>
    <p><strong>Product ID:</strong> <jsp:getProperty name="product" property="productId" /></p>
    <p><strong>Name:</strong> <jsp:getProperty name="product" property="name" /></p>
    <p><strong>Price:</strong> $<jsp:getProperty name="product" property="price" /></p>
    <p><strong>Quantity:</strong> <jsp:getProperty name="product" property="quantity" /></p>
</body>
</html>
