<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="prop.localization"/>

<fmt:message key="login.greeting" var="greeting"/>
<fmt:message key="login.e_mail" var="e_mail"/>
<fmt:message key="login.password" var="password"/>
<fmt:message key="login.login" var="login"/>
<fmt:message key="login.register" var="register"/>
<fmt:message key="login.forgot_password" var="forgot_password"/>

<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">

    <c:import url="main.jsp"/>
</head>
<body>
<div class="pop">
    <div class="sign_in_msg">${greeting}</div>
    <div class="login_register_block">
        <form action="${pageContext.request.contextPath}/controller">
            <input type="hidden" name="command" value="login"/>
            ${login_msg.toUpperCase()}
            ${invalid_input_message}
            <div class="login_password_input">

                <input type="text" placeholder="${e_mail}" name="e_mail" value=""/>
                <br>
                <input type="password" placeholder="${password}" name="password" value=""/>
                <br>
            </div>
            <input type="submit" name="sub" value="${login}" class="login_button"/>
        </form>
        <form action="${pageContext.request.contextPath}/controller">
            <input type="hidden" name="command" value="open_registry_page"/>
            <input type="submit" name="register_page" value="${register}"/>

            <a href="">${forgot_password}</a>
        </form>
    </div>
</div>
</body>
</html>
