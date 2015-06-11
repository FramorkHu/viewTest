 var curPage = 1; //当前页码
 var rows = 20;
 var total,pageSize,totalPage; //总记录数，每页显示数，总页数
 function search(){
    getData(curPage);
 }
 function getData(page){
    var year = $("#year").attr("value");
    var type = $("#typeId").attr("value");
    var attribute = $("#attributeName").attr("value");
    $.ajax({
        type: 'POST',
        url: 'filmList',
        data: {'startPage':page-1, 'rows':rows, 'attribute':attribute,'classify':type,'year':year },
        dataType:'json',
        beforeSend:function(){
            var loading = '<div style=" height:200px; width:700px; margin:30px auto; text-align:center; line-height:200px; font-size:14px;"><img src="images/load1.gif" width="70" height="70"style="margin:55px auto;" /></div>'
            $("#list").empty();
            $("#list").append(loading);//显示加载动画
        },
        success:function(json){
            $("#list").empty();//清空数据区
            total = json.totalCount; //总记录数
            pageSize = json.pageSize; //每页显示条数
            curPage = page; //当前页
            totalPage = json.totalPage; //总页数
            var pageData = json.pageData;
            $("#list").append(pageData);
        },
        complete:function(){ //生成分页条
            getPageBar();
        },
        error:function(){
            alert("数据加载失败");
        }
    });
}

//获取分页条
function getPageBar(){
    //页码大于最大页数
    if(curPage>totalPage){
        curPage=totalPage;
    }
    //页码小于1
    if(curPage<1){
        curPage=1;
    }
    var pageStr ='';

    if(curPage==1 && totalPage>1){ //如果是第一页
        pageStr += '<li class="next" style="margin-left:0px"><a href="javascript:void(0)" >首页</a></li>'+
        '<li class="next"><a href="javascript:void(0)" >上一页</a></li>';
        for(var i=1; i< totalPage+1; i++){
            if (i==curPage){
                pageStr += '<li><a href="javascript:void(0)" style="background:#d24727; color:#fff;" rel="'+i+'">'+i+'</a></li>';
            }else{
                pageStr += '<li><a href="javascript:void(0)" rel="'+i+'">'+i+'</a></li>';
            }

        }
        pageStr += '<li class="next"><a href="javascript:void(0)" rel="'+(parseInt(curPage)+1)+'" >下一页</a></li>'+
                    '<li class="next"><a href="javascript:void(0)" rel="'+totalPage+'">尾页</a></li>'
    }else if(curPage>=totalPage  && totalPage>1){//如果是最后页
        pageStr += '<li class="next" style="margin-left:0px"><a href="javascript:void(0)" rel="1">首页</a></li>'+
            '<li class="next"><a href="javascript:void(0)" rel="'+(curPage-1)+'">上一页</a></li>';
        for(var i=1; i< totalPage+1; i++){
            if (i==curPage){
                pageStr += '<li><a href="javascript:void(0)" style="background:#d24727; color:#fff;" rel="'+i+'">'+i+'</a></li>';
            }else{
                pageStr += '<li><a href="javascript:void(0)" rel="'+i+'">'+i+'</a></li>';
            }
        }
        pageStr += '<li class="next"><a href="javascript:void(0)">下一页</a></li>'+
                            '<li class="next"><a href="javascript:void(0)">尾页</a></li>'
    } else if(totalPage == 1){
     pageStr += '<li class="next" style="margin-left:0px"><a href="javascript:void(0)">首页</a></li>'+
                '<li class="next"><a href="javascript:void(0)">上一页</a></li>';
            pageStr += '<li><a href="javascript:void(0)" style="background:#d24727; color:#fff;" rel="1">1</a></li>';

            pageStr += '<li class="next"><a href="javascript:void(0)">下一页</a></li>'+
                                '<li class="next"><a href="javascript:void(0)">尾页</a></li>';
    } else if(totalPage == 0){
    pageStr += '<li class="next" style="margin-left:0px"><a href="javascript:void(0)">首页</a></li>'+
                    '<li class="next"><a href="javascript:void(0)">上一页</a></li>';
                pageStr += '<li class="next"><a href="javascript:void(0)">下一页</a></li>'+
                                    '<li class="next"><a href="javascript:void(0)">尾页</a></li>';
    } else{
        pageStr += '<li class="next" style="margin-left:0px"><a href="javascript:void(0)" rel="1">首页</a></li>'+
            '<li class="next"><a href="javascript:void(0)" rel="'+(curPage-1)+'">上一页</a></li>';
        for(var i=1; i< totalPage+1; i++){
            if (i==curPage){
                pageStr += '<li><a href="javascript:void(0)" style="background:#d24727; color:#fff;" rel="'+i+'">'+i+'</a></li>';
            }else{
                pageStr += '<li><a href="javascript:void(0)" rel="'+i+'">'+i+'</a></li>';
            }
        }
        pageStr += '<li class="next"><a href="javascript:void(0)" rel="'+(parseInt(curPage)+1)+'" >下一页</a></li>'+
                         '<li class="next"><a href="javascript:void(0)" rel="'+totalPage+'">尾页</a></li>'
    }

    pageStr +='<li class="next"style="margin-left:20px"><a>共'+total+'条</a></li>';

    $("#pageCount ul").html(pageStr);
}

$(function(){
    getData(1);
    $("#pageCount ul li a").live('click',function(){
        var rel = $(this).attr("rel");
        if(rel){
            getData(rel);
        }
    });
});