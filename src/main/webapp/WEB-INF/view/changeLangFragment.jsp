<%--TODO rename file!--%>
<%--TODO find out what value="${page}" means--%>
<%--TODO input type radio, deleted fragments: " id="lang" ", find out for what they where...--%>
<%--TODO [loginPage, EN] - [login, EN] - [login, RU] - [back] - [back] - [RegistrationPage, WTF lang?]--%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@include file="/WEB-INF/view/i18n.jsp" %>
<form action="/" method="POST">
    <div><input name="command" value="setLang" type="hidden"/></div>
    <div><input name="page" value="${page}" type="hidden"/></div>
    <input type="radio" name="lang" value="en" checked="checked"/>EN
    <input type="radio" name="lang" value="ru"/>RU
    <button class="btn" type="submit">
        <fmt:message key="changeLang" bundle="${bundle}"/>
    </button>
</form>