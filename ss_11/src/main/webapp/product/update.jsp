<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/14/2023
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="product?action=edit" method="post">
    <table>
        <tr>
            <th>Id</th>
            <th><input type="number" name="id" value="${product.id}"></th>
        </tr>
        <tr>
            <th>Name</th>
            <td><input type="text" name="name" value="${product.name}"></td>
        </tr>
        <tr>
            <th>Price</th>
            <td><input type="number" name="price" value="${product.price}"></td>
        </tr>
        <tr>
            <th>Image</th>
            <td><input type="text" name="image" value="${product.image}"></td>
        </tr>
        <tr>
            <th>Product Details</th>
            <td><input type="text" name="productDetails" value="${product.productDetails}"></td>
        </tr>
        <tr>
            <th>
                Producer
            </th>
            <td>
                <input type="text" name="producer" value="${product.producer}">
            </td>
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
