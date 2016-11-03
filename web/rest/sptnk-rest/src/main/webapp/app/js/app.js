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
function _addBook() {

    var id = $('#id').val();
    var name = $('#name').val();
    var athor = $('#athor').val();
    var date = $('#date').val();
    var catalog = $('#catalog').val() == 1;

    var book = {
        id: id ? id : null,
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

function _getBook(id) {
    var defer = $.Deferred();

    $.ajax({
        method: "GET",
        url: "rest/api/libserv/get/"+id,
        success: function (_response) {
            defer.resolve(_response.books);
        }
    });
    $.when(defer).then(function (data) {
        console.log(data);
        var isClose = data[0].close && data[0].close != "false" ? 1 : 0;

        $('#id').val(data[0].id);
        $('#name').val(data[0].name);
        $('#athor').val(data[0].athor);
        $('#date').val(data[0].date);
        $('#catalog').val(isClose);

        $('#addDlg').modal('show');
    })
}

function _delBook(id, catalog) {
    var defer = $.Deferred();

    $.ajax({
        method: "DELETE",
        url: "rest/api/libserv/remove/"+id,
        dataType : 'text',
        success: function (_response) {
            defer.resolve(_response);
        }
    });
    $.when(defer).then(function (data) {
        console.log(data);
        getCatalog(catalog);
    })
}

function getCatalog(isClose) {

    var defer = $.Deferred();
    var criteria = {
        close: isClose
    };

    var tbody = $('#books > tbody');

    var close = isClose && isClose != "false";

    if (close) {
        $('#openCatalog').removeClass('active');
        $('#closeCatalog').addClass('active');
    } else {
        $('#closeCatalog').removeClass('active');
        $('#openCatalog').addClass('active');
    }

    $.ajax({
            method: 'POST',
            url:'rest/api/libserv/search',
            data: JSON.stringify(criteria),
            success: function (response) {
                defer.resolve(response);
            }
        });

    $.when(defer).then(function(data) {
        tbody.empty();

        if (data.books.length > 0) {

            data.books.forEach(function (item, i) {
                var index = i+1;

                var row = $('<tr/>');

                var editBtn = $('<a/>');
                editBtn.addClass('glyphicon');
                editBtn.addClass('glyphicon-pencil');
                editBtn.addClass('edit-btn');
                editBtn.addClass('margin-5');
                editBtn.click(function () {
                    _getBook(item.id);
                });

                var delBtn = $('<a/>');
                delBtn.addClass('glyphicon');
                delBtn.addClass('glyphicon-remove');
                delBtn.addClass('del-btn');
                delBtn.addClass('margin-5');
                delBtn.click(function () {
                    _delBook(item.id, item.close);
                });

                var btnRow = $('<td/>');

                btnRow.append(editBtn).append(delBtn);

                row.append( $('<td/>').text(index))
                    .append($('<td/>').text(item.name))
                    .append($('<td/>').text(item.athor))
                    .append($('<td/>').text(item.date))
                    .append(btnRow);
                tbody.append(row);
            });
        }

    });
}

