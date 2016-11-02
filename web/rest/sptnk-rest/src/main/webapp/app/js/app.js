$(function(){
    $(document).ready(function () {
        $.ajaxSetup({
            headers: { 'Content-Type': 'application/json; charset=utf-8' }
        });
        $('#datetimepicker2').datetimepicker({
            locale: 'ru',
            format: 'DD.MM.YYYY'
        });
        getData();
    });
});
function addBook() {

    var name = $('#name').val();
    var athor = $('#athor').val();
    var date = $('#date').val();


    var book = {
        name: name,
        athor: athor,
        date: date,
        close:"true"
    };

    $.ajax({
            method: "POST",
            url: "rest/api/libserv/add",
            data: JSON.stringify(book),
            success: function() {
                name = null;
                athor = null;
                date = null;
                getData();
            }
        });
}

function getData() {

    var defer = $.Deferred();
    var criteria = {
        close: true
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
                .append('</tr>')
            ;
        });
    });
}

