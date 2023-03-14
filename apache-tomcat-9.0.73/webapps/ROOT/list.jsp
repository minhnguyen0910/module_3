<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 3/14/2023
  Time: 8:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
  <thread>
    <tr>
      <th>Id</th>
      <th>Name</th>
      <th>Country</th>
    </tr>
  </thread>
  <tbody>
  <c:forEach items="" var="user">
    <tr>
      <td>${listUser.id}</td>
      <td>${listUser.name}</td>
      <td>${listUser.country}</td>
    </tr>
  </c:forEach>
  </tbody>
  
</table>
</body>
</html>
