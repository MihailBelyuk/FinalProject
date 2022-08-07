<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Cart</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
</head>
<body>
<c:out value="${empty_cart}"/>

<table style="background-color: rgba(177,158,90,0.68)">
    <tbody style="border-color: #2a2a2a;border-width: 1px; background-color: rgba(240,227,221,0.73)">
    <c:forEach var="item" items="${items_in_cart}">
        <tr>
            <td><img src="${item.encodedImage}" alt="" style="width: 150px;height: 150px"></td>
            <td><c:out value="${item.name}"/></td>
            <td><c:out value="${item.price}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
