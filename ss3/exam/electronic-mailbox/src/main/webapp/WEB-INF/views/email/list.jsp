<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023-02-02
  Time: 11:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List email</title>
</head>
<body>
<h2>list email</h2>
<p style="color:red;"> ${mess}</p>
<table>
  <tr>
    <th>Language</th>
    <th>Page Size</th>
    <th>Spam Filter</th>
    <th>Signature</th>
  </tr>

  <tr>
    <td>${language}</td>
    <td>${pageSize}</td>
    <td>${spamFilter}</td>
    <td>${signature}</td>
  </tr>
</table>
</body>
</html>
