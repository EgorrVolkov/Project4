<%@ page pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/view/multilang.jsp" %>
<html lang="${language}">
<head>
    <title>Login page</title>
</head>
<body>
<form action="/" method="POST">
    <%--<div><input name="command" value="login" type="hidden"/></div>--%>
    <div class="form-group">
        <label for="username"><fmt:message key="username" />:</label>
        <input type="text" id="username" name="username">
    </div>
    <div class="form-group">
        <label for="password"><fmt:message key="password" />:</label>
        <input type="password" id="password" name="password">
    </div>
    <fmt:message key="logIn" var="buttonValue" />
    <button name="command" value="login" type="submit" class="btn btn-primary"><fmt:message key="logIn"/></button>
    <button name="command" value="registrationPage" type="submit" class="btn btn-primary"><fmt:message key="registration"/></button>
    <%--<a href="/?command=registrationPage" class="btn"><fmt:message key="registration"/></a>--%>
</form>
</body>
</html>