function $(id) {
    return typeof id === "string" ? document.getElementById(id) : id;
}

window.onload=function(){
    //控制网页高度
    var listlen= $("center_right_main").children[0].children.length;
    var listheight=(Math.ceil(listlen/3))*35;
    $("center").style.height=listheight+15+"rem";
    $("center_right_main").style.height=listheight+8+"rem";
}
