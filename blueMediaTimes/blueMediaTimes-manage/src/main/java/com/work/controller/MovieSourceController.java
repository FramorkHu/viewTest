package com.work.controller;

import com.util.MediaUtils;
import com.work.controller.webPage.ItemPageController;
import com.work.core.model.bvo.MovieSourceBaseDataBvo;
import com.work.core.model.bvo.MovieSourceDetailBvo;
import com.work.core.model.pojo.MovieClassify;
import com.work.core.model.pojo.MovieImgInfo;
import com.work.core.model.pojo.MovieSourceClassifyInfo;
import com.work.core.model.pojo.MovieSourceDetailInfoWithBLOBs;
import com.work.service.MovieClassifyService;
import com.work.service.MovieImgInfoService;
import com.work.service.MovieSourceClassifyInfoService;
import com.work.service.MovieSourceDetailInfoService;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huyan on 15/5/11.
 */
@Controller
@RequestMapping(value = "/webAdminMovie")
public class MovieSourceController extends AbstractController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MovieSourceController.class);

    private static final String PREFIX = "/web_admin/movieSource/";

    @Autowired
    MovieSourceDetailInfoService movieSourceDetailInfoService;

    @Autowired
    MovieImgInfoService movieImgInfoService;

    @Autowired
    MovieClassifyService movieClassifyService;

    @Autowired
    MovieSourceClassifyInfoService movieSourceClassifyInfoService;

    @RequestMapping("movieSourceView")
    public String getMovieView(){

        return PREFIX+"movieSource";
    }

    @RequestMapping("getMovieSourceData")
    private void getMovieSourceData(HttpServletResponse response, String movieName,
                                    int page, int rows){

        int start = (page - 1) * rows;
        List<MovieSourceDetailInfoWithBLOBs> detailInfoWithBLOBses =
                movieSourceDetailInfoService.getMovieSourceDetailInfo(movieName, start, rows);
        int total = movieSourceDetailInfoService.countMovieSourceDetailInfo(movieName);

        Map<String, Object> result = new HashMap<String, Object>();
        result.put(ROWS, detailInfoWithBLOBses);
        result.put(TOTAL, total);

        writeJson(response, result);

    }

    @RequestMapping("getMovieSourceBaseDataView")
    private String viewMovieSource(){
        return "/web_admin/index/addMovieSource";
    }

    @RequestMapping("getMovieSourceBaseData")
    private void getMovieSourceBaseDataByName(HttpServletResponse response, String movieName){

        List<MovieSourceBaseDataBvo> baseDataBvos =
                movieSourceDetailInfoService.getMovieSourceBaseDataByName(movieName);

        Map<String, Object> result = new HashMap<String, Object>();
        result.put(ROWS, baseDataBvos);

        writeJson(response, result);

    }

    @RequestMapping("getMovieSourceDetail")
    public String getMovieSourceDetail(Model model, int sourceId){

        MovieSourceDetailBvo detailBvo =
                movieSourceDetailInfoService.getMovieSourceDetailBvo(sourceId);

        model.addAttribute("detailBvo",detailBvo);

        return PREFIX +"movieSourceDetail";
    }

    @RequestMapping("getAddMovieSourceView")
    public String getAddMovieSourceView(Model model){

        return PREFIX +"addMovieSource";
    }

    @RequestMapping(value = {"addMovieSourceDetail"}, method = RequestMethod.POST)
    public String insertMovieSourceDetail(Model model, MovieSourceDetailInfoWithBLOBs infoWithBLOBs,
                                          String[] picPath, String[] mediaPath,String[] classifyId,
                                          HttpServletRequest request){

        String movieFileName = "";
        int isMedia = 0;
        String coverImgPath = "";
        ServletContext sc = request.getSession().getServletContext();

        if (picPath != null && picPath.length>0){
            coverImgPath = picPath[0];
        }

        if (infoWithBLOBs.getMediaUrl()!= null && !"".equals(infoWithBLOBs.getMediaUrl())){  //上传了三方视频的地址，使用三方视频地址，删除文件
            isMedia = 2;
            if (mediaPath!=null && mediaPath.length>0){
                movieFileName = mediaPath[0];
                String path = sc.getRealPath(movieFileName);
                com.util.FileUtils.deleteFile(path);
            }
        } else {
            if (mediaPath!=null && mediaPath.length>0){
                movieFileName = mediaPath[0];
                isMedia = 1;
            }
        }

        if (mediaPath!=null && mediaPath.length>1){
            for (int i=1; i<mediaPath.length; i++){
                String path = sc.getRealPath(mediaPath[i]);
                com.util.FileUtils.deleteFile(path);
            }

        }

        infoWithBLOBs.setCoverImgPath(coverImgPath);
        infoWithBLOBs.setMediaPath(movieFileName);
        infoWithBLOBs.setIsMedia(isMedia);

        int result = movieSourceDetailInfoService.insertMovieSourceDetailInfo(infoWithBLOBs);

        if (result >0 ){
            model.addAttribute("msg", "添加成功");
            int id = infoWithBLOBs.getId();
            if (classifyId != null){
                MovieSourceClassifyInfo classifyInfo ;
                for (String classify : classifyId){
                    classifyInfo = new MovieSourceClassifyInfo();
                    classifyInfo.setClassifyId(NumberUtils.toInt(classify));
                    classifyInfo.setSourceId(id);
                    movieSourceClassifyInfoService.insertMovieSourceClassifyInfo(classifyInfo);
                }

            }
            MovieImgInfo movieImgInfo;
            if (picPath!=null && picPath.length>1){
                for (int i=1; i<picPath.length; i++){
                    movieImgInfo = new MovieImgInfo();
                    movieImgInfo.setImgPath(picPath[i]);
                    movieImgInfo.setSourceId(id);
                    movieImgInfoService.insertMovieImgInfo(movieImgInfo);
                }

            }

            ItemPageController.years = movieSourceDetailInfoService.getProductYearMovieSource();
        }else {
            model.addAttribute("msg", "添加失败");
        }

        return PREFIX +"movieSourceDetail";
    }

    @RequestMapping("deleteMovieSourceDetail")
    public void deleteMovieSource(Model model, String sourceIdStr, HttpServletRequest request){
        Integer sourceId = NumberUtils.toInt(sourceIdStr);

        MovieSourceDetailBvo detailBvo =
                movieSourceDetailInfoService.getMovieSourceDetailBvo(sourceId);

        ServletContext sc = request.getSession().getServletContext();

        String coverImgPath = sc.getRealPath(detailBvo.getCoverImgPath());
        String mediaPath = sc.getRealPath(detailBvo.getMediaPath());
        List<String> imgPaths = detailBvo.getImgPaths();
        com.util.FileUtils.deleteFile(coverImgPath);
        com.util.FileUtils.deleteFile(mediaPath);
        for (String imgPath : imgPaths){

            com.util.FileUtils.deleteFile(sc.getRealPath(imgPath));
        }

        int result =
                movieSourceDetailInfoService.deleteMovieSourceDetail(sourceId);
        movieSourceClassifyInfoService.deleteMovieSourceClassifyInfo(sourceId);
        if (result>0){
            model.addAttribute("msg","删除成功");
            movieImgInfoService.deleteMovieImgInfo(sourceId);
            ItemPageController.years = movieSourceDetailInfoService.getProductYearMovieSource();
        } else {
            model.addAttribute("msg","删除失败");
        }

    }

    @RequestMapping("updateMovieSourceDetail")
    public void updateMovieSource(Model model,
                                  MovieSourceDetailInfoWithBLOBs infoWithBLOBs ){
        int id = infoWithBLOBs.getId();

        MovieSourceDetailBvo tmpWithBLOBs =
                movieSourceDetailInfoService.getMovieSourceDetailBvo(id);

        infoWithBLOBs.setMediaPath(tmpWithBLOBs.getMediaPath());
        infoWithBLOBs.setIsMedia(tmpWithBLOBs.getIsMedia());
        infoWithBLOBs.setCoverImgPath(tmpWithBLOBs.getCoverImgPath());
        int result = movieSourceDetailInfoService.updateMovieSourceDetailInfo(infoWithBLOBs);
        if (result>0){
            model.addAttribute("msg","更新成功");
            ItemPageController.years = movieSourceDetailInfoService.getProductYearMovieSource();
        } else {
            model.addAttribute("msg","更新失败");
        }

    }



}
