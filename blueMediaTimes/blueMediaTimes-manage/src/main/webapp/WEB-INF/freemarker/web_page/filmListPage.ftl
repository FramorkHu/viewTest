
 <#list baseDataBvos as baseDataBvo>
     <#if (baseDataBvo_index+1)%5 == 1>
         <div class="choose_on" style="padding-left:0px;">
             <img src="${baseDataBvo.coverImgPath!''}" width="140" height="200" />
             <ul>
                 <li class="film_name"><a href="film/filmDetail?film=${baseDataBvo.id!''}" target="_blank">${baseDataBvo.movieName!''}</a></li>
                 <li class="film_actor">${baseDataBvo.movieActor!''}</li>
             </ul>
         </div>
         <#else>
             <div class="choose_on">
                 <img src="${baseDataBvo.coverImgPath!''}" width="140" height="200" />
                 <ul>
                     <li class="film_name"><a href="film/filmDetail?film=${baseDataBvo.id!''}" target="_blank">${baseDataBvo.movieName!''}</a></li>
                     <li class="film_actor">${baseDataBvo.movieActor!''}</li>
                 </ul>
             </div>
     </#if>
 </#list>
