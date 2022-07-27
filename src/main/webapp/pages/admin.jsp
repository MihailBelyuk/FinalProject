<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
</head>
<body>

<form action="${pageContext.request.contextPath}/controller">
    <input type="hidden" name="command" value="show_all_users"/>
    <input type="submit" value="Show all users">
</form>
<form action="${pageContext.request.contextPath}/controller">
    <input type="hidden" name="command" value="show_all_items"/>
    <input type="submit" value="Show all items">
</form>
<form action="${pageContext.request.contextPath}/controller">
    <input type="hidden" name="command" value="go_to_add_item_page"/>
    <input type="submit" value="Add item">
</form>


</body>
</html>
