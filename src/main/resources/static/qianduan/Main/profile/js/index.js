function $(id) {
    return typeof id === "string" ? document.getElementById(id) : id;
}
//改变高度
$("center").style.height=$("center_right_main").clientHeight+"px";
