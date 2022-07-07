<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
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
</html>
