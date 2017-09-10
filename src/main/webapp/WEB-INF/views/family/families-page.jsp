<button class="btn btn-default" id="registerFamilyPageButtonId">Register Family</button>
<table class="table" id="familyTableId">
    <thead>
    <tr>
        <th>id</th>
        <th>number Of family</th>
        <th>husbandId</th>
        <th>wifeId</th>
        <th>date of formation</th>
        <th>description</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>

    </tbody>
</table>



<%-- Modal Edit --%>
<div class="modal fade" id="editFamilyModalBlanckId" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close modalCloseEditFamilyButton" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Edit Chin</h4>
            </div>
            <div class="modal-body">
                <%-- personal chin info--%>
                <ul class="list-group">
                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6">Id:</div>
                            <div class="col-md-6"><span id="family-id"></span></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6">N%:</div>
                            <div class="col-md-6"><input type="number" id="family-numberOfFamily"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6">HusbandId:</div>
                            <div class="col-md-6"><input type="number" id="family-husbandId"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6">WifeId:</div>
                            <div class="col-md-6"><input type="number" id="family-wifeId"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6">Date:</div>
                            <div class="col-md-6"><input type="date" id="family-dateOfFormation"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6">Description:</div>
                            <div class="col-md-6"><input type="text" id="family-description"></input></div>
                        </div>
                    </li>


                    <li class="list-group-item" style="display: none;" id="errorMessagesId">
                        <p id="errorsId"></p>
                    </li>
                </ul>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default"
                        data-dismiss="modal" id="modalSaveEditFamilyButtonId">Save</button>
                <button type="button" class="btn btn-default modalCloseEditFamilyButton"
                        data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>


<div class="modal fade" id="deleteFamilyModalBlanckId" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close modalCloseEditFamilyButton" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Delete Chin</h4>
            </div>
            <div class="modal-body">
                <%-- yes or cancel --%>
                <h3>Do you really want to delete Family?</h3>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default"
                        data-dismiss="modal" id="modalDeleteFamilyButtonId">Delete</button>
                <button type="button" class="btn btn-default modalCloseEditFamilyButton"
                        data-dismiss="modal">Cancel</button>
            </div>
        </div>

    </div>
</div>


<script src='${pageContext.request.contextPath}/resources/js/family/families-p.js'></script>