<%@ page pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/view/changeLangFragment.jsp" %>
<html lang="${language}">
<head>
    <title><fmt:message key="loginPage" bundle="${bundle}"/></title>
</head>
<body>
<form action="/" method="POST">
    <div class="form-group">
        <label for="username"><fmt:message key="nickname" bundle="${bundle}"/>:</label>
        <input type="text" id="username" name="username">
    </div>
    <div class="form-group">
        <label for="password"><fmt:message key="password" bundle="${bundle}"/>:</label>
        <input type="password" id="password" name="password">
    </div>
    <fmt:message key="login" var="buttonValue" bundle="${bundle}"/>
    <button name="command" value="login" type="submit" class="btn btn-primary"><fmt:message key="login" bundle="${bundle}"/></button>
    <button name="command" value="registrationPage" type="submit" class="btn btn-primary"><fmt:message key="registration" bundle="${bundle}"/></button>
</form>
</body>
</html>