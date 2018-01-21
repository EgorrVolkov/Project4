<%@ page pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/view/changeLangFragment.jsp" %>
<html>
<head>
    <title>Add device</title>
</head>
<body>
    ADD DEVICE PAGE (MULTIPLE BUTTONS)
    <form action="/" method="POST">
        <button name="command" value="inputSerialNumberPage" type="submit" class="btn btn-primary">Select model</button>
        <button name="command" value="inputSerialNumberPage" type="submit" class="btn btn-primary">Select model2</button>
        <button name="command" value="inputSerialNumberPage" type="submit" class="btn btn-primary">Select model3</button>
    </form>
</body>
</html>
