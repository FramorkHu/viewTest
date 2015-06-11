<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>登陆</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache, must-revalidate">
    <meta http-equiv="Expires" content="0">

    <link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/css/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/css/themes/bootstrap/easyui.css"/>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->



    <!-- Le fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="/assets/images/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="/assets/images/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="/assets/images/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="/assets/images/apple-touch-icon-57-precomposed.png">
</head>

<body>
<div id="loginWin" class="easyui-window" title="登录" style="height:190px;width:350px;padding:5px;"
   minimizable="false" maximizable="false" resizable="false" collapsible="false">
    <div fit="true">
            <div region="center" border="false" style="height:94px;padding:5px;background:#fff;border:1px solid #ccc;">
                <form id="loginForm"  method="post" action="${rc.getContextPath()}/admin/login">
                    <div style="padding:5px 0;">
                        <label for="login">帐号:</label>
                        <input type="text" name="userName" style="width:260px;"/>
                    </div>
                    <div style="padding:5px 0;">
                        <label for="password">密码:</label>
                        <input type="password" name="password" style="width:260px;"/>
                    </div>
                     <div style="padding:5px 0;text-align: center;color: red;" id="showMsg">${msg!}</div>
                </form>
            </div>
            <div region="south" border="false" style="text-align:right;padding:5px 0;">
                <a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:void(0)" onclick="login()">登录</a>
                <a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="cleardata()">重置</a>
            </div>
    </div>
</div>
</body>
<script type="text/javascript" src="${rc.getContextPath()}/js/jquery.min.js"></script>
<script type="text/javascript" src="${rc.getContextPath()}/js/jquery.easyui.min.js"></script>
<script type="text/javascript">
document.onkeydown = function(e){
    var event = e || window.event;
    var code = event.keyCode || event.which || event.charCode;
    if (code == 13) {
        login();
    }
}
$(function(){
    $("input[name='login']").focus();
});
function cleardata(){
    $('#loginForm').form('clear');
}
function login(){
     if($("input[name='login']").val()=="" || $("input[name='password']").val()==""){
         $("#showMsg").html("用户名或密码为空，请输入");
         $("input[name='login']").focus();
    }else{
         $("#loginForm").submit();
            //ajax异步提交
           <#--$.ajax({-->
                  <#--type:"POST",   //post提交方式默认是get-->
                  <#--url:"${rc.getContextPath()}/login",-->
                  <#--data:$("#loginForm").serialize(),   //序列化-->
                  <#--error:function(request) {      // 设置表单提交出错-->
                  <#--},-->
                  <#--success:function(data) {-->
                      <#--$("#showMsg").html(data.msg);  //登录错误提示信息-->
                  <#--}-->
            <#--});-->
        }
}
</script>
</html>