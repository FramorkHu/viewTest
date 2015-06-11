<#-- 自定义标签 li 20121213 -->

<#--
    主界面左侧的功能菜单项
-->
<#macro menu id text url >

        <li id="${id}">
            <a href="javascript:addTab('${id}','${text}','${rc.getContextPath()}/${url}')">${text}</a>
            <!--<a href="javascript:postRequest('${rc.getContextPath()}/${url}','${id}')">${text}</a>-->
        </li>

</#macro>

<#--
    control div
-->
<#macro control name="" label="" wrap="1">
	<#if wrap="1" || wrap="true">
    <div id="${name}" class="control-group">
        <label class="control-label" for="${name}">${label}</label>
        <div class="controls">
            <#nested><#---->
        </div>
    </div>
	<#else>
            <#nested><#---->
	</#if>
</#macro>

<#--
    input
-->
<#macro input name="" type="text" label="" value="" class="input-xlarge" maxlength="" readonly="" disabled="" placeholder="" onclick="">
    <@li.control name="${name}" label="${label}">
        <input type="${type}" class="${class}" id="${name}" name="${name}" maxlength="${maxlength}"
               <#if readonly!="">readonly</#if>
               <#if disabled!="">disabled</#if>
               <#if value!="">value="${value}"</#if>
               <#if onclick!="">onclick="${onclick}"</#if>
               <#if placeholder!="">placeholder="${placeholder}"</#if>
                />
    </@li.control>
</#macro>

<#--
    select
-->
<#macro select list key val name="" label="" value="" def="" disabled="" class="input-xlarge" wrap="1">
    <@li.control name="${name}" label="${label}" wrap="${wrap}">
        <select id="${name}" name="${name}" class="${class}" <#if disabled!="">disabled</#if>>
            <#if def!="">
                <option value="">${def}</option>
            </#if>
            <#list list as each>
                <option value="${each[key]}" <#if each[key]?string==value?string>selected</#if>>${each[val]}</option>
            </#list>
        </select>
    </@li.control>
</#macro>

<#--
    textarea
-->
<#macro textarea name="" type="text" label="" value="" class="input-xlarge" cols="500" rows="10"readonly="" placeholder="">
    <@li.control name="${name}" label="${label}">
        <textarea cols="${cols}" rows="${rows}" class="${class}" id="${name}" name="${name}"
                  <#if readonly!="">readonly</#if>
                  <#if placeholder!="">placeholder="${placeholder}"</#if>
                >${value}</textarea>
    </@li.control>
</#macro>

<#--
    从list中查找指定的值
-->
<#macro find list key val value>
    <#list list as each>
        <#if each[key]?string==value?string>${each[val]}</#if>
    </#list>
</#macro>

<#--
    以指定长度截取文本
-->
<#macro text value="" pre="" length="999">
    <#if (value??)&&(value?length gt length?number)>
        <span title="${pre} ${value!}">${value[0..length?number]}..</span>
    <#else>
        <span title="${pre} ${value!}">${value!}</span>
    </#if>
</#macro>

<#--
    定义一个table列表
-->
<#macro table list cols=1>
    <table class="table table-striped table-bordered table-bordered">
        <#if list?size=0>
            <#assign i=-1/>
            <thead>
                <tr>
                    <#nested row,i,true/>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td colspan=${cols}>
                        <b>没有符合条件的数据</b>
                    </td>
                </tr>
            </tbody>
        </#if>

        <#list list as row>
            <#if row_index==0>
                <#assign i=-1/>
                <thead>
                    <tr>
                        <#nested row,i,true/>
                    </tr>
                </thead>
            </#if>
            <#assign i=row_index has_next=row_has_next/>
            <#if row_index==0>
                <tbody>
                <tr>
            <#else>
                <tr>
            </#if>
            <#nested row,row_index,row_has_next/>
            <#if !row_has_next>
                </tr>
                </tbody>
            <#else>
                </tr>
            </#if>
        </#list>
    </table>
</#macro>

<#--
    定义table列表的一列
-->
<#macro tr title="">
    <#if i==-1>
        <th>${title}</th>
    <#else>
        <td><#nested/></td>
    </#if>
</#macro>

<#--
    定义一个弹出窗口包含一个form(表单)一个button(操作)
-->
<#macro window id="" title="window">
    <div class="modal hide fade in" id="${id}">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">×</button>
        <h3 id="h3Title">${title!}</h3>
    </div>
        <#nested/><#-- 一个form 加 一个button-->
    </div>
</#macro>

<#--
    form表单,放在window里面的
-->
<#macro form id="" action="" method="POST">
    <div class="modal-body">
        <form class="form-horizontal" id="${id}" action="${action}" method="${method}">
            <fieldset>
                <#nested/><#-- 多个input-->
            </fieldset>
        </form>
    </div>
</#macro>

<#--
    按钮组,放在window里面的
-->
<#macro button>
    <div class="modal-footer">
        <#nested/>
    </div>
</#macro>

<#--
    分页对象
    <@li.page url="/edm_user/list_page?start="/>
-->
<#macro page url pg=pager>
    <@li.basic_page url="${rc.getContextPath()}"+url totalPages="${pg.totalPageCount}" totalRecords="${pg.totalCount}" currPage="${pg.currentPageNo}" pageSize="${pg.pageSize}"/>
</#macro>

<#--
    从page.ftl复制的,尽量不要直接引用,用 <@li.page url="/edm_user/list_page?start="/>
-->
<#macro basic_page url totalPages totalRecords currPage=1 pageSize=20 showPageNum=10  class="">
    <#local currPage = currPage?number/>
    <#local showPageNum = showPageNum?number/>
    <#local pageSize = pageSize?number/>
    <#local totalPages = totalPages?number/>
    <#local halfPage = (showPageNum/2)?number/>
${currPage} / ${totalPages} 页
    <#if ( currPage > 1) >
    <a href="javascript:getPage('${url}','${(currPage-2)*pageSize}')"><b>上一页</b></a>&nbsp;&nbsp;
        <#else >
        上一页
    </#if>

    <#if ( currPage < totalPages) >
    <a href="javascript:getPage('${url}','${(currPage)*pageSize}')"><b>下一页</b></a>&nbsp;&nbsp;
        <#else >
        下一页
    </#if>

共有记录${totalRecords} 条,到第
<input id="pageNum" name="pageNum" type="text" class="input-small" value="${currPage}"/>
页
<input id="gobutton" type="button" class="btn btn-primary" style="position: relative; left: 0px;  top: -5px;"
       value="GO.." onclick="javascript:checkGo(this,'${url}')"/>

<script type="text/javascript">
    function checkGo(obj, url) {
        var pageNo = $(obj).prev().attr('value');
        var preObj = $(obj).prev();
        if (isNaN(pageNo)) {
            alert('请输入数字!');
            preObj.focus();
            return false;
        } else if (pageNo == null || pageNo == '') {
            alert('请先输入页码!');
            preObj.focus();
            return false;
        } else if (pageNo < 1 || pageNo > ${totalPages}) {
            alert('输入的值超出页码范围!');
            preObj.focus();
            return false;
        } else {
            getPage(url, (pageNo - 1) *${pageSize} );
        }
    }

    var setVal = function(obj) {
        var pageNum = $(obj).val();
        $("#pageNum").val(pageNum);
    }

    var ua = window.navigator.userAgent;
    if (ua.indexOf('Firefox') >= 1) {
        document.onkeydown = function(event) {
            e = event ? event : (window.event ? window.event : null);
            if (e.keyCode == 13) {
                checkGo($("#gobutton"), '${url}')
            }
        }
    }
</script>
</#macro>





<#--
    分页对象 2侧边个
    <@li.page_tier2 url="/edm_user/list_page?start="/>
-->
<#macro page_tier2 url pg=pager>
    <@li.basic_page_tier2 url="${rc.getContextPath()}"+url totalPages="${pg.totalPageCount}" totalRecords="${pg.totalCount}" currPage="${pg.currentPageNo}" pageSize="${pg.pageSize}"/>
</#macro>

<#--
    从page.ftl复制的,尽量不要直接引用,用 <@li.page_tier2 url="/edm_user/list_page?start="/>
-->
<#macro basic_page_tier2 url totalPages totalRecords currPage=1 pageSize=20 showPageNum=10  class="">
    <#local currPage = currPage?number/>
    <#local showPageNum = showPageNum?number/>
    <#local pageSize = pageSize?number/>
    <#local totalPages = totalPages?number/>
    <#local halfPage = (showPageNum/2)?number/>
${currPage} / ${totalPages} 页
    <#if ( currPage > 1) >
    <a href="javascript:getPageTier2('${url}','${(currPage-2)*pageSize}')"><b>上一页</b></a>&nbsp;&nbsp;
        <#else >
        上一页
    </#if>

    <#if ( currPage < totalPages) >
    <a href="javascript:getPageTier2('${url}','${(currPage)*pageSize}')"><b>下一页</b></a>&nbsp;&nbsp;
        <#else >
        下一页
    </#if>

共有记录${totalRecords} 条,到第
<input id="pageNumTier2" name="pageNumTier2" type="text" class="input-small" value="${currPage}"/>
页
<input id="gobutton" type="button" class="btn btn-primary" style="position: relative; left: 0px;  top: -5px;"
       value="GO.." onclick="javascript:checkGoTier2(this,'${url}')"/>

<script type="text/javascript">
    function checkGoTier2(obj, url) {
        var pageNo = $(obj).prev().attr('value');
        var preObj = $(obj).prev();
        if (isNaN(pageNo)) {
            alert('请输入数字!');
            preObj.focus();
            return false;
        } else if (pageNo == null || pageNo == '') {
            alert('请先输入页码!');
            preObj.focus();
            return false;
        } else if (pageNo < 1 || pageNo > ${totalPages}) {
            alert('输入的值超出页码范围!');
            preObj.focus();
            return false;
        } else {
            getPageTier2(url, (pageNo - 1) *${pageSize} );
        }
    }

    var setVal = function(obj) {
        var pageNumTier2 = $(obj).val();
        $("#pageNumTier2").val(pageNumTier2);
    }

    var ua = window.navigator.userAgent;
    if (ua.indexOf('Firefox') >= 1) {
        document.onkeydown = function(event) {
            e = event ? event : (window.event ? window.event : null);
            if (e.keyCode == 13) {
                checkGoTier2($("#gobutton"), '${url}')
            }
        }
    }
</script>
</#macro>

