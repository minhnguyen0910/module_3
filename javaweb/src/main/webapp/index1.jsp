<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/9/2023
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/CalculateDiscountServlet" method="post">
    <table>
        <tr>
            <th>Product Description:</th>
            <td><input type="text"></td>
        </tr>
        <tr>
            <th>List Price:</th>
            <td><input type="number" name="price"></td>
        </tr>
        <tr>
            <th>Discount Percent :</th>
            <td><input type="number" name="percent"></td>
        </tr>
        <tr>
            <th><button type="submit">Calculate Discount</button></th>
        </tr>
    </table>



</form>
</body>
</html>
