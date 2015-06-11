<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>蓝媒电影</title>
<meta http-equiv="X-UA-Compatible" content="IE=8" />
<meta http-equiv="X-UA-Compatible" content="IE=9">
<link href="style/home.css" rel="stylesheet" type="text/css" />
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
        <li><a href="${rc.getContextPath()}/" class="on" style="color:#fff">主页</a></li>
        <li><a href="${rc.getContextPath()}/film">电影</a></li>
        <li><a href="${rc.getContextPath()}/documentary" >纪录片</a></li>
        <li><a href="${rc.getContextPath()}/cartoon" >动画片</a></li>
        <li><a href="${rc.getContextPath()}/3d">3D电影</a></li>
        <li><a  href="${rc.getContextPath()}/about">关于蓝媒</a></li>
    </ul>
</div>
<!--导航 end-->
<!--banner start-->
<div class="index_banner" id="banner_tabs">
    <ul>
        <#list headPicInfos as headPicInfo>
            <li><a href="film/filmDetail?film=${headPicInfo.sourceId!''}"><img src="${headPicInfo.imgPath}" width="100%"></a></li>
        </#list>
    </ul>
	<!--此处的img是用来占位的，在实际使用中，可以另外制作一张全空的图片-->
	<img style="visibility:hidden;" src="images/index_banner1.jpg" width="100%">
	<cite>
        <#list headPicInfos as headPicInfo>
            <#if headPicInfo_index+1 ==1>
                <span class="cur">${headPicInfo_index+1}</span>
                <#else>
                    <span>${headPicInfo_index+1}</span>
            </#if>

        </#list>
	</cite>
	<div class="clear"></div>
</div>
<script src="js/banner.js" type="text/javascript"></script>
<div class="main_warp">
<!--新片速递-->
     <div class="film-warp">
         <h3>新片速递<span>New Arrive   /     Trailers & Clips</span><a href="${rc.getContextPath()}/film">更多<img src="images/more.png" width="10" height="10" /></a></h3>
     <div class="new_film">
<!--左边大图片-->
          <div class="film-left">
              <#list newInfos as newInfo>
                  <#if newInfo_index ==0>
                      <a href="film/filmDetail?film=${newInfo.sourceId!''}"target="_blank"><img src="${newInfo.imgPath}" width="380" height="380" /></a>
                      <div class="film_title">
                          <div class="film_icon"><img src="${newInfo.imgPath}" width="45" height="45" /></div>
                          <ul>
                              <li class="film_name"><a href="film/filmDetail?film=${newInfo.sourceId!''}"target="_blank">${newInfo.sourceName}</a></li>
                              <li class="film_descrbe">${newInfo.simpleDescribe}</li>
                          </ul>
                      </div>
                  </#if>
              </#list>

          </div>
<!--右边小图片排列-->
          <div class="film_right">
              <#list newInfos as newInfo>
                  <#if (newInfo_index >0 && newInfo_index<7)>
                      <div class="film">
                          <div class="film_img"><a href="film/filmDetail?film=${newInfo.sourceId!''}" target="_blank">
                              <img src="${newInfo.imgPath}" width="180" height="180" /></a></div>
                          <ul>
                              <li class="film_name"><a href="film/filmDetail?film=${newInfo.sourceId!''}" target="_blank">${newInfo.sourceName}</a></li>
                              <li class="film_descrbe">${newInfo.simpleDescribe}</li>
                          </ul>
                      </div>
                  </#if>
              </#list>
<!--创可贴 --> 

<!--IRIS2电影版-->

          </div><!--film_right end-->
     </div>
     </div>
<!--热门电影-->
     <div class="hot_warp">
     <h3>韩影专区<span>Korean Film   /     Trailers & Clips</span><a href="${rc.getContextPath()}/film">更多<img src="images/more.png" width="10" height="10" /></a></h3>

     <#list koreanMovieInfos as hotMovieInfo>
         <#if (hotMovieInfo_index+1)%5 == 1 && (hotMovieInfo_index<10) >
             <div class="hot_film" style="margin-left:0px;">
                 <div class="hot_film_img"><a href="film/filmDetail?film=${hotMovieInfo.sourceId!''}" target="_blank">
                     <img src="${hotMovieInfo.imgPath}" width="180" height="260" /></a></div>
                 <ul>
                     <li class="film_name"><a href="film/filmDetail?film=${hotMovieInfo.sourceId!''}" target="_blank">${hotMovieInfo.sourceName}</a></li>
                     <li class="film_descrbe">${hotMovieInfo.simpleDescribe}</li>
                 </ul>
             </div>
         <#elseif (hotMovieInfo_index<10)>
             <div class="hot_film">
                 <div class="hot_film_img"><a href="film/filmDetail?film=${hotMovieInfo.sourceId!''}" target="_blank">
                     <img src="${hotMovieInfo.imgPath}" width="180" height="260" /></a></div>
                 <ul>
                     <li class="film_name"><a href="film/filmDetail?film=${hotMovieInfo.sourceId!''}" target="_blank">${hotMovieInfo.sourceName}</a></li>
                     <li class="film_descrbe">${hotMovieInfo.simpleDescribe}</li>
                 </ul>
             </div>
         </#if>

     </#list>

     </div> <!--热门电影结束-->

    <div class="hot_warp" style="height:310px">
        <h3>回味经典<span>Aftertaste Classic   /     Trailers & Clips</span><a href="${rc.getContextPath()}/film">更多<img src="images/more.png" width="10" height="10" /></a></h3>

        <#list classicInfos as hotMovieInfo>
            <#if (hotMovieInfo_index+1)%5 == 1 && (hotMovieInfo_index<5) >
            <div class="hot_film" style="margin-left:0px;">
                <div class="hot_film_img"><a href="film/filmDetail?film=${hotMovieInfo.sourceId!''}" target="_blank">
                    <img src="${hotMovieInfo.imgPath}" width="180" height="260" /></a></div>
                <ul>
                    <li class="film_name"><a href="film/filmDetail?film=${hotMovieInfo.sourceId!''}" target="_blank">${hotMovieInfo.sourceName}</a></li>
                    <li class="film_descrbe">${hotMovieInfo.simpleDescribe}</li>
                </ul>
            </div>
            <#elseif (hotMovieInfo_index<5)>
            <div class="hot_film">
                <div class="hot_film_img"><a href="film/filmDetail?film=${hotMovieInfo.sourceId!''}" target="_blank">
                    <img src="${hotMovieInfo.imgPath}" width="180" height="260" /></a></div>
                <ul>
                    <li class="film_name"><a href="film/filmDetail?film=${hotMovieInfo.sourceId!''}" target="_blank">${hotMovieInfo.sourceName}</a></li>
                    <li class="film_descrbe">${hotMovieInfo.simpleDescribe}</li>
                </ul>
            </div>
            </#if>

        </#list>

    </div> <!--热门电影结束-->


</div><!--main_warp end-->
<!--底部-->
<#include "foot.ftl"/>
</body>
</html>
