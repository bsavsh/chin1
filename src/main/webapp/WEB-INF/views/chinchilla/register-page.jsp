<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<br/>
<%-- to fill form of chinnchilla  --%>
<div class="row">
    <div class="col-md-4">

        <div class="form-group">
            <div class="col-md-offset-2 col-md-10">
                <h3><spring:message code="chinchilla.register"/></h3> <br/>
            </div>
        </div>

        <form class="form-horizontal">
            <div class="form-group">
                <label class="control-label col-md-4"><spring:message code="chinchilla.sex"/></label>
                <div class="col-md-8">
                    <%--<input type="text" class="form-control" id="chin-gender"/>--%>
                    <select name="gender" id="chin-gender" class="form-control">
                        <option value="FEMALE">FEMALE</option>
                        <option value="MALE">MALE</option>
                        <option value="UNKNOWN">UNKNOWN</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-4"><spring:message code="chinchilla.color"/></label>
                <div class="col-md-8">
                    <input type="text" class="form-control" id="chin-color"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-4"><spring:message code="chinchilla.fatherId"/></label>
                <div class="col-md-8">
                    <input type="number" class="form-control" id="chin-fatherId"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-4"><spring:message code="chinchilla.motherId"/></label>
                <div class="col-md-8">
                    <input type="number" class="form-control" id="chin-motherId"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-4"><spring:message code="chinchilla.description"/></label>
                <div class="col-md-8">
                    <input type="text" class="form-control" id="chin-description"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-md-4"><spring:message code="chinchilla.born"/></label>
                <div class="col-md-8">
                    <input type="date" class="form-control" id="chin-born"/>
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

<script src='${pageContext.request.contextPath}/resources/js/chinchilla/register-file.js'></script>
