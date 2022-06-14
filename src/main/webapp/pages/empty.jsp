<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>All users</title>
</head>
<body>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Last name</th>
        <th>Name</th>
        <th>E-mail</th>
        <th>Phone number</th>
        <th>Edit</th>
    </tr>
    </thead>
    <c:forEach var="user" items="${all_users}" >
    <tbody>
        <tr>
            <td>${user.id}</td>
            <td>${user.lastName}</td>
            <td>${user.name}</td>
            <td>${user.eMail}</td>
            <td>${user.phoneNumber}</td>
            <td><input type="button" name="edit" value="edit"></td>
        </tr>
    </tbody>
    </c:forEach>
  </table>
</body>
</html>
