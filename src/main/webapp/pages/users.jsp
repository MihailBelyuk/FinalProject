<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>All users</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <c:import url="header.jsp"/>
</head>
<body>
<div id="content">
    <table>
        <thead>
        <tr style="border-color: #2a2a2a;border-width: 1px; background-color: rgba(240,227,221,0.73)">
            <th>ID</th>
            <th>Role</th>
            <th>Last name</th>
            <th>Name</th>
            <th>E-mail</th>
            <th>Phone number</th>
            <th>Edit user</th>
            <th>Delete user</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${all_users}">
            <tr style="border-color: #2a2a2a;border-width: 1px; background-color: rgba(240,227,221,0.73)">
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
                        <input type="submit" name="delete" value="Delete" id="delete_button"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
