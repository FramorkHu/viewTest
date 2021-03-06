package com.work.core.model.pojo;

import java.util.ArrayList;
import java.util.List;

public class MovieSourceDetailInfoExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    public MovieSourceDetailInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathIsNull() {
            addCriterion("cover_img_path is null");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathIsNotNull() {
            addCriterion("cover_img_path is not null");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathEqualTo(String value) {
            addCriterion("cover_img_path =", value, "coverImgPath");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathNotEqualTo(String value) {
            addCriterion("cover_img_path <>", value, "coverImgPath");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathGreaterThan(String value) {
            addCriterion("cover_img_path >", value, "coverImgPath");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathGreaterThanOrEqualTo(String value) {
            addCriterion("cover_img_path >=", value, "coverImgPath");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathLessThan(String value) {
            addCriterion("cover_img_path <", value, "coverImgPath");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathLessThanOrEqualTo(String value) {
            addCriterion("cover_img_path <=", value, "coverImgPath");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathLike(String value) {
            addCriterion("cover_img_path like", value, "coverImgPath");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathNotLike(String value) {
            addCriterion("cover_img_path not like", value, "coverImgPath");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathIn(List<String> values) {
            addCriterion("cover_img_path in", values, "coverImgPath");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathNotIn(List<String> values) {
            addCriterion("cover_img_path not in", values, "coverImgPath");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathBetween(String value1, String value2) {
            addCriterion("cover_img_path between", value1, value2, "coverImgPath");
            return (Criteria) this;
        }

        public Criteria andCoverImgPathNotBetween(String value1, String value2) {
            addCriterion("cover_img_path not between", value1, value2, "coverImgPath");
            return (Criteria) this;
        }

        public Criteria andMediaPathIsNull() {
            addCriterion("media_path is null");
            return (Criteria) this;
        }

        public Criteria andMediaPathIsNotNull() {
            addCriterion("media_path is not null");
            return (Criteria) this;
        }

        public Criteria andMediaPathEqualTo(String value) {
            addCriterion("media_path =", value, "mediaPath");
            return (Criteria) this;
        }

        public Criteria andMediaPathNotEqualTo(String value) {
            addCriterion("media_path <>", value, "mediaPath");
            return (Criteria) this;
        }

        public Criteria andMediaPathGreaterThan(String value) {
            addCriterion("media_path >", value, "mediaPath");
            return (Criteria) this;
        }

        public Criteria andMediaPathGreaterThanOrEqualTo(String value) {
            addCriterion("media_path >=", value, "mediaPath");
            return (Criteria) this;
        }

        public Criteria andMediaPathLessThan(String value) {
            addCriterion("media_path <", value, "mediaPath");
            return (Criteria) this;
        }

        public Criteria andMediaPathLessThanOrEqualTo(String value) {
            addCriterion("media_path <=", value, "mediaPath");
            return (Criteria) this;
        }

        public Criteria andMediaPathLike(String value) {
            addCriterion("media_path like", value, "mediaPath");
            return (Criteria) this;
        }

        public Criteria andMediaPathNotLike(String value) {
            addCriterion("media_path not like", value, "mediaPath");
            return (Criteria) this;
        }

        public Criteria andMediaPathIn(List<String> values) {
            addCriterion("media_path in", values, "mediaPath");
            return (Criteria) this;
        }

        public Criteria andMediaPathNotIn(List<String> values) {
            addCriterion("media_path not in", values, "mediaPath");
            return (Criteria) this;
        }

        public Criteria andMediaPathBetween(String value1, String value2) {
            addCriterion("media_path between", value1, value2, "mediaPath");
            return (Criteria) this;
        }

        public Criteria andMediaPathNotBetween(String value1, String value2) {
            addCriterion("media_path not between", value1, value2, "mediaPath");
            return (Criteria) this;
        }

        public Criteria andIsMediaIsNull() {
            addCriterion("is_media is null");
            return (Criteria) this;
        }

        public Criteria andIsMediaIsNotNull() {
            addCriterion("is_media is not null");
            return (Criteria) this;
        }

        public Criteria andIsMediaEqualTo(Integer value) {
            addCriterion("is_media =", value, "isMedia");
            return (Criteria) this;
        }

        public Criteria andIsMediaNotEqualTo(Integer value) {
            addCriterion("is_media <>", value, "isMedia");
            return (Criteria) this;
        }

        public Criteria andIsMediaGreaterThan(Integer value) {
            addCriterion("is_media >", value, "isMedia");
            return (Criteria) this;
        }

        public Criteria andIsMediaGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_media >=", value, "isMedia");
            return (Criteria) this;
        }

        public Criteria andIsMediaLessThan(Integer value) {
            addCriterion("is_media <", value, "isMedia");
            return (Criteria) this;
        }

        public Criteria andIsMediaLessThanOrEqualTo(Integer value) {
            addCriterion("is_media <=", value, "isMedia");
            return (Criteria) this;
        }

        public Criteria andIsMediaIn(List<Integer> values) {
            addCriterion("is_media in", values, "isMedia");
            return (Criteria) this;
        }

        public Criteria andIsMediaNotIn(List<Integer> values) {
            addCriterion("is_media not in", values, "isMedia");
            return (Criteria) this;
        }

        public Criteria andIsMediaBetween(Integer value1, Integer value2) {
            addCriterion("is_media between", value1, value2, "isMedia");
            return (Criteria) this;
        }

        public Criteria andIsMediaNotBetween(Integer value1, Integer value2) {
            addCriterion("is_media not between", value1, value2, "isMedia");
            return (Criteria) this;
        }

        public Criteria andMovieNameIsNull() {
            addCriterion("movie_name is null");
            return (Criteria) this;
        }

        public Criteria andMovieNameIsNotNull() {
            addCriterion("movie_name is not null");
            return (Criteria) this;
        }

        public Criteria andMovieNameEqualTo(String value) {
            addCriterion("movie_name =", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameNotEqualTo(String value) {
            addCriterion("movie_name <>", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameGreaterThan(String value) {
            addCriterion("movie_name >", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameGreaterThanOrEqualTo(String value) {
            addCriterion("movie_name >=", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameLessThan(String value) {
            addCriterion("movie_name <", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameLessThanOrEqualTo(String value) {
            addCriterion("movie_name <=", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameLike(String value) {
            addCriterion("movie_name like", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameNotLike(String value) {
            addCriterion("movie_name not like", value, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameIn(List<String> values) {
            addCriterion("movie_name in", values, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameNotIn(List<String> values) {
            addCriterion("movie_name not in", values, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameBetween(String value1, String value2) {
            addCriterion("movie_name between", value1, value2, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieNameNotBetween(String value1, String value2) {
            addCriterion("movie_name not between", value1, value2, "movieName");
            return (Criteria) this;
        }

        public Criteria andMovieEnglishNameIsNull() {
            addCriterion("movie_english_name is null");
            return (Criteria) this;
        }

        public Criteria andMovieEnglishNameIsNotNull() {
            addCriterion("movie_english_name is not null");
            return (Criteria) this;
        }

        public Criteria andMovieEnglishNameEqualTo(String value) {
            addCriterion("movie_english_name =", value, "movieEnglishName");
            return (Criteria) this;
        }

        public Criteria andMovieEnglishNameNotEqualTo(String value) {
            addCriterion("movie_english_name <>", value, "movieEnglishName");
            return (Criteria) this;
        }

        public Criteria andMovieEnglishNameGreaterThan(String value) {
            addCriterion("movie_english_name >", value, "movieEnglishName");
            return (Criteria) this;
        }

        public Criteria andMovieEnglishNameGreaterThanOrEqualTo(String value) {
            addCriterion("movie_english_name >=", value, "movieEnglishName");
            return (Criteria) this;
        }

        public Criteria andMovieEnglishNameLessThan(String value) {
            addCriterion("movie_english_name <", value, "movieEnglishName");
            return (Criteria) this;
        }

        public Criteria andMovieEnglishNameLessThanOrEqualTo(String value) {
            addCriterion("movie_english_name <=", value, "movieEnglishName");
            return (Criteria) this;
        }

        public Criteria andMovieEnglishNameLike(String value) {
            addCriterion("movie_english_name like", value, "movieEnglishName");
            return (Criteria) this;
        }

        public Criteria andMovieEnglishNameNotLike(String value) {
            addCriterion("movie_english_name not like", value, "movieEnglishName");
            return (Criteria) this;
        }

        public Criteria andMovieEnglishNameIn(List<String> values) {
            addCriterion("movie_english_name in", values, "movieEnglishName");
            return (Criteria) this;
        }

        public Criteria andMovieEnglishNameNotIn(List<String> values) {
            addCriterion("movie_english_name not in", values, "movieEnglishName");
            return (Criteria) this;
        }

        public Criteria andMovieEnglishNameBetween(String value1, String value2) {
            addCriterion("movie_english_name between", value1, value2, "movieEnglishName");
            return (Criteria) this;
        }

        public Criteria andMovieEnglishNameNotBetween(String value1, String value2) {
            addCriterion("movie_english_name not between", value1, value2, "movieEnglishName");
            return (Criteria) this;
        }

        public Criteria andMovieTimeIsNull() {
            addCriterion("movie_time is null");
            return (Criteria) this;
        }

        public Criteria andMovieTimeIsNotNull() {
            addCriterion("movie_time is not null");
            return (Criteria) this;
        }

        public Criteria andMovieTimeEqualTo(Integer value) {
            addCriterion("movie_time =", value, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeNotEqualTo(Integer value) {
            addCriterion("movie_time <>", value, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeGreaterThan(Integer value) {
            addCriterion("movie_time >", value, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("movie_time >=", value, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeLessThan(Integer value) {
            addCriterion("movie_time <", value, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeLessThanOrEqualTo(Integer value) {
            addCriterion("movie_time <=", value, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeIn(List<Integer> values) {
            addCriterion("movie_time in", values, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeNotIn(List<Integer> values) {
            addCriterion("movie_time not in", values, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeBetween(Integer value1, Integer value2) {
            addCriterion("movie_time between", value1, value2, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieTimeNotBetween(Integer value1, Integer value2) {
            addCriterion("movie_time not between", value1, value2, "movieTime");
            return (Criteria) this;
        }

        public Criteria andMovieProduceYearIsNull() {
            addCriterion("movie_produce_year is null");
            return (Criteria) this;
        }

        public Criteria andMovieProduceYearIsNotNull() {
            addCriterion("movie_produce_year is not null");
            return (Criteria) this;
        }

        public Criteria andMovieProduceYearEqualTo(Integer value) {
            addCriterion("movie_produce_year =", value, "movieProduceYear");
            return (Criteria) this;
        }

        public Criteria andMovieProduceYearNotEqualTo(Integer value) {
            addCriterion("movie_produce_year <>", value, "movieProduceYear");
            return (Criteria) this;
        }

        public Criteria andMovieProduceYearGreaterThan(Integer value) {
            addCriterion("movie_produce_year >", value, "movieProduceYear");
            return (Criteria) this;
        }

        public Criteria andMovieProduceYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("movie_produce_year >=", value, "movieProduceYear");
            return (Criteria) this;
        }

        public Criteria andMovieProduceYearLessThan(Integer value) {
            addCriterion("movie_produce_year <", value, "movieProduceYear");
            return (Criteria) this;
        }

        public Criteria andMovieProduceYearLessThanOrEqualTo(Integer value) {
            addCriterion("movie_produce_year <=", value, "movieProduceYear");
            return (Criteria) this;
        }

        public Criteria andMovieProduceYearIn(List<Integer> values) {
            addCriterion("movie_produce_year in", values, "movieProduceYear");
            return (Criteria) this;
        }

        public Criteria andMovieProduceYearNotIn(List<Integer> values) {
            addCriterion("movie_produce_year not in", values, "movieProduceYear");
            return (Criteria) this;
        }

        public Criteria andMovieProduceYearBetween(Integer value1, Integer value2) {
            addCriterion("movie_produce_year between", value1, value2, "movieProduceYear");
            return (Criteria) this;
        }

        public Criteria andMovieProduceYearNotBetween(Integer value1, Integer value2) {
            addCriterion("movie_produce_year not between", value1, value2, "movieProduceYear");
            return (Criteria) this;
        }

        public Criteria andMovieAttributeIsNull() {
            addCriterion("movie_attribute is null");
            return (Criteria) this;
        }

        public Criteria andMovieAttributeIsNotNull() {
            addCriterion("movie_attribute is not null");
            return (Criteria) this;
        }

        public Criteria andMovieAttributeEqualTo(Integer value) {
            addCriterion("movie_attribute =", value, "movieAttribute");
            return (Criteria) this;
        }

        public Criteria andMovieAttributeNotEqualTo(Integer value) {
            addCriterion("movie_attribute <>", value, "movieAttribute");
            return (Criteria) this;
        }

        public Criteria andMovieAttributeGreaterThan(Integer value) {
            addCriterion("movie_attribute >", value, "movieAttribute");
            return (Criteria) this;
        }

        public Criteria andMovieAttributeGreaterThanOrEqualTo(Integer value) {
            addCriterion("movie_attribute >=", value, "movieAttribute");
            return (Criteria) this;
        }

        public Criteria andMovieAttributeLessThan(Integer value) {
            addCriterion("movie_attribute <", value, "movieAttribute");
            return (Criteria) this;
        }

        public Criteria andMovieAttributeLessThanOrEqualTo(Integer value) {
            addCriterion("movie_attribute <=", value, "movieAttribute");
            return (Criteria) this;
        }

        public Criteria andMovieAttributeIn(List<Integer> values) {
            addCriterion("movie_attribute in", values, "movieAttribute");
            return (Criteria) this;
        }

        public Criteria andMovieAttributeNotIn(List<Integer> values) {
            addCriterion("movie_attribute not in", values, "movieAttribute");
            return (Criteria) this;
        }

        public Criteria andMovieAttributeBetween(Integer value1, Integer value2) {
            addCriterion("movie_attribute between", value1, value2, "movieAttribute");
            return (Criteria) this;
        }

        public Criteria andMovieAttributeNotBetween(Integer value1, Integer value2) {
            addCriterion("movie_attribute not between", value1, value2, "movieAttribute");
            return (Criteria) this;
        }

        public Criteria andMovieActorIsNull() {
            addCriterion("movie_actor is null");
            return (Criteria) this;
        }

        public Criteria andMovieActorIsNotNull() {
            addCriterion("movie_actor is not null");
            return (Criteria) this;
        }

        public Criteria andMovieActorEqualTo(String value) {
            addCriterion("movie_actor =", value, "movieActor");
            return (Criteria) this;
        }

        public Criteria andMovieActorNotEqualTo(String value) {
            addCriterion("movie_actor <>", value, "movieActor");
            return (Criteria) this;
        }

        public Criteria andMovieActorGreaterThan(String value) {
            addCriterion("movie_actor >", value, "movieActor");
            return (Criteria) this;
        }

        public Criteria andMovieActorGreaterThanOrEqualTo(String value) {
            addCriterion("movie_actor >=", value, "movieActor");
            return (Criteria) this;
        }

        public Criteria andMovieActorLessThan(String value) {
            addCriterion("movie_actor <", value, "movieActor");
            return (Criteria) this;
        }

        public Criteria andMovieActorLessThanOrEqualTo(String value) {
            addCriterion("movie_actor <=", value, "movieActor");
            return (Criteria) this;
        }

        public Criteria andMovieActorLike(String value) {
            addCriterion("movie_actor like", value, "movieActor");
            return (Criteria) this;
        }

        public Criteria andMovieActorNotLike(String value) {
            addCriterion("movie_actor not like", value, "movieActor");
            return (Criteria) this;
        }

        public Criteria andMovieActorIn(List<String> values) {
            addCriterion("movie_actor in", values, "movieActor");
            return (Criteria) this;
        }

        public Criteria andMovieActorNotIn(List<String> values) {
            addCriterion("movie_actor not in", values, "movieActor");
            return (Criteria) this;
        }

        public Criteria andMovieActorBetween(String value1, String value2) {
            addCriterion("movie_actor between", value1, value2, "movieActor");
            return (Criteria) this;
        }

        public Criteria andMovieActorNotBetween(String value1, String value2) {
            addCriterion("movie_actor not between", value1, value2, "movieActor");
            return (Criteria) this;
        }

        public Criteria andMovieDirectIsNull() {
            addCriterion("movie_direct is null");
            return (Criteria) this;
        }

        public Criteria andMovieDirectIsNotNull() {
            addCriterion("movie_direct is not null");
            return (Criteria) this;
        }

        public Criteria andMovieDirectEqualTo(String value) {
            addCriterion("movie_direct =", value, "movieDirect");
            return (Criteria) this;
        }

        public Criteria andMovieDirectNotEqualTo(String value) {
            addCriterion("movie_direct <>", value, "movieDirect");
            return (Criteria) this;
        }

        public Criteria andMovieDirectGreaterThan(String value) {
            addCriterion("movie_direct >", value, "movieDirect");
            return (Criteria) this;
        }

        public Criteria andMovieDirectGreaterThanOrEqualTo(String value) {
            addCriterion("movie_direct >=", value, "movieDirect");
            return (Criteria) this;
        }

        public Criteria andMovieDirectLessThan(String value) {
            addCriterion("movie_direct <", value, "movieDirect");
            return (Criteria) this;
        }

        public Criteria andMovieDirectLessThanOrEqualTo(String value) {
            addCriterion("movie_direct <=", value, "movieDirect");
            return (Criteria) this;
        }

        public Criteria andMovieDirectLike(String value) {
            addCriterion("movie_direct like", value, "movieDirect");
            return (Criteria) this;
        }

        public Criteria andMovieDirectNotLike(String value) {
            addCriterion("movie_direct not like", value, "movieDirect");
            return (Criteria) this;
        }

        public Criteria andMovieDirectIn(List<String> values) {
            addCriterion("movie_direct in", values, "movieDirect");
            return (Criteria) this;
        }

        public Criteria andMovieDirectNotIn(List<String> values) {
            addCriterion("movie_direct not in", values, "movieDirect");
            return (Criteria) this;
        }

        public Criteria andMovieDirectBetween(String value1, String value2) {
            addCriterion("movie_direct between", value1, value2, "movieDirect");
            return (Criteria) this;
        }

        public Criteria andMovieDirectNotBetween(String value1, String value2) {
            addCriterion("movie_direct not between", value1, value2, "movieDirect");
            return (Criteria) this;
        }

        public Criteria andMovieCountryIsNull() {
            addCriterion("movie_country is null");
            return (Criteria) this;
        }

        public Criteria andMovieCountryIsNotNull() {
            addCriterion("movie_country is not null");
            return (Criteria) this;
        }

        public Criteria andMovieCountryEqualTo(String value) {
            addCriterion("movie_country =", value, "movieCountry");
            return (Criteria) this;
        }

        public Criteria andMovieCountryNotEqualTo(String value) {
            addCriterion("movie_country <>", value, "movieCountry");
            return (Criteria) this;
        }

        public Criteria andMovieCountryGreaterThan(String value) {
            addCriterion("movie_country >", value, "movieCountry");
            return (Criteria) this;
        }

        public Criteria andMovieCountryGreaterThanOrEqualTo(String value) {
            addCriterion("movie_country >=", value, "movieCountry");
            return (Criteria) this;
        }

        public Criteria andMovieCountryLessThan(String value) {
            addCriterion("movie_country <", value, "movieCountry");
            return (Criteria) this;
        }

        public Criteria andMovieCountryLessThanOrEqualTo(String value) {
            addCriterion("movie_country <=", value, "movieCountry");
            return (Criteria) this;
        }

        public Criteria andMovieCountryLike(String value) {
            addCriterion("movie_country like", value, "movieCountry");
            return (Criteria) this;
        }

        public Criteria andMovieCountryNotLike(String value) {
            addCriterion("movie_country not like", value, "movieCountry");
            return (Criteria) this;
        }

        public Criteria andMovieCountryIn(List<String> values) {
            addCriterion("movie_country in", values, "movieCountry");
            return (Criteria) this;
        }

        public Criteria andMovieCountryNotIn(List<String> values) {
            addCriterion("movie_country not in", values, "movieCountry");
            return (Criteria) this;
        }

        public Criteria andMovieCountryBetween(String value1, String value2) {
            addCriterion("movie_country between", value1, value2, "movieCountry");
            return (Criteria) this;
        }

        public Criteria andMovieCountryNotBetween(String value1, String value2) {
            addCriterion("movie_country not between", value1, value2, "movieCountry");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated do_not_delete_during_merge Sun Jun 07 22:02:19 CST 2015
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}