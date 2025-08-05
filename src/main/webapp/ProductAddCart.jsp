<!-- JSP + Session + useBean -->

<%@ page import="java.util.*,myservletdemos.Product" %>

<jsp:useBean id="product" class="myservletdemos.Product" scope="page" />

<jsp:setProperty name="product" property="*" />

<%
    HttpSession session1 = request.getSession();
    List<Product> cart = (List<Product>) session1.getAttribute("mycart");

    if (cart == null) {
        cart = new ArrayList<>();
    }

    cart.add(product);
    session1.setAttribute("mycart", cart);//mycart is a session variable
%>

<p>Product added to cart!</p>

<a href="ProductCart.html">Add Another</a><br>

<a href="ProductViewCart.jsp">View Cart</a>
