
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
    <title>${contact.name}</title>
</head>
<body>
        <c:set var="address" value="${contact.address}" />
        <h1>${contact.name}</h1>
        <ul>
            <li>${address.street}</li>
            <li>${address.city}, ${address.state} ${address.zip}</li>
        </ul>
        <a href="contact?edit&id=${contact.id}">Edit contact</a>
        <a href="contact?delete&id=${contact.id}">Delete contact</a>
        <a href="contacts">Back to contact list</a>
</body>
</html>
