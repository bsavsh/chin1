<br/>
<%-- to fill form of chinnchilla  --%>
<div class="row">
    <div class="col-md-4">


        <div class="form-group">
            <div class="col-md-offset-2 col-md-10">
                <h3>Register Finance</h3> <br/>
            </div>
        </div>

        <form class="form-horizontal">
            <div class="form-group">
                <label class="control-label col-md-4">chinId:</label>
                <div class="col-md-8">
                    <input type="text" class="form-control" id="finance-chinId" placeholder="Enter chin id you want to sell"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-4">dateOfChinGone:</label>
                <div class="col-md-8">
                    <input type="date" class="form-control" id="finance-dateOfChinGone">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-md-4">description:</label>
                <div class="col-md-8">
                    <input type="text" class="form-control" id="finance-description" placeholder="Enter description"/>
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

<script src='${pageContext.request.contextPath}/resources/js/finance/register-finance-p.js'></script>
