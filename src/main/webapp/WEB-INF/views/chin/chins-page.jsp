<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<br/>
<h4>All chins</h4>
<ul class="nav nav-tabs" role="tablist">
    <li><button class="btn btn-default">gender</button></li>
    <li><button class="btn btn-default">age</button></li>
    <li><button class="btn btn-default">color</button></li>
    <li><button class="btn btn-default">for sell</button></li>
    <li><button class="btn btn-default">in family</button></li>
</ul>
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
