

    <link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/css/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/css/themes/gray/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/css/themes/tooltip-form-style.css"/>
    <link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/css/webuploader.css" />
    <link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/css/style.css" />

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
    <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="apple-touch-icon-precomposed" sizes="144x144"
          href="${rc.getContextPath()}/js/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114"
          href="${rc.getContextPath()}/js/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72"
          href="${rc.getContextPath()}/js/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${rc.getContextPath()}/js/apple-touch-icon-57-precomposed.png">





<script type="text/javascript" src="${rc.getContextPath()}/js/jquery.min.js"></script>
<script type="text/javascript" src="${rc.getContextPath()}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${rc.getContextPath()}/js/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript">

    function formatterDate (AddDayCount)
    {
        var date = new Date();
        date.setDate(date.getDate()+AddDayCount);//获取AddDayCount天后的日期
        var y = date.getFullYear();
        var m = (date.getMonth() + 1) > 9 ? (date.getMonth() + 1) : "0"+ (date.getMonth() + 1);
        var d = date.getDate() > 9 ? date.getDate() : "0" + date.getDate();
        return y+"-"+m+"-"+d;
    }

</script>