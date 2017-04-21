<%--
  Created by IntelliJ IDEA.
  User: Vuclip
  Date: 21/04/17
  Time: 11:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Student</title>
</head>
<body>
<h1>New Student</h1>
<form action="/update" method="post">
    <table>
        <tr>
            <td>Id:</td>
            <td><input type="text" name="id" value=${student.getId()} readonly /></td>
        </tr>
        <tr>
            <td>Name:</td>
            <td><input type="text" name="name" value=${student.getName()} /></td>
        </tr>
        <tr>
            <td>Age:</td>
            <td><input type="text" name="age" value=${student.getAge()} /></td>
        </tr>
        <tr>
            <td>Mobile:</td>
            <td><input type="text" name="mobile" value=${student.getMobile()} /></td>
        </tr>
        <tr>
            <td>DOB:</td>
            <td><input type="text" name="dob" value=${student.getDob()} /></td>
        </tr>
        <tr>
            <td>Stream:</td>
            <td><input type="text" name="stream" value=${student.getStream()} /></td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" value="Save"></td>
        </tr>
    </table>
</form>
</body>
</html>
