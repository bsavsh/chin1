<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<br/>
<h4>All chins</h4>
<button class="btn btn-default" id="registerChinId">Register</button>
<br/>

<ul class="nav nav-tabs" role="tablist">
    <li><input type="text" class="form-control" id="chin-sex-query-id" placeholder="Enter sex"/></li>
    <li><input type="text" class="form-control" id="chin-color-query-id" placeholder="Enter color"/></li>
    <li><input type="date" class="form-control" id="chin-from-query-id" placeholder="Enter date from"/></li>
    <li><input type="date" class="form-control" id="chin-to-query-id" placeholder="Enter date to"/></li>
    <li><button class="btn btn-default" id="selectQueryButtonId">Select</button></li>
</ul>
<br/>
<%-- to show all chins --%>
<table class="table" id="chinTableId">
    <thead>
    <tr>
        <th><spring:message code="chin.id"/></th>
        <th>sex</th>
        <th>color</th>
        <th>fatherId</th>
        <th>motherId</th>
        <th>born</th>
        <th>in family</th>
        <th>name</th>
        <th>Edit</th>
    </tr>
    </thead>
    <tbody>

    </tbody>
</table>


<%-- Modal --%>
<div class="modal fade" id="editChinModalBlanckId" role="dialog">
    <div class="modal-dialog">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close modalCloseEditChinButton" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Edit Chin</h4>
            </div>
            <div class="modal-body">
                <%-- personal chin info--%>
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
                            <div class="col-md-6"><input type="text" id="chin-sex"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6">Color:</div>
                            <div class="col-md-6"><input type="text" id="chin-color"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6">FatherId:</div>
                            <div class="col-md-6"><input type="number" id="chin-fatherId"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6">MotherId:</div>
                            <div class="col-md-6"><input type="number" id="chin-motherId"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6">Born:</div>
                            <div class="col-md-6"><input type="date" id="chin-born"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6">Deceased:</div>
                            <div class="col-md-6"><input type="text" id="chin-deceased"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6">Sold:</div>
                            <div class="col-md-6"><input type="text" id="chin-sold"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6">In Family:</div>
                            <div class="col-md-6"><input type="text" id="chin-inFamily"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6">Name:</div>
                            <div class="col-md-6"><input type="text" id="chin-name"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item" style="display: none;" id="errorMessagesId">
                        <p id="errorsId"></p>
                    </li>
                </ul>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default"
                        data-dismiss="modal" id="modalSaveEditChinButtonId">Save</button>
                <button type="button" class="btn btn-default modalCloseEditChinButton"
                        data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>

<script src='${pageContext.request.contextPath}/resources/js/chin/chins-p.js'></script>

