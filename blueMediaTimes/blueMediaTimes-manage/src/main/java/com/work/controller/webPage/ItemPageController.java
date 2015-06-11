package com.work.controller.webPage;

import com.util.StringUtils;
import com.work.controller.AbstractController;
import com.work.core.model.bvo.MovieSourceBaseDataBvo;
import com.work.core.model.pojo.MovieClassify;
import com.work.service.MovieClassifyService;
import com.work.service.MovieSourceDetailInfoService;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by huyan on 15/5/7.
 */
@Controller
@RequestMapping(value = "/")
public class ItemPageController extends AbstractController implements InitializingBean {

    private static final String PREFIX = "/web_page/";

    @Autowired
    MovieClassifyService movieClassifyService;

    @Autowired
    MovieSourceDetailInfoService movieSourceDetailInfoService;

    public static List<MovieClassify> movieClassifies ;
    public static List<String> years ;

    @RequestMapping(value = "film")
    public String getFilmPageView(Model model ){
        model.addAttribute("classifies", movieClassifies);
        model.addAttribute("years", years);
        model.addAttribute("attributeName",2);
        model.addAttribute("itemName","电影");
        return PREFIX +"film";
    }

    @RequestMapping(value = "documentary")
    public String getDocumentaryPageView(Model model ){
        model.addAttribute("classifies", movieClassifies);
        model.addAttribute("years", years);
        model.addAttribute("attributeName",3);
        model.addAttribute("itemName","纪录片");
        return PREFIX +"film";
    }

    @RequestMapping(value = "cartoon")
    public String getCartoonPageView(Model model ){
        model.addAttribute("classifies", movieClassifies);
        model.addAttribute("years", years);
        model.addAttribute("attributeName",4);
        model.addAttribute("itemName","动画片");
        return PREFIX +"film";
    }

    @RequestMapping(value = "3d")
    public String get3dPageView(Model model ){
        model.addAttribute("classifies", movieClassifies);
        model.addAttribute("years", years);
        model.addAttribute("attributeName",5);
        model.addAttribute("itemName","3D电影");
        return PREFIX +"film";
    }

    @RequestMapping(value = "filmList")
    public void getFilmListView(Model model,String year, String classify, Integer attribute,
                                  String startPage, String rows ,HttpServletResponse response){

        Integer yearInt = null;
        Integer classifyId = null;
        int start = NumberUtils.toInt(startPage);
        int pageSize = NumberUtils.toInt(rows);

        if (year!=null && !"".equals(year)){
            yearInt = NumberUtils.toInt(year);
        }
        if (classify!= null && !"".equals(classify)){
            classifyId = NumberUtils.toInt(classify);
        }
        if (start<0){
            start = 0;
        }
        if (pageSize<=0){
            pageSize = 15;
        }
        if (attribute == null){
            attribute = 2;
        }

        start = start*pageSize;

        List<MovieSourceBaseDataBvo> baseDataBvos =
                movieSourceDetailInfoService.getMovieSourceByCondition(yearInt, classifyId,attribute, start, pageSize);
        int totalCount = movieSourceDetailInfoService.countMovieSourceByCondition(yearInt, classifyId,attribute);

        int totalPage = (int) Math.ceil(totalCount * 1.0 / pageSize);

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("totalCount", totalCount);
        result.put("totalPage", totalPage);
        result.put("pageSize", rows);
        StringBuilder builder = new StringBuilder();

        if (baseDataBvos.isEmpty()){
            builder.append("<div style=\"border:1px solid #d24727; height:200px; width:700px; margin:30px auto; text-align:center; line-height:200px; font-size:14px;\">\n" +
                    "    对不起，您查看的目录暂时没有上传影片，请查看其他目录\n" +
                    "\n" +
                    "    </div>");
        } else {
            for (int i=0; i<baseDataBvos.size(); i++){
                String movieActor = StringUtils.valueOf(baseDataBvos.get(i).getMovieActor());
                if(movieActor.length()>13){
                    movieActor = movieActor.substring(0,10)+"...";
                }

                if ( (i+1)%5 == 1){
                    builder.append("<div class=\"choose_on\" style=\"padding-left:0px;\">\n" +
                            "             <img src=\""+StringUtils.valueOf(baseDataBvos.get(i).getCoverImgPath())+"\" width=\"140\" height=\"200\" />\n" +
                            "             <ul>\n" +
                            "                 <li class=\"film_name\"><a href=\"film/filmDetail?film="+StringUtils.valueOf(baseDataBvos.get(i).getId()) + "\" target=\"_blank\">" + StringUtils.valueOf(baseDataBvos.get(i).getMovieName()) + "</a></li>\n" +
                            "                 <li class=\"film_actor\">"+movieActor+"</li>\n" +
                            "             </ul>\n" +
                            "         </div>");
                } else {
                    builder.append("<div class=\"choose_on\">\n" +
                            "             <img src=\""+StringUtils.valueOf(baseDataBvos.get(i).getCoverImgPath())+"\" width=\"140\" height=\"200\" />\n" +
                            "             <ul>\n" +
                            "                 <li class=\"film_name\"><a href=\"film/filmDetail?film="+StringUtils.valueOf(baseDataBvos.get(i).getId()) + "\" target=\"_blank\">" + StringUtils.valueOf(baseDataBvos.get(i).getMovieName()) + "</a></li>\n" +
                            "                 <li class=\"film_actor\">"+movieActor+"</li>\n" +
                            "             </ul>\n" +
                            "         </div>");
                }

            }
        }

        result.put("pageData", builder.toString());
        writeJson(response, result);

    }



    @RequestMapping("about")
    public String aboutUs(){
        return PREFIX+"about";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        movieClassifies =
                movieClassifyService.getMovieClassify(null, null);
        years =
                movieSourceDetailInfoService.getProductYearMovieSource();
    }


}
