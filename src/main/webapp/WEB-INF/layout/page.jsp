<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE>
<html>
<head>
    <script src="${pageContext.request.contextPath}/resources/js/lib/jquery-3.2.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/lib/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath}/resources/css/lib/bootstrap.min.css" rel="stylesheet"/>
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">--%>
    <%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>--%>

    <title>ChinApp</title>
</head>

<body>
<div class="container">
    <div id="header">
        <t:insertAttribute name="header"/>
    </div>

    <div id="body">
        <t:insertAttribute name="body"/>
    </div>

    <div id="footer">
        <t:insertAttribute name="footer"/>
    </div>
</div>
</body>
</html>