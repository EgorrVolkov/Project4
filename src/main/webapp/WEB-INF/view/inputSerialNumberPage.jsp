<%@ page pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/view/changeLangFragment.jsp" %>
<html>
<head>
    <title>Input serial number page</title>
</head>
<body>
    INPUT SERIAL NUMBER PAGE
    <form action="/" method="POST">
        <br>
        <div class="form-group">
            <label for="deviceSerialNumber">Input serial number:</label>
            <input type="text" id="deviceSerialNumber" name="deviceSerialNumber">
        </div>
        <button name="command" value="selectBreakagePage" type="submit" class="btn btn-primary">Select breakage</button>
    </form>
</body>
</html>
