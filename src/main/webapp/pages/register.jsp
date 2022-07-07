<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${locale}" scope="session"/>
<fmt:setBundle basename="prop.localization"/>

<fmt:message key="register.greeting" var="greeting"/>
<fmt:message key="register.last_name" var="last_name_label"/>
<fmt:message key="register.name" var="name_label"/>
<fmt:message key="register.password" var="password_label"/>
<fmt:message key="register.e_mail" var="e_mail_label"/>
<fmt:message key="register.phone_number" var="phone_nummber_label"/>
<fmt:message key="register.register" var="register"/>

<html>
<head>
    <title>RegisterPage</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register_style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <c:import url="header.jsp"/>
</head>
<body>
<div class="fill_in_register_form">${greeting}</div>
<form action="${pageContext.request.contextPath}/controller" class="registration_form">
    <br>
    <label for="last_name" class="label">${last_name_label}</label>
    <br>
    <input type="text" id="last_name" name="last_name" value="${last_name}" class="field"/>
    <br>
    <div class="message"> ${empty_last_name_field}</div>
    <br>
    <label for="name" class="label">${name_label}</label>
    <br>
    <input type="text" id="name" name="name" value="${name}" class="field"/>
    <br>
    <div class="message"> ${empty_name_field}</div>
    <br>
    <label for="password" class="label">${password_label}</label>
    <br>
    <input type="text" id="password" name="password" value="${password}" class="field"/>
    <br>
    <div class="message"> ${empty_password_field}</div>
    <br>
    <label for="e_mail" class="label">${e_mail_label}</label>
    <br>
    <input type="text" id="e_mail" name="e_mail" value="${e_mail}" class="field"/>
    <br>
    <div class="message"> ${empty_email_field}</div>
    <br>
    <label for="phone" class="label">${phone_nummber_label}</label>
    <br>
    <input type="text" id="phone" name="phone_number" value="${phone_number}" class="field"/>
    <br>
    <div class="message"> ${empty_phone_number_field}</div>
    <hr>
    <input type="hidden" name="command" value="register"/>
    <input type="submit" value="${register}" class="register_btn"/>
    <br>
</form>
</body>
</html>
