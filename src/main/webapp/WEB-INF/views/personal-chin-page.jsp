<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<br><br>
<%-- to show detail info of chinchilla--%>
<div row>
    <div class="col-md-6">
        <h3>Personal chin page</h3>
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
                    <div class="col-md-6"><span id="chin-sex"></span></div>
                </div>
            </li>

            <li class="list-group-item">
                <div class="row">
                    <div class="col-md-6">Color:</div>
                    <div class="col-md-6"><span id="chin-color"></span></div>
                </div>
            </li>

            <li class="list-group-item">
                <div class="row">
                    <div class="col-md-6">FatherId:</div>
                    <div class="col-md-6"><span id="chin-fatherId"></span></div>
                </div>
            </li>

            <li class="list-group-item">
                <div class="row">
                    <div class="col-md-6">MotherId:</div>
                    <div class="col-md-6"><span id="chin-motherId"></span></div>
                </div>
            </li>
        </ul>

    </div>
    <div class="col-md-6"></div>
</div>

<input type="hidden" id="chinId" value='${chinId}'/>

<script src="personal-chin-p.js"></script>
