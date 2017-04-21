<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Add New Student</title>
</head>
<body>
<div align="center">
    <h1>New Student</h1>
    <form action="/save" method="post">
        <table>
            <tr>
                <td>Id:</td>
                <td><input type="text" name="id"/></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name"/></td>
            </tr>
            <tr>
                <td>Age:</td>
                <td><input type="text" name="age"/></td>
            </tr>
            <tr>
                <td>Mobile:</td>
                <td><input type="text" name="mobile"/></td>
            </tr>
            <tr>
                <td>DOB:</td>
                <td><input type="text" name="dob"/></td>
            </tr>
            <tr>
                <td>Stream:</td>
                <td><input type="text" name="stream"/></td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
