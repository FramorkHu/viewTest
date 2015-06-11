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
    <a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-add" onclick="addClassify()" plain="true">添加分类</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-edit" onclick="updateClassify()" plain="true">修改分类</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconcls="icon-remove" onclick="deleteClassify()" plain="true">删除分类</a>
</div>

<table id="movieClassifyDg" class="easyui-datagrid"  width="98%" style="height:450px"
       data-options="autoRowHeight:true,rownumbers:true,fitColumns:true,collapsible:true,singleSelect:true,
			    pagination:true,toolbar:'#toolbar',url:'${rc.getContextPath()}/webAdminMovie/getMovieClassifyData.json'">
    <thead>
    <tr>
        <th width='60%' data-options="field:'classifyName',align:'center'">分类</th>
    </tr>
    </thead>
</table>
<div id="addClassifyDiv" class="easyui-dialog" style="width: 400px; height: 280px;top:100px;padding-left:20px"
     closed="true" buttons="#user-buttons">  <br/><br/>
    <form id="classifyForm" method="post">
        <div class="fitem">
            <label>
                分类名称
            </label>
            <input id="classifyName" name="classifyName" class="easyui-validatebox"  required="true" style="width: 250px"/>
        </div>   <br/>
        <input id="classifyId" name="id" type="hidden"/>
    </form>
    <div id="user-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="movieClassifyAdd()" iconcls="icon-save">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#addClassifyDiv').dialog('close')"
           iconcls="icon-cancel">取消</a>
    </div>
</div>

<script type="text/javascript">


        var url = "";

        function addClassify(){
            $("#addClassifyDiv").dialog("open").dialog('setTitle', '添加电影分类');
            url = "${rc.getContextPath()}/webAdminMovie/addMovieClassify.json";
        }

        function movieClassifyAdd(){
            $("#classifyForm").form("submit", {
                url: url,
                onsubmit: function () {
                return $(this).form("validate");
                },
                success: function (data) {
                data = eval('('+data+')');
                $.messager.alert("提示信息",data.msg);
                $("#addClassifyDiv").dialog("close");
                $('#movieClassifyDg').datagrid('load');

                }
            });
            $("#classifyId").val("");
            $("#classifyName").val("");
        }

        function deleteClassify() {
            var row = $('#movieClassifyDg').datagrid('getSelected');
            if (row) {
                $.messager.confirm('Confirm', '确定删除该信息?', function (r) {
            if (r) {
                $.post('${rc.getContextPath()}/webAdminMovie/deleteMovieClassify.json', { idStr: row.id }, function (data) {
                $.messager.show({title: '提示信息',msg: data.msg});
                $('#movieClassifyDg').datagrid('reload');
            }, 'json');
            }
            });
            }else{
                $.messager.alert('提示信息',"请选择需要删除的数据!");
            }
        }

        function updateClassify(){
            var row = $("#movieClassifyDg").datagrid("getSelected");
            if (row) {
                $("#addClassifyDiv").dialog("open").dialog('setTitle', '修改分类');
                $("#classifyForm").form("load", row);
                url = "${rc.getContextPath()}/webAdminMovie/updateMovieClassify.json";
            }else{
                $.messager.alert('提示信息',"请选择需要修改的数据!");
            }
        }




    </script>