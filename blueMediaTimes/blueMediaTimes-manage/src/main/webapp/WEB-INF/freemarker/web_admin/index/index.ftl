<#include "../../source.ftl"/>
<style>
    .fitem
    {
    margin-bottom: 5px;
    }
    .fitem label
    {
    display: inline-block;
    width: 80px;
    }
    .thumbImage img{
        MAX-WIDTH: 100%!important;HEIGHT: auto!important;width:expression(this.width > 600 ? "600px" : this.width)!important;
    }
    .thumbImage {MARGIN: auto;WIDTH: 600px;}
    *html.thumbImage img{
        width:expression(this.width>600&&this.width>this.height?450:auto);
        height:expression(this.height>300?300:auto);
    }
</style>

<div id="toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-add" onclick="addSource()" plain="true">添加资源</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-edit" onclick="editSource()" plain="true">修改资源</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-remove" onclick="deleteSource()" plain="true">删除资源</a>
</div>

<table id="indexModelDg" class="easyui-datagrid"  width="98%" style="height:450px"
       data-options="autoRowHeight:true,rownumbers:true,fitColumns:true,collapsible:true,singleSelect:true,onLoadSuccess:count,
			    pagination:true,toolbar:'#toolbar',url:'${rc.getContextPath()}/webAdminItem/getIndexModelData.json?modelId=${modelId}'">
    <thead>
    <tr>
        <th width='60%' data-options="field:'imgPath',align:'center'">图片</th>
        <th width='40%' data-options="field:'simpleDescribe',align:'center'">描述</th>
    </tr>
    </thead>
</table>

<div id="addSourceDiv" class="easyui-dialog" style="width:550px;height:auto;top:10px;padding-left:20px"
     closed="true" buttons="#user-buttons">  <br/><br/>
    <form id="modelSourceForm" method="post" enctype="multipart/form-data">

        <div class="fitem">
            <label>
                图片上传
            </label>
            <input type="file" name="picture" style="width: 250px" required="true" class="easyui-validatebox"/>
        </div>   <br/>
        <div class="fitem">
            <label>影片名称</label>
            <input name="sourceName" class="easyui-validatebox" required="true"/>
        </div> <br/>
        <div class="fitem">
            <label>影片简单描述</label>
            <textarea name="simpleDescribe" class="easyui-validatebox" rows="5" cols="50" required="true" class="easyui-textbox"></textarea>
        </div> <br/>
        <div class="fitem">
            <label>选择影片资源</label>
            <input type="button" value="浏览" onclick="viewMovieSource()"><br/>
            <input id="selectMovieName" name="selectMovieName" class="easyui-validatebox" required="true" readonly="true">
            <div id="selectMovieSourceName" >
            </div>
        </div>

        <input type="hidden" name="modelIdStr" value="${modelId}">
    </form>
    <div id="source-buttons" style="margin-bottom:10px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="addMovieSourceInfo()" iconcls="icon-save">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#addSourceDiv').dialog('close')"
           iconcls="icon-cancel">取消</a>
    </div>
</div>

<div id="updateSourceDiv" class="easyui-dialog" style="width:550px;height:auto;top:10px;padding-left:20px"
     closed="true" buttons="#user-buttons">  <br/><br/>
    <form id="updateSourceForm" method="post" enctype="multipart/form-data">

        <input type="hidden" name="id"/>
        <div class="fitem">
            <label>影片名称</label>
            <input name="sourceName" class="easyui-validatebox" required="true"/>
        </div> <br/>
        <div class="fitem">
            <label>影片简单描述</label>
            <textarea name="simpleDescribe" class="easyui-validatebox" rows="5" cols="50" required="true" class="easyui-textbox"></textarea>
        </div> <br/>
        <div class="fitem">
            <label>选择影片资源</label>
            <input type="button" value="浏览" onclick="viewUpdateMovieSource()"><br/>
            <div id="updateSelectMovieName" ></div>
            <div id="updateSelectMovieSourceName" >
                <input name='sourceId' type='hidden'/>
                <input name='movieName' type='hidden'/>
            </div>
        </div>

        <input type="hidden" name="modelId">
    </form>
    <div id="updatesource-buttons" style="margin-bottom:10px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="updateMovieSourceInfo()" iconcls="icon-save">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#updateSourceDiv').dialog('close')"
           iconcls="icon-cancel">取消</a>
    </div>
</div>

<div id="movieSourceDiv" class="easyui-dialog" style="width:650px;height:500px;top:10px;padding-left:20px"
     closed="true" buttons="#detail-buttons">  <br/><br/>
    <div id="detailBody">
        <div id="addSourceToolBar">
            <span>电影名称:</span><input type="text" id="movieName" size=10 />
            <a href="javascript:findSourceByName()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
            <a href="javascript:void(0)" id="selectMovieSource" class="easyui-linkbutton" iconcls="icon-add" onclick="updateSelectMovieSource()" plain="true">选择资源</a>
        </div>

        <table id="addSourceDlg" class="easyui-datagrid"  width="98%" style="height:450px"
               data-options="autoRowHeight:true,rownumbers:true,fitColumns:true,collapsible:true,singleSelect:true,
			    pagination:false,toolbar:'#addSourceToolBar',url:'${rc.getContextPath()}/webAdminMovie/getMovieSourceBaseData.json'">
            <thead>
            <tr>
                <th width='60%' data-options="field:'movieName',align:'center'">电影名称</th>
                <th width='60%' data-options="field:'movieEnglishName',align:'center'">英文名称</th>
                <th width='60%' data-options="field:'movieProduceYear',align:'center'">出品年代</th>
            </tr>
            </thead>
        </table>

    </div>
    <div id="detail-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#movieSourceDiv').dialog('close')"
           iconcls="icon-cancel">取消</a>
    </div>
</div>

<script type="text/javascript">

        function count(){
            var rows = $('#indexModelDg').datagrid('getRows')//获取当前的数据行
            for (var i = 0; i < rows.length; i++) {
            if(rows[i]['imgPath'] != null)
                rows[i]['imgPath'] = "<div class = 'thumbImage'> <img src='${rc.getContextPath()}/"+rows[i]['imgPath']+"' /></div>";
            $("#indexModelDg").datagrid("updateRow", { index: i});
            }
        }
        var url = "";

        //添加模块资源对话框
        function addSource(){
            $("#addSourceDiv").dialog("open").dialog('setTitle', '添加资源');
            url = "${rc.getContextPath()}/webAdminModel/addModelSource.json";
        }

        //添加模块资源操作
        function addMovieSourceInfo(){
            $("#modelSourceForm").form("submit", {
                url: url,
                onsubmit: function () {
                return $(this).form("validate");
                },
                success: function (data) {
                data = eval('('+data+')');
                $.messager.show({title: '提示信息',msg: data.msg});
                $("#addSourceDiv").dialog("close");
                $('#indexModelDg').datagrid('load');
                }
            });
        }
        function viewMovieSource() {
            $("#movieSourceDiv").dialog("open").dialog('setTitle', '选择影片');
            $("#selectMovieSource").attr("onclick","selectMovieSource()")
        }
        function viewUpdateMovieSource() {
            $("#movieSourceDiv").dialog("open").dialog('setTitle', '选择影片');
            $("#selectMovieSource").attr("onclick","updateSelectMovieSource()")
        }

        //选择影片资源
        function selectMovieSource(){
            var rows = $('#addSourceDlg').datagrid('getSelected')//获取当前的数据行
            if(rows){
                var movieName = "<input name='sourceIdStr' type='hidden' value='"+rows.id+"'/>";
                $("#selectMovieName").attr("value",rows.movieName)
                $("#selectMovieSourceName").empty();
                $("#selectMovieSourceName").append(movieName);

                $('#movieSourceDiv').dialog('close')
            } else{
                $.messager.alert('提示信息',"请选择需要添加的影视资源!");
            }

        }



        function findSourceByName(){
            $('#addSourceDlg').datagrid('load',{
                movieName:$('#movieName').val()
                });
        }

        function editSource(){
            var row = $("#indexModelDg").datagrid("getSelected");
            if (row) {
                $("#updateSourceDiv").dialog("open").dialog('setTitle', '修改资源');
                $("#updateSourceForm").form("load", row);
                $("#updateSelectMovieName").html(row.movieName)
                url = "${rc.getContextPath()}/webAdminModel/updateModelSource.json";
            }else{
                $.messager.alert('提示信息',"请选择需要修改的数据!");
            }
        }

        //选择更新的影片资源
        function updateSelectMovieSource(){
            var rows = $('#addSourceDlg').datagrid('getSelected')//获取当前的数据行
            if(rows){
                var movieName = "<input name='sourceId' type='hidden' value='"+rows.id+"'/><input name='movieName' type='hidden' value='"+rows.movieName+"'/>";
                $("#updateSelectMovieName").html(rows.movieName)
                $("#updateSelectMovieSourceName").empty();
                $("#updateSelectMovieSourceName").append(movieName);

                $('#movieSourceDiv').dialog('close')
            } else{
                $.messager.alert('提示信息',"请选择需要添加的影视资源!");
            }

        }

        function updateMovieSourceInfo(){
            url = "${rc.getContextPath()}/webAdminModel/updateModelSource.json";
            $("#updateSourceForm").form("submit", {
                url: url,
                onsubmit: function () {
                return $(this).form("validate");
                },
                success: function (data) {
                data = eval('('+data+')');
                $.messager.show({title: '提示信息',msg: data.msg});
                $("#updateSourceDiv").dialog("close");
                $('#indexModelDg').datagrid('load');
                }
            });
        }


        function deleteSource() {
            var row = $('#indexModelDg').datagrid('getSelected');
            if (row) {
                $.messager.confirm('Confirm', '确定删除该信息?', function (r) {
            if (r) {
                $.post('${rc.getContextPath()}/webAdminModel/deleteModelSource.json', { idStr: row.id ,imgPath : row.tmpImgPath}, function (data) {
                $.messager.show({title: '提示信息',msg: data.msg});
                $('#indexModelDg').datagrid('reload');
            }, 'json');
            }
            });
            }else{
                $.messager.alert('提示信息',"请选择需要删除的数据!");
            }
        }


    </script>