<%@ page language="java" import="beans.BankAccount" %>
<jsp:useBean id="bank" class="beans.BankAccount" scope="request" />
<jsp:setProperty name="bank" property="*" />

<%
    String accountType = request.getParameter("accountType");
    session.setAttribute("accountType", accountType);
%>

<!DOCTYPE html>
<html>
<head>
    <title>Bank Account Result</title>
</head>
<body>
    <h2>Bank Account Details</h2>
    <p><strong>Account No:</strong> ${bank.accountNo}</p>
    <p><strong>Name:</strong> ${bank.name}</p>
    <p><strong>Balance:</strong> ${bank.balance}</p>
    <p><strong>Account Type:</strong> ${sessionScope.accountType}</p>

    <p>
        <strong>Status:</strong>
        ${bank.balance >= 1000 ? "Sufficient Balance" : "Insufficient Balance"}
    </p>
</body>
</html>
