
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../css/header.css" content="text/css"/>
</head>
<body>
<div class="header_menu">
    <div>
        About Us
    </div>
    <div>Contacts</div>
    <div>Payment</div>
    <div>Shipping</div>
    <div>Brands</div>
    <div class="submit_btn" title="Login/Register">
        <form action="${pageContext.request.contextPath}/controller" method="post">
            <input type="hidden" name="command" value="open_login_page"/>
            <div class="avatar_btn">
                <input type="image" name="login_page_avatar" src="../css/pictures/avatar-default.png"/>
            </div>
        </form>
        <%--        <div class="avatar">--%>
        <%--            <img src="../css/pictures/avatar-default.png" alt="avatar should be here">--%>
        <%--        </div>--%>
    </div>
</div>

</body>
</html>
