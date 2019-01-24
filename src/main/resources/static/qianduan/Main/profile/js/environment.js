window.onload=function(){
    //控制网页高度
    var listlen= $("center_right_main").children.length;
    var listheight=(listlen)*420;
    $("center").style.height=listheight+230+"px";
    $("center_right_main").style.height=listheight+100+"px";
}