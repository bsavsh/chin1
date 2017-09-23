<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<div class="row">
    <div class="col-md-6">
        <div id="statistics-data-info">
            <ul class="list-group">
                <li class="list-group-item">
                    <div class="row">
                        <div class="col-md-6"><spring:message code="statistics.all"/></div>
                        <div class="col-md-6"><span id="all-chin"></span></div>
                    </div>
                </li>

                <li class="list-group-item">
                    <div class="row">
                        <div class="col-md-6"><spring:message code="statistics.females"/></div>
                        <div class="col-md-6"><span id="females-chin"></span></div>
                    </div>
                </li>

                <li class="list-group-item">
                    <div class="row">
                        <div class="col-md-6"><spring:message code="statistics.males"/></div>
                        <div class="col-md-6"><span id="males-chin"></span></div>
                    </div>
                </li>

                <li class="list-group-item">
                    <div class="row">
                        <div class="col-md-6"><spring:message code="statistics.not.inFamily"/></div>
                        <div class="col-md-6"><span id="all-not-infamilies-chin"></span></div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
    <div class="col-md-6"></div>
</div>

<script src='${pageContext.request.contextPath}/resources/js/home-p.js'></script>