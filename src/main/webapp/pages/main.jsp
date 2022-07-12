<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
    <title>On The Hook</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
</head>
<body>
<c:import url="header.jsp"/>
<%--    ${filter_attribute}--%>
<div class="reg_success_message">
    <c:out value="${registration_successful}"/>
</div>
</body>
</html>