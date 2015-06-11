<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>关于蓝媒</title>
<link href="style/home.css" rel="stylesheet" type="text/css" />
<link href="style/other.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
</head>
<script type="text/javascript">
$(function(){	
	$('.tab_left ul li').click(function(){
		$(this).addClass('hover1').siblings().removeClass('hover1');
		$('.tab_right>div:eq('+$(this).index()+')').show().siblings().hide();	
	})
})
</script>
<body>
<!--logo start-->
<div class="logo"><img src="${rc.getContextPath()}/images/logo.png" width="655" height="60" /></div>
<!--logo end-->
<!--导航-->
<div class="nav">
    <ul class="nav nav_ul">
        <li><a href="${rc.getContextPath()}/">主页</a></li>
        <li><a href="${rc.getContextPath()}/film" >电影</a></li>
        <li><a href="${rc.getContextPath()}/documentary" >纪录片</a></li>
        <li><a href="${rc.getContextPath()}/cartoon" >动画片</a></li>
        <li><a href="${rc.getContextPath()}/3d">3D电影</a></li>
        <li><a  href="${rc.getContextPath()}/about"  class="on" style="color:#fff">关于蓝媒</a></li>
    </ul>
</div>
<!--导航 end-->
<div class="tab_warp">
     <div class="tab_left">
          <ul>
              <li>•关于蓝媒</li>
              <li>•联系我们</li>
          </ul>
     </div>
     <div class="tab_right">
   <!-- 关于蓝莓-->
         <div>
         <h2>关于蓝媒</h2>
         <h3> About BlueMedia</h3>
             <p>蓝媒时代作为一家专业的媒体内容提供商, 始终致力于向国内电影院线、电视台、数字电视、新媒体及移动互联网平台，提供高品质的海外电影。</p>
             <p>作为影视版权的上游授权公司，蓝媒时代与各平台始终保持着稳定的合作。我们的国外合作伙伴主要是来自欧洲、北美及亚洲各国的近百家主流的影视制片方和发行方。长期与我们保持合作的国内合作伙伴及客户有近50余家, 包括中影集团、中央电视台、上海百视通、华数传媒、优酷土豆网、爱奇艺、乐视网、腾讯网、迅雷网、芒果TV、PPTV、搜狐网、中国移动视频（和视界和视频）、中国电信（天翼视讯）、中国联通及省级地方广电网络。</p>
             <p>截至2015年，蓝媒时代拥有中国大陆发行权的海外电影近400余部。蓝媒时代的所有电影，授权期限为3-10年，影片授权范围包括院线发行权、卫星电视、付费电视的电视发行权及手机端、PC端、PAD端及OTT端在内的新媒体发行权。</p>
             <p>蓝媒时代秉承诚实守信的原则,愿与各平台及合作伙伴共同发展, 尽全力为中国观众提供更多更好的视听享受。</p>

      </div>
<!-- 联系我们--> 
      <div style="display:none;">
         <h2>联系我们</h2>
         <h3> Contact Information</h3>
         <p>欢迎联系蓝媒时代。</p>
         <p>办公电话：86-10-64261886</p>
         <p style="margin-top:0px;">移动手机：86-13910069961</p>
         <p style="margin-top:0px;">邮箱email：ibluemedia@yahoo.com</p>
         <p style="margin-top:0px;">办公地址：北京市丰台区芳群路古园1号</p>    
         <p >为了更好的与您沟通，请在来信中留下您的联系方式和信息。</p>
         <p style="margin-top:0px;">我们将及时与您取得联系，谢谢。</p>
      </div>    
</div>
</div>
<div style="clear:both"></div>
<!--底部-->
<#include "foot.ftl"/>
</body>
</html>
