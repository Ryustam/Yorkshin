$(document).ready(function (){
    $.ajax({
        url: 'http://localhost:8008/admin',
        type: 'GET',
        success: function(data) {
            console.log(data);
        },
    });

    $('.one').off('click');
    $('.one').on('click', function () {
        $('.two').width('400px');
    });

})

