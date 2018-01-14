<%@ page pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/view/changeLangFragment.jsp" %>
<html lang="${language}">
<head>
    <title><fmt:message key="error" bundle="${bundle}"/></title>
</head>
<body>
    <h2><fmt:message key="error" bundle="${bundle}"/>!</h2>
</body>
</html>
