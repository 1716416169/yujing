function $(id) {
    return typeof id === "string" ? document.getElementById(id) : id;
}
//换标签
var pagelist= $("center_left_list").children[0].children;
var pagelen=pagelist.length;
var pagepoint=pagelist[0];//
var posEngName=["Indoor farming solution","Outdoor farming solution"]

for(var i=0;i<pagelen;i++){
    (function(i){
        pagelist[i].onclick = function(){
            if(pagelist[i]===pagepoint){
                return;
            }
            pagepoint.getElementsByClassName("left_arrowr")[0].src="../../img/left_arrowr_r.png";
            pagepoint.classList.remove("nowpos");
            pagepoint=pagelist[i];
            pagelist[i].classList.add("nowpos");
            pagelist[i].getElementsByClassName("left_arrowr")[0].src="../../img/left_arrowr_rblue.png";
            $("top_tips").innerHTML="<h3>"+pagepoint.innerText+"</h3> / "+posEngName[i];
        };
    })(i)
    
}