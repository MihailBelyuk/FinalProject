<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${localization}" scope="session"/>
<fmt:setBundle basename="prop.localization"/>

<fmt:message key="client.logout" var="logout"/>
<html>
<head>
    <title>Client Room</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
</head>
<body style="background-color: rgba(106,155,55,0.5)">
<div>
        <a href="${pageContext.request.contextPath}/controller?command=logout"> ${logout}</a>
</div>
</body>
<footer>
    <c:import url="footer.jsp"/>
</footer>
</html>
