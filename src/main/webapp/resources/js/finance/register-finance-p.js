$(document).ready(function() {

    let url = "http://localhost:8080/financies";

    $('#register-button-id').click(function() {
        let dataSender = {
            id: null,
            chinId: $('#finance-chinId').val(),
            dateOfChinGone: $('#finance-dateOfChinGone').val(),
            description: $('#finance-description').val()
        };

        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: url,
            dataType: "json",
            data: JSON.stringify(dataSender),
            success: function(data){
                if (data.id !== undefined) {
                    window.location.replace("http://localhost:8080/financies-page");
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