<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<br/>
<%-- to fill form of chinnchilla  --%>
<div class="row">
    <div class="col-md-4">

        <div class="form-group">
            <div class="col-md-offset-2 col-md-10">
                <h3><spring:message code="finance.register"/></h3> <br/>
            </div>
        </div>

        <form class="form-horizontal">
            <div class="form-group">
                <label class="control-label col-md-4"><spring:message code="finance.chinId"/></label>
                <div class="col-md-8">
                    <input type="text" class="form-control" id="finance-chinId"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-4"><spring:message code="finance.dateOfChinGone"/></label>
                <div class="col-md-8">
                    <input type="date" class="form-control" id="finance-dateOfChinGone">
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-md-4"><spring:message code="finance.description"/></label>
                <div class="col-md-8">
                    <input type="text" class="form-control" id="finance-description"/>
                </div>
            </div>

            <div class="list-group-item" style="display: none;" id="errorMessagesId">
                <p id="errorsId"></p>
            </div>

            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                    <button type="button" class="btn btn-default pull-right"
                            id="register-button-id"><spring:message code="register"/></button>
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
