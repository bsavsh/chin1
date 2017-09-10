$(document).ready(function () {
    let familyNumber = $('#familyNumber').val();
    getAllChins(familyNumber);
    saveEditedChin(familyNumber);
});


function getAllChins(familyNumber) {
    let url = "http://localhost:8080/families/whole-by-number/" + familyNumber;
    console.log(url);
    $.ajax({
        url: url,
        type: 'GET',
        success: function(result) {
            let chinList = result;
            $.each(chinList, function(i, chin) {
                let url = "http://localhost:8080/chin?id=" + chin.id;
                let newRowContent =
                    "<tr>" +
                    "<td> <a href= " + url + ">" + chin.id + "</a></td>" +
                    "<td>" + chin.sex + "</td>" +
                    "<td>" + chin.color + "</td>" +
                    "<td>" + chin.fatherId + "</td>" +
                    "<td>" + chin.motherId + "</td>" +
                    "<td>" + chin.born + "</td>" +
                    "<td>" + chin.inFamily + "</td>" +
                    "<td>" + chin.name + "</td>" +
                    "<td><button type='button' class='btn btn-default chin-edit'" +
                    " data-toggle='modal' data-target='#editChinModalBlanckId'>Edit</button></td>"
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
        let dataSender = {
            id: $('#chin-id').text(),
            sex: $('#chin-sex').val(),
            color: $('#chin-color').val(),
            fatherId: $('#chin-fatherId').val(),
            motherId: $('#chin-motherId').val(),
            born: $('#chin-born').val(),
            deceased: $('#chin-deceased').val(),
            sold: $('#chin-sold').val(),
            inFamily: $('#chin-inFamily').val(),
            name: $('#chin-name').val
        };

        $.ajax({
            type: 'PUT',
            contentType: 'application/json',
            url: 'http://localhost:8080/chins',
            dataType: "json",
            data: JSON.stringify(dataSender),
            success: function(data){
                if (data.id !== undefined) {
                    // window.location.replace("http://localhost:8080/chin?id=" + data.id);
                    $('#chinTableId tbody > tr').remove();
                    getAllChins(familyNumber);
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
            $('#chin-id').text(data.id);
            $('#chin-sex').val(data.sex);
            $('#chin-color').val(data.color);
            $('#chin-fatherId').val(data.fatherId);
            $('#chin-motherId').val(data.motherId);
            $('#chin-born').val(data.born);
            $('#chin-deceased').val(data.deceased);
            $('#chin-sold').val(data.sold);
            $('#chin-inFamily').val(data.inFamily);
            $('#chin-name').val(data.name);
        }
    });
}


