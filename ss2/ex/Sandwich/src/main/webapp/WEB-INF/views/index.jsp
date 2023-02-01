<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2>sandwich condiment</h2>

<form action="/save" method="post">
    <input type=checkbox value=”lettuce” name="condiment">lettuce <br>
    <input type=checkbox value=”tomato” name="condiment">tomato <br>
    <input type=checkbox value=”mustard” name="condiment">mustard <br>
    <input type=checkbox value=”sprouts” name="condiment">sprouts <br>
    <button type="submit">Save</button>
</form>

<p>List Condiment : </p>
<c:forEach var="con" items="${condiment}">
    <table>
        <tr>
            <td>${con.toString()}</td>
        </tr>
    </table>
</c:forEach>
</body>
</html>