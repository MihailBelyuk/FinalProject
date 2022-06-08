<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="../css/login_style.css" type="text/css">
</head>
<body>
<div class="login_window_background"></div>
<div class="login_form">
    <form action="${pageContext.request.contextPath}/controller">
        <input type="hidden" name="command" value="login"/>
        ${login_msg.toUpperCase()}
        ${invalid_input_message}
        <p>SIGN IN</p>
        <div class="login">
            <p>
                <input type="text" placeholder="LOGIN" name="e_mail" value=""/>
            </p>
        </div>
        <div class="login">
            <p>
                <input type="password" placeholder="PASSWORD" name="password" value=""/>
            </p>
        </div>

        <div class="login_btn">
            <input type="submit" name="sub" value="LOGIN" class="login_button"/>
        </div>
    </form>

    <form action="${pageContext.request.contextPath}/controller">
        <div class="register_btn">
            <input type="hidden" name="command" value="open_registry_page"/>
            <input type="submit" name="register_page" value="REGISTER"/>
            <a href="">Forgot your password?</a>
        </div>
    </form>
</div>
</body>
</html>
