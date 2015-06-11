package com.work.controller;

import com.util.FileUtils;
import com.work.core.model.pojo.ModelSourceInfo;
import com.work.service.ModelSourceInfoService;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by huyan on 15/5/8.
 */
@Controller
@RequestMapping(value = "/webAdminModel")
public class WebAdminModelController extends AbstractController {

    private static final String PREFIX = "/web_admin/index/";

    private static final Logger LOGGER = LoggerFactory.getLogger(WebAdminModelController.class);

    private static final String PIC_UPLOAD_PATH = "upload/img";

    @Autowired
    ModelSourceInfoService modelSourceInfoService;

    @RequestMapping("addModelSource")
    public void addModelSource(Model model,String sourceName,
                               String simpleDescribe,String modelIdStr, String sourceIdStr,
                               String selectMovieName,
                               @RequestParam("picture") MultipartFile picture,
                               HttpServletRequest request){

        Integer sourceId = NumberUtils.toInt(sourceIdStr);
        Integer modelId = NumberUtils.toInt(modelIdStr);

        ModelSourceInfo sourceInfo = new ModelSourceInfo();
        sourceInfo.setSourceId(sourceId);
        sourceInfo.setModelId(modelId);
        sourceInfo.setSourceName(sourceName);
        sourceInfo.setSimpleDescribe(simpleDescribe);
        sourceInfo.setMovieName(selectMovieName);

        if(!picture.isEmpty()){
            ServletContext sc = request.getSession().getServletContext();
            String dir = sc.getRealPath(PIC_UPLOAD_PATH);    //设定文件保存的目录

            String fileOriginName = picture.getOriginalFilename();
            int lastIndex = fileOriginName.lastIndexOf(".");
            String suffix = fileOriginName.substring(lastIndex, fileOriginName.length());
            String picName = System.currentTimeMillis()+suffix; //设置上传文件名

            try {
                org.apache.commons.io.FileUtils.writeByteArrayToFile(new File(dir, picName), picture.getBytes());
                String picPath = PIC_UPLOAD_PATH+"/"+picName;
                sourceInfo.setImgPath(picPath);
            } catch (Exception e){
                LOGGER.error("addModelSource upload file is error, fileName:"+picName,e);

            }

        }

        int result = modelSourceInfoService.insertItemModelSource(sourceInfo);
        if (result>0){
            model.addAttribute("msg","添加成功");
        }else {
            model.addAttribute("msg","添加失败");
        }
    }

    @RequestMapping("deleteModelSource")
    public void deleteModelSource(HttpServletRequest request, Model model, String idStr, String imgPath){

        String path = request.getSession().getServletContext()
                .getRealPath(imgPath);
        Integer id = NumberUtils.toInt(idStr);
        FileUtils.deleteFile(path);
        int result = modelSourceInfoService.deleteItemModelSource(id);
        if (result>0){
            model.addAttribute("msg","删除成功");
        }else {
            model.addAttribute("msg","删除失败");
        }
    }

    @RequestMapping("updateModelSource")
    public void updateModelSource(Model model, ModelSourceInfo modelSourceInfo){

        if (modelSourceInfo == null){
            model.addAttribute("msg","更新失败");
            return;
        }
        int id = modelSourceInfo.getId();
        ModelSourceInfo sourceInfo = modelSourceInfoService.getModelSourceInfo(id);
        modelSourceInfo.setImgPath(sourceInfo.getImgPath());
        int result = modelSourceInfoService.updateModelSourceInfo(modelSourceInfo);
        if (result>0){
            model.addAttribute("msg","更新成功");
        } else {
            model.addAttribute("msg","更新失败");
        }
    }

    @RequestMapping("movie")
    public String movieUploadView(){
        return PREFIX+"movie";
    }

}
