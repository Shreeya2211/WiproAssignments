<!DOCTYPE html>
<html>
<head>
    <title>Enter Product Details</title>
</head>
<body>
    <h2>Product Entry Form</h2>
    <form action="ProductResult4.jsp" method="post">
        Product ID: <input type="text" name="productId" required><br><br>
        Name: <input type="text" name="name" required><br><br>
        Price: <input type="number" step="0.01" name="price" required><br><br>
        Quantity: <input type="number" name="quantity" required><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
