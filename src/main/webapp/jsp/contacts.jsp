<%--
  Created by IntelliJ IDEA.
  User: SERGE
  Date: 31.08.2014
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>

<ul>
<c:forEach var="contact" items="${contacts}">
    <li><a href="#">${contact.name}</a></li>
</c:forEach>
</ul>
</body>
</html>
