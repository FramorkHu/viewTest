package com.work.controller;

import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.taskdefs.condition.Http;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.util.*;

/**
 * Created by huyan on 2015/5/18.
 */
public class UploadUtils {

    private static final String MEDIA_UPLOAD_PATH = "source/movie";
    private static final String PICTURE_UPLOAD_PATH = "source/img";
    private static String DEFAULT_PATH ="source/img";
    private static final Map<String, String> FILE_PATH = new HashMap<String, String>();
    static {
        FILE_PATH.put("coverPicture",PICTURE_UPLOAD_PATH);
        FILE_PATH.put("movie",MEDIA_UPLOAD_PATH);
        FILE_PATH.put("picture",PICTURE_UPLOAD_PATH);
    }


    public static Map<String, List<String>> uploadFileDiff( HttpServletRequest request){

        Map<String, List<String>> uploadPathMap = new HashMap<String, List<String>>();
        uploadPathMap.put("pic", new ArrayList<String>());
        uploadPathMap.put("media", new ArrayList<String>());

        ServletContext servletContext = request.getSession().getServletContext();

        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(servletContext);

        if(multipartResolver.isMultipart(request)) { //判断请求form中是否有enctype="multipart/form-data"
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator fileNames=multiRequest.getFileNames();

            while(fileNames.hasNext()) {
                String fileName = fileNames.next().toString();

                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(fileName);
                if(file!=null) {
                    String fileOriginName = file.getOriginalFilename();
                    int lastIndex = fileOriginName.lastIndexOf(".");
                    String suffix = fileOriginName.substring(lastIndex, fileOriginName.length());
                    String name = System.currentTimeMillis()+suffix;

                    //上传
                    try {
                        String savePath ;
                        List<String> uploadPath;
                        String path;
                        if (!checkIsMedia(name)){   //图片
                            savePath = servletContext.getRealPath(PICTURE_UPLOAD_PATH);   //得到文件保存的绝对路径
                            uploadPath = uploadPathMap.get("pic");
                            path = PICTURE_UPLOAD_PATH;

                        } else if (checkIsMedia(name) && uploadPathMap.get("media").isEmpty()){
                            savePath = servletContext.getRealPath(MEDIA_UPLOAD_PATH);   //得到文件保存的绝对路径
                            uploadPath = uploadPathMap.get("media");
                            path = MEDIA_UPLOAD_PATH;
                        } else {
                            continue;
                        }
                        FileUtils.writeByteArrayToFile(new File(savePath, name), file.getBytes());
                        uploadPath.add(path+"/"+name);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        return uploadPathMap;

    }


    public static List<String> uploadPicFile(HttpServletRequest request){

        List<String> fileUploadPath = new ArrayList<String>();

        ServletContext servletContext = request.getSession().getServletContext();

        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(servletContext);

        if(multipartResolver.isMultipart(request)) { //判断请求form中是否有enctype="multipart/form-data"
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator fileNames=multiRequest.getFileNames();
            while(fileNames.hasNext()) {
                String fileName = fileNames.next().toString();

                String savePath = servletContext.getRealPath(PICTURE_UPLOAD_PATH);   //得到文件保存的绝对路径

                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(fileName);
                if(file!=null) {
                    String name = System.currentTimeMillis()+file.getOriginalFilename();    //设置上传文件名
                    //上传
                    try {

                        FileUtils.writeByteArrayToFile(new File(savePath, name), file.getBytes());
                        fileUploadPath.add(PICTURE_UPLOAD_PATH+"/"+name);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

        }
        return fileUploadPath;

    }

    public static Map<String, List<String>> uploadFile( HttpServletRequest request){

        Map<String, List<String>> uploadPathMap = new HashMap<String, List<String>>();
        uploadPathMap.put("coverPicture",new ArrayList<String>());
        uploadPathMap.put("movie",new ArrayList<String>());
        uploadPathMap.put("picture",new ArrayList<String>());

        ServletContext servletContext = request.getSession().getServletContext();

        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(servletContext);

        if(multipartResolver.isMultipart(request)) { //判断请求form中是否有enctype="multipart/form-data"
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
            //获取multiRequest 中所有的文件名
            Iterator fileNames=multiRequest.getFileNames();
            List<String> pathStrList ;
            while(fileNames.hasNext()) {
                String fileName = fileNames.next().toString();
                String path = FILE_PATH.get(fileName);
                if (path==null){
                    path = DEFAULT_PATH;
                }
                pathStrList = uploadPathMap.get(fileName);
                if (pathStrList == null){
                    pathStrList = uploadPathMap.get("picture");
                }
                String savePath = servletContext.getRealPath(path);   //得到文件保存的绝对路径

                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(fileName);
                if(file!=null) {
                    String name = System.currentTimeMillis()+file.getOriginalFilename();    //设置上传文件名
                    //上传
                    try {

                        FileUtils.writeByteArrayToFile(new File(savePath, name), file.getBytes());
                        //file.transferTo(uploadFile);
                        pathStrList.add(path+"/"+name);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }

        }
        return uploadPathMap;

    }


    public static boolean checkIsMedia(String fileName){
        boolean flag = false;
        if (fileName == null){
            return flag;
        }

        List<String> medias = new ArrayList<String>();
        medias.add(".mp4");
        medias.add(".rmvb");
        medias.add(".rm");
        medias.add(".mpg");
        medias.add(".avi");
        medias.add(".mpeg");
        medias.add(".flv");
        int lastIndex = fileName.lastIndexOf(".");
        if (lastIndex<0){
            return flag;
        }
        String suffix = fileName.substring(lastIndex, fileName.length());
        for (String media : medias){
            if (suffix.equalsIgnoreCase(media)){
                flag = true;
                break;
            }
        }

        return flag;
    }

}
