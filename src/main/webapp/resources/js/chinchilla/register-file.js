$(document).ready(function() {

    let url = "http://localhost:8080/chins";

    $('#register-button-id').click(function() {
        let father = $('#chin-fatherId').val() == 0 ? null : {"id": $('#chin-fatherId').val()};
        let mother = $('#chin-motherId').val() == 0 ? null : {"id": $('#chin-motherId').val()};
        let dataSender = {
            id: null,
            gender: $('#chin-gender').val(),
            color: $('#chin-color').val(),
            father: father,
            mother: mother,
            born: $('#chin-born').val(),
            description: $('#chin-description').val()
        };

        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: url,
            dataType: "json",
            data: JSON.stringify(dataSender),
            success: function(data){
                if (data.id !== undefined) {
                    window.location.replace("http://localhost:8080/chin?id=" + data.id);
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
                alert('register Chin error: ');

            }
        });
    });

});