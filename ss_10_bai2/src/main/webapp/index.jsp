<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<style>
    form {
        border: 1px solid #000;
        position: relative;
    }
    .title {
        position: absolute;
        top: -26px;
        background-color: #fff;
    }
</style>
<body>
<h1>Simple Calculator</h1>

<form action="/Calculator" method="post">
    <fiedlset>
        <p class="title">
            Calculate
        </p>
        <table style="margin-top: 15px">
            <tr>
                <th>
                    First: <input type="number" name="first">
                </th>
                <th>
                    <select name="phepTinh" id="">
                        <option value="cong">+</option>
                        <option value="tru">-</option>
                        <option value="nhan">*</option>
                        <option value="chia">/</option>
                    </select>
                </th>
                <th>
                    Last: <input type="number" name="last">
                </th>
                <th>
                    <button type="submit">Calculator</button>
                </th>
            </tr>
            <tr style="text-align: left">
                <th style="">
                    Result
                </th>
                <td>
                    ${results}
                </td>
            </tr>

        </table>
    </fiedlset>

</form>

</body>
</html>