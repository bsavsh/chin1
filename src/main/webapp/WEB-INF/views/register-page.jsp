<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<script src="jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>register</title>

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
        <li class="active"><a href="/chin/register">Register</a></li>
    </ul>

    <%-- to fill form of chinnchilla  --%>
    <div class="row">
        <div class="col-md-4">

            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                    <h3>Register</h3> <br/>
                </div>
            </div>
            <sf:form method="POST" commandName="chin" class="form-horizontal">
                <div class="form-group">
                    <label class="control-label col-md-4" for="sex">Sex:</label>
                    <div class="col-md-8">
                        <sf:input path="sex" class="form-control" placeholder="Enter sex"/>
                        <sf:errors path="sex"/><br/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-4" for="color">Color:</label>
                    <div class="col-md-8">
                        <sf:input path="color" class="form-control" placeholder="Enter color"/>
                        <sf:errors path="color"/><br/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-4" for="fatherId">Father Id:</label>
                    <div class="col-md-8">
                        <sf:input path="fatherId" class="form-control" placeholder="Enter father's id"/>
                        <sf:errors path="color"/><br/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-md-4" for="motherId">Mother Id:</label>
                    <div class="col-md-8">
                        <sf:input path="motherId" class="form-control" placeholder="Enter mother's id"/>
                        <sf:errors path="color"/><br/>
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-md-offset-2 col-md-10">
                        <input type="submit" class="btn btn-default" value="Register"/>
                    </div>
                </div>
            </sf:form>
        </div>
        <div class="col-md-8">
        </div>
    </div>
</div>
