<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/15/2023
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user?action=create" method="post">
    <table>
        <tr>
            <th>id</th>
            <td><input type="number" name="id"></td>
        </tr>
        <tr>
            <th>name</th>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <th>country</th>
            <td><input type="text" name="country"></td>
        </tr>
        <tr>
            <th>email</th>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td>
                <button type="submit">Create</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
