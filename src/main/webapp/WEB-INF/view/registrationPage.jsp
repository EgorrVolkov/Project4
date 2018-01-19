<%@ page pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/view/changeLangFragment.jsp" %>
<html lang="${language}">
<head>
    <title><fmt:message key="registrationPage" bundle="${bundle}"/></title>
</head>
<body>
<form action="/" method="POST">
    <div class="form-group">
        <label for="firstName"><fmt:message key="firstName" bundle="${bundle}"/>:</label>
        <input type="text" id="firstName" name="firstName">
    </div>
    <div class="form-group">
        <label for="lastName"><fmt:message key="lastName" bundle="${bundle}"/>:</label>
        <input type="text" id="lastName" name="lastName">
    </div>
    <div class="form-group">
        <label for="login"><fmt:message key="login" bundle="${bundle}"/>:</label>
        <input type="text" id="login" name="login">
    </div>
    <div class="form-group">
        <label for="email">E-mail:</label>
        <input type="text" id="email" name="email">
    </div>
    <div class="form-group">
        <label for="password"><fmt:message key="password" bundle="${bundle}"/>:</label>
        <input type="password" id="password" name="password">
    </div>
    <fmt:message key="signIn" var="buttonValue" bundle="${bundle}"/>
    <button name="command" value="signInPage" type="submit" class="btn btn-primary"><fmt:message key="signIn" bundle="${bundle}"/></button>
    <button name="command" value="registration" type="submit" class="btn btn-primary"><fmt:message key="registration" bundle="${bundle}"/></button>
</form>
</body>
</html>
