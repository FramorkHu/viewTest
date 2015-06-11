<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>电影详情</title>
<link href="${rc.getContextPath()}/style/home.css" rel="stylesheet" type="text/css" />
<link href="${rc.getContextPath()}/style/other.css" rel="stylesheet" type="text/css" />
<script src="${rc.getContextPath()}/js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="${rc.getContextPath()}/js/DD_belatedPNG.js" type="text/javascript"></script>
</head>
<script>
$(document).ready(function(){
$(".ul li a").click(function(){
$(this).addClass("cur1").parent().siblings().find('a').removeClass('cur1');
});
});</script>
<body>
<!--logo start-->
<div class="logo"><img src="${rc.getContextPath()}/images/logo.png" width="655" height="60" /></div>
<!--logo end-->
<!--导航-->
<div class="nav">
    <ul class="nav nav_ul">
        <li><a href="${rc.getContextPath()}/">主页</a></li>
        <li><a href="${rc.getContextPath()}/film"  class="on" style="color:#fff">电影</a></li>
        <li><a href="${rc.getContextPath()}/documentary" >纪录片</a></li>
        <li><a href="${rc.getContextPath()}/cartoon" >动画片</a></li>
        <li><a href="${rc.getContextPath()}/3d">3D电影</a></li>
        <li><a  href="${rc.getContextPath()}/about"  >关于蓝媒</a></li>
    </ul>
</div>
<!--导航 end-->
<#if !detailBvo??>
    <div class="filmpage_top">
        <div style="border:1px solid #d24727; height:200px; width:700px; margin:30px auto; text-align:center; line-height:200px; font-size:14px;">
            对不起，您查看的目录暂时没有上传影片，点击<a href="${rc.getContextPath()}/film">这里</a>查看其他影片

        </div>
    </div><!--filmpage_top end-->
    <#else>
        <div class="postion"><a href="${rc.getContextPath()}/">首页</a><a href="${rc.getContextPath()}/film">>电影</a><a href="#">>${detailBvo.movieName!''}</a></div>
        <div class="filmpage_top">
            <div class="filmpage_top_left"><img src="${rc.getContextPath()}/${detailBvo.coverImgPath!''}" width="195" height="260" /></div>
            <div class="filmpage_top_right">
                <h4>${detailBvo.movieName!''}</h4>
                <h5>外文名：${detailBvo.movieEnglishName!''}</h5>
                <ul class="ul1">
                    <li style="width:110px;">影片时长：<span>${detailBvo.movieTime!''}</span> </li>
                    <li>出品年代：<span>${detailBvo.movieProduceYear!''}</span></li>
                </ul>
                <ul class="ul1">
                    <li style="width:110px;">导演：<span>${detailBvo.movieDirect!''}</span> </li>
                    <li >主演：<span>${detailBvo.movieActor!''}</span></li>
                </ul>
                <ul class="ul1">
                    <li style="width:110px;">类型：<span>${detailBvo.movieClassifyName!''}</span> </li>
                    <li>国家：<span>${detailBvo.movieCountry!''}</span></li>
                </ul>
                <ul class="ul1">
                    <li style="width:560px;">剧情看点：<span>${detailBvo.ext!''}</span> </li>
                </ul>
                <ul class="ul1">
                    <#if (detailBvo.isMedia>0)>
                        <li class="play"><a href="${rc.getContextPath()}/film/playFilm?film=${detailBvo.id!''}" target="_blank">预告片<img src="${rc.getContextPath()}/images/未标题-1_03.png" width="17" height="17" /></a></li>
                    </#if>
                </ul>
            </div>
        </div><!--filmpage_top end-->
        <div class="filmintro">
            <ul class="ul">
                <li><a href="#jq" class="cur1">影片概览</a></li>
                <li><a href="#tp">电影图片</a></li>
            </ul>
            <h4 id="jq">剧情介绍</h4>
            <p>${detailBvo.movieDescribe!''}</p>
            <h4 id="tp">电影图片</h4>
            <!--缩略图-->
            <div class="mod18Box">
                <div class="mod18">
                    <span id="prev" class="btn prev"></span>
                    <span id="next" class="btn next"></span>
                    <span id="prevTop" class="btn prev"></span>
                    <span id="nextTop" class="btn next"></span>

                    <div id="picBox" class="picBox">
                        <ul class="cf">
                            <#if detailBvo?? && (detailBvo.imgPaths?size>0) >
                                <#list detailBvo.imgPaths as path>
                                    <li>
                                        <img src="${rc.getContextPath()}/${path}" alt="" />
                                    </li>
                                </#list>
                            </#if>
                        </ul>
                    </div>

                    <div id="listBox" class="listBox">
                        <ul class="cf">
                            <#if detailBvo?? && (detailBvo.imgPaths?size>0) >
                                <#list detailBvo.imgPaths as path>
                                    <#if path_index == 0>
                                        <li class="on3"><i class="arr2"></i><img width="118" height="64" src="${rc.getContextPath()}/${path}" /></li>
                                    <#else>
                                        <li><i class="arr2"></i><img width="118" height="64" src="${rc.getContextPath()}/${path}" /></li>
                                    </#if>

                                </#list>
                            </#if>

                        </ul>
                    </div>

                </div>
            </div>
        </div>
