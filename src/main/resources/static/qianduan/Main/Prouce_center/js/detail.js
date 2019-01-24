//底部模块切换
var selectlist = document.getElementById("selectlist").children;
var selectbox = document.getElementsByClassName("selectbox");
var selectlen = (selectlist.length + 1) / 2;

var j;
for (var i = 0; i < selectlen; i++) {
    (function (i) {
        selectlist[2 * i].onclick = function () {
            for (j = 0; j < selectlen; j++) {
                selectbox[j].classList.remove("selecton");
                selectlist[2 * j].classList.remove("on");
            }
            selectbox[i].classList.add("selecton");
            selectlist[2 * i].classList.add("on");
        }
    })(i);
}


//大图切换
var bigimg = document.getElementById("bigimg").children[0].getElementsByTagName("img")[0];
var zoomimg = document.getElementById("zoom").getElementsByTagName("img")[0];
var imglist = document.getElementById("imglist").children[0].children;
var imglen = imglist.length;

var temp = 0;
bigimg.src = imglist[1].children[0].src;
for (var i = 0; i < imglen; i++) {
    (function (i) {
        imglist[i].onclick = function () {
            for (temp = 0; temp < imglen; temp++) {
                imglist[temp].classList.remove("clicked");
            }
            bigimg.src = imglist[i].children[0].src;
            zoomimg.src = imglist[i].children[0].src;
            imglist[i].classList.add("clicked");
        }
    })(i);
}

//放大镜
//bigimg要放大的图片
//zoom放大的图片

jQuery("#dimg").mouseover(function () {
    jQuery("#zoom").css("display", "block");
    jQuery("#block").css("display", "block");
    document.getElementsByClassName("topright")[0].style.display = "none";
});


jQuery("#dimg").mouseout(function () {
    jQuery("#zoom").css("display", "none");
    jQuery("#block").css("display", "none");
    document.getElementsByClassName("topright")[0].style.display = "block";
});

var img = document.getElementById("dimg").getElementsByTagName("img");
var realWidth = img[0].naturalWidth;
var realHeight = img[0].naturalHeight;
// //绑定鼠标在原图窗口移动的事件
jQuery("#dimg").mousemove(function (e) { 
    // 获取鼠标当前的位置
    var x = e.clientX;
    var y = e.clientY;
    // 获取原图窗口距离文档的偏移位置
    var sX = jQuery('#dimg').offset().left;
    var sY = jQuery('#dimg').offset().top - jQuery(window).scrollTop();

    // 计算鼠标的相对位置（相对于原图窗口的偏移距离）
    var mx = x - sX;
    var my = y - sY;

    // 获取小框框的宽高
    var mw = jQuery('#block').width() / 2;
    var mh = jQuery('#block').height() / 2;

    // 鼠标移动后小框框的移动距离
    jQuery('#block').css({
        left: mx - mw + 'px',
        top: my - mh + 'px'
    });

    // 获取小框框的偏移位置
    var lw = jQuery('#block').position().left;
    var lh = jQuery('#block').position().top;


    // 判断边界（小框框只能在原图窗口范围内移动）
    var maxW = jQuery('#dimg').width();
    var maxH = jQuery('#dimg').height();
    
    // 左边界
    if (lw <= 0) {
        jQuery('#block').css('left', '0px');
    }
    // 右边界
    if (lw >= maxW) {
        jQuery('#block').css('left', maxW-mx*2 + 'px');
    }
    // 上边界
    if (lh <= 0) {
        jQuery('#block').css('top', '0px');
    }
    // 下边界
    if (lh >= maxH) {
        jQuery('#block').css('top', maxH-my*2 + 'px');
    }
    

    // 获取小框框的偏移位置

    var newX = lw*5;
    var newY = lh*5;
    jQuery('#zoom img').css({
        left: -newX + 'px',
        top: -newY + 'px',
    });
});




//Float
//滑动顶部
$("totop").onclick = function () {
    var time = setInterval(function () {
        document.body.scrollTop = document.body.scrollTop - 50;
        if (document.body.scrollTop === 0) {
            clearInterval(time);
        }
    }, 1);
}

document.body.scrollTop = 0;
var Float = document.getElementById("float");
var init = document.body.scrollTop || document.documentElement.scrollTop;
if (init == 0) Float.style.display = "none";
document.onscroll = function () {
    var scrollY = document.body.scrollTop || document.documentElement.scrollTop;
    if (scrollY != init) {
        Float.style.display = "block";
    } else {
        Float.style.display = "none";
    }
}