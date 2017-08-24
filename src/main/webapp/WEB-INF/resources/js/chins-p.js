$(document).ready(function(){

    $.ajax({
        url: "http://localhost:8080/chins",
        type: 'GET',
        success: function(result) {
            let chinList = result;
            $.each(chinList, function(i, chin) {
                let url = "http://localhost:8080/chin?id=" + chin.id;
                console.log(url);
                let newRowContent =
                    "<tr>" +
                        "<td> <a href= " + url + ">" + chin.id + "</a></td>" +
                        "<td>" + chin.sex + "</td>" +
                        "<td>" + chin.color + "</td>" +
                        "<td>" + chin.fatherId + "</td>" +
                        "<td>" + chin.motherId + "</td>" +
                    "</tr>";

                $("#chinTableId tbody").append(newRowContent);
            })
        }
    });
});