</#if>


     <!--缩略图-->
<script type="text/javascript">
<!--
(function(){
	function G(s){
		return document.getElementById(s);
	}
	
	function getStyle(obj, attr){
		if(obj.currentStyle){
			return obj.currentStyle[attr];
		}else{
			return getComputedStyle(obj, false)[attr];
		}
	}
	
	function Animate(obj, json){
		if(obj.timer){
			clearInterval(obj.timer);
		}
		obj.timer = setInterval(function(){
			for(var attr in json){
				var iCur = parseInt(getStyle(obj, attr));
				iCur = iCur ? iCur : 0;
				var iSpeed = (json[attr] - iCur) / 5;
				iSpeed = iSpeed > 0 ? Math.ceil(iSpeed) : Math.floor(iSpeed);
				obj.style[attr] = iCur + iSpeed + 'px';
				if(iCur == json[attr]){
					clearInterval(obj.timer);
				}
			}
		}, 30);
	}

	var oPic = G("picBox");
	var oList = G("listBox");
	
	var oPrev = G("prev");
	var oNext = G("next");
	var oPrevTop = G("prevTop");
	var oNextTop = G("nextTop");

	var oPicLi = oPic.getElementsByTagName("li");
	var oListLi = oList.getElementsByTagName("li");
	var len1 = oPicLi.length;
	var len2 = oListLi.length;
	
	var oPicUl = oPic.getElementsByTagName("ul")[0];
	var oListUl = oList.getElementsByTagName("ul")[0];
	var w1 = oPicLi[0].offsetWidth;
	var w2 = oListLi[0].offsetWidth;

	oPicUl.style.width = w1 * len1 + "px";
	oListUl.style.width = w2 * len2 + "px";

	var index = 0;
	
	var num = 5;
	var num2 = Math.ceil(num / 2);

	function Change(){

		Animate(oPicUl, {left: - index * w1});
		
		if(index < num2){
			Animate(oListUl, {left: 0});
		}else if(index + num2 <= len2){
			Animate(oListUl, {left: - (index - num2 + 1) * w2});
		}else{
			Animate(oListUl, {left: - (len2 - num) * w2});
		}

		for (var i = 0; i < len2; i++) {
			oListLi[i].className = "";
			if(i == index){
				oListLi[i].className = "on3";
			}
		}
	}
	
	oNextTop.onclick = oNext.onclick = function(){
		index ++;
		index = index == len2 ? 0 : index;
		Change();
	}

	oPrevTop.onclick = oPrev.onclick = function(){
		index --;
		index = index == -1 ? len2 -1 : index;
		Change();
	}

	for (var i = 0; i < len2; i++) {
		oListLi[i].index = i;
		oListLi[i].onclick = function(){
			index = this.index;
			Change();
		}
	}
	
})()
//-->
</script>

<!--效果html结束-->
</div>
     
<div style=" height:1px; border-bottom:#ccc 1px solid; width:800px; margin:30px auto;"></div>
</div><!--filmintro end-->
<!--底部-->
<#include "foot.ftl"/>
</body>
</html>
