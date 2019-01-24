function $(id) {
    return typeof id === "string" ? document.getElementById(id) : id;
}

//cookie
function getCookie(c_name)
{
if (document.cookie.length>0)
  {
  c_start=document.cookie.indexOf(c_name + "=")
  if (c_start!=-1)
    { 
    c_start=c_start + c_name.length+1 
    c_end=document.cookie.indexOf(";",c_start)
    if (c_end==-1) c_end=document.cookie.length
    return unescape(document.cookie.substring(c_start,c_end))
    } 
  }
return ""
}



//改变位置
var poslist = $(center_left_list).children[0].children;
var poslistlen = poslist.length;
var posEngName=["company news","industry news","customer response"];
var poschange=document.getElementsByClassName("nowpos");
var posname;

if(document.cookie.indexOf("posindex")===-1){
    window.posindex=0;
    document.cookie="posindex="+0+";path=/";
}else{
    window.posindex=getCookie("posindex");
}

for(var i=0;i<poslistlen;i++){
    (function(i){
        poslist[i].onclick=function(){
            poslist[posindex].getElementsByClassName("left_arrowr")[0].src="../../img/left_arrowr_r.png";
            poslist[posindex].classList.remove("clicked");
            poslist[i].classList.add("clicked");
            poslist[i].getElementsByClassName("left_arrowr")[0].src="../../img/left_arrowr_rblue.png";
            window.posindex=i;
            document.cookie="posindex="+window.posindex+";path=/";
            posname=poslist[i].children[0].children[0].innerText;
            poschange[0].innerHTML="<h3>"+posname+"</h3> / "+posEngName[i];
        } 
    })(i);
}
poslist[window.posindex].onclick();


//控制网页高度
var listlen= $("center_right_main").children.length;
var listheight=(listlen)*23;
$("center").style.height=listheight+10+"rem";
$("center_right_main").style.height=listheight+"rem";
