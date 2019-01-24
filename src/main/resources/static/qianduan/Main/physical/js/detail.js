function $(id) {
    return typeof id === "string" ? document.getElementById(id) : id;
}


window.imgindex=0;
function BigimgShow(){
    $("bigimg").src=document.getElementsByClassName("hover")[0].src;
}

function changeBigImg(){
    $("imglist").children[0].classList.remove("hover");
    $("imglist").children[1].classList.remove("hover");
    $("imglist").children[2].classList.remove("hover");
    $("imglist").children[window.imgindex].classList.add("hover");
    BigimgShow();
}

BigimgShow();

for(var i=0;i<3;i++){
    (function(i){
        $("imglist").children[i].onclick=function(){
            $("imglist").children[0].classList.remove("hover");
            $("imglist").children[1].classList.remove("hover");
            $("imglist").children[2].classList.remove("hover");
            $("imglist").children[i].classList.add("hover");
            window.imgindex=i;
            BigimgShow();
        }
    })(i);
}

$("center_right_turn").children[0].onclick=function(){
    console.log(window.imgindex);
    if(window.imgindex==0)return;
    window.imgindex--;
    changeBigImg()
}

$("center_right_turn").children[1].onclick=function(){
    console.log(window.imgindex);
    if(window.imgindex==2)return;
    window.imgindex++;
    changeBigImg()
}
