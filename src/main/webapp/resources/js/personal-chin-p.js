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
});