<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>On The Hook</title>
    <link rel="stylesheet" href="../css/main.css" content="text/css"/>
</head>
<body>
<div class="index_table">
    <div>
        About us
    </div>
    <div>Contacts</div>
    <div>Payment</div>
    <div>Shipping</div>
    <div>Brands</div>
    <div class="submit_btn" title="Login/Register">
        <form action="${pageContext.request.contextPath}/controller" method="post">
            <input type="hidden" name="command" value="open_login_page"/>
            <div class="btn">
            <input type="image" name="login_page_avatar" src="../css/pictures/avatar-default.png"/>
            </div>
        </form>
<%--        <div class="avatar">--%>
<%--            <img src="../css/pictures/avatar-default.png" alt="avatar should be here">--%>
<%--        </div>--%>
    </div>
</div>
<div class="greeting_message">
    <em>THE WORLD OF FISHING</em>
</div>
<%--    ${filter_attribute}--%>
<form action="${pageContext.request.contextPath}/controller">
    <input type="hidden" name="command" value="show_all_users"/>
    <input type="submit" value="show">
</form>
</body>
</html>