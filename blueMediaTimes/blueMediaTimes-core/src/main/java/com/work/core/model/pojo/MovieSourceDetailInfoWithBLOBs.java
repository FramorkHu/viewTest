package com.work.core.model.pojo;

public class MovieSourceDetailInfoWithBLOBs extends MovieSourceDetailInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_source_detail_info.movie_describe
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    private String movieDescribe;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_source_detail_info.media_url
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    private String mediaUrl;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_source_detail_info.ext
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    private String ext;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_source_detail_info.movie_describe
     *
     * @return the value of movie_source_detail_info.movie_describe
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    public String getMovieDescribe() {
        return movieDescribe;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_source_detail_info.movie_describe
     *
     * @param movieDescribe the value for movie_source_detail_info.movie_describe
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    public void setMovieDescribe(String movieDescribe) {
        this.movieDescribe = movieDescribe == null ? null : movieDescribe.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_source_detail_info.media_url
     *
     * @return the value of movie_source_detail_info.media_url
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    public String getMediaUrl() {
        return mediaUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_source_detail_info.media_url
     *
     * @param mediaUrl the value for movie_source_detail_info.media_url
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl == null ? null : mediaUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_source_detail_info.ext
     *
     * @return the value of movie_source_detail_info.ext
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    public String getExt() {
        return ext;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_source_detail_info.ext
     *
     * @param ext the value for movie_source_detail_info.ext
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    public void setExt(String ext) {
        this.ext = ext == null ? null : ext.trim();
    }
}