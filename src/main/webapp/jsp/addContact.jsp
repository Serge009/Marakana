<%--
  Created by IntelliJ IDEA.
  User: SERGE
  Date: 31.08.2014
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<a href="contacts">Back to contact list</a>
    <form action="contact" method="post">
        <input type="text" name="name" placeholder="Name" />
        <input type="text" name="city" placeholder="City" />
        <input type="text" name="street" placeholder="Street" />
        <input type="text" name="state" placeholder="State" />
        <input type="text" name="zip" placeholder="Zip" />
        <input type="hidden" name="add" />
        <input type="submit" />
    </form>
</body>
</html>
