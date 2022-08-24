<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<html>
<head>
    <title>On The Hook</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
    <c:import url="header.jsp"/>
</head>
<body style="background-color: rgba(106,155,55,0.5)">
<div class="reg_success_message">
    <c:out value="${registration_successful}"/>
    <c:out value="${no_matching_items}"/>
</div>
<table style="margin:20px 20px 20px 20px">
    <tbody style="border: 5px #2a2a2a;">
    <c:forEach var="item" items="${search_items}">
        <tr style="border-color: #2a2a2a;border-width: 1px; background-color: rgba(240,227,221,0.73)">
            <td><img src="${item.encodedImage}" alt="" style="width: 150px;height: 150px"></td>
            <td><c:out value="${item.name}"/></td>
            <td style="width: 800px"><c:out value="${item.description}"/></td>
            <td><c:out value="${item.price}"/></td>
            <td>
                <c:if test="${item.inStock }">
                    <c:out value="In Stock"/>
                </c:if>
                <c:if test="${!item.inStock}">
                    <c:out value="Out of stock"/>
                </c:if>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/controller" method="post">
                    <input type="hidden" name="command" value="add_to_cart"/>
                    <input type="hidden" name="item_name" value="<c:out value="${item.name}"/>">
                    <input type="submit" name="sub" value="Add to cart"/>
                </form>
            </td>
        </tr>

    </c:forEach>
    <c:out value="${out_of_stock}"/>
    </tbody>
</table>
</body>
<footer>
    <c:import url="footer.jsp"/>
</footer>
</html>