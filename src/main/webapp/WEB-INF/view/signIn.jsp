<%@ page pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/view/changeLangFragment.jsp" %>
<html lang="${language}">
<head>
    <title><fmt:message key="orderPage" bundle="${bundle}"/></title>
</head>
<body>
    <fmt:message key="signInSuccessful" bundle="${bundle}"/>
    <br>
    <form action="/" method="POST">
        <c:if test="${not empty manager}">
            <button name="command" value="managerPage" type="submit" class="btn btn-primary"><fmt:message key="managerPage" bundle="${bundle}"/></button>
        </c:if>
        <c:if test="${not empty engineer}">
            <button name="command" value="engineerPage" type="submit" class="btn btn-primary"><fmt:message key="engineerPage" bundle="${bundle}"/></button>
        </c:if>
        <br>
<%--        <div class="form-group">
            <label for="deviceName"><fmt:message key="deviceName" bundle="${bundle}"/>:</label>
            <input type="text" id="deviceName" name="deviceName">
        </div>
        <div class="form-group">
            <label for="devicePrice"><fmt:message key="devicePrice" bundle="${bundle}"/>:</label>
            <input type="number" id="devicePrice" name="devicePrice">
        </div>
        <div class="form-group">
            <label for="deviceBreakage"><fmt:message key="deviceBreakage" bundle="${bundle}"/>:</label>
            <input type="text" id="deviceBreakage" name="deviceBreakage">
        </div>--%>
        <button name="command" value="createOrderPage" type="submit" class="btn btn-primary"><fmt:message key="createOrder" bundle="${bundle}"/></button>
        <button name="command" value="viewOrdersPage" type="submit" class="btn btn-primary"><fmt:message key="viewOrders" bundle="${bundle}"/></button>
    </form>
</body>
</html>
