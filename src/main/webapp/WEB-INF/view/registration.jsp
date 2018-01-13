<%@ page pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/view/multilang.jsp" %>
<html lang="${language}">
<head>
    <title><fmt:message key="registration"/></title>
</head>
<body>
<form action="/" method="POST">
    <fmt:message key="registrationSuccessful"/>
    <br>
    <fmt:message key="login" var="buttonValue"/>
    <button name="command" value="loginPage" type="submit" class="btn btn-primary"><fmt:message key="login"/></button>
</form>
</body>
</html>
