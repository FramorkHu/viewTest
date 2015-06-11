package com.work.core.model.bvo;

/**
 * Created by huyan on 15/5/12.
 */
public class MovieSourceBaseDataBvo {

    private Integer id;
    private String coverImgPath;
    private String movieName;
    private String movieEnglishName;
    private Integer isMedia;
    private Integer movieProduceYear;
    private String movieActor;

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

    public Integer getIsMedia() {
        return isMedia;
    }

    public void setIsMedia(Integer isMedia) {
        this.isMedia = isMedia;
    }

    public Integer getMovieProduceYear() {
        return movieProduceYear;
    }

    public void setMovieProduceYear(Integer movieProduceYear) {
        this.movieProduceYear = movieProduceYear;
    }

    public String getMovieActor() {
        return movieActor;
    }

    public void setMovieActor(String movieActor) {
        this.movieActor = movieActor;
    }
}
