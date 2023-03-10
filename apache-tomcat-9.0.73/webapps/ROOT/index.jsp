<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style>
        th{
            text-align: left;
        }
    </style>
</head>
<body>
<h1>Danh sách khách hàng</h1>
<hr>
<table  width="100%" style="font-size: 17px; border-collapse: collapse">
    <tr style="background-color: gray; height: 40px">
        <th>Tên</th>
        <th>Ngày Sinh</th>
        <th>Địa Chỉ</th>
        <th>Ảnh</th>
    </tr>
    <c:forEach items="${listCustomer}" var="customer" varStatus="loop">
        <c:if test="${loop.count%2==0}">
            <tr style="margin-bottom: 15px; background-color: gray">
                <td>${customer.name}</td>
                <td>${customer.dayOfBirth}</td>
                <td>${customer.address}</td>
                <td><img style="width: 100px" src="${customer.picture}" alt=""></td>
            </tr>
        </c:if>
        <c:if test="${loop.count%2!=0}">
            <tr style="margin-bottom: 15px">
                <td>${customer.name}</td>
                <td>${customer.dayOfBirth}</td>
                <td>${customer.address}</td>
                <td><img style="width: 100px" src="${customer.picture}" alt=""></td>
            </tr>
        </c:if>
    </c:forEach>
</table>
</body>
</html>