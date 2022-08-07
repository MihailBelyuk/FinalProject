<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>All items</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/items.css">
    <c:import url="header.jsp"/>
</head>
<body>
<table>
    <thead>
    <tr style="border-color: #2a2a2a;border-width: 1px; background-color: rgba(240,227,221,0.73)">
        <th style="width: 100px">ID</th>
        <th style="width: 100px">Category</th>
        <th style="width: 100px">Brand</th>
        <th style="width: 100px">Picture</th>
        <th style="width: 100px">Description</th>
        <th style="width: 100px">Price</th>
        <th style="width: 100px">In stock</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${all_items}">
        <tr style="border-color: #2a2a2a;border-width: 1px; background-color: rgba(240,227,221,0.73)">
            <td style="position: center"><c:out value="${item.id}"/></td>
            <td><c:out value="${item.itemCategory}"/></td>
            <td><c:out value="${item.brandName}"/></td>
            <td><img src="${item.encodedImage}" alt=""></td>
            <td><c:out value="${item.name}"/></td>
            <td><c:out value="${item.price}"/></td>
            <td><c:out value="${item.inStock}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
