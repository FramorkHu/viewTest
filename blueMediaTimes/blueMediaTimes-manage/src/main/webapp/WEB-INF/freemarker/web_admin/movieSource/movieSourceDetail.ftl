
<div class="fitem">
    <label>
        封面
    </label>
    <div> <img src='${rc.getContextPath()}/"+${detailBvo.coverImgPath!""}+"'></div>
</div>   <br/>
<div class="fitem">
    <label>
        电影名称
    </label>
    <div> ${detailBvo.movieName!""}</div>
</div>   <br/>
<div class="fitem">
    <label>
        英文名称
    </label>
    <div> ${detailBvo.movieEnglishName!""}</div>
</div>   <br/>
<div class="fitem">

    <label>影片时长</label><div>${detailBvo.movieTime!""}</div>

    <label style="padding-left:10px">出品年代</label><div>${detailBvo.movieProduceYear!""}</div>
</div>   <br/>
<div class="fitem">
    <label>影片详细描述</label>
    <div>${detailBvo.movieDescribe!""}</div>
</div>

