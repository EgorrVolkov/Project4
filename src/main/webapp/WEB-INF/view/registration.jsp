<%@ page pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/view/changeLangFragment.jsp" %>
<html lang="${language}">
<head>
    <title><fmt:message key="registration" bundle="${bundle}"/></title>
</head>
<body>
<form action="/" method="POST">
    <fmt:message key="registrationSuccessful" bundle="${bundle}"/>
    <br>
    <fmt:message key="signIn" var="buttonValue" bundle="${bundle}"/>
    <button name="command" value="signInPage" type="submit" class="btn btn-primary"><fmt:message key="signIn" bundle="${bundle}"/></button>
</form>
</body>
</html>
