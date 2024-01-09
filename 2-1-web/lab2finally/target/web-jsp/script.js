$("#form").on("submit", function(){
    let y = document.getElementById("y").value;
    let r = document.getElementById("r").value;

    if(!Ychecker(y)){
        yErr();
        console.log("y warning");
        return false;
    }
    if(!Rchecker(r)){
        rErr();
        console.log("r warning");
        return false;
    }
});

function Ychecker(y) {
    if (y <= -3 || y >= 5) {
        yErr();
        console.log("y zalupa");
        return false;
    } else {
        return true;
    }
}
function Rchecker(r){
    if(r <= 2 || r >= 5){
        rErr();
        console.log("r zalupa");
        return false;
    } else {
        return true;
    }
}

function yErr(){
    Swal.fire({
        icon: 'error',
        title: 'АШИБКА',
        text: 'НЕВЕРНЫЙ Y (не входит в (-3,5))'
    });
}

function rErr(){
    Swal.fire({
        icon: 'error',
        title: 'АШИБКА',
        text: 'НЕВЕРНЫЙ R (не входит в (2,5))'
    });
}

function backReturn(){
    window.location.replace("http://localhost:8080/web-jsp/");
}
