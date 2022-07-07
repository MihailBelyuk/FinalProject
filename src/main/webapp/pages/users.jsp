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
    <tbody>
    <c:forEach var="user" items="${all_users}">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.userRole}"/></td>
            <td><c:out value="${user.lastName}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.eMail}"/></td>
            <td><c:out value="${user.phoneNumber}"/></td>
            <td>
                <form action="${pageContext.request.contextPath}/controller">
                    <input type="hidden" name="command" value="go_to_user_update_page"/>
                    <input type="hidden" name="userId" value="<c:out value="${user.id}"/>">
                    <input type="submit" name="edit" value="Edit"/>
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/controller">
                    <input type="hidden" name="userId" value="<c:out value="${user.id}"/>">
                    <input type="hidden" name="command" value="delete_user"/>
                    <input type="submit" name="delete" value="Delete"/>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>
</body>
</html>
