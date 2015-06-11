package com.work.core.model.pojo;

import com.util.BasePojo;

public class MovieSourceClassifyInfo extends BasePojo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_source_classify_info.id
     *
     * @mbggenerated Thu May 28 22:57:40 CST 2015
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_source_classify_info.classify_id
     *
     * @mbggenerated Thu May 28 22:57:40 CST 2015
     */
    private Integer classifyId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column movie_source_classify_info.source_id
     *
     * @mbggenerated Thu May 28 22:57:40 CST 2015
     */
    private Integer sourceId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_source_classify_info.id
     *
     * @return the value of movie_source_classify_info.id
     *
     * @mbggenerated Thu May 28 22:57:40 CST 2015
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_source_classify_info.id
     *
     * @param id the value for movie_source_classify_info.id
     *
     * @mbggenerated Thu May 28 22:57:40 CST 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_source_classify_info.classify_id
     *
     * @return the value of movie_source_classify_info.classify_id
     *
     * @mbggenerated Thu May 28 22:57:40 CST 2015
     */
    public Integer getClassifyId() {
        return classifyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_source_classify_info.classify_id
     *
     * @param classifyId the value for movie_source_classify_info.classify_id
     *
     * @mbggenerated Thu May 28 22:57:40 CST 2015
     */
    public void setClassifyId(Integer classifyId) {
        this.classifyId = classifyId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column movie_source_classify_info.source_id
     *
     * @return the value of movie_source_classify_info.source_id
     *
     * @mbggenerated Thu May 28 22:57:40 CST 2015
     */
    public Integer getSourceId() {
        return sourceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column movie_source_classify_info.source_id
     *
     * @param sourceId the value for movie_source_classify_info.source_id
     *
     * @mbggenerated Thu May 28 22:57:40 CST 2015
     */
    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }
}