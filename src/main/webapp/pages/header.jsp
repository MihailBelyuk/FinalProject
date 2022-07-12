<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${localization}" scope="session"/>
<fmt:setBundle basename="prop.localization"/>

<fmt:message key="header.about_us" var="about_us" />
<fmt:message key="header.contacts" var="contacts"/>
<fmt:message key="header.payment" var="payment"/>
<fmt:message key="header.shipping" var="shipping"/>
<fmt:message key="header.brands" var="brands"/>
<fmt:message key="header.login_register" var="login_register"/>




<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css"/>
</head>
<body>
<div class="header_menu">
    <div>
        ${about_us}
    </div>
    <div>${contacts}</div>
    <div>${payment}</div>
    <div>${shipping}</div>
    <div>${brands}</div>
    <div class="submit_btn">
        <form action="${pageContext.request.contextPath}/controller" method="post">
            <input type="hidden" name="command" value="open_login_page"/>
            <div class="avatar_btn">
                <input type="image" title="${login_register}" name="login_page_avatar"
                       src="${pageContext.request.contextPath}/css/pictures/avatar-default.png"/>
            </div>
        </form>
    </div>
    <div class="logged_user">
        <a href="${pageContext.request.contextPath}/controller?command=logout">${logged_user}</a>
    </div>
</div>
<div class="lang">
    <form action="${pageContext.request.contextPath}/controller" >
        <input type="hidden" name="command" value="change_locale">
        <input type="hidden" name="locale_param" value="ru">
        <input type="submit" value="РУ">
    </form>
    <form action="${pageContext.request.contextPath}/controller">
        <input type="hidden" name="command" value="change_locale">
        <input type="hidden" name="locale_param" value="en">
        <input type="submit" value="EN">
    </form>
</div>

</body>
</html>
