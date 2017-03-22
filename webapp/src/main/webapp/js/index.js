/**
 * Created by Abakumov on 01.10.2016.
 */

$(document).ready(function(){
    $("#my-tab a").click(function (e) {
        e.preventDefault();
        $(this).tab('show');
    });
});

