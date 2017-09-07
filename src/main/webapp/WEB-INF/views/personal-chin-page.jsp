<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<br><br>
<%-- to show detail info of chinchilla--%>
<div row>
    <div class="col-md-6">
        <button id="index-data-id" class="btn btn-default">Index data</button>
        <button id="blood-relation-id" class="btn btn-default">Blood relations</button>
        <div id="index-data-info">
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

                <li class="list-group-item">
                    <div class="row">
                        <div class="col-md-6">Born:</div>
                        <div class="col-md-6"><span id="chin-born"></span></div>
                    </div>
                </li>

                <li class="list-group-item">
                    <div class="row">
                        <div class="col-md-6">Deceased:</div>
                        <div class="col-md-6"><span id="chin-deceased"></span></div>
                    </div>
                </li>

                <li class="list-group-item">
                    <div class="row">
                        <div class="col-md-6">Name:</div>
                        <div class="col-md-6"><span id="chin-name"></span></div>
                    </div>
                </li>
            </ul>
        </div>

    </div>
    <div class="col-md-6">
        <div id="blood-relation-info" style="display: none;">
            <button id="offspring-id" class="btn btn-default">Offspring</button>
            <button id="ancestors-id" class="btn btn-default">Ancestors</button>
            <button id="others-id" class="btn btn-default">Others</button><br/><br/>

            <div id="ancestor-buttons-id" style="display: none;">
                <button id="parrents-id" class="btn btn-default">Parents</button>
                <button id="grand-parrents-id" class="btn btn-default">GrandParents</button>
                <button id="great-grand-parrents-id", class="btn btn-default">Great GrandParents</button>
                <button id="great-great-grand-parrents-id", class="btn btn-default">Great Great GrandParents</button>
                <button id="all-ancestors-up-to-10-id", class="btn btn-default">All ancestors up to 10 generations</button>
            </div>

            <div id="others-buttons-id" style="display: none;">
                <button id="brothers-sisters-id" class="btn btn-default">Brothers & Sisters</button>
                <button id="half-brothers-and-half-sisters-id" class="btn btn-default">Half brothers & half sisters</button>
                <button id="uncles-and-aunts-id", class="btn btn-default">Uncles & Aunts</button>
                <button class="btn btn-default">Cousins</button>
            </div>

            <div id="offspring-buttons-id" style="display: none;">
                <button class="btn btn-default">1st line offspring</button>
                <button class="btn btn-default">2nd line offspring</button>
                <button class="btn btn-default">All offspring</button>
            </div>

            <br/>
            <br/>
            <table class="table" id="chinTableId">
                <thead>
                <tr>
                    <th>Id</th>
                    <th>sex</th>
                    <th>color</th>
                    <th>fatherId</th>
                    <th>motherId</th>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>

        </div>


    </div>
</div>

<input type="hidden" id="chinId" value='${chinId}'/>

<script src="personal-chin-p.js"></script>
