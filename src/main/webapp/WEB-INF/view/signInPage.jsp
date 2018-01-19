<%@ page pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/view/changeLangFragment.jsp" %>
<html lang="${language}">
<head>
    <title><fmt:message key="signInPage" bundle="${bundle}"/></title>
</head>
<body>
<form action="/" method="POST">
    <div class="form-group">
        <label for="login"><fmt:message key="login" bundle="${bundle}"/>:</label>
        <input type="text" id="login" name="login">
    </div>
    <div class="form-group">
        <label for="password"><fmt:message key="password" bundle="${bundle}"/>:</label>
        <input type="password" id="password" name="password">
    </div>
    <button name="command" value="signIn" type="submit" class="btn btn-primary"><fmt:message key="signIn" bundle="${bundle}"/></button>
    <button name="command" value="registrationPage" type="submit" class="btn btn-primary"><fmt:message key="registration" bundle="${bundle}"/></button>
</form>
</body>
</html>