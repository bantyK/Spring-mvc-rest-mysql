<%--
  Created by IntelliJ IDEA.
  User: Vuclip
  Date: 20/04/17
  Time: 6:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add New Student</title>
</head>
<body>
    <form action="/add/student" method="post">

        <p>ID :<input type="text" name="id"/></p>
        <p>NAME :<input type="text" name="name"/></p>
        <p>AGE :<input type="text" name="age"/></p>
        <p>MOBILE :<input type="text" name="mobile"/></p>
        <p>DOB :<input type="text" name="dob"/></p>
        <p>STREAM :<input type="text" name="stream"/></p>

        <p><input type="submit" value="SUBMIT"/></p>
    </form>
</body>
</html>
