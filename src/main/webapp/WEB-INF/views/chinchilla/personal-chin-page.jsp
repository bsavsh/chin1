<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<br/>
<%-- to show detail info of chinchilla--%>
<div row>
    <div class="col-md-4">
        <button id="index-data-id" class="btn btn-default"><spring:message code="index.data" /></button>
        <button id="blood-relation-id" class="btn btn-default"><spring:message code="blood.relations" /></button>
        <div id="index-data-info">
            <h3><spring:message code="personal-chinchilla-page" /></h3>
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
                        <div class="col-md-6"><span id="chin-gender"></span></div>
                    </div>
                </li>

                <li class="list-group-item">
                    <div class="row">
                        <div class="col-md-6"><spring:message code="chinchilla.color" /></div>
                        <div class="col-md-6"><span id="chin-color"></span></div>
                    </div>
                </li>

                <li class="list-group-item">
                    <div class="row">
                        <div class="col-md-6"><spring:message code="chinchilla.fatherId" /></div>
                        <div class="col-md-6"><span id="chin-fatherId"></span></div>
                    </div>
                </li>

                <li class="list-group-item">
                    <div class="row">
                        <div class="col-md-6"><spring:message code="chinchilla.motherId" /></div>
                        <div class="col-md-6"><span id="chin-motherId"></span></div>
                    </div>
                </li>

                <li class="list-group-item">
                    <div class="row">
                        <div class="col-md-6"><spring:message code="chinchilla.born" /></div>
                        <div class="col-md-6"><span id="chin-born"></span></div>
                    </div>
                </li>

                <li class="list-group-item">
                    <div class="row">
                        <div class="col-md-6"><spring:message code="chinchilla.deceased" /></div>
                        <div class="col-md-6"><span id="chin-deceased"></span></div>
                    </div>
                </li>

                <li class="list-group-item">
                    <div class="row">
                        <div class="col-md-6"><spring:message code="chinchilla.description" /></div>
                        <div class="col-md-6"><span id="chin-description"></span></div>
                    </div>
                </li>
            </ul>
        </div>

    </div>
    <div class="col-md-8">
        <div id="blood-relation-info">
            <button id="offspring-id" class="btn btn-default"><spring:message code="offspring" /></button>
            <button id="ancestors-id" class="btn btn-default"><spring:message code="ancestors" /></button>
            <button id="others-id" class="btn btn-default"><spring:message code="others" /></button>
            <br/><br/>

            <div id="ancestor-buttons-id" style="display: none;">
                <button id="parrents-id" class="btn btn-default"><spring:message code="parrents" /></button>
                <button id="grand-parrents-id" class="btn btn-default"><spring:message code="grand.parrents" /></button>
                <button id="great-grand-parrents-id" , class="btn btn-default"><spring:message code="great.grand.parrents" /></button>
                <button id="great-great-grand-parrents-id" , class="btn btn-default"><spring:message code="great.great.grand.parrents" /></button>
                <button id="all-ancestors-up-to-10-id" , class="btn btn-default"><spring:message code="all.up.to.10.gen" />
                </button>
            </div>

            <div id="others-buttons-id" style="display: none;">
                <button id="brothers-sisters-id" class="btn btn-default"><spring:message code="brothers.and.sisters" /></button>
                <button id="half-brothers-and-half-sisters-id" class="btn btn-default"><spring:message code="hbrothers.and.hsisters" />
                </button>
                <button id="uncles-and-aunts-id" , class="btn btn-default"><spring:message code="uncles.and.aunts" /></button>
                <button id="cousins-id" , class="btn btn-default"><spring:message code="cousins" /></button>
            </div>

            <div id="offspring-buttons-id">
                <button id="first-offspring-id" class="btn btn-default"><spring:message code="children" /></button>
                <button id="second-offspring-id" class="btn btn-default"><spring:message code="grand.children" /></button>
                <button id="all-offspring-id" class="btn btn-default"><spring:message code="all.up.to.10.gen.children"/></button>
            </div>

            <br/>
            <br/>
            <table class="table" id="chinTableId">
                <thead>
                <tr>
                    <th><spring:message code="chinchilla.id" /></th>
                    <th><spring:message code="chinchilla.sex" /></th>
                    <th><spring:message code="chinchilla.color"/></th>
                    <th><spring:message code="chinchilla.fatherId" /></th>
                    <th><spring:message code="chinchilla.motherId" /></th>
                    <th><spring:message code="chinchilla.born" /></th>
                    <th><spring:message code="chinchilla.description" /></th>

                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>

        </div>


    </div>
</div>

<input type="hidden" id="chinId" value='${chinId}'/>


<script src='${pageContext.request.contextPath}/resources/js/chinchilla/personal-chin-p.js'></script>