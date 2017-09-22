$(document).ready(function(){

    getAllChins();
    saveEditedChin();
    listenerToSelectQueryButton();
    listenerToRegisterButton();
    listenerToSoldButton();
    listenerToDeceasedButton();
    listenerToAllChinButton();

});

// let url = "http://localhost:8080/chins/query?gender=&color=&bornAfter=&bornBefore=&inFamily=";

let url = "http://localhost:8080/chins";

// to get all chins in table
function getAllChins() {
    $('#chinTableId tbody > tr').remove();
    $.ajax({
        url: url,
        type: 'GET',
        success: function(result) {
            let chinList = result;
            $.each(chinList, function(i, chin) {
                // let fatherId = chin.father !== null ? chin.father.id : 0;
                // let motherId = chin.mother !== null ? chin.mother.id : 0;
                let urlR = "http://localhost:8080/chin?id=";
                let url = urlR + chin.id;
                let urlFather = urlR + chin.fatherId;
                let urlMother = urlR + chin.motherId;
                let newRowContent =
                    "<tr>" +
                    "<td> <a href= " + url + ">" + chin.id + "</a></td>" +
                    "<td>" + chin.gender + "</td>" +
                    "<td>" + chin.color + "</td>" +
                    "<td><a href= " + urlFather + ">" + chin.fatherId + "</a></td>" +
                    "<td><a href= " + urlMother + ">" + chin.motherId + "</a></td>" +
                    "<td>" + chin.born + "</td>" +
                    "<td>" + chin.description + "</td>" +
                    "<td><button type='button' class='btn btn-default chin-edit'" +
                    " data-toggle='modal' data-target='#editChinModalBlanckId'>...</button></td>"
                "</tr>";

                $("#chinTableId tbody").append(newRowContent);
            });

            // to pass chin id into function that will fill edit-modal
            $('.chin-edit').click(function() {
                let chinId = $(this).parents('tr').find('td').eq(0).text();
                getChinById(chinId);
            });
        }
    });
}

// action to save button in edit window
function saveEditedChin() {
    $('#modalSaveEditChinButtonId').click(function() {
        let fatherId = $('#chin-fatherId').val() == 0 ? null : {"id": + $('#chin-fatherId').val()};
        let motherId = $('#chin-motherId').val() == 0 ? null : {"id": + $('#chin-motherId').val()};
        let dataSender = {
            id: $('#chin-id').text(),
            gender: $('#chin-gender').val(),
            color: $('#chin-color').val(),
            father: fatherId,
            mother: motherId,
            born: $('#chin-born').val(),
            deceased: $('#chin-deceased').val(),
            description: $('#chin-description').val()
        };

        $.ajax({
            type: 'PUT',
            contentType: 'application/json',
            url: "http://localhost:8080/chins",
            dataType: "json",
            data: JSON.stringify(dataSender),
            success: function(data){
                if (data.id !== undefined) {
                    $('#chinTableId tbody > tr').remove();
                    getAllChins();
                } else {
                    let str = "";
                    for (let i = 0; i < data.length; i++) {
                        str += data[i].message + "</br>";
                        $("#errorsId").html(str);
                    }
                    $("#errorMessagesId").show();

                }

            },
            error: function(){
                alert('updateChin error: ');
            }
        });
    });


    $(".modalCloseEditChinButton").click(function () {
        $("#errorMessagesId").hide();
    });
}

// to fill modal edit form
function getChinById(id) {
    let rootURL = "http://localhost:8080/chins/";
    $.ajax({
        type: 'GET',
        url: rootURL + '/' + id,
        dataType: "json",
        success: function(data){
            $('#chin-id').text(data.id);
            $('#chin-gender').val(data.gender);
            $('#chin-color').val(data.color);
            $('#chin-fatherId').val(data.fatherId);
            $('#chin-motherId').val(data.motherId);
            $('#chin-born').val(data.born);
            $('#chin-deceased').val(data.deceased);
            $('#chin-description').val(data.description);
        }
    });
}

function listenerToRegisterButton() {
    $('#registerChinId').click(function() {
        window.location.replace("http://localhost:8080/register");
    });
}

function listenerToSelectQueryButton() {
    $('#selectQueryButtonId').click(function() {
        let gender = $('#chin-sex-query-id').val();
        let color = $('#chin-color-query-id').val();
        let from = $('#chin-from-query-id').val();
        let to = $('#chin-to-query-id').val();
        let inFamily = $('#chin-inFamily-query-id').val();

        let urlLocal = "http://localhost:8080/chins/query?gender=" + gender
            + "&color=" + color + "&bornAfter=" + from + "&bornBefore=" + to + "&inFamily=" + inFamily;
        url = urlLocal;
        getAllChins();
    });
}

function listenerToSoldButton() {
    $('#soldChinButtonId').click(function () {
        url = "http://localhost:8080/chins/sold";
        getAllChins();
    });
}

function listenerToDeceasedButton() {
    $('#deceasedChinButtonId').click(function () {
        url = "http://localhost:8080/chins/deceased";
        getAllChins();
    });
}

function listenerToAllChinButton() {
    $('#allChinButtonId').click(function () {
        url = "http://localhost:8080/chins";
        getAllChins();
    });
}