<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<script src="jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Chin page</title>


<div class="container">
    <h2>Welcome dear Ola</h2>
    <p>This tool will help you to manage your business:</p>
    <ul class="nav nav-tabs" role="tablist">
        <li><a href="/home-page">Home</a></li>
        <li><a href="/chins-page">Chins</a></li>
        <li><a href="#">Family</a></li>
        <li><a href="#">Finance</a></li>
        <li><a href="#">Statistics</a></li>
        <li><a href="#">Notification</a></li>
        <li><a href="/chin/register">Register</a></li>
    </ul>

    <br><br>
    <%-- to show detail info of chinchilla--%>
    <div row>
        <div class="col-md-6">
            <h3>Personal chin page</h3>
            <ul class="list-group">
                <li class="list-group-item">
                    <div class="row">
                        <div class="col-md-6">Id:</div>
                        <div class="col-md-6"><span id="chin-id"></span></div>
                    </div>
                </li>

                <li class="list-group-item">
                    <div class="row">
                        <div class="col-md-6">Sex:</div>
                        <div class="col-md-6"><span id="chin-sex"></span></div>
                    </div>
                </li>

                <li class="list-group-item">
                    <div class="row">
                        <div class="col-md-6">Color:</div>
                        <div class="col-md-6"><span id="chin-color"></span></div>
                    </div>
                </li>

                <li class="list-group-item">
                    <div class="row">
                        <div class="col-md-6">FatherId:</div>
                        <div class="col-md-6"><span id="chin-fatherId"></span></div>
                    </div>
                </li>

                <li class="list-group-item">
                    <div class="row">
                        <div class="col-md-6">MotherId:</div>
                        <div class="col-md-6"><span id="chin-motherId"></span></div>
                    </div>
                </li>
            </ul>

        </div>
        <div class="col-md-6"></div>
    </div>

    <input type="hidden" id="chinId" value='${chinId}'/>
</div>

<script src="personal-chin-p.js"></script>
