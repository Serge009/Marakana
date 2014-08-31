<%--
  Created by IntelliJ IDEA.
  User: SERGE
  Date: 31.08.2014
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>


<c:forEach var="name" items="${names}">
    <h1>Hello, ${name}!</h1>
</c:forEach>
</body>
</html>
