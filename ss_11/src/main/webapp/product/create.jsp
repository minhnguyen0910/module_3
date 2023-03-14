<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/13/2023
  Time: 10:51 AM
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
        <th>Id</th>
        <th><input type="number" name="id"></th>
    </tr>
    <tr>
        <th>Name</th>
        <td><input type="text" name="name"></td>
    </tr>
    <tr>
        <th>Price</th>
        <td><input type="number" name="price"></td>
    </tr>
    <tr>
        <th>Image</th>
        <td><input type="text" name="image"></td>
    </tr>
    <tr>
        <th>Product Details</th>
        <td><input type="text" name="productDetails"></td>
    </tr>
    <tr>
        <th>
            <button type="submit">Submit</button>
        </th>
    </tr>
</table>
</form>
</body>
</html>
