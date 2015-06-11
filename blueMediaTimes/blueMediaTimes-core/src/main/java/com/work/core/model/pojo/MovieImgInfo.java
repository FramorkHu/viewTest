package com.work.core.model.pojo;

import com.util.BasePojo;

public class MovieImgInfo extends BasePojo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_img_info.source_id
     *
     * @mbggenerated Sun May 10 10:58:39 CST 2015
     */
    private Integer sourceId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_img_info.img_path
     *
     * @mbggenerated Sun May 10 10:58:39 CST 2015
     */
    private String imgPath;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_img_info.source_id
     *
     * @return the value of movie_img_info.source_id
     *
     * @mbggenerated Sun May 10 10:58:39 CST 2015
     */
    public Integer getSourceId() {
        return sourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_img_info.source_id
     *
     * @param sourceId the value for movie_img_info.source_id
     *
     * @mbggenerated Sun May 10 10:58:39 CST 2015
     */
    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_img_info.img_path
     *
     * @return the value of movie_img_info.img_path
     *
     * @mbggenerated Sun May 10 10:58:39 CST 2015
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_img_info.img_path
     *
     * @param imgPath the value for movie_img_info.img_path
     *
     * @mbggenerated Sun May 10 10:58:39 CST 2015
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }
}