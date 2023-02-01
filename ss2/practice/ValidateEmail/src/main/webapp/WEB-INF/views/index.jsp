<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h2>Email Validate</h2>
<p style="color: red">${mess}</p>
<p style="color: red">${mess2}- ${email}</p>

<form action="validate" method="post">
    <label>Nhập email : </label>
    <input name="email" type="text">
    <button type="submit">kiểm tra</button>
</form>
</body>
</html>