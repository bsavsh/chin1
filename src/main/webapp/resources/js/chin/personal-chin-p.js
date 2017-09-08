$(document).ready(function () {
    let id = $('#chinId').val();
    let rootURL = "http://localhost:8080/chins/";
    $.ajax({
        type: 'GET',
        url: rootURL + '/' + id,
        dataType: "json",
        success: function(data){
            $('#chin-id').append(data.id);
            $('#chin-sex').append(data.sex);
            $('#chin-color').append(data.color);
            $('#chin-fatherId').append(data.fatherId);
            $('#chin-motherId').append(data.motherId);
            $('#chin-born').append(data.born);
            $('#chin-deceased').append(data.deceased);
            $('#chin-name').append(data.name);
        }
    });

    listenerToIndexData();
    listenerToBloodRelation();
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




});

function listenerToIndexData() {
    $('#index-data-id').click(function() {
        $('#index-data-info').toggle();
    });
}

function listenerToBloodRelation() {
    $('#blood-relation-id').click(function() {
        $('#blood-relation-info').toggle();
    });
}

function listenerToAncestors() {
    $('#ancestors-id').click(function() {
        $('#others-buttons-id').hide();
        $('#offspring-buttons-id').hide();
       $('#ancestor-buttons-id').toggle();
    });
}

function listenerToOthers() {
    $('#others-id').click(function() {
        $('#ancestor-buttons-id').hide();
        $('#offspring-buttons-id').hide();
        $('#others-buttons-id').toggle();
    })
}

function listenerToOffspring() {
    $('#offspring-id').click(function() {
        $('#ancestor-buttons-id').hide();
        $('#others-buttons-id').hide();
        $('#offspring-buttons-id').toggle();
    });
}

function listenerToAncestorsByNamingThem(buttonId, name, id) {
    $(buttonId).click(function () {
        getAncestorsByNamingThemAndId(name, id);
    });
}

function getAncestorsByNamingThemAndId(name, id) {
    $('#chinTableId tbody > tr').remove();
    let urlForParrents = "http://localhost:8080/" + name + "/" + id;
    console.log(urlForParrents);

    $.ajax({
        url: urlForParrents,
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
                "</tr>";

                $("#chinTableId tbody").append(newRowContent);
            });
        }
    });
}