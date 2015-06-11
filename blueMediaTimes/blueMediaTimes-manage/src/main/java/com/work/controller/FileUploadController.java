package com.work.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.aspectj.util.FileUtil;
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
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by huyan on 15/5/8.
 */
@Controller
@RequestMapping(value = "/webAdminMovie")
public class FileUploadController extends AbstractController {

    private static final String PREFIX = "web_admin/movieSource";

    private Map<String, List<String>> fileNameMap;

    @RequestMapping("upload")
    public void upload(Model model, HttpServletRequest request, HttpServletResponse response){

        Map<String, List<String>> fileNameMap = UploadUtils.uploadFileDiff(request);
        writeJson(response, fileNameMap);
        //return PREFIX+"/movieSource";
    }

    @RequestMapping("uploadPic")
    public String uploadMovie(Model model, HttpServletRequest request){

        List<String> picPathList =
                UploadUtils.uploadPicFile(request);

        model.addAttribute("picPaths", picPathList);
        return PREFIX+"/movieSource";
    }

    @RequestMapping("uploadView")
    public String uploadView(Model model, HttpServletRequest request){

        return PREFIX+"/upload";
    }

    public Map<String, List<String>> getFileNameMap() {
        return fileNameMap;
    }

    class DataBvo{
        private String picPath;
        private String mediaPath;

        public String getPicPath() {
            return picPath;
        }

        public void setPicPath(String picPath) {
            this.picPath = picPath;
        }

        public String getMediaPath() {
            return mediaPath;
        }

        public void setMediaPath(String mediaPath) {
            this.mediaPath = mediaPath;
        }
    }
}
