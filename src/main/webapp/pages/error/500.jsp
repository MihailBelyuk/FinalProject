
<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error 500</title>
</head>
<body>
request from = ${pageContext.errorData.requestURI}
<hr/>
exception = ${pageContext.exception}
<hr/>
exception = ${pageContext.exception.message}
<hr/>
status = ${pageContext.errorData.statusCode}
<hr/>
servlet name = ${pageContext.errorData.servletName}
<hr/>
<a href="${pageContext.request.contextPath}/index.jsp">BackToIndexPage</a>
</body>
</html>
