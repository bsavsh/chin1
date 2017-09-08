<br/>
<%-- to fill form of chinnchilla  --%>
<div class="row">
    <div class="col-md-4">


        <div class="form-group">
            <div class="col-md-offset-2 col-md-10">
                <h3>Register</h3> <br/>
            </div>
        </div>

        <form class="form-horizontal">
            <div class="form-group">
                <label class="control-label col-md-4">Sex:</label>
                <div class="col-md-8">
                    <input type="text" class="form-control" id="chin-sex" placeholder="Enter sex"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-4">Color:</label>
                <div class="col-md-8">
                    <input type="text" class="form-control" id="chin-color" placeholder="Enter color"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-4">Father Id:</label>
                <div class="col-md-8">
                    <input type="number" class="form-control" id="chin-fatherId" placeholder="Enter father's id"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-4">Mother Id:</label>
                <div class="col-md-8">
                    <input type="number" class="form-control" id="chin-motherId" placeholder="Enter mother's id"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-4">Birthday:</label>
                <div class="col-md-8">
                    <input type="date" class="form-control" id="chin-born" placeholder="Enter birthday"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-md-4">Name:</label>
                <div class="col-md-8">
                    <input type="text" class="form-control" id="chin-name" placeholder="Enter name"/>
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

<script src='${pageContext.request.contextPath}/resources/js/chin/register-file.js'></script>
