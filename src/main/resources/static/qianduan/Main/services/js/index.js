function $(id) {
    return typeof id === "string" ? document.getElementById(id) : id;
}

var list=document.getElementsByClassName("problemslist");
var listlen=list.length;
var problemslist_icon=document.getElementsByClassName("problemslist_icon");

for(var i=0;i<listlen;i++){
    (function(i){
        list[i].onclick=function(){
            //重复点击已经打开的
            if(list[i].style.height===18+"rem"){
                list[i].style.height=6+"rem";
                problemslist_icon[i].src="../qianduan/Main/services/img/down.png";
                return;
            }
            //排他
            for(var j=0;j<listlen;j++){
                list[j].style.height=6+"rem";
                problemslist_icon[i].src="../qianduan/Main/services/img/down.png";
            }
            list[i].style.height=18+"rem";
            problemslist_icon[i].src="../qianduan/Main/services/img/up.png";
    }})(i);
}
