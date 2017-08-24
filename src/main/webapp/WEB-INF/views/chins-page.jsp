<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE>
<html>
<head>
    <script src="jquery-3.2.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <title>Chins</title>
</head>

<body>
<div class="container">
    <h2>Welcome dear Ola</h2>
    <p>This tool will help you to manage your business:</p>
    <ul class="nav nav-tabs" role="tablist">
        <li><a href="/home-page">Home</a></li>
        <li class="active"><a href="/chins-page">Chins</a></li>
        <li><a href="#">Family</a></li>
        <li><a href="#">Finance</a></li>
        <li><a href="#">Statistics</a></li>
        <li><a href="#">Notification</a></li>
        <li><a href="/chin/register">Register</a></li>
    </ul>

    <%-- to show all chins --%>
    <table class="table" id="chinTableId">
        <thead>
        <tr>
            <th>Id</th>
            <th>sex</th>
            <th>color</th>
            <th>fatherId</th>
            <th>motherId</th>
        </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
</div>



<script src="chins-p.js"></script>
</body>
</html>