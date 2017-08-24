<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<br/>
<br/>
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

             <div class="form-group">
                <label class="control-label col-md-4" for="fatherId">Father Id:</label>
                 <div class="col-md-8">
                    <sf:input path="fatherId" class="form-control" placeholder="Enter father's id"/>
                    <sf:errors path="fatherId"/><br/>
                </div>
             </div>
             <div class="form-group">
                <label class="control-label col-md-4" for="motherId">Mother Id:</label>
                <div class="col-md-8">
                    <sf:input path="motherId" class="form-control" placeholder="Enter mother's id"/>
                    <sf:errors path="motherId"/><br/>
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

