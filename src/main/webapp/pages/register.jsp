<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
<body style="background-color: rgba(106,155,55,0.5)">
<div >
    <div class="fill_in_register_form_greeting">${greeting}</div>

    <form action="${pageContext.request.contextPath}/controller" class="registration_form" style="background-color: ivory;border-radius: 5px">
        <br>
        <label for="last_name" class="label">${last_name_label}</label>
        <br>
        <input type="text" id="last_name" name="last_name" placeholder="Ivanov" value="${last_name}" class="field"
               pattern="\p{Alpha}{1,45}"/>

        <div class="message">
            <c:out value="${empty_last_name}"/>
            <c:out value="${wrong_input_last_name}"/>
        </div>

        <label for="name" class="label">${name_label}</label>

        <input type="text" id="name" name="name" value="${name}" placeholder="Ivan" class="field"
               pattern="p{Alpha}{1,45}"/>

        <div class="message">
            <c:out value="${empty_name}"/>
            <c:out value="${wrong_input_name}"/>
        </div>

        <label for="password" class="label">${password_label}</label>

        <input type="text" id="password" name="password" value="${password}" placeholder="Ivan321, etc.."
               class="field" pattern=".{5,45}"/>

        <div class="message">
            <c:out value="${empty_password}"/>
            <c:out value="${wrong_input_password}"/>
        </div>

        <label for="e_mail" class="label">${e_mail_label}</label>

        <input type="text" id="e_mail" name="e_mail" value="${e_mail}" placeholder="vanya12@gmail.com, etc.."
               class="field" pattern="^\w{0,14}(\.|\-?)\w{0,14}@\w{3,14}\.\p{Lower}{2,3}$"/>

        <div class="message">
            <c:out value="${empty_email}"/>
            <c:out value="${wrong_input_email}"/>
            <c:out value="${user_exists}"/>
        </div>

        <label for="phone" class="label">${phone_nummber_label}</label>

        <input type="text" id="phone" name="phone_number" value="${phone_number}" placeholder="+375 29 0000000"
               class="field" pattern="^\+\d{2,3}\s\d{2,3}\s\d{7}" style="margin-bottom: 30px"/>

        <div class="message">
            <c:out value="${empty_phone_number}"/>
            <c:out value="${wrong_input_phone_number}"/>
        </div>

        <input type="hidden" name="command" value="register"/>
        <input type="submit" value="${register}" class="register_btn" style="margin-bottom: 20px; border-radius: 5px; height: 50px"/>
        <br>
    </form>
</div>
</body>
<footer>
    <c:import url="footer.jsp"/>
</footer>
</html>
