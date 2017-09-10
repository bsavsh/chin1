
<button class="btn btn-default" id="registerFinanceButtonId">Register Finance</button>
<br/>
<table class="table" id="financeTableId">
    <thead>
    <tr>
        <th>id</th>
        <th>chinId</th>
        <th>dateOfChinsGone</th>
        <th>dateOfMoneyBack</th>
        <th>description</th>
        <th>Edit</th>
    </tr>
    </thead>
    <tbody>

    </tbody>
</table>


<%-- Modal --%>
<div class="modal fade" id="editFinanceModalBlanckId" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close modalCloseEditFinanceButton" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Edit Finance</h4>
            </div>
            <div class="modal-body">
                <%-- personal chin info--%>
                <ul class="list-group">
                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6">Id:</div>
                            <div class="col-md-6"><span id="finance-id"></span></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6">chinId:</div>
                            <div class="col-md-6"><input type="text" id="finance-chinId"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6">dateOfChinGone:</div>
                            <div class="col-md-6"><input type="date" id="finance-dateOfChinGone"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6">dateOfMoneyBack:</div>
                            <div class="col-md-6"><input type="date" id="finance-dateOfMoneyBack"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6">description:</div>
                            <div class="col-md-6"><input type="text" id="finance-description"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item" style="display: none;" id="errorMessagesId">
                        <p id="errorsId"></p>
                    </li>
                </ul>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default"
                        data-dismiss="modal" id="modalSaveEditFinanceButtonId">Save</button>
                <button type="button" class="btn btn-default modalCloseEditFinanceButton"
                        data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>

<script src='${pageContext.request.contextPath}/resources/js/finance/financies-p.js'></script>
