$(document).ready(function () {
    let id = $('#chinId').val();
    let rootURL = "http://localhost:8080/chins/";

    let lastUrl = "first-offspring";
    $.ajax({
        type: 'GET',
        url: rootURL + '/' + id,
        dataType: "json",
        success: function (data) {
            $('#chin-id').append(data.id);
            $('#chin-gender').append(data.gender);
            $('#chin-color').append(data.color);
            $('#chin-fatherId').append(data.fatherId);
            $('#chin-motherId').append(data.motherId);
            $('#chin-born').append(data.born);
            $('#chin-deceased').append(data.deceased);
            $('#chin-description').append(data.description);
        }
    });

    // at page loading make ajax for first offspring of chin
    $('#chinTableId tbody > tr').remove();
    let urlForParrents = "http://localhost:8080/" + "first-offspring" + "/" + id;
    $.ajax({
        url: urlForParrents,
        type: 'GET',
        success: function (result) {
            let chinList = result;
            $.each(chinList, function (i, chin) {
                let root = "http://localhost:8080/chin?id=";
                let url = root + chin.id;
                let fatherUrl = root + chin.fatherId;
                let motherUrl = root + chin.motherId;
                let newRowContent =
                    "<tr>" +
                    "<td> <a href= " + url + ">" + chin.id + "</a></td>" +
                    "<td>" + chin.gender + "</td>" +
                    "<td>" + chin.color + "</td>" +
                    "<td><a href= " + fatherUrl + ">" + chin.fatherId + "</a></td>" +
                    "<td><a href= " + motherUrl + ">" + chin.motherId + "</a></td>" +
                    "<td>" + chin.born + "</td>" +
                    "<td>" + chin.description + "</td>" +
                    "<td><button type='button' class='btn btn-default chin-edit'" +
                    " data-toggle='modal' data-target='#editChinModalBlanckId'>...</button></td>"
                    "</tr>";

                $("#chinTableId tbody").append(newRowContent);
            });

            $('.chin-edit').click(function () {
                let chinId = $(this).parents('tr').find('td').eq(0).text();
                getChinById(chinId);
            });
        }
    });

    listenerToIndexData();
    listenerToBloodRelation();
    listenerToEditChinOnPersonalPage(id);
    listenerToAncestors();
    listenerToOthers();
    listenerToOffspring();

    listenerToAncestorsByNamingThem("#parrents-id", "parrents", id);
    listenerToAncestorsByNamingThem("#grand-parrents-id", "grand-parrents", id);
    listenerToAncestorsByNamingThem("#great-grand-parrents-id", "great-grand-parrents", id);
    listenerToAncestorsByNamingThem("#great-great-grand-parrents-id", "great-great-grand-parrrents", id);
    listenerToAncestorsByNamingThem("#all-ancestors-up-to-10-id", "all-ancestors-up-to-10-generations", id);
    listenerToAncestorsByNamingThem("#brothers-sisters-id", "brothers-and-sisters", id);
    listenerToAncestorsByNamingThem("#half-brothers-and-half-sisters-id", "half-brothers-and-half-sisters", id);
    listenerToAncestorsByNamingThem("#uncles-and-aunts-id", "uncles-and-aunts", id);
    listenerToAncestorsByNamingThem("#cousins-id", "cousins", id);
    listenerToAncestorsByNamingThem("#first-offspring-id", "first-offspring", id);
    listenerToAncestorsByNamingThem("#second-offspring-id", "second-offspring", id);
    listenerToAncestorsByNamingThem("#all-offspring-id", "all-offspring", id);

    saveEditedChin();
});

function listenerToIndexData() {
    $('#index-data-id').click(function () {
        $('#index-data-info').toggle();
    });
}

function listenerToBloodRelation() {
    $('#blood-relation-id').click(function () {
        $('#blood-relation-info').toggle();
    });
}

function listenerToEditChinOnPersonalPage(id) {
    $('#chin-edit-id').click(function () {
        getChinById(id);
    })
}

function listenerToAncestors() {
    $('#ancestors-id').click(function () {
        $('#others-buttons-id').hide();
        $('#offspring-buttons-id').hide();
        $('#ancestor-buttons-id').toggle();
    });
}

