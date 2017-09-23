<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<ul class="nav nav-tabs" role="tablist">
    <li>
        <button class="btn btn-default" id="registerFamilyPageButtonId"><spring:message
                code="family.register"/></button>
    </li>
    <li><input type="text" class="form-control" id="family-number-id" placeholder=<spring:message
            code="family.numberOfFamily"/>/></li>
    <li>
        <button class="btn btn-default" id="selectFamilyNumber"><spring:message code="select"/></button>
    </li>
</ul>
<table class="table" id="familyTableId">
    <thead>
    <tr>
        <th><spring:message code="family.id"/></th>
        <th><spring:message code="family.numberOfFamily"/></th>
        <th><spring:message code="family.husbandId"/></th>
        <th><spring:message code="family.wifeId"/></th>
        <th><spring:message code="family.dateOfFormation"/></th>
        <th><spring:message code="family.description"/></th>
        <th><spring:message code="edit"/></th>
        <th><spring:message code="delete"/></th>
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
                <h4 class="modal-title"><spring:message code="family.edit"/></h4>
            </div>
            <div class="modal-body">
                <%-- personal chinchilla info--%>
                <ul class="list-group">
                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="family.id"/></div>
                            <div class="col-md-6"><span id="family-id"></span></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="family.numberOfFamily"/></div>
                            <div class="col-md-6"><input type="number" id="family-numberOfFamily"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="family.husbandId"/></div>
                            <div class="col-md-6"><input type="number" id="family-husbandId"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="family.wifeId"/></div>
                            <div class="col-md-6"><input type="number" id="family-wifeId"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="family.dateOfFormation"/></div>
                            <div class="col-md-6"><input type="date" id="family-dateOfFormation"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="family.description"/></div>
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
                        data-dismiss="modal" id="modalSaveEditFamilyButtonId"><spring:message
                        code="family.save"/></button>
                <button type="button" class="btn btn-default modalCloseEditFamilyButton"
                        data-dismiss="modal"><spring:message code="family.cancel"/></button>
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
            </div>
            <div class="modal-body">
                <%-- yes or cancel --%>
                <h3><spring:message code="family.deleteQuestion"/></h3>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default"
                        data-dismiss="modal" id="modalDeleteFamilyButtonId"><spring:message
                        code="family.delete"/></button>
                <button type="button" class="btn btn-default modalCloseEditFamilyButton"
                        data-dismiss="modal"><spring:message code="family.cancel"/></button>
            </div>
        </div>

    </div>
</div>


<script src='${pageContext.request.contextPath}/resources/js/family/families-p.js'></script>