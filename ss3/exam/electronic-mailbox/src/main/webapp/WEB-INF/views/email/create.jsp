<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023-02-02
  Time: 2:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create</title>
</head>
<body>
<form:form modelAttribute="email" action="add" method="post">
    <h2>Setting</h2>
    Language :
    <form:select path="language">
        <form:option value="english">English</form:option>
        <form:option value="vietnamese">Vietnamese</form:option>
        <form:option value="japanese">Japanese</form:option>
        <form:option value="chinese">Chinese</form:option>
    </form:select><br>

    Page size :
    show 
    <form:select path="pageSize">
        <form:option value="5">5</form:option>
        <form:option value="10">10</form:option>
        <form:option value="15">15</form:option>
        <form:option value="25">25</form:option>
        <form:option value="50">50</form:option>
        <form:option value="100">100</form:option>
        email per page
    </form:select><br>

    Spams filter :
    <form:radiobutton path="spamFilter" value="true"></form:radiobutton>Enable spams filter<br>

    Signature :
    <form:textarea path="signature"></form:textarea><br>

    <form:button>update</form:button>

</form:form>
</body>
</html>
