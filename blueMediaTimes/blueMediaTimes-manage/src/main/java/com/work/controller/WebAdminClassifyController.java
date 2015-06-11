package com.work.controller;

import com.work.controller.webPage.ItemPageController;
import com.work.core.model.pojo.MovieClassify;
import com.work.service.MovieClassifyService;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
 * Created by huyan on 15/5/16.
 */
@Controller
@RequestMapping(value = "/webAdminMovie")
public class WebAdminClassifyController extends AbstractController  {

    private static final String PREFIX = "/web_admin/movieSource/";

    @Autowired
    MovieClassifyService movieClassifyService;

    @RequestMapping("getMovieClassifyView")
    public String getMovieClassifyView(){

        return PREFIX+"movieClassify";
    }

    @RequestMapping("getMovieClassifyData")
    public void getClassifyData(HttpServletResponse response,
                                int page, int rows){

        int start = (page - 1) * rows;
        List<MovieClassify> movieClassifies =
                movieClassifyService.getMovieClassify(start, rows);
        int total = movieClassifyService.countMovieClassify();

        Map<String, Object> result = new HashMap<String, Object>();
        result.put(ROWS, movieClassifies);
        result.put(TOTAL, total);

        writeJson(response, result);
    }

    @RequestMapping("addMovieClassify")
    public void addMovieClassify(Model model, String classifyName){

        if (!"".equals(classifyName)){
            MovieClassify movieClassify = new MovieClassify();
            movieClassify.setClassifyName(classifyName);
            int result = movieClassifyService.insertMovieClassify(movieClassify);
            if (result>0){
                model.addAttribute("msg","添加成功");
                ItemPageController.movieClassifies = movieClassifyService.getMovieClassify(null, null);
            } else {
                model.addAttribute("msg","添加失败");
            }
        } else {
            model.addAttribute("msg","上传的分类不能为空");
        }


    }

    @RequestMapping("updateMovieClassify")
    public void updateMovieClassify(Model model, String id, String classifyName){

        if (!"".equals(classifyName)){
            int idInt = NumberUtils.toInt(id);
            MovieClassify movieClassify = new MovieClassify();
            movieClassify.setClassifyName(classifyName);
            movieClassify.setId(idInt);
            int result = movieClassifyService.updateMovieClassify(movieClassify);
            if (result>0){
                model.addAttribute("msg","更新成功");
                ItemPageController.movieClassifies = movieClassifyService.getMovieClassify(null, null);
            } else {
                model.addAttribute("msg","更新失败");
            }
        } else {
            model.addAttribute("msg","上传的分类不能为空");
        }
    }

    @RequestMapping("deleteMovieClassify")
    public void deleteMovieClassify(Model model, String idStr){


        int idInt = NumberUtils.toInt(idStr);

        int result = movieClassifyService.delMovieClassify(idInt);
        if (result>0){
            model.addAttribute("msg","删除成功");
            ItemPageController.movieClassifies = movieClassifyService.getMovieClassify(null, null);
        } else {
            model.addAttribute("msg","删除失败");
        }

    }

    @RequestMapping("getClassifyList")
    public void getClassifyList(HttpServletResponse response){
        List<MovieClassify> movieClassifies =
                movieClassifyService.getMovieClassify(null, null);
        writeJson(response, movieClassifies);

    }

    @RequestMapping("getMovieAttribute")
    public void getMovieAttribute(HttpServletResponse response){
        List<MovieClassify> movieAttributes = new ArrayList<MovieClassify>();
        Map<Integer, String> attributeMap = new LinkedHashMap<Integer, String>();
        attributeMap.put(2,"电影");
        attributeMap.put(3,"纪录片");
        attributeMap.put(4,"动画片");
        attributeMap.put(5,"3D电影");
        MovieClassify movieClassify ;
        for (Map.Entry<Integer, String> entry : attributeMap.entrySet()){
            movieClassify = new MovieClassify();
            movieClassify.setId(entry.getKey());
            movieClassify.setClassifyName(entry.getValue());

            movieAttributes.add(movieClassify);
        }
        writeJson(response, movieAttributes);
    }

}
