package com.work.core.model.bvo;

import java.util.List;

/**
 * Created by huyan on 15/5/12.
 */
public class MovieSourceDetailBvo {

    private Integer id;
    private String coverImgPath;
    private String mediaPath;
    private Integer isMedia;
    private String movieName;
    private String movieEnglishName;
    private String mediaUrl;
    private Integer movieTime;
    private Integer movieProduceYear;
    private String movieClassifyName;
    private String movieActor;
    private String movieDirect;
    private String movieDescribe;
    private String movieCountry;
    private String ext;
    private List<String> imgPaths;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCoverImgPath() {
        return coverImgPath;
    }

    public void setCoverImgPath(String coverImgPath) {
        this.coverImgPath = coverImgPath;
    }

    public String getMediaPath() {
        return mediaPath;
    }

    public void setMediaPath(String mediaPath) {
        this.mediaPath = mediaPath;
    }

    public Integer getIsMedia() {
        return isMedia;
    }

    public void setIsMedia(Integer isMedia) {
        this.isMedia = isMedia;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieEnglishName() {
        return movieEnglishName;
    }

    public void setMovieEnglishName(String movieEnglishName) {
        this.movieEnglishName = movieEnglishName;
    }

    public Integer getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(Integer movieTime) {
        this.movieTime = movieTime;
    }

    public Integer getMovieProduceYear() {
        return movieProduceYear;
    }

    public void setMovieProduceYear(Integer movieProduceYear) {
        this.movieProduceYear = movieProduceYear;
    }

    public String getMovieClassifyName() {
        return movieClassifyName;
    }

    public void setMovieClassifyName(String movieClassifyName) {
        this.movieClassifyName = movieClassifyName;
    }

    public String getMovieActor() {
        return movieActor;
    }

    public void setMovieActor(String movieActor) {
        this.movieActor = movieActor;
    }

    public String getMovieDirect() {
        return movieDirect;
    }

    public void setMovieDirect(String movieDirect) {
        this.movieDirect = movieDirect;
    }

    public String getMovieDescribe() {
        return movieDescribe;
    }

    public void setMovieDescribe(String movieDescribe) {
        this.movieDescribe = movieDescribe;
    }

    public String getMovieCountry() {
        return movieCountry;
    }

    public void setMovieCountry(String movieCountry) {
        this.movieCountry = movieCountry;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public List<String> getImgPaths() {
        return imgPaths;
    }

    public void setImgPaths(List<String> imgPaths) {
        this.imgPaths = imgPaths;
    }
}
