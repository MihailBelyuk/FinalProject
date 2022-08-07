<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${localization}" scope="session"/>
<fmt:setBundle basename="prop.localization"/>

<fmt:message key="admin.logout" var="logout"/>
<fmt:message key="admin.show_all_users" var="show_all_users"/>
<fmt:message key="admin.show_all_items" var="show_all_items"/>
<fmt:message key="admin.add_item" var="add_item"/>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
</head>
<body>
<form action="${pageContext.request.contextPath}/controller" method="post">
    <input type="hidden" name="command" value="logout"/>
    <input type="submit" value="logout">
</form>
<p>
<form action="${pageContext.request.contextPath}/controller">
    <input type="hidden" name="command" value="show_all_users"/>
    <input type="submit" value="${show_all_users}">
</form>
<form action="${pageContext.request.contextPath}/controller">
    <input type="hidden" name="command" value="show_all_items"/>
    <input type="submit" value="${show_all_items}">
</form>
<form action="${pageContext.request.contextPath}/controller">
    <input type="hidden" name="command" value="go_to_add_item_page"/>
<<<<<<< HEAD
    <input type="submit" value="${add_item}">
</form>
<footer style="padding-top: 600px">
    <c:import url="footer.jsp"/>
</footer>
=======
    <input type="submit" value="Add item">
</form>

>>>>>>> 07c9f1c70dc4b005c9f0e708c0d7104fc4b3aea2

</body>
</html>
