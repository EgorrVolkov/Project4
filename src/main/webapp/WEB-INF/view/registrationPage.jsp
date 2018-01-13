<%@ page pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/view/multilang.jsp" %>
<html lang="${language}">
<head>
    <title><fmt:message key="registrationPage"/></title>
</head>
<body>
<form action="/" method="POST">
    <div class="form-group">
        <label for="firstName"><fmt:message key="firstName"/>:</label>
        <input type="text" id="firstName" name="firstName">
    </div>
    <div class="form-group">
        <label for="secondName"><fmt:message key="secondName"/>:</label>
        <input type="text" id="secondName" name="secondName">
    </div>
    <div class="form-group">
        <label for="username"><fmt:message key="username"/>:</label>
        <input type="text" id="username" name="username">
    </div>
    <div class="form-group">
        <label for="email">E-mail:</label>
        <input type="text" id="email" name="email">
    </div>
    <div class="form-group">
        <label for="password"><fmt:message key="password"/>:</label>
        <input type="password" id="password" name="password">
    </div>
    <fmt:message key="login" var="buttonValue"/>
    <button name="command" value="loginPage" type="submit" class="btn btn-primary"><fmt:message key="login"/></button>
    <button name="command" value="registration" type="submit" class="btn btn-primary"><fmt:message key="registration"/></button>
</form>
</body>
</html>
