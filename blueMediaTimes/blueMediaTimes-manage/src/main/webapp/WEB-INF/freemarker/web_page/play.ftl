<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>蓝媒电影播放</title>
<link href="${rc.getContextPath()}/style/home.css" rel="stylesheet" type="text/css" />
<link href="${rc.getContextPath()}/style/other.css" rel="stylesheet" type="text/css" />
<link href="${rc.getContextPath()}/style/style.css" rel="stylesheet" type="text/css" />
<script src="${rc.getContextPath()}/js/jquery-1.7.2.min.js" type="text/javascript"></script>
</head>
<script type="text/javascript">
$(function(){	
	$('.shipiin_list ul').click(function(){
		$(this).addClass('hover2').siblings().removeClass('hover2');
		$('.warp>div:eq('+$(this).index()+')').show().siblings().hide();	
	})
})
</script>

<body>
<!--logo start-->
<div class="logo"><img src="${rc.getContextPath()}/images/logo.png" width="655" height="60" /></div>
<!--logo end-->
<!--导航-->
<div class="nav">
     <ul class="nav_ul">
         <li><a href="${rc.getContextPath()}/">主页</a></li>
         <li><a href="${rc.getContextPath()}/film"  class="on" style="color:#fff">电影</a></li>
         <li><a href="${rc.getContextPath()}/documentary" >纪录片</a></li>
         <li><a href="${rc.getContextPath()}/cartoon" >动画片</a></li>
         <li><a href="${rc.getContextPath()}/3d">3D电影</a></li>
         <li><a href="${rc.getContextPath()}/about"  >关于蓝媒</a></li>
     </ul>
</div><!--导航 end-->


<!--视频播放-->
<#if detailBvo??>
    <h1 style="font-size:24px; color:#333; line-height:30px; width:1000px; margin:0 auto; margin-top:30px;">${detailBvo.movieName}（预告片）</h1>
    <div class="shipin_warp">
        <div class="warp">
            <div id="shipin" class="shipin">
                <!--这个<embed>里是优酷复制过来的-->
                <#if (detailBvo.isMedia==1) && !(detailBvo.mediaPath=="")>
                    <center>
                    <video width="735" height="420" controls="controls">
                        <source src="${rc.getContextPath()}/${detailBvo.mediaPath}" type="video/mp4" />
                        <source src="${rc.getContextPath()}/${detailBvo.mediaPath}" type="video/ogg" />
                        <source src="${rc.getContextPath()}/${detailBvo.mediaPath}" type="video/webm" />
                    </video>
                    </center>
                    <#elseif (detailBvo.isMedia==2) && !(detailBvo.mediaUrl=="")>
                        <embed src="${detailBvo.mediaUrl}" allowFullScreen="true" quality="high" width="835" height="420" align="middle" allowScriptAccess="always" type="application/x-shockwave-flash"></embed>


                    <#else>
                        <div style="border:1px solid #d24727; height:200px; width:700px; margin:30px auto; text-align:center; line-height:200px; font-size:14px;">
                            对不起，该电影暂无视频
                        </div>
                </#if>

            </div>

        </div><!--warp end-->
    </div>

<#else>
    <div style="border:1px solid #d24727; height:200px; width:700px; margin:30px auto; text-align:center; line-height:200px; font-size:14px;">
        对不起，该电影暂无视频
    </div>
</#if>

<div style=" clear:both"></div>
<!--底部-->
<#include "foot.ftl"/>
</body>
</html>
