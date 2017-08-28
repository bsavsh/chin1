$(document).ready(function(){
    let url = "http://localhost:8080/chins";
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
                        "<td><button type='button' class='btn btn-default chin-edit' data-toggle='modal' data-target='#myModal'>Edit</button></td>"
                    "</tr>";

                $("#chinTableId tbody").append(newRowContent);
            })

            $('.chin-edit').click(function() {
                let chinId = $(this).parents('tr').find('td').eq(0).text();
                // alert(managerId);
                getChinById(chinId);
            });
        }
    });

    $('#modalSaveEditChinButtonId').click(function() {
        let dataSender = {
            id: $('#chin-id').text(),
            sex: $('#chin-sex').val(),
            color: $('#chin-color').val(),
            fatherId: $('#chin-fatherId').val(),
            motherId: $('#chin-motherId').val()
        };

        console.log(dataSender.id);
        console.log(dataSender.sex);
        console.log(dataSender.color);
        console.log(dataSender.fatherId);
        console.log(dataSender.motherId);

        $.ajax({
            type: 'PUT',
            contentType: 'application/json',
            url: url,
            dataType: "json",
            data: JSON.stringify(dataSender),
            success: function(data){
                window.location.replace("http://localhost:8080/chin?id=" + data.id);
            },
            error: function(){
                alert('updateChin error: ');
            }
        });
    });
});

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
        }
    });
}
