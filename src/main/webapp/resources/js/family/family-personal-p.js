$(document).ready(function () {
    let familyNumber = $('#familyNumber').val();
    getAllChins(familyNumber);
    saveEditedChin(familyNumber);
});


function getAllChins(familyNumber) {
    let url = "http://localhost:8080/families/whole-by-number/" + familyNumber;
    $.ajax({
        url: url,
        type: 'GET',
        success: function(result) {
            let chinList = result;
            $.each(chinList, function(i, chin) {
                let url = "http://localhost:8080/chin?id=" + chin.id;
                let urlFather = "http://localhost:8080/chin?id=" + chin.fatherId;
                let urlMother = "http://localhost:8080/chin?id=" + chin.motherId;
                let newRowContent =
                    "<tr>" +
                    "<td><a href= " + url + ">" + chin.id + "</a></td>" +
                    "<td>" + chin.gender + "</td>" +
                    "<td>" + chin.color + "</td>" +
                    "<td><a href= " + urlFather + ">" + chin.fatherId + "</a></td>" +
                    "<td><a href= " + urlMother + ">" + chin.motherId + "</a></td>" +
                    "<td>" + chin.born + "</td>" +
                    "<td>" + chin.deceased + "</td>" +
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

function saveEditedChin(familyNumber) {
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
            url: 'http://localhost:8080/chins',
            dataType: "json",
            data: JSON.stringify(dataSender),
            success: function(data){
                if (data.id !== undefined) {
                    window.location.replace("http://localhost:8080/family?number=" + familyNumber);
                    // $('#chinTableId tbody > tr').remove();
                    // getAllChins(familyNumber);
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
    })
}

// to fill modal edit form
function getChinById(id) {
    let rootURL = "http://localhost:8080/chins/";
    $.ajax({
        type: 'GET',
        url: rootURL + '/' + id,
        dataType: "json",
        success: function(data){
            let fatherId = data.father !== null ? data.father.id : 0;
            let motherId = data.mother !== null ? data.mother.id : 0;
            $('#chin-id').text(data.id);
            $('#chin-gender').val(data.gender);
            $('#chin-color').val(data.color);
            $('#chin-fatherId').val(fatherId);
            $('#chin-motherId').val(motherId);
            $('#chin-born').val(data.born);
            $('#chin-deceased').val(data.deceased);
            $('#chin-description').val(data.description);
        }
    });
}


