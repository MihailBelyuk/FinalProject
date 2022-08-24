<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${localization}" scope="session"/>
<fmt:setBundle basename="prop.localization"/>

<fmt:message key="admin.logout" var="logout"/>
<fmt:message key="admin.show_all_users" var="show_all_users"/>
<fmt:message key="admin.show_all_items" var="show_all_items"/>
<fmt:message key="admin.add_item" var="add_item"/>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css" type="text/css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body style="background-color: rgba(106,155,55,0.5)">
<nav class="navbar navbar-expand-lg bg-light" style="height: 50px; padding:0">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li style="width: 300px">
                    <form action="${pageContext.request.contextPath}/controller" method="post" style="margin: 0">
                        <input type="hidden" name="command" value="logout"/>
                        <input type="submit" value="logout" style="border: 0">
                    </form>
                </li>
                <li style="width: 300px">
                    <form action="${pageContext.request.contextPath}/controller" style="margin: 0">
                        <input type="hidden" name="command" value="show_all_users"/>
                        <input type="submit" value="${show_all_users}" style="border: 0">
                    </form>
                </li>
                <li style="width: 300px">
                    <form action="${pageContext.request.contextPath}/controller" style="margin: 0">
                        <input type="hidden" name="command" value="show_all_items"/>
                        <input type="submit" value="${show_all_items}" style="border: 0">
                    </form>
                </li>
                <li style="width: 300px">
                    <form action="${pageContext.request.contextPath}/controller" style="margin: 0">
                        <input type="hidden" name="command" value="go_to_add_item_page"/>
                        <input type="submit" value="${add_item}" style="border: 0">
                    </form>
                </li>
            </ul>
        </div>
    </div>
</nav>
</body>
<footer>
    <c:import url="footer.jsp"/>
</footer>
</html>
