let form = document.querySelector(".js-form"),
    inputY = document.querySelector(".js-input-y"),
    inputR = document.querySelector(".js-input-r");

if(localStorage.getItem("data") == null){
    localStorage.setItem("data", "");
}

$("#zapros").on("submit", function(){
    let yVal = inputY.value,
        rVal = inputR.value;

    // validate
    if (!validateY(yVal)){
        yErr();
        console.log("Y_value error");
        return false;
    }
    if (!validateR(rVal)){
        rErr();
        console.log("Radius_value error");
        return false;
    }

    //zapros
    $.ajax({
        url: './back.php',
        method: 'post',
        dataType: 'html',
        data: $(this).serialize(),
        success: function(data){
            localStorage.setItem("data", data + localStorage.getItem("data"))
            addToTable(data);
        }
    });
})

function validateY(y){
    if(!(y <= -3 || y >= 3)){
        return true;
    } else {
        yErr();
        return false;
    }
}

function yErr(){
    Swal.fire({
        icon: 'error',
        title: 'АШИБКА',
        text: 'НЕВЕРНЫЙ Y (не входит в (-3,3))'
    });
}

function validateR(r){
    if(!(r <= 1 || r >= 4)){
        return true;
    } else {
        rErr();
        return false;
    }
}

function rErr(){
    Swal.fire({
        icon: 'error',
        title: 'АШИБКА',
        text: 'НЕВЕРНЫЙ R (не входит в (1,4))'
    });
}

// check php 
function php_response(param) {
    if(param.split("/")[0].split(";")[0] === ""){
        alert("Ошибка в отправленных данных");
    }else{
        console.log(param);
        addToTable(param);
    }
}

addToTable();

// add to table
function addToTable(cookies){
    let table = document.getElementById("tableOut");
    table.innerHTML = localStorage.getItem("data");
}

function clearTable(){
    localStorage.clear();
    location.reload();
}
