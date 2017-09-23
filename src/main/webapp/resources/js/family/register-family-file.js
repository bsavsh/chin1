$(document).ready(function () {
    let url = "http://localhost:8080/families";
    $('#register-button-id').click(function () {
        let dataSender = {
            id: null,
            number: $('#family-numberOfFamily').val(),
            husband: {"id": $('#family-husbandId').val()},
            wife: {"id": $('#family-wifeId').val()},
            dateOfFormation: $('#family-dateOfFormation').val(),
            description: $('#family-description').val()
        };
        $.ajax({
            type: 'POST',
            contentType: 'application/json',
            url: url,
            dataType: "json",
            data: JSON.stringify(dataSender),
            success: function (data) {
                if (data.id !== undefined) {
                    window.location.replace("http://localhost:8080/families-page");
                } else {
                    let str = "";
                    for (let i = 0; i < data.length; i++) {
                        str += data[i].message + "</br>";
                        $("#errorsId").html(str);
                    }
                    $("#errorMessagesId").show();
                }
            },
            error: function () {
                alert('register family error: ');

            }
        });
    });
});