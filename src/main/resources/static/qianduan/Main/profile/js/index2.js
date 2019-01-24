function $(id) {
    return typeof id === "string" ? document.getElementById(id) : id;
}
//改变高度
document.onload=function(){
	$("center").style.height=$("center_right_main").clientHeight+100+"px";
//	console.log($("center_right_main").style.height);
//console.log($("center_right_main").offsetHeight);
//console.log($("center_right_main").clientHeight);
//console.log($("center_right_main").height);
}



