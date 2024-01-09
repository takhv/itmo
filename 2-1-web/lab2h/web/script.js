let form = document.querySelector(".js-form"),
    inputY = document.querySelector(".js-input-y"),
    inputR = document.querySelector(".js-input-r");

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
})

// for y
function validateY(y){
    if((y > -3 || y < 3)){
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

// for radius
function validateR(r){
    if((r > 1 || r < 4)){
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

// clear table
function clearTable(){
    localStorage.clear();
    location.reload();
}
