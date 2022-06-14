<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RegisterPage</title>
    <link rel="stylesheet" href="../css/register_style.css">
</head>
<c:import url="main.jsp"/>
<form action="${pageContext.request.contextPath}/controller">

    <%--    Id: <input type="text" name="id" value=""/>--%>
    <%--    <hr/>--%>
    <div class="register_window">
        <div class="register_input">
<%--            <label for="status">Status</label>--%>
<%--            <br>--%>
<%--            <select name="status" id="status">--%>
<%--                <option value="admin">Admin</option>--%>
<%--                <option value="client">Client</option>--%>
<%--            </select>--%>
            <br>
            <label for="last_name">Last name</label>
            <br>
            <input type="text" id="last_name" name="last_name" value=""/>
            <br>
            <label for="name">Name</label>
            <br>
            <input type="text" id="name" name="name" value="" style=""/>
            <br>
            <label for="password">Password</label>
            <br>
            <input type="text" id="password" name="password" value=""/>
            <br>
            <label for="e_mail">E-Mail</label>
            <br>
            <input type="text" id="e_mail" name="e_mail" value=""/>
            <br>
            <label for="phone">Phone number</label>
            <br>
            <input type="text" id="phone" name="phone_number" value=""/>
            <br>
        </div>
        <input type="hidden" name="command" value="register"/>
        <input type="submit" value="Register new user"/>
        <br>

    </div>
</form>
</body>
</html>
