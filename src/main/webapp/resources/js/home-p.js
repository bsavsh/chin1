$(document).ready(function(){
    getNumberOfAllChins();
    getNumberOfFemalesInFamilies();
    getNumberOfMalesInFamilies();
    getNumberOfChinNotInFamilies();
});

function getNumberOfAllChins() {
    $.ajax({
        url: "http://localhost:8080/statistics/number-of-all-chins",
        type: 'GET',
        success: function(result) {
            $('#all-chin').text(result);
        }
    });
}

function getNumberOfFemalesInFamilies() {
    $.ajax({
        url: "http://localhost:8080/statistics/number-of-females-in-family",
        type: 'GET',
        success: function(result) {
            $('#females-chin').text(result);
        }
    });
}

function getNumberOfMalesInFamilies() {
    $.ajax({
        url: "http://localhost:8080/statistics/number-of-males-in-family",
        type: 'GET',
        success: function(result) {
            $('#males-chin').text(result);
        }
    });
}

function getNumberOfChinNotInFamilies() {
    $.ajax({
        url: "http://localhost:8080/statistics/number-of-all-not-in-family",
        type: 'GET',
        success: function(result) {
            $('#all-not-infamilies-chin').text(result);
        }
    });
}
