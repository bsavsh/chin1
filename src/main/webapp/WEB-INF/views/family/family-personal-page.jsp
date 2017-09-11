<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>


<h3><spring:message code="family.personal-page" /></h3>

<table class="table" id="chinTableId">
    <thead>
    <tr>
        <th><spring:message code="chin.id" /></th>
        <th><spring:message code="chin.sex" /></th>
        <th><spring:message code="chin.color" /></th>
        <th><spring:message code="chin.fatherId" /></th>
        <th><spring:message code="chin.motherId" /></th>
        <th><spring:message code="chin.deceased" /></th>
        <th><spring:message code="chin.inFamily" /></th>
        <th><spring:message code="chin.sold" /></th>
        <th><spring:message code="edit" /></th>
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
                <h4 class="modal-title"><spring:message code="chin.Edit" /></h4>
            </div>
            <div class="modal-body">
                <%-- personal chin info--%>
                <ul class="list-group">
                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="chin.id" /></div>
                            <div class="col-md-6"><span id="chin-id"></span></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="chin.sex" /></div>
                            <div class="col-md-6"><input type="text" id="chin-sex"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="chin.color" /></div>
                            <div class="col-md-6"><input type="text" id="chin-color"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="chin.fatherId" /></div>
                            <div class="col-md-6"><input type="number" id="chin-fatherId"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="chin.motherId" /></div>
                            <div class="col-md-6"><input type="number" id="chin-motherId"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="chin.born" /></div>
                            <div class="col-md-6"><input type="date" id="chin-born"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="chin.deceased" /></div>
                            <div class="col-md-6"><input type="text" id="chin-deceased"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="chin.sold" /></div>
                            <div class="col-md-6"><input type="text" id="chin-sold"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="chin.inFamily" /></div>
                            <div class="col-md-6"><input type="text" id="chin-inFamily"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="chin.name" /></div>
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
                        data-dismiss="modal" id="modalSaveEditChinButtonId"><spring:message code="save" /></button>
                <button type="button" class="btn btn-default modalCloseEditChinButton"
                        data-dismiss="modal"><spring:message code="close" /></button>
            </div>
        </div>

    </div>
</div>

<input type="hidden" id="familyNumber" value='${familyNumber}'/>

<script src='${pageContext.request.contextPath}/resources/js/family/family-personal-p.js'></script>