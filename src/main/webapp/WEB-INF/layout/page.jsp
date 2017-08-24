<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>

<!DOCTYPE>
<html>
<head>
    <title>ChinApp</title>
</head>

<body>

<div id="header">
    <t:insertAttribute name="header"/>
</div>

<div id="body">
    <t:insertAttribute name="body"/>
</div>

<div id="footer">
    <t:insertAttribute name="footer"/>
</div>

</body>
</html>