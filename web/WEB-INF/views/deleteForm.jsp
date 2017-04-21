<%--
  Created by IntelliJ IDEA.
  User: Vuclip
  Date: 22/04/17
  Time: 12:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Student</title>
</head>
<body>
    <form action="/delete" method="post">
        <h4>Enter the id which you want to delete</h4>
        <input type="text" name="id"/>
        <input type="submit" value="DELETE"/>
    </form>
</body>
</html>
