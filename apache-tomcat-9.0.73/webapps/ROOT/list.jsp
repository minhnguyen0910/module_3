<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/14/2023
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<h1>User</h1>
<a href="/user?action=create">Create new User</a> <br>
<a href="/user?action=sort">Sort By Name</a>
<form action="/user?action=search" method="post">
  <button type="submit">Search</button>
  <input type="text" name="country">
</form>
<table class="table">
  <thread>
    <tr>
      <th>Id</th>
      <th>Name</th>
      <th>Country</th>
      <th>Email</th>
      <th>Delete</th>
      <th>Edit</th>
    </tr>
  </thread>
  <tbody>
  <c:forEach items="${listUser}" var="user">
    <tr>
      <td>${user.id}</td>
      <td>${user.name}</td>
      <td>${user.country}</td>
      <td>${user.email}</td>
      <td><a href="user?action=delete&id=${user.id}">Delete</a></td>
      <td><a href="user?action=edit&id=${user.id}">Edit</a></td>
    </tr>
  </c:forEach>
  </tbody>
  
</table>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</html>
