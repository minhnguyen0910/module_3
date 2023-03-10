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
    Product Description: <input type="text"> <br>
    List Price: <input type="number" name="price"> <br>
    Discount Percent : <input type="number" name="percent">
    <button type="submit" name="submit">Calculate Discount</button>

</form>
</body>
</html>
