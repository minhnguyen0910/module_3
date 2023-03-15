<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/15/2023
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <table>
        <tr>
            <td>ID</td>
            <td><input type="number" name="id" value="${user.id}"></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="${user.name}"></td>
        </tr>
        <tr>
            <td>Email</td>
            <td><input type="text" name="email" value="${user.email}"></td>
        </tr>
        <tr>
            <td>Country</td>
            <td><input type="text" name="country" value="${user.country}"></td>
        </tr>
        <tr>
            <th><button type="submit">Edit</button></th>
        </tr>
    </table>
</form>
</body>
</html>
