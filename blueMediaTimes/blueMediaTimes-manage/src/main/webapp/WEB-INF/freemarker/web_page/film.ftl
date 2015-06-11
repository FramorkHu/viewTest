<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>蓝媒电影_所有电影</title>
<link href="style/home.css" rel="stylesheet" type="text/css" />
<script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
<script src="js/page.js" type="text/javascript"></script>

</head>
<body>
<!--logo start-->
<!--logo start-->
<div class="logo"><img src="${rc.getContextPath()}/images/logo.png" width="655" height="60" /></div>
<!--logo end-->
<!--导航-->
<div class="nav">
    <ul class="nav nav_ul">
        <li><a href="${rc.getContextPath()}/">主页</a></li>
		<#if attributeName==2 >
			<li><a href="${rc.getContextPath()}/film" class="on" style="color:#fff">电影</a></li>
			<li><a href="${rc.getContextPath()}/documentary" >纪录片</a></li>
			<li><a href="${rc.getContextPath()}/cartoon" >动画片</a></li>
			<li><a href="${rc.getContextPath()}/3d">3D电影</a></li>
		<#elseif attributeName==3 >
			<li><a href="${rc.getContextPath()}/film" >电影</a></li>
			<li><a href="${rc.getContextPath()}/documentary" class="on" style="color:#fff">纪录片</a></li>
			<li><a href="${rc.getContextPath()}/cartoon" >动画片</a></li>
			<li><a href="${rc.getContextPath()}/3d">3D电影</a></li>
		<#elseif attributeName==4 >
			<li><a href="${rc.getContextPath()}/film">电影</a></li>
			<li><a href="${rc.getContextPath()}/documentary" >纪录片</a></li>
			<li><a href="${rc.getContextPath()}/cartoon" class="on" style="color:#fff" >动画片</a></li>
			<li><a href="${rc.getContextPath()}/3d">3D电影</a></li>
		<#elseif attributeName==5 >
			<li><a href="${rc.getContextPath()}/film">电影</a></li>
			<li><a href="${rc.getContextPath()}/documentary" >纪录片</a></li>
			<li><a href="${rc.getContextPath()}/cartoon" >动画片</a></li>
			<li><a href="${rc.getContextPath()}/3d" class="on" style="color:#fff">3D电影</a></li>
		<#else>
			<li><a href="${rc.getContextPath()}/film" class="on" style="color:#fff">电影</a></li>
			<li><a href="${rc.getContextPath()}/documentary" >纪录片</a></li>
			<li><a href="${rc.getContextPath()}/cartoon" >动画片</a></li>
			<li><a href="${rc.getContextPath()}/3d">3D电影</a></li>
		</#if>

		<li><a href="${rc.getContextPath()}/about">关于蓝媒</a></li>
    </ul>
</div>
<!--导航 end-->
<div class="film_page">
     <div class="film_page_left">
         <h4>${itemName}</h4>
        <input type="hidden" id="attributeName" name="attributeName" value="${attributeName}"/>
		<dl class="listIndex" attr="terminal_brand_s">
			<dt>按类型：</dt>
			<dd>
                <#list classifies as classify>
                    <a href="javascript:void(0)" value1="${classify.id!''}" value2="typeName" >${classify.classifyName!''}</a>
                </#list>
			</dd>
		</dl>
		<dl class="listIndex" style="border-bottom:none" attr="terminal_brand_s">
			<dt>按年份：</dt>
			<dd>
                <#list years as year>
                    <a href="javascript:void(0)" value1="${year!''}" value2="yearName" >${year!''}</a>
                </#list>
			</dd>
		</dl>
     </div><!--/*film_page_left end*/-->
     
     
     <div class="film_page_right">
     
	<div class="hasBeenSelected">
		<dl>
			<dt>您已选择：</dt>
			<dd style="display:none" class="clearDd">
				<div class="clearList"></div>
			</dd>
		</dl>

	</div>
<script type="text/javascript">
var dlNum  =$(".film_page_left").find("dl");
for (i=0; i <dlNum.length; i++) {
	$(".hasBeenSelected .clearList").append("<div class=\"selectedInfor selectedShow\" style=\"display:none\"><span></span><label></label><input  type='hidden'/><em></em></div>");
}

var refresh = "true";

$(".listIndex a ").live("click",function(){
	var text =$(this).text();
	var value1 =$(this).attr("value1");
	var value2 =$(this).attr("value2");
	var selectedShow = $(".selectedShow");
	var textTypeIndex =$(this).parents("dl").index();
	var textType =$(this).parent("dd").siblings("dt").text();
	index = textTypeIndex -(2);
	$(".clearDd").show();
	$(".selectedShow").eq(index).show();
	$(this).addClass("selected").siblings().removeClass("selected");
	selectedShow.eq(index).find("span").text(textType);
	selectedShow.eq(index).find("label").text(text);
	if(value2 == 'typeName'){
		selectedShow.eq(index).find("input").attr("id","typeId");
		selectedShow.eq(index).find("input").attr("value",value1);
	}
	if(value2 == 'yearName'){
		selectedShow.eq(index).find("input").attr("id","year");
		selectedShow.eq(index).find("input").attr("value",value1);
	}
	search();
   
});
$(".selectedShow em").live("click",function(){
	$(this).parents(".selectedShow").hide();

	var textTypeIndex =$(this).parents(".selectedShow").index();
	index = textTypeIndex;
	$(".listIndex").eq(index).find("a").removeClass("selected");
	$(this).parents(".selectedShow").find("input").removeAttr("id");
	$(this).parents(".selectedShow").find("input").removeAttr("value");
	search();
});

</script>
         <div id="list">

         </div>


          <div style="clear:both"></div>
<!--分页 -->  
<div class="fy" id="pageCount">
     <ul>
     </ul>
</div>
     </div><!--film_page_right end-->
</div><!--film_page end-->
<div style="clear:both"></div>
<!--底部-->
<#include "foot.ftl"/>
</body>
</html>
