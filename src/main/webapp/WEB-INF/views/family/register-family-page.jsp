<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<br/>
<%-- to fill form of chinnchilla  --%>
<div class="row">
    <div class="col-md-4">


        <div class="form-group">
            <div class="col-md-offset-2 col-md-10">
                <h3><spring:message code="family.register" /></h3> <br/>
            </div>
        </div>

        <form class="form-horizontal">

            <div class="form-group">
                <label class="control-label col-md-4"><spring:message code="family.numberOfFamily" /></label>
                <div class="col-md-8">
                    <input type="number" class="form-control" id="family-numberOfFamily"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-md-4"><spring:message code="family.husbandId" /></label>
                <div class="col-md-8">
                    <input type="number" class="form-control" id="family-husbandId"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-md-4"><spring:message code="family.wifeId" /></label>
                <div class="col-md-8">
                    <input type="number" class="form-control" id="family-wifeId" />
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-md-4"><spring:message code="family.dateOfFormation" /></label>
                <div class="col-md-8">
                    <input type="date" class="form-control" id="family-dateOfFormation"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-md-4"><spring:message code="family.description" /></label>
                <div class="col-md-8">
                    <input type="text" class="form-control" id="family-description"/>
                </div>
            </div>

            <div class="list-group-item" style="display: none;" id="errorMessagesId">
                <p id="errorsId"></p>
            </div>

            <div class="form-group">
                <div class="col-md-offset-2 col-md-10">
                    <button type="button"
                            class="btn btn-default pull-right"
                            id="register-button-id"><spring:message code="family.register" /></button>
                </div>
            </div>
        </form>

    </div>
    <div class="col-md-4">

    </div>
    <div class="col-md-4">

    </div>
</div>

<script src='${pageContext.request.contextPath}/resources/js/family/register-family-file.js'></script>
