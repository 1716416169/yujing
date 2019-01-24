
function $(id) {
    return typeof id === "string" ? document.getElementById(id) : id;
}

// window.event? window.event.cancelBubble = true : e.stopPropagation();

var news_links=document.getElementsByClassName("news-links");
var  srarch=document.getElementById("search");

news_links[0].onclick=function() {
    
    if(news_links[0].classList.contains("news_hover")){
        return;
    }
    $("news-two").style.display="none";
    $("news-one").style.display="block";
    news_links[1].classList.remove("news-hover");
    news_links[0].classList.add("news-hover");
};

news_links[1].onclick=function() {
    if(news_links[1].classList.contains("news-hover")){
        return;
    }
    $("news-one").style.display="none";
    $("news-two").style.display="block";
    news_links[0].classList.remove("news-hover");
    news_links[1].classList.add("news-hover");
};
