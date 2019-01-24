function $(id) {
    return typeof id === "string" ? document.getElementById(id) : id;
}
//Float
//滑动顶部
$("totop").onclick=function(){
    var time = setInterval(function () {
        document.body.scrollTop = document.body.scrollTop - 50;
        if (document.body.scrollTop === 0) {
            clearInterval(time);
        }
    }, 1);
}

document.body.scrollTop=0;
var Float=document.getElementById("float");
var init= document.body.scrollTop|| document.documentElement.scrollTop;
if(init==0)Float.style.display="none";;
document.onscroll=function(){
    var scrollY = document.body.scrollTop|| document.documentElement.scrollTop;
    if(scrollY!=init){
        Float.style.display="block";
    }
    else{
        Float.style.display="none";
    }
}


//导航栏产品中心和搜索
$("search").style.display="none";
$("search_top_off").onclick=function(){
    $("search").style.display="none";
    $("amazing").style.display="none";
};
$("searchicon").onclick=function(){
    if($("search").style.display!="none"){
        $("search").style.display="none";
        $("amazing").style.display="none";
        return;
    }
    $("search").style.display="block";
    $("amazing").style.display="block";
    $("search_form_text").focus();
};

$("mynav_procude_center").style.display="none";
$("mynav_procude_center").onmouseover=$("down").onmouseover=function(){
    $("down").style.backgroundColor="#0072bc";
    $("down").getElementsByTagName("a")[0].style.color="white";
    $("mynav_procude_center").style.display="block";
    $("toc").style.display="block";
}

$("mynav_procude_center").onmouseout=$("down").onmouseout=function(){
    $("down").getElementsByTagName("a")[0].style.color="black";
    $("down").style.backgroundColor="#fff";
    $("mynav_procude_center").style.display="none";
    $("toc").style.display="none";
}



//跳转页面

//变量声明
if($("center_right_bottom_list")!="center_right_bottom_list" && $("center_right_bottom_list")){
    var bottomlist=$("center_right_bottom_list").children;
    document.page=1;
    document.pagemax=bottomlist.length;
    /*
    //from:原来的页面
    //to:要到的页面
    */
    function pagechange(from,to){
        if(from<1||to>document.pagemax)return ;
        bottomlist[from-1].classList.remove("bottom_hover");
        bottomlist[to-1].classList.add("bottom_hover");
    }

    $("goleft").onclick=function(){
        if(document.page===1)return ;
        pagechange(document.page,document.page-1);
        document.page--;
    }

    $("goright").onclick=function(){
        if(document.page===document.pagemax)return ;
        pagechange(document.page,document.page+1);
        document.page++;
    }


    //换页
    for(var i=0;i<document.pagemax;i++){
        (function(i){
             bottomlist[i].onclick=function(){
                if(i+1===document.page)return;
                pagechange(document.page,i+1);
                document.page=i+1;
            } 
        })(i);
    }
}
