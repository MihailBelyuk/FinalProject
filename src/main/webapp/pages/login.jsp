<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="../css/login.css">
</head>
<body>
<c:import url="main.jsp"/>
<div class="sign_in_msg"><p>SIGN IN</p></div>
<div class="login_register_block">
    <form action="${pageContext.request.contextPath}/controller">
        <input type="hidden" name="command" value="login"/>
        ${login_msg.toUpperCase()}
        ${invalid_input_message}
        <div class="login_password_input">

            <input type="text" placeholder="LOGIN" name="e_mail" value=""/>
            <br>
            <input type="password" placeholder="PASSWORD" name="password" value=""/>
            <br>
        </div>
        <input type="submit" name="sub" value="LOGIN" class="login_button"/>
    </form>
    <form action="${pageContext.request.contextPath}/controller">
        <input type="hidden" name="command" value="open_registry_page"/>
        <input type="submit" name="register_page" value="REGISTER"/>
        <a href="">Forgot your password?</a>
    </form>
</div>
</body>
</html>
