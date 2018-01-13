<%@ page pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/view/multilang.jsp" %>
<html lang="${language}">
<head>
    <title><fmt:message key="loginPage"/></title>
</head>
<body>
<form action="/" method="POST">
    <div class="form-group">
        <label for="username"><fmt:message key="username"/>:</label>
        <input type="text" id="username" name="username">
    </div>
    <div class="form-group">
        <label for="password"><fmt:message key="password"/>:</label>
        <input type="password" id="password" name="password">
    </div>
    <fmt:message key="login" var="buttonValue"/>
    <button name="command" value="login" type="submit" class="btn btn-primary"><fmt:message key="login"/></button>
    <button name="command" value="registrationPage" type="submit" class="btn btn-primary"><fmt:message key="registration"/></button>
</form>
</body>
</html>