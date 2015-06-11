<link rel="stylesheet" type="text/css" href="${rc.getContextPath()}/css/themes/gray/easyui.css"/>
<script type="text/javascript" src="${rc.getContextPath()}/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${rc.getContextPath()}/js/upload/webuploader.js"></script>
<script type="text/javascript" src="${rc.getContextPath()}/js/upload.js"></script>

<div id="addSourceDiv" class="easyui-dialog" style="width:550px;top:10px;padding-left:20px"
     closed="true" buttons="#user-buttons">  <br/><br/>
    <form id="movieSourceForm" method="post" enctype="multipart/form-data">
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

            <label>影片分类</label>
            <input type="button" value="浏览" onclick="viewMovieSourceType()">
            <span id="beenSelectClassify"></span>
        </div>   <br/>

        <div class="fitem">
            <label>影片属性</label>
            <select id="attributeId" name="movieAttribute"style="width:100px">
            </select>
        </div>   <br/>
        <div class="fitem">

            <label>导演</label><input name="movieDirect" style="width: 100px;"/>

            <label style="padding-left:10px">主演</label><input name="movieActor" style="width: 100px;"/>
        </div>   <br/>
        影片图片上传(注意: <font color="red">第一张图片是电影的封面图片</font>,中间是电影展示图片,<br><font color="red">如果有预告片，请添加在最后一个附件中</font>，请注意顺序)
        <div id="wrapper">
            <div id="container">
                <!--头部，相册选择和格式选择-->

                <div id="uploader">
                    <div class="queueList">
                        <div id="dndArea" class="placeholder">
                            <div id="filePicker"></div>
                            <p>单次最多可选15个资源，最多上传100M文件，单个资源不能超过80M</p>
                        </div>
                    </div>
                    <div class="statusBar" style="display:none;">
                        <div class="progress">
                            <span class="text">0%</span>
                            <span class="percentage"></span>
                        </div><div class="info"></div>
                        <div class="btns">
                            <div id="filePicker2"></div><div class="uploadBtn">开始上传</div>
                        </div>
                    </div>
                </div>
            </div>
        </div><br>

        <div class="fitem">

            三方网站视频地址<br>
                (如果已经上传了视频，请不要填写该项，如果两者都有，视频播放会使用三方视频的地址)<input name="mediaUrl" style="width: 200px;"/>
        </div>   <br/>
        <div class="fitem">
            <label>影片看点描述</label>
            <textarea name="ext" class="easyui-validatebox" rows="5" cols="50" required="true" class="easyui-textbox"></textarea>
        </div>
        <div class="fitem">
            <label>影片详细描述</label>
            <textarea name="movieDescribe" class="easyui-validatebox" rows="10" cols="50" required="true" class="textarea easyui-validatebox"></textarea>
        </div>
        <div id="uploadFilePath">

        </div>
    </form>
    <div id="source-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="movieSourceInfoAdd()" iconcls="icon-save">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#addSourceDiv').dialog('close');"
           iconcls="icon-cancel">取消</a>
    </div>
</div>

<div id="movieClassifyDiv" class="easyui-dialog" style="width:650px;height:500px;top:10px;padding-left:20px"
     closed="true" buttons="#classify-buttons">  <br/><br/>
    <div id="detailBody">
        <div id="classifyToolBar">
            <a href="javascript:void(0)" id="selectMovieSource" class="easyui-linkbutton" iconcls="icon-add" onclick="selectMovieClassifySource()" plain="true">选择分类</a>
        </div>

        <table id="movieClassifyDg" class="easyui-datagrid"  width="98%" style="height:450px"
               data-options="pageSize:40,autoRowHeight:true,rownumbers:true,fitColumns:true,collapsible:true,singleSelect:false,
			    pagination:true,toolbar:'#classifyToolBar',url:'${rc.getContextPath()}/webAdminMovie/getMovieClassifyData.json'">
            <thead>
            <tr>
                <th width='60%' data-options="field:'classifyName',align:'center'">分类</th>
            </tr>
            </thead>
        </table>

    </div>
    <div id="classify-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="javascript:$('#movieClassifyDiv').dialog('close')"
           iconcls="icon-cancel">取消</a>
    </div>
</div>

<script type="text/javascript">
    $("#addSourceDiv").dialog({
            onClose: function () {//销毁对话框
                $(this).dialog('destroy');

            }
        });


        $("#attributeId").combobox({
            valueField: "id",
            textField: "classifyName",
            url: '${rc.getContextPath()}/webAdminMovie/getMovieAttribute'
        });

function movieSourceInfoAdd(){

            url = "${rc.getContextPath()}/webAdminMovie/addMovieSourceDetail.json";

            $("#movieSourceForm").form("submit", {
                url: url,
                onsubmit: function () {

                    if($(this).form("validate")){
                        alert("qqq");
                        $("#source-buttons").html('正在提交......');
                        return true;
                    } else{
                        alert("2212");
                        return false;
                    }
                },
                success: function (data) {
                data = eval('('+data+')');
                $.messager.alert("提示信息",data.msg);
                $("#addSourceDiv").dialog("close");
                $('#indexModelDg').datagrid('load');

                }
            });
        }

         function viewMovieSourceType() {
            $("#movieClassifyDiv").dialog("open").dialog('setTitle', '选择分类');
        }

        function selectMovieClassifySource() {
            var rows = $('#movieClassifyDg').datagrid('getSelections');//获取当前的数据行
            if(rows){
                var classifyInfo = "";
                var classifyName = "";
                for (var i = 0; i < rows.length; i++) {
                    classifyInfo =classifyInfo+ "<input name='classifyId' type='hidden' value='"+rows[i].id+"'/>";
                    if (i<rows.length-1){
                        classifyName += rows[i].classifyName+",";
                    } else{
                        classifyName += rows[i].classifyName;
                    }
                }
                $("#beenSelectClassify").html(classifyName+classifyInfo);
                $("#movieClassifyDiv").dialog("close");
            } else{
                $.messager.alert('提示信息',"请选择分类!");
            }
        }

</script>
