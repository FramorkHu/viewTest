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
    <span>电影名称:</span><input type="text" id="movieNameText" size=10 />
    <a href="javascript:findSourceByName()" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-add" onclick="addSource()" plain="true">添加资源</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-edit" onclick="editSource()" plain="true">修改资源</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-remove" onclick="deleteSource()" plain="true">删除资源</a>
    <!--<a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-remove" onclick="viewMovieDetail()" plain="true">查看详情</a>-->
</div>

<table id="indexModelDg" class="easyui-datagrid"  width="98%" style="height:450px"
       data-options="pageSize:50,autoRowHeight:true,rownumbers:true,fitColumns:true,collapsible:true,singleSelect:true,
			    pagination:true,toolbar:'#toolbar',url:'${rc.getContextPath()}/webAdminMovie/getMovieSourceData.json'">
    <thead>
    <tr>
        <th width='20%'data-options="field:'movieName',align:'center'">电影名称</th>
        <th width='20%' data-options="field:'movieEnglishName',align:'center'">英文名称</th>
        <th width='20%' data-options="field:'movieDirect',align:'center'">导演</th>
        <th width='20%' data-options="field:'movieActor',align:'center'">演员</th>
        <th width='10%' data-options="field:'movieProduceYear',align:'center'">出品年代</th>
        <th width='10%' data-options="field:'movieTime',align:'center'">影片时长</th>
    </tr>
    </thead>
</table>

<div id="adSourceDivView">

</div>

<div id="updateSourceDiv" class="easyui-dialog" style="width:550px;height:auto;top:10px;padding-left:20px"
     closed="true" buttons="#user-buttons">  <br/><br/>
    <form id="updateSourceForm" method="post" enctype="multipart/form-data">
        <input name="id" type="hidden"/>
        <div class="fitem">
            <label>
                影片名称
            </label>
            <input class="easyui-validatebox" name="movieName" required="true"  style="width: 250px;"/>
        </div>   <br/>
        <div class="fitem">
            <label>
                英文名称
            </label>
            <input class="easyui-validatebox" name="movieEnglishName" required="true"  style="width: 250px;"/>
        </div>   <br/>
        <div class="fitem">

            <label>影片时长</label><input name="movieTime" class="easyui-numberbox" style="width: 50px;"/>

            <label style="padding-left:10px">出品年代</label><input name="movieProduceYear" class="easyui-numberbox" style="width: 50px;"/>
            <label style="padding-left:10px">国家</label><input name="movieCountry" style="width: 100px;"/>
        </div>   <br/>
        <div class="fitem">
            <label>影片属性</label>
            <input id="uploadAttributeId" name="movieAttribute" style="width:100px"
                   valueField="id" textField="text">
            </input>
        </div>   <br/>
        <div class="fitem">

            <label>导演</label><input name="movieDirect" style="width: 100px;"/>

            <label style="padding-left:10px">主演</label><input name="movieActor" style="width: 100px;"/>
        </div>   <br/>
        <div class="fitem">

            <label>三方视频地址</label><input name="mediaUrl" style="width: 200px;"/>
        </div>   <br/>
        <div class="fitem">
            <label>影片看点描述</label>
            <textarea name="ext" class="easyui-validatebox" rows="5" cols="50" required="true" class="easyui-textbox"></textarea>
        </div>
        <div class="fitem">
            <label>影片详细描述</label>
            <textarea name="movieDescribe" class="easyui-validatebox" rows="10" cols="50" required="true" class="textarea easyui-validatebox"></textarea>
        </div>
    </form>
    <div id="editsource-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="updateSourceInfoAdd()" iconcls="icon-save">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#updateSourceDiv').dialog('close')"
           iconcls="icon-cancel">取消</a>
    </div>
</div>

<div id="testFiled"></div>

<script type="text/javascript">

        var url = "";

        function addSource(){
            $.ajax({
                type: 'POST',
                url: 'getAddMovieSourceView',
                success:function(data){
                    $("#adSourceDivView").html(data);
                },complete:function(){
                    $("#addSourceDiv").dialog("open").dialog('setTitle', '添加电影资源');
                },error:function(){
                    alert("数据加载失败");
                }

            });

        }


        function deleteSource() {
            var row = $('#indexModelDg').datagrid('getSelected');
            if (row) {
                $.messager.confirm('Confirm', '确定删除该信息?', function (r) {
            if (r) {
                $.post('${rc.getContextPath()}/webAdminMovie/deleteMovieSourceDetail.json', { sourceIdStr: row.id }, function (data) {
                $.messager.show({title: '提示信息',msg: data.msg});
                $('#indexModelDg').datagrid('reload');
            }, 'json');
            }
            });
            }else{
                $.messager.alert('提示信息',"请选择需要删除的数据!");
            }
        }

        function editSource(){
            var row = $("#indexModelDg").datagrid("getSelected");
            if (row) {
                $("#updateSourceDiv").dialog("open").dialog('setTitle', '修改影片信息');
                $("#updateSourceForm").form("load", row);
                url = "${rc.getContextPath()}/webAdminMovie/updateMovieSourceDetail.json";
            }else{
                $.messager.alert('提示信息',"请选择需要修改的数据!");
            }
        }

        function updateSourceInfoAdd(){
            $("#updateSourceForm").form("submit", {
                url: url,
                onsubmit: function () {
                return $(this).form("validate");
                },
                success: function (data) {
                data = eval('('+data+')');
                $.messager.alert("提示信息",data.msg);
                $("#updateSourceDiv").dialog("close");
                $('#indexModelDg').datagrid('load');

                }
            });
        }


        $("#uploadAttributeId").combobox({
            valueField: "id",
            textField: "classifyName",
            url: '${rc.getContextPath()}/webAdminMovie/getMovieAttribute'
        });

function movieSourceInfoAdd(){

            url = "${rc.getContextPath()}/webAdminMovie/addMovieSourceDetail.json";
            $("#movieSourceForm").form("submit", {
                url: url,

                success: function (data) {
                    data = eval('('+data+')');
                    $.messager.alert("提示信息",data.msg);
                    $("#addSourceDiv").dialog("close");
                    $('#indexModelDg').datagrid('load');

                }
            });
        }

        function findSourceByName(){
        $('#indexModelDg').datagrid('load',{
                movieName:$('#movieNameText').val()
                });
        }
    </script>