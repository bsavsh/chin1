$(document).ready(function() {

    let url = "http://localhost:8080/chins";

    $('#register-button-id').click(function() {
        let dataSender = {
            id: null,
            sex: $('#chin-sex').val(),
            color: $('#chin-color').val(),
            fatherId: $('#chin-fatherId').val(),
            motherId: $('#chin-motherId').val(),
            born: $('#chin-born').val(),
            name: $('#chin-name').val()
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