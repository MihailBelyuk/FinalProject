<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${localization}" scope="session"/>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <c:import url="header.jsp"/>
</head>
<body>
<div class="pop_register">
<div class="fill_in_register_form_greeting">${greeting}</div>

<form action="${pageContext.request.contextPath}/controller" class="registration_form">
    <br>
    <label for="last_name" class="label">${last_name_label}</label>
    <br>

    <input type="text" id="last_name" name="last_name" placeholder="Ivanov" value="${last_name}" class="field"/>
    <br>
    <div class="message">
        <c:if test="${last_name.equals('')}">
            <c:out value="Last name field must not be empty."/>
        </c:if>
    </div>
    <br>
    <label for="name" class="label">${name_label}</label>
    <br>
    <input type="text" id="name" name="name" value="${name}" placeholder="Ivan" class="field"/>
    <br>
    <div class="message">
        <c:if test="${name.equals('')}">
            <c:out value="Name field must not be empty."/>
        </c:if>
    </div>
    <br>
    <label for="password" class="label">${password_label}</label>
    <br>
    <input type="text" id="password" name="password" value="${password}" placeholder="Ivan321, etc.." class="field"/>
    <br>
    <div class="message">
        <c:if test="${password.equals('')}">
            <c:out value="Password field must not be empty."/>
        </c:if>
    </div>
    <br>
    <label for="e_mail" class="label">${e_mail_label}</label>
    <br>
    <input type="text" id="e_mail" name="e_mail" value="${e_mail}" placeholder="vanya12@gmail.com, etc.." class="field"/>
    <br>
    <div class="message">
        <c:if test="${e_mail.equals('')}">
            <c:out value="E-mail field must not be empty."/>
        </c:if>
    </div>
    <br>
    <label for="phone" class="label">${phone_nummber_label}</label>
    <br>
    <input type="text" id="phone" name="phone_number" value="${phone_number}" placeholder="375290000000" class="field"/>
    <br>
    <div class="message">
        <c:if test="${phone_number.equals('')}">
            <c:out value="Phone number field must not be empty."/>
        </c:if>
    </div>
    <br>
    <input type="hidden" name="command" value="register"/>
    <input type="submit" value="${register}" class="register_btn"/>
    <br>
   </form>
</div>
</body>
</html>
