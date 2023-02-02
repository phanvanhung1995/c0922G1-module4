<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2023-02-02
  Time: 10:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Create new info</title>
</head>
<body>
<h3>Welcome, Enter The Employee Details</h3>


<form:form method="post" action="/add" modelAttribute="employee">

    <table>
        <tr>
            <td>
                id :
                <form:input path="id"></form:input>
            </td>
        </tr>
        <tr>
            <td>
                Name :
                <form:input path="name"></form:input>
            </td>
        </tr>
        <tr>
            <td>
                contactNumber :
                <form:input path="contactNumber" ></form:input>
            </td>
        </tr>
        <tr>
            <form:button>submid</form:button>
        </tr>
    </table>
</form:form>

</body>
</html>
