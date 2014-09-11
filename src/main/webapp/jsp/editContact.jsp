<%--
  Created by IntelliJ IDEA.
  User: SERGE
  Date: 31.08.2014
  Time: 23:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Contact</title>
</head>
<body>
<a href="contacts">Back to contact list</a>
    <form action="contact" method="post">
        <c:set var="address" value="${contact.address}" />
        <input type="text" name="name" placeholder="Name" value="${contact.name}" />
        <input type="text" name="city" placeholder="City" value="${address.city}" />
        <input type="text" name="street" placeholder="Street" value="${address.street}" />
        <input type="text" name="state" placeholder="State" value="${address.state}" />
        <input type="text" name="zip" placeholder="Zip" value="${address.zip}" />
        <input type="hidden" name="edit" />
        <input type="hidden" name="id"  value="${contact.id}" />
        <input type="submit" />
    </form>
</body>
</html>
