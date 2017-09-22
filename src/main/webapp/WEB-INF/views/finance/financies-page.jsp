<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<button class="btn btn-default" id="registerFinanceButtonId"><spring:message code="finance.register" /></button>
<br/>
<table class="table" id="financeTableId">
    <thead>
    <tr>
        <th><spring:message code="finance.id" /></th>
        <th><spring:message code="finance.chinId" /></th>
        <th><spring:message code="finance.dateOfChinGone" /></th>
        <th><spring:message code="finance.dateOfMoneyBack" /></th>
        <th><spring:message code="finance.description" /></th>
        <th><spring:message code="edit" /></th>
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
                <h4 class="modal-title"><spring:message code="edit" /></h4>
            </div>
            <div class="modal-body">
                <%-- personal chinchilla info--%>
                <ul class="list-group">
                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="finance.id" /></div>
                            <div class="col-md-6"><span id="finance-id"></span></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="finance.chinId" /></div>
                            <div class="col-md-6"><input type="text" id="finance-chinId"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="finance.dateOfChinGone" /></div>
                            <div class="col-md-6"><input type="date" id="finance-dateOfChinGone"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="finance.dateOfMoneyBack" /></div>
                            <div class="col-md-6"><input type="date" id="finance-dateOfMoneyBack"></input></div>
                        </div>
                    </li>

                    <li class="list-group-item">
                        <div class="row">
                            <div class="col-md-6"><spring:message code="finance.description" /></div>
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
                        data-dismiss="modal" id="modalSaveEditFinanceButtonId"><spring:message code="save" /></button>
                <button type="button" class="btn btn-default modalCloseEditFinanceButton"
                        data-dismiss="modal"><spring:message code="close" /></button>
            </div>
        </div>

    </div>
</div>

<script src='${pageContext.request.contextPath}/resources/js/finance/financies-p.js'></script>