function listenerToOthers() {
    $('#others-id').click(function () {
        $('#ancestor-buttons-id').hide();
        $('#offspring-buttons-id').hide();
        $('#others-buttons-id').toggle();
    })
}

function listenerToOffspring() {
    $('#offspring-id').click(function () {
        $('#ancestor-buttons-id').hide();
        $('#others-buttons-id').hide();
        $('#offspring-buttons-id').toggle();
    });
}

function listenerToAncestorsByNamingThem(buttonId, name, id) {
    lastUrl = name;
    $(buttonId).click(function () {
        getAncestorsByNamingThemAndId(name, id);
    });
}

function getAncestorsByNamingThemAndId(name, id) {
    $('#chinTableId tbody > tr').remove();
    let urlForParrents = "http://localhost:8080/" + name + "/" + id;
    $.ajax({
        url: urlForParrents,
        type: 'GET',
        success: function (result) {
            let chinList = result;
            $.each(chinList, function (i, chin) {
                let root = "http://localhost:8080/chin?id=";
                let url = root + chin.id;
                let fatherUrl = root + chin.fatherId;
                let motherUrl = root + chin.motherId;
                let newRowContent =
                    "<tr>" +
                    "<td> <a href= " + url + ">" + chin.id + "</a></td>" +
                    "<td>" + chin.gender + "</td>" +
                    "<td>" + chin.color + "</td>" +
                    "<td><a href= " + fatherUrl + ">" + chin.fatherId + "</a></td>" +
                    "<td><a href= " + motherUrl + ">" + chin.motherId + "</a></td>" +
                    "<td>" + chin.born + "</td>" +
                    "<td>" + chin.description + "</td>" +
                    "<td><button type='button' class='btn btn-default chin-edit'" +
                    " data-toggle='modal' data-target='#editChinModalBlanckId'>...</button></td>"
                    "</tr>";
                $("#chinTableId tbody").append(newRowContent);
            });


            $('.chin-edit').click(function () {
                let chinId = $(this).parents('tr').find('td').eq(0).text();
                getChinById(chinId);
            });

        }
    });
}


function getChinById(id) {
    let rootURL = "http://localhost:8080/chins/";
    $.ajax({
        type: 'GET',
        url: rootURL + '/' + id,
        dataType: "json",
        success: function (data) {
            $('#chin-id-modal').text(data.id);
            $('#chin-gender-modal').val(data.gender);
            $('#chin-color-modal').val(data.color);
            $('#chin-fatherId-modal').val(data.fatherId);
            $('#chin-motherId-modal').val(data.motherId);
            $('#chin-born-modal').val(data.born);
            $('#chin-deceased-modal').val(data.deceased);
            $('#chin-description-modal').val(data.description);
        }
    });
}

// action to save button in edit window
function saveEditedChin() {
    $('#modalSaveEditChinButtonId').click(function () {
        let fatherId = $('#chin-fatherId-modal').val() == 0 ? null : {"id": +$('#chin-fatherId-modal').val()};
        let motherId = $('#chin-motherId-modal').val() == 0 ? null : {"id": +$('#chin-motherId-modal').val()};
        let dataSender = {
            id: $('#chin-id-modal').text(),
            gender: $('#chin-gender-modal').val(),
            color: $('#chin-color-modal').val(),
            father: fatherId,
            mother: motherId,
            born: $('#chin-born-modal').val(),
            deceased: $('#chin-deceased-modal').val(),
            description: $('#chin-description-modal').val()
        };
        $.ajax({
            type: 'PUT',
            contentType: 'application/json',
            url: "http://localhost:8080/chins",
            dataType: "json",
            data: JSON.stringify(dataSender),
            success: function (data) {
                if (data.id !== undefined) {
                } else {
                    let str = "";
                    for (let i = 0; i < data.length; i++) {
                        str += data[i].message + "</br>";
                        // $("#errorsId").html(str);
                    }
                    alert(str);
                    // $("#errorMessagesId").show();
                }

            },
            error: function () {
                alert('updateChin error: ');
            }
        });
    });
    $(".modalCloseEditChinButton").click(function () {
        $("#errorMessagesId").hide();
    });
}