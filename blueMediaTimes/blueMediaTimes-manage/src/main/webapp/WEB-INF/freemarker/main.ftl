<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>蓝媒时代后台管理</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache, must-revalidate">
    <meta http-equiv="Expires" content="0">


    <link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/css/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/css/themes/gray/easyui.css"/>

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

    <style type="text/css">
        #easyui-layout-north {
            height: 80px;
        }

        #easyui-layout-west {
            width: 190px;
        }

        #easyui-layout-center {
            padding: 5px;
        }

        #easyui-layout-south {
            height: 30px;
        }

        .brand {
          float: left;
          display: block;
          padding: 8px 20px 12px;
          margin-left: -20px;
          font-size: 20px;
          font-weight: bold;;
          line-height: 1;
          color: #999999;
          text-decoration: none;
          margin: 0 0 0 -5px;
        }
    </style>

  <script type="text/javascript">
      /**
         * 创建新选项卡
         * @param tabId    选项卡id
         * @param title    选项卡标题
         * @param url      选项卡远程调用路径
         */
        function addTab(tabId,title,url){
          if ($("#centerTab").tabs('exists', title)){
              $("#centerTab").tabs('select', title);
          }else{
                //如果当前id的tab不存在则创建一个tab
              if($("#"+tabId).html()==null){
                    var name = 'iframe_'+tabId;
                    $('#centerTab').tabs('add',{
                        title: title,
                        closable:true,
                        cache : false,
                        content : '<iframe name="'+name+'"id="'+tabId+'"src="'+url+'" width="100%" height="100%" frameborder="0" scrolling="auto" ></iframe>'
                    });
              }
          }
        }

    </script>

    <script type="text/javascript" src="${rc.getContextPath()}/js/jquery.min.js"></script>
    <script type="text/javascript" src="${rc.getContextPath()}/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${rc.getContextPath()}/js/locale/easyui-lang-zh_CN.js"></script>
</head>

<body class="easyui-layout">
    <div id="easyui-layout-north" region="north" split="true" style="height:50px;background-color: #2c2c2c">
        <a class="brand" href="#">北京蓝媒时代有限公司网站管理</a>
    </div>
    <div id="easyui-layout-west" region="west" split="true" title="系统功能">
        <div id="easyui-accordion" class="easyui-accordion" fit="true">

            <div title="首页模块管理">
                <ul class="easyui-tree">
                    <@li.menu id="indexPic" text="首页头图管理" url="webAdminItem/index?modelId=11" />
                    <@li.menu id="indexNewMovie" text="新品速递" url="webAdminItem/index?modelId=12" />
                    <@li.menu id="indexHotMovie" text="韩语专区" url="webAdminItem/index?modelId=13" />
                    <@li.menu id="indexDocumentary" text="回味经典" url="webAdminItem/index?modelId=14" />
                </ul>
            </div>

            <div title="电影资源管理">
                <ul class="easyui-tree">
                    <@li.menu id="movieSourceli" text="电影资源添加" url="webAdminMovie/movieSourceView" />
                    <@li.menu id="classifyli" text="电影分类添加" url="webAdminMovie/getMovieClassifyView" />
                </ul>
            </div>


        </div>
    </div>

    <div id="easyui-layout-center" region="center" >
    	<div class="easyui-tabs" id="centerTab" fit="true" border="false">
			<div title="欢迎页" style="padding:20px;overflow:hidden;">
				<div style="margin-top:20px;">
					<h1>欢迎！${(user.username)!}</h1><br/>
                    <a href="${rc.getContextPath()}/admin/logout">注销</a>
				</div>
			</div>
		</div>
    </div>

    <div id="easyui-layout-south" region="south" split="false" align="center" style="height:50px;">
        <label><br/>
    		© Company 2015
    	</label>
    </div>
</body>
</html>