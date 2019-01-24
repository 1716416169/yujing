function $(id) {
    return typeof id === "string" ? document.getElementById(id) : id;
}
 //控制网页高度
 var listlen= $("center_right_main").children[0].children.length;
 var listheight=(Math.ceil(listlen/3))*31;
 $("center").style.height=listheight+10+"rem";
 $("center_right_main").style.height=listheight+5+"rem";

 