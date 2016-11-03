$(function(){
    $(document).ready(function () {
        $.ajaxSetup({
            headers: { 'Content-Type': 'application/json; charset=utf-8' }
        });
        $('#datetimepicker2').datetimepicker({
            locale: 'ru',
            format: 'DD.MM.YYYY'
        });
        $('#openCatalog').click(function () {
            getCatalog(false);
        });
        $('#closeCatalog').click(function () {
            getCatalog(true);
        });
        getCatalog(false);
    });
});
function _clearFields() {
    $('#name').val("");
    $('#athor').val("");
    $('#date').val("");
    $('#catalog').val("");
}
function addBook() {

    var name = $('#name').val();
    var athor = $('#athor').val();
    var date = $('#date').val();
    var catalog = $('#catalog').val();

    // var formatedDate = moment(date, "YYYY-MM-DD").format("YYYY-MM-DD");

    var book = {
        name: name,
        athor: athor,
        date: date,
        close: catalog
    };

    var defer = $.Deferred();

    $.ajax({
            method: "POST",
            url: "rest/api/libserv/add",
            data: JSON.stringify(book),
            success: function () {
                defer.resolve();
            }
        });
    $.when(defer).then(function () {
        getCatalog(catalog);
        _clearFields();
    })
}

function getCatalog(isClose) {

    var defer = $.Deferred();
    var criteria = {
        close: isClose
    };

    $.ajax({
            method: 'POST',
            url:'rest/api/libserv/search',
            data: JSON.stringify(criteria),
            success: function (response) {
                defer.resolve(response);
            }
        });

    $.when(defer).then(function(data) {
        $('#books > tbody').empty();
        data.books.forEach(function (item, i) {
            $('#books > tbody')
                .append('<tr>')
                .append('<td>'+i+'</td>')
                .append('<td>'+item.name+'</td>')
                .append('<td>'+item.athor+'</td>')
                .append('<td>'+item.date+'</td>')
                .append('<td><p id="editBook" class="glyphicon glyphicon-pencil"></p></td>')
                .append('</tr>')
            ;
        });
    });
}

