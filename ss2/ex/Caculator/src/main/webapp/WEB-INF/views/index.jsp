<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2>Calculator </h2>

<form action="save" method="post">
    <input name="number1" value="number1">
    <input name="number2" value="number2"><br>
    <button type="submit" name="action" value="+">Addition</button>
    <button type="submit" name="action" value="-">Subtraction</button>
    <button type="submit" name="action" value="*">Multiplication</button>
    <button type="submit" name="action" value="/">Division</button>
</form>
<p> division : ${number}</p>
</body>
</html>