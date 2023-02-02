<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2>list employee</h2>

<p style="color: red">${mess}</p>

<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>contactNumber</th>
    </tr>

    <tr>
        <td>${id}</td>
        <td>${name}</td>
        <td>${contactNumber}</td>
    </tr>
</table>
</body>
</html>