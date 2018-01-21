<%@ page pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/view/changeLangFragment.jsp" %>
<html>
<head>
    <title>Select breakage page</title>
</head>
<body>
    SELECT BREAKAGE PAGE (MULTIPLE BUTTONS)
    <form action="/" method="POST">
        <div class="form-group">
            <label for="deviceBreakageComment">Input comment:</label>
            <input type="text" id="deviceBreakageComment" name="deviceBreakageComment">
        </div>
        <button name="command" value="selectBreakagePage" type="submit" class="btn btn-primary">Select breakage</button>
        <button name="command" value="selectBreakagePage" type="submit" class="btn btn-primary">Select breakage2</button>
        <button name="command" value="selectBreakagePage" type="submit" class="btn btn-primary">Select breakage3</button>
        <button name="command" value="addDevicePage" type="submit" class="btn btn-primary">Add another device</button>
        <button name="command" value="submitOrderPage" type="submit" class="btn btn-primary">Submit order</button>
    </form>
</body>
</html>
