package com.work.core.model.mapper;

import com.work.core.model.pojo.MovieSourceDetailInfo;
import com.work.core.model.pojo.MovieSourceDetailInfoExample;
import com.work.core.model.pojo.MovieSourceDetailInfoWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface MovieSourceDetailInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    int countByExample(MovieSourceDetailInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    int deleteByExample(MovieSourceDetailInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    @Delete({
        "delete from movie_source_detail_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    @Insert({
        "insert into movie_source_detail_info (cover_img_path, media_path, ",
        "is_media, movie_name, ",
        "movie_english_name, movie_time, ",
        "movie_produce_year, movie_attribute, ",
        "movie_actor, movie_direct, ",
        "movie_country, movie_describe, ",
        "media_url, ext)",
        "values (#{coverImgPath,jdbcType=VARCHAR}, #{mediaPath,jdbcType=VARCHAR}, ",
        "#{isMedia,jdbcType=INTEGER}, #{movieName,jdbcType=VARCHAR}, ",
        "#{movieEnglishName,jdbcType=VARCHAR}, #{movieTime,jdbcType=INTEGER}, ",
        "#{movieProduceYear,jdbcType=INTEGER}, #{movieAttribute,jdbcType=INTEGER}, ",
        "#{movieActor,jdbcType=VARCHAR}, #{movieDirect,jdbcType=VARCHAR}, ",
        "#{movieCountry,jdbcType=VARCHAR}, #{movieDescribe,jdbcType=LONGVARCHAR}, ",
        "#{mediaUrl,jdbcType=LONGVARCHAR}, #{ext,jdbcType=LONGVARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(MovieSourceDetailInfoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    int insertSelective(MovieSourceDetailInfoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    List<MovieSourceDetailInfoWithBLOBs> selectByExampleWithBLOBs(MovieSourceDetailInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    List<MovieSourceDetailInfo> selectByExample(MovieSourceDetailInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    @Select({
        "select",
        "id, cover_img_path, media_path, is_media, movie_name, movie_english_name, movie_time, ",
        "movie_produce_year, movie_attribute, movie_actor, movie_direct, movie_country, ",
        "movie_describe, media_url, ext",
        "from movie_source_detail_info",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("ResultMapWithBLOBs")
    MovieSourceDetailInfoWithBLOBs selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    int updateByExampleSelective(@Param("record") MovieSourceDetailInfoWithBLOBs record, @Param("example") MovieSourceDetailInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    int updateByExampleWithBLOBs(@Param("record") MovieSourceDetailInfoWithBLOBs record, @Param("example") MovieSourceDetailInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    int updateByExample(@Param("record") MovieSourceDetailInfo record, @Param("example") MovieSourceDetailInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    int updateByPrimaryKeySelective(MovieSourceDetailInfoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    @Update({
        "update movie_source_detail_info",
        "set cover_img_path = #{coverImgPath,jdbcType=VARCHAR},",
          "media_path = #{mediaPath,jdbcType=VARCHAR},",
          "is_media = #{isMedia,jdbcType=INTEGER},",
          "movie_name = #{movieName,jdbcType=VARCHAR},",
          "movie_english_name = #{movieEnglishName,jdbcType=VARCHAR},",
          "movie_time = #{movieTime,jdbcType=INTEGER},",
          "movie_produce_year = #{movieProduceYear,jdbcType=INTEGER},",
          "movie_attribute = #{movieAttribute,jdbcType=INTEGER},",
          "movie_actor = #{movieActor,jdbcType=VARCHAR},",
          "movie_direct = #{movieDirect,jdbcType=VARCHAR},",
          "movie_country = #{movieCountry,jdbcType=VARCHAR},",
          "movie_describe = #{movieDescribe,jdbcType=LONGVARCHAR},",
          "media_url = #{mediaUrl,jdbcType=LONGVARCHAR},",
          "ext = #{ext,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(MovieSourceDetailInfoWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table movie_source_detail_info
     *
     * @mbggenerated Sun Jun 07 22:02:19 CST 2015
     */
    @Update({
        "update movie_source_detail_info",
        "set cover_img_path = #{coverImgPath,jdbcType=VARCHAR},",
          "media_path = #{mediaPath,jdbcType=VARCHAR},",
          "is_media = #{isMedia,jdbcType=INTEGER},",
          "movie_name = #{movieName,jdbcType=VARCHAR},",
          "movie_english_name = #{movieEnglishName,jdbcType=VARCHAR},",
          "movie_time = #{movieTime,jdbcType=INTEGER},",
          "movie_produce_year = #{movieProduceYear,jdbcType=INTEGER},",
          "movie_attribute = #{movieAttribute,jdbcType=INTEGER},",
          "movie_actor = #{movieActor,jdbcType=VARCHAR},",
          "movie_direct = #{movieDirect,jdbcType=VARCHAR},",
          "movie_country = #{movieCountry,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MovieSourceDetailInfo record);
}