<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>User update</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    </head>
<body style="background-color: rgba(106,155,55,0.5)">
<form action="${pageContext.request.contextPath}/controller">
    <label for="role">User Role</label>
    <select name="role" id="role" >
        <option value="admin" >ADMIN</option>
        <option value="client" selected>CLIENT</option>
    </select>
    <label for="last_name">Last Name</label>
    <input type="text" id="last_name" name="last_name" value="${last_name}">
    <label for="name">Name</label>
    <input type="text" id="name" name="name" value="${name}">
    <label for="password">Password</label>
    <input type="password" id="password" name="password" value="${password}">
    <label for="e_mail">E-mail</label>
    <input type="text" id="e_mail" name="e_mail" value="${e_mail}">
    <label for="phone_number">Phone Number</label>
    <input type="text" id="phone_number" name="phone_number" value="${phone_number}">
    <input type="hidden" name="command" value="update_user">
    <input type="submit" name="update" value="Update User">
</form>
</body>
<footer>
    <c:import url="footer.jsp"/>
</footer>
</html>
