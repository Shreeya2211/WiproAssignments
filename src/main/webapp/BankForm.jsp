<!DOCTYPE html>
<html>
<head>
    <title>Bank Account Form</title>
</head>
<body>
    <h2>Enter Bank Account Details</h2>
    <form action="BankResult.jsp" method="post">
        Account No: <input type="text" name="accountNo" required><br><br>
        Name: <input type="text" name="name" required><br><br>
        Balance: <input type="number" name="balance" step="0.01" required><br><br>
        Account Type:
        <select name="accountType">
            <option value="Savings">Savings</option>
            <option value="Current">Current</option>
        </select><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
