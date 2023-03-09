<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<form action="/CalculateDiscountServlet">
    <table>
        <tr>
            <th>
                Discount Amount:
            </th>
            <td>
                ${amount}
            </td>
        </tr>
        <tr>
            <th>
                Discount Price:
            </th>
            <td>
                ${prices}
            </td>
        </tr>
    </table>
</form>

</body>
</html>