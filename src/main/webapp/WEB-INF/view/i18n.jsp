<%--TODO find out what var="bundle" scope="session" means--%>
<c:set var="language" scope="session" value="${empty sessionScope.lang ? 'en_US' : sessionScope.lang}" />
<fmt:setLocale value="${language}"/>
<fmt:setBundle basename="messages" var="bundle" scope="session"/>
