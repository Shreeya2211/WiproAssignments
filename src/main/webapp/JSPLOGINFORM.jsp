<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
</head>
<body>
    <h2>User Registration</h2>
    <form action="register" method="post">
        <table>
            <tr>
                <td>Full name:</td>
                <td><input type="text" name="fullname" required /></td>
            </tr>
            <tr>
                <td>E-mail:</td>
                <td><input type="email" name="email" required /></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="password" required /></td>
            </tr>
            <tr>
                <td>Birthday (yyyy-mm-dd):</td>
                <td><input type="date" name="dob" required /></td>
            </tr>
            <tr>
                <td>Gender:</td>
                <td>
                    <input type="radio" name="gender" value="Male" /> Male
                    <input type="radio" name="gender" value="Female" /> Female
                </td>
            </tr>
            <tr>
                <td>Profession:</td>
                <td>
                    <select name="profession">
                        <option>Developer</option>
                        <option>Designer</option>
                        <option>Manager</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>Married?</td>
                <td><input type="checkbox" name="married" /></td>
            </tr>
            <tr>
                <td>Note:</td>
                <td><textarea name="note" rows="4" cols="30"></textarea></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Register" /></td>
            </tr>
        </table>
    </form>
</body>
</html>
