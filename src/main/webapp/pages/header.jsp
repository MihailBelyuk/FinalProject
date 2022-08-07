<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<fmt:setLocale value="${localization}" scope="session"/>
<fmt:setBundle basename="prop.localization"/>

<fmt:message key="header.search" var="search"/>
<fmt:message key="header.home" var="home"/>
<fmt:message key="header.about_us" var="about_us"/>
<fmt:message key="header.contacts" var="contacts"/>
<fmt:message key="header.payment" var="payment"/>
<fmt:message key="header.shipping" var="shipping"/>
<fmt:message key="header.brands" var="brands"/>
<fmt:message key="header.login_register" var="login_register"/>
<fmt:message key="header.change_language" var="change_language"/>


<html>
<head>
    <title>Bootstrap Example</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.2/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body class="p-3 m-0 border-0 bd-example">
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page"
                       href="${pageContext.request.contextPath}/controller?command=go_to_main_page">${home}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">${about_us}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">${contacts}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">${payment}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">${shipping}</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">${brands}</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown"
                       aria-expanded="false">
                        ${change_language}
                    </a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#">
                            <form action="${pageContext.request.contextPath}/controller">
                                <input type="hidden" name="command" value="change_locale">
                                <input type="hidden" name="locale_param" value="ru">
                                <input type="submit" value="РУ">
                            </form>
                        </a></li>
                        <li><a class="dropdown-item" href="#">
                            <form action="${pageContext.request.contextPath}/controller">
                                <input type="hidden" name="command" value="change_locale">
                                <input type="hidden" name="locale_param" value="en">
                                <input type="submit" value="EN">
                            </form>
                        </a></li>
                    </ul>
                </li>
                <li>
                    <div class="submit_btn">
                        <form action="${pageContext.request.contextPath}/controller" method="post">
                            <input type="hidden" name="command" value="open_login_page"/>
                            <div class="avatar_btn">
                                <input type="image" title="${login_register}" name="login_page_avatar"
                                       src="${pageContext.request.contextPath}/css/pictures/avatar-default.png"
                                       style="height: 40px;margin-top: 2px">
                            </div>
                        </form>
                    </div>
                </li>
                <li class="nav-item" style="margin-top: 10px; margin-left: 5px">
                    <a href="${pageContext.request.contextPath}/controller?command=go_to_logged_user_page">${logged_user}</a>
                </li>
            </ul>
            <form class="d-flex" role="search" action="${pageContext.request.contextPath}/controller">
                <input type="hidden" name="command" value="search_item">
                <input class="form-control me-2" type="search" placeholder="${search}" aria-label="Search" name="search">
                <button class="btn btn-outline-success" type="submit">${search}</button>
            </form>
        </div>
    </div>
</nav>
</body>
</html>
