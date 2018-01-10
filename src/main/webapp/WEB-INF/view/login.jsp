<%@ page pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/view/multilang.jsp" %>
<html lang="${language}">
<head>
    <title>Login page</title>
</head>
<body>
<form action="/" method="POST">
    <div><input name="command321" value="login123" type="hidden"/></div>
    <div class="form-group">
        <label for="username"><fmt:message key="username" />:</label>
        <input type="text" id="username" name="username">
    </div>
    <div class="form-group">
        <label for="password"><fmt:message key="password" />:</label>
        <input type="password" id="password" name="password">
    </div>
    <fmt:message key="logIn" var="buttonValue" />
    <input type="submit" name="login" value="${buttonValue}">

<%--    <fmt:message key="registration" var="buttonValue" />
    <input type="submit" name="registration" value="${buttonValue}">--%>
</form>
</body>
</html>