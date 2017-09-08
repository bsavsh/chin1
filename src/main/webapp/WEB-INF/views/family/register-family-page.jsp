<br/>
<%-- to fill form of chinnchilla  --%>
<div class="row">
    <div class="col-md-4">


        <div class="form-group">
            <div class="col-md-offset-2 col-md-10">
                <h3>Register Family</h3> <br/>
            </div>
        </div>

        <form class="form-horizontal">
            <div class="form-group">
                <label class="control-label col-md-4">Husband Id:</label>
                <div class="col-md-8">
                    <input type="number" class="form-control" id="family-husbandId" placeholder="Enter husbandId"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-4">Wife Id:</label>
                <div class="col-md-8">
                    <input type="number" class="form-control" id="family-wifeId" placeholder="Enter wifeId"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-4">Number of Family:</label>
                <div class="col-md-8">
                    <input type="number" class="form-control" id="family-numberOfFamily"
                           placeholder="Enter number of family"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-4">Date of formation:</label>
                <div class="col-md-8">
                    <input type="date" class="form-control" id="family-dateOfFormation" placeholder="Enter date"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-md-4">Description:</label>
                <div class="col-md-8">
                    <input type="text" class="form-control" id="family-description" placeholder="Enter description"/>
                </div>
            </div>

            <div class="list-group-item" style="display: none;" id="errorMessagesId">
                <p id="errorsId"></p>
            </div>

            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                    <button type="button" class="btn btn-default pull-right" id="register-button-id">Register</button>
                </div>
            </div>
        </form>

    </div>
    <div class="col-md-4">

    </div>
    <div class="col-md-4">

    </div>
</div>

<script src='${pageContext.request.contextPath}/resources/js/family/register-family-file.js'></script>
