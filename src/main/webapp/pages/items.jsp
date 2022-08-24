<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>All items</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/items.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body style="background-color: rgba(106,155,55,0.5)">
<a href="${pageContext.request.contextPath}/controller?command=go_to_add_item_page" style="margin: 20px 20px 20px 20px;background-color: chartreuse">ADD ITEM</a>
<table class="table table-success table-striped" >
    <thead>
    <tr>
        <th>ID</th>
        <th>Category</th>
        <th>Brand</th>
        <th>Picture</th>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
        <th>In stock</th>
        <th>Edit</th>
        <th>Delete item</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${all_items}">
        <tr>
            <td><c:out value="${item.id}"/></td>
            <td><c:out value="${item.itemCategory}"/></td>
            <td><c:out value="${item.brandName}"/></td>
            <td><img src="${item.encodedImage}" alt=""></td>
            <td><c:out value="${item.name}"/></td>
            <td>
                <textarea name="description" id="description" cols="80" rows="10"
                          style="font-size: 10px; border-width: 0; background-color: rgba(176,255,90,0)">
                    <c:out value="${item.description}"/>
                </textarea>
            </td>
            <td><c:out value="${item.price}"/></td>
            <td><c:out value="${item.inStock}"/></td>
            <td>
                <form action="${pageContext.request.contextPath}/controller">
                    <input type="hidden" name="command" value="go_to_item_update_page"/>
                    <input type="hidden" name="item_id" value="<c:out value="${item.id}"/>">
                    <input type="submit" name="edit" value="Edit"
                           style="border-width: 0; background-color: rgba(176,255,90,0)"/>
                </form>
            </td>
            <td>
                <form action="${pageContext.request.contextPath}/controller">
                    <input type="hidden" name="item_id" value="<c:out value="${item.id}"/>">
                    <input type="hidden" name="command" value="delete_item"/>
                    <input type="submit" name="delete" value="Delete" id="delete_button"
                           style="border-width: 0; background-color: rgba(176,255,90,0)"/>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
<footer>
    <c:import url="footer.jsp"/>
</footer>
</html>
