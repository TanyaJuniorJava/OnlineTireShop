/**
 * Created by cube on 20.08.2016.
 */
var main = {
    registration: function () {
        var log = document.getElementById("logReg").value;
        var mail = document.getElementById("mailReg").value;
        var pass = document.getElementById("passReg").value;
        $.ajax({
            type: "POST",
            url: "/OnlineTireShop",
            dataType: "json",
            data: {requestType: "registration", login: log, password: pass, email: mail},
            success: function (data) {
                console.log(data);
                document.location.href = 'shop.html'
            }
        });
    },

    log_in: function () {
        var log = document.getElementById("login").value;
        var pass = document.getElementById("password").value;
        $.ajax({
            type: "POST",
            url: "/OnlineTireShop",
            dataType: "json",
            data: {requestType: "login", login: log, password: pass},
            success: function (data) {
                if (data.name == "error")
                    document.location.href = 'errorPage.html';
                else
                    document.location.href = 'shop.html'
                window.onload = function () {
                    document.getElementById("name").innerHTML = data.name;
                    document.getElementById("index").innerHTML = data.indexNumber;
                }

            }
        });
    }


};