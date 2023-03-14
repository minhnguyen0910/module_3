<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<h1>Products</h1>
<p>
    <a href="/product?action=create">Create new customer</a>
</p>
<form action="/product?action=search" method="post">
         <input type="number" name="idSearch">
        <button type="submit">Search</button>
</form>
<table class="table">
    <thread>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
            <th>Image</th>

        </tr>
    </thread>
    <tbody>
    <c:forEach items="${productList}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td><img style="width: 100px" src="${product.image}" alt=""></td>
            <td><a href="/product?action=delete&id=${product.id}">Delete</a></td>
            <td><a href="/product?action=edit&id=${product.id}">Edit</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>
