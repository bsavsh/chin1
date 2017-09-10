$(document).ready(function () {

    getAllFinancies();
    saveEditedFinance();
    listenerToRegisterFinanceButton();

});

let url = "http://localhost:8080/financies";

// to get all financies in table
function getAllFinancies() {
    $.ajax({
        url: url,
        type: 'GET',
        success: function (result) {
            let financies = result;
            $.each(financies, function (i, finance) {
                let url = "http://localhost:8080/chin?id=" + finance.chinId;
                let newRowContent =
                    "<tr>" +
                    "<td>" + finance.id + "</td>" +
                    "<td><a href= " + url + ">" + finance.chinId + "</a></td>" +
                    "<td>" + finance.dateOfChinGone + "</td>" +
                    "<td>" + finance.dateOfMoneyBack + "</td>" +
                    "<td>" + finance.description + "</td>" +
                    "<td><button type='button' class='btn btn-default chin-edit'" +
                    " data-toggle='modal' data-target='#editFinanceModalBlanckId'>Edit</button></td>"
                "</tr>";

                $("#financeTableId tbody").append(newRowContent);
            });

            // to pass chin id into function that will fill edit-modal
            $('.chin-edit').click(function () {
                let financeId = $(this).parents('tr').find('td').eq(0).text();
                getFinanceById(financeId);
            });
        }
    });
}

// to fill modal edit form
function getFinanceById(id) {
    let rootURL = "http://localhost:8080/financies/";
    $.ajax({
        type: 'GET',
        url: rootURL + '/' + id,
        dataType: "json",
        success: function (data) {
            $('#finance-id').text(data.id);
            $('#finance-chinId').val(data.chinId);
            $('#finance-dateOfChinGone').val(data.dateOfChinGone);
            $('#finance-dateOfMoneyBack').val(data.dateOfMoneyBack);
            $('#finance-description').val(data.description);
        }
    });
}


// action to save button in edit window
function saveEditedFinance() {
    $('#modalSaveEditFinanceButtonId').click(function () {

        let dateOfMoney = $('#finance-dateOfMoneyBack').val() === "" ? null : $('#finance-dateOfMoneyBack').val();

        let dataSender = {
            id: $('#finance-id').text(),
            chinId: $('#finance-chinId').val(),
            dateOfChinGone: $('#finance-dateOfChinGone').val(),
            dateOfMoneyBack: dateOfMoney,
            description: $('#finance-description').val(),
        };

        console.log(dataSender);

        $.ajax({
            type: 'PUT',
            contentType: 'application/json',
            url: url,
            dataType: "json",
            data: JSON.stringify(dataSender),
            success: function (data) {
                if (data.id !== undefined) {
                    // window.location.replace("http://localhost:8080/chin?id=" + data.id);
                    $('#financeTableId tbody > tr').remove();
                    getAllFinancies();
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
                alert('updateChin error: ');
            }
        });
    });


    $(".modalCloseEditFinanceButton").click(function () {
        $("#errorMessagesId").hide();
    });
}

function listenerToRegisterFinanceButton() {
    $('#registerFinanceButtonId').click(function () {
        window.location.replace("http://localhost:8080/register-finance-page");
    });
}