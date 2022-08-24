<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${localization}" scope="session"/>
<fmt:setBundle basename="prop.localization"/>

<fmt:message key="login.greeting" var="greeting"/>
<fmt:message key="login.e_mail" var="e_mail"/>
<fmt:message key="login.password" var="password"/>
<fmt:message key="login.login" var="login"/>
<fmt:message key="login.register" var="register"/>

<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <c:import url="header.jsp"/>
</head>
<body style="background-color: rgba(106,155,55,0.5)">
<div class="pop_login">
    <div class="sign_in_msg">${greeting}</div>
    <div class="login_register_block" style="border-radius: 5px">
        <form action="${pageContext.request.contextPath}/controller" method="post" style="margin: 0">
            <input type="hidden" name="command" value="login"/>
            ${login_msg.toUpperCase()}
            ${invalid_input_message}
            <div class="login_password_input">
                <input type="text" placeholder="${e_mail}" name="e_mail" value=""
                       style="border-top-right-radius: 5px;
                       border-top-left-radius: 5px"/>
                <br>
                <input type="password" placeholder="${password}" name="password" value=""/>
                <br>
            </div>
            <input type="submit" name="sub" value="${login}" class="login_button"/>
        </form>
        <form action="${pageContext.request.contextPath}/controller" method="post">
            <input type="hidden" name="command" value="open_registry_page"/>
            <input type="submit" name="register_page" value="${register}"
                   style="border-width: 0;
                   background-color:dodgerblue;
                   width: 300px;height: 30px;
                   border-bottom-right-radius: 5px;
                   border-bottom-left-radius: 5px; letter-spacing: 3px"/>
        </form>
    </div>
</div>
</body>
<footer>
    <c:import url="footer.jsp"/>
</footer>
</html>
