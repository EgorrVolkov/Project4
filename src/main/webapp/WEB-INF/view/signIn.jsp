<%@ page pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/view/changeLangFragment.jsp" %>
<html lang="${language}">
<head>
    <title><fmt:message key="signIn" bundle="${bundle}"/></title>
</head>
<body>
    <fmt:message key="signInSuccessful" bundle="${bundle}"/>
    <br>
    <form action="/" method="POST">
        <c:if test="${not empty token}">
            <c:if test="${not empty manager}">
                <button name="command" value="managerPage" type="submit" class="btn btn-primary"><fmt:message key="managerPage" bundle="${bundle}"/></button>
            </c:if>
            <c:if test="${not empty engineer}">
                <button name="command" value="engineerPage" type="submit" class="btn btn-primary"><fmt:message key="engineerPage" bundle="${bundle}"/></button>
            </c:if>
        </c:if>
    </form>
</body>
</html>
