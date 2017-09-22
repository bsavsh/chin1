<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<ul class="nav nav-tabs" role="toolbar">
    <li><button class="btn btn-default" id="registerChinId"><spring:message code="chinchilla.register" /></button></li>
    <li><button class="btn btn-default pull-right" id="allChinButtonId"><spring:message code="all" /></button></li>
    <li><button class="btn btn-default pull-right" id="soldChinButtonId"><spring:message code="sold" /></button></li>
    <li><button class="btn btn-default pull-right" id="deceasedChinButtonId"><spring:message code="deceased" /></button></li>
</ul>

<ul class="nav nav-tabs" role="tablist">
    <li><input type="text" class="form-control" id="chin-sex-query-id" placeholder=<spring:message code="enter.sex" />/></li>
    <li><input type="text" class="form-control" id="chin-color-query-id" placeholder=<spring:message code="enter.color" />/></li>
    <li><input type="date" class="form-control" id="chin-from-query-id"/></li>
    <li><input type="date" class="form-control" id="chin-to-query-id"/></li>
    <li><input type="text" class="form-control" id="chin-inFamily-query-id" placeholder=<spring:message code="enter.inFamily"/>/></li>
    <li><button class="btn btn-default" id="selectQueryButtonId"><spring:message code="select"/></button></li>
</ul>
<br/>
<%-- to show all chins --%>
<table class="table" id="chinTableId">
    <thead>
    <tr>
        <th><spring:message code="chinchilla.id"/></th>
        <th><spring:message code="chinchilla.sex"/></th>
        <th><spring:message code="chinchilla.color"/></th>
        <th><spring:message code="chinchilla.fatherId"/></th>
        <th><spring:message code="chinchilla.motherId"/></th>
        <th><spring:message code="chinchilla.born"/></th>
        <th><spring:message code="chinchilla.description"/></th>
        <th><spring:message code="chinchilla.Edit"/></th>
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
                <h4 class="modal-title"><spring:message code="chinchilla.Edit" /></h4>
            </div>
            <div class="modal-body">
                <%-- personal chinchilla info--%>
                <ul class="list-group">
                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="chinchilla.id" /></div>
                            <div class="col-md-6"><span id="chin-id"></span></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="chinchilla.sex" /></div>
                            <div class="col-md-6"><input type="text" id="chin-gender"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="chinchilla.color" /></div>
                            <div class="col-md-6"><input type="text" id="chin-color"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="chinchilla.fatherId" /></div>
                            <div class="col-md-6"><input type="number" id="chin-fatherId"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="chinchilla.motherId" /></div>
                            <div class="col-md-6"><input type="number" id="chin-motherId"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="chinchilla.born" /></div>
                            <div class="col-md-6"><input type="date" id="chin-born"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="chinchilla.deceased" /></div>
                            <div class="col-md-6"><input type="text" id="chin-deceased"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="chinchilla.description" /></div>
                            <div class="col-md-6"><input type="text" id="chin-description"></input></div>
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

<script src='${pageContext.request.contextPath}/resources/js/chinchilla/chins-p.js'></script>

