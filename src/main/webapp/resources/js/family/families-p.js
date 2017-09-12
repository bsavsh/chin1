$(document).ready(function(){

    getAllFamilies();
    saveEditedFamily();
    listenerToRegisterFamilyButton();
});

let url = "http://localhost:8080/families";

function getAllFamilies() {
    $.ajax({
        url: url,
        type: 'GET',
        success: function(result) {
            let familiesList = result;
            $.each(familiesList, function(i, family) {
                let url = "http://localhost:8080/family?number=" + family.numberOfFamily;
                let newRowContent =
                    "<tr>" +
                    "<td>" + family.id + "</td>" +
                    "<td> <a href= " + url + ">" + family.numberOfFamily + "</a></td>" +
                    "<td>" + family.husbandId + "</td>" +
                    "<td>" + family.wifeId + "</td>" +
                    "<td>" + family.dateOfFormation + "</td>" +
                    "<td>" + family.description + "</td>" +
                    "<td><button type='button' class='btn btn-default family-edit'" +
                    " data-toggle='modal' data-target='#editFamilyModalBlanckId'>...</button></td>" +
                    "<td><button type='button' class='btn btn-default family-delete'" +
                    " data-toggle='modal' data-target='#deleteFamilyModalBlanckId'>...</button></td>"
                "</tr>";

                $("#familyTableId tbody").append(newRowContent);
            });

            $('.family-edit').click(function() {
                let familyId = $(this).parents('tr').find('td').eq(0).text();
                getFamilyById(familyId);
            });

            $('.family-delete').click(function() {
                let id = $(this).parents('tr').find('td').eq(0).text();
                $('#modalDeleteFamilyButtonId').click(function() {
                    let rootUrl = "http://localhost:8080/families";
                    $.ajax({
                        type: 'DELETE',
                        url: rootUrl + '/' + id,
                        dataType: "json",
                        success: function() {
                            $('#familyTableId tbody > tr').remove();
                            getAllFamilies();
                        },
                        error: function(){
                            $('#familyTableId tbody > tr').remove();
                            getAllFamilies();
                        }
                    });
                });
            });
        }
    });
}


// action to save button in edit window
function saveEditedFamily() {
    $('#modalSaveEditFamilyButtonId').click(function() {
        let dataSender = {
            id: $('#family-id').text(),
            husbandId: $('#family-husbandId').val(),
            wifeId: $('#family-wifeId').val(),
            numberOfFamily: $('#family-numberOfFamily').val(),
            dateOfFormation: $('#family-dateOfFormation').val(),
            description: $('#family-description').val()
        };

        $.ajax({
            type: 'PUT',
            contentType: 'application/json',
            url: url,
            dataType: "json",
            data: JSON.stringify(dataSender),
            success: function(data){
                if (data.id !== undefined) {
                    // window.location.replace("http://localhost:8080/chin?id=" + data.id);
                    $('#familyTableId tbody > tr').remove();
                    getAllFamilies();
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
                alert('updateFamily error: ');
            }
        });
    });


    $(".modalCloseEditFamilyButton").click(function () {
        $("#errorMessagesId").hide();
    })
}

// to fill modal edit form
function getFamilyById(id) {
    let rootURL = "http://localhost:8080/families/";
    $.ajax({
        type: 'GET',
        url: rootURL + '/' + id,
        dataType: "json",
        success: function(data){
            $('#family-id').text(data.id);
            $('#family-husbandId').val(data.husbandId);
            $('#family-wifeId').val(data.wifeId);
            $('#family-numberOfFamily').val(data.numberOfFamily);
            $('#family-dateOfFormation').val(data.dateOfFormation);
            $('#family-description').val(data.description);
        }
    });
}

function listenerToRegisterFamilyButton() {
    $('#registerFamilyPageButtonId').click(function() {
        window.location.replace("http://localhost:8080/register-family-page");
    });
}

