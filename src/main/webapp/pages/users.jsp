<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>All users</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body style="background-color: rgba(106,155,55,0.5)">
<div id="content">
    <table class="table table-success table-striped" >
        <thead>
        <tr>
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
                        <input type="hidden" name="user_id" value="<c:out value="${user.id}"/>">
                        <input type="submit" name="edit" value="Edit"
                               style="border-width: 0; background-color: rgba(176,255,90,0)"/>
                    </form>
                </td>
                <td>
                    <form action="${pageContext.request.contextPath}/controller">
                        <input type="hidden" name="user_id" value="<c:out value="${user.id}"/>">
                        <input type="hidden" name="command" value="delete_user"/>
                        <input type="submit" name="delete" value="Delete" id="delete_button"
                               style="border-width: 0; background-color: rgba(176,255,90,0)"/>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<footer>
    <c:import url="footer.jsp"/>
</footer>
</html>
