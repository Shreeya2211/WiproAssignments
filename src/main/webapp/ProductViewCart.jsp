<%@ page import="java.util.*, myservletdemos.Product" %>
<%
    HttpSession session1 = request.getSession(false);
    List<Product> cart = (List<Product>) session1.getAttribute("mycart");
%>

<h2>Cart Contents</h2>

<%
if (cart == null || cart.isEmpty()) {
%>
    <p>Your cart is empty.</p>
<%
} else {
%>
    <table border="1">
        <tr><th>Name</th><th>Quantity</th></tr>
        <%
            for (Product p : cart) {
        %>
            <tr>
                <td><%= p.getName() %></td>
                <td><%= p.getQuantity() %></td>
            </tr>
        <%
            }
        %>
    </table>
<%
}
%>

<a href="ProductCart.html">Back to Product Page</a>
