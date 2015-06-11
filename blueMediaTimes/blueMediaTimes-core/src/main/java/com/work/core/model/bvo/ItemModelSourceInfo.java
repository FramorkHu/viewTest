package com.work.core.model.bvo;

/**
 * Created by huyan on 15/5/10.
 */
public class ItemModelSourceInfo {

    private int id;
    private int modelId;
    private int sourceId;
    private String sourceName;
    private String movieName;
    private String imgPath;
    private String tmpImgPath;
    private String simpleDescribe;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public int getSourceId() {
        return sourceId;
    }

    public void setSourceId(int sourceId) {
        this.sourceId = sourceId;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getTmpImgPath() {
        return tmpImgPath;
    }

    public void setTmpImgPath(String tmpImgPath) {
        this.tmpImgPath = tmpImgPath;
    }

    public String getSimpleDescribe() {
        return simpleDescribe;
    }

    public void setSimpleDescribe(String simpleDescribe) {
        this.simpleDescribe = simpleDescribe;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
}
