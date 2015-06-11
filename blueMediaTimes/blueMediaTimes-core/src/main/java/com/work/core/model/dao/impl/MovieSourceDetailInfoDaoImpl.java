package com.work.core.model.dao.impl;

import com.util.StringUtils;
import com.work.core.model.bvo.MovieSourceBaseDataBvo;
import com.work.core.model.bvo.MovieSourceDetailBvo;
import com.work.core.model.dao.MovieSourceDetailInfoDao;
import com.work.core.model.mapper.MovieSourceDetailInfoMapper;
import com.work.core.model.pojo.MovieSourceDetailInfo;
import com.work.core.model.pojo.MovieSourceDetailInfoExample;
import com.work.core.model.pojo.MovieSourceDetailInfoWithBLOBs;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huyan on 15/5/11.
 */
public class MovieSourceDetailInfoDaoImpl extends SqlSessionDaoSupport implements MovieSourceDetailInfoDao {

    @Autowired
    MovieSourceDetailInfoMapper mapper;

    @Override
    public List<String> getProductYearMovieSource() {
        List<String> productYear = new ArrayList<String>();
        List<Map<String,Object>> results =
                getSqlSession().selectList("com.work.core.model.dao.impl.MovieSourceDetailInfoDaoImpl.getMovieSourceProductYear");
        for (Map<String, Object> result : results){
            if (result != null){
                String year = StringUtils.valueOf(result.get("movieProduceYear"));
                productYear.add(year);
            }

        }
        return productYear;
    }

    @Override
    public List<MovieSourceBaseDataBvo> getMovieSourceByCondition(Integer year, Integer classifyId, Integer attribute,
                                                                  Integer start, Integer rows) {
        Map<String, Object> parm = new HashMap<String, Object>();
        String sourceIds = null;
        parm.put("year", year);
        parm.put("attribute", attribute);
        parm.put("start", start);
        parm.put("rows", rows);
        List<String> sourceIdList = new ArrayList<String>();
        if (classifyId != null){
            List<String> tmpSourceIdList =
                    getSqlSession().selectList("com.work.core.model.dao.impl.MovieSourceDetailInfoDaoImpl.getMovieSourcesByClassify", classifyId);
            sourceIdList.addAll(tmpSourceIdList);
            if ( !sourceIdList.isEmpty()){
                sourceIds = StringUtils.parseListToString(sourceIdList);
            } else {
                sourceIds = "-1";
            }
        }
        parm.put("sourceIds", sourceIds);

        return getSqlSession().selectList("com.work.core.model.dao.impl.MovieSourceDetailInfoDaoImpl.getMovieSourceByCondition",parm);
    }

    @Override
    public int countMovieSourceByCondition(Integer year, Integer classifyId, Integer attribute) {
        Map<String, Object> parm = new HashMap<String, Object>();
        String sourceIds = null;
        parm.put("year", year);
        parm.put("attribute", attribute);
        List<String> sourceIdList = new ArrayList<String>();
        if (classifyId != null){
            List<String> tmpSourceIdList =
                    getSqlSession().selectList("com.work.core.model.dao.impl.MovieSourceDetailInfoDaoImpl.getMovieSourcesByClassify", classifyId);
            sourceIdList.addAll(tmpSourceIdList);
            if ( !sourceIdList.isEmpty()){
                sourceIds = StringUtils.parseListToString(sourceIdList);
            } else {
                sourceIds = "-1";
            }
        }
        parm.put("sourceIds", sourceIds);
        return getSqlSession().selectOne("com.work.core.model.dao.impl.MovieSourceDetailInfoDaoImpl.countMovieSourceByCondition", parm);
    }




    @Override
    public int insertMovieSourceDetailInfo(MovieSourceDetailInfoWithBLOBs detailInfo) {

        return mapper.insert(detailInfo);

    }

    @Override
    public List<MovieSourceDetailInfoWithBLOBs> getMovieSourceDetailInfo(String movieName, Integer startPage, Integer pageSize) {
        MovieSourceDetailInfoExample example = new MovieSourceDetailInfoExample();
        MovieSourceDetailInfoExample.Criteria criteria = example.createCriteria();
        if (movieName!=null){
            criteria.andMovieNameLike("%"+movieName+"%");
        }
        String limitStr = "";
        if ( startPage != null && pageSize!= null){
            limitStr = " limit "+startPage+","+pageSize;
        }
        example.setOrderByClause(" id "+limitStr);
        return mapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public List<MovieSourceBaseDataBvo> getMovieSourceBaseDataByName(String movieName) {
        Map<String, Object> parm = new HashMap<String, Object>();
        parm.put("movieName", movieName);
        return getSqlSession().selectList("com.work.core.model.dao.impl.MovieSourceDetailInfoDaoImpl.getMovieSourceBaseDataByName", parm);

    }

    @Override
    public int countMovieSourceDetailInfo(String movieName) {
        MovieSourceDetailInfoExample example = new MovieSourceDetailInfoExample();
        MovieSourceDetailInfoExample.Criteria criteria = example.createCriteria();
        if (movieName!=null){
            criteria.andMovieNameLike("%"+movieName+"%");
        }
        return mapper.countByExample(example);
    }

    @Override
    public MovieSourceDetailInfoWithBLOBs getMovieSourceDetailById(Integer sourceId) {
        return mapper.selectByPrimaryKey(sourceId);
    }

    @Override
    public List<String> getMovieSourceClassifyList(Integer sourceId) {
        List<String> result = new ArrayList<String>();
        List<String> tmpList = getSqlSession().selectList("com.work.core.model.dao.impl.MovieSourceDetailInfoDaoImpl.getMovieSourcesClassifyList", sourceId);
        result.addAll(tmpList);
        return result;
    }


    @Override
    public List<String> getMovieSourceImgPaths(Integer sourceId) {
        List<String> imgPaths = new ArrayList<String>();

        Map<String, Object> parm = new HashMap<String, Object>();
        parm.put("sourceId", sourceId);
        List<Map<String, String>> results =
                getSqlSession().selectList("com.work.core.model.dao.impl.MovieSourceDetailInfoDaoImpl.getSourceImgPath", parm);
        if (results != null && !results.isEmpty()){
            String imgPath;
            for (Map<String, String> result : results){
                imgPath = result.get("img_path");
                imgPaths.add(imgPath);
            }
        }
        return imgPaths;
    }

    @Override
    public int updateMovieSourceDetailInfo(MovieSourceDetailInfoWithBLOBs infoWithBLOBs) {
        return mapper.updateByPrimaryKeyWithBLOBs(infoWithBLOBs);
    }

    @Override
    public int deleteMovieSourceDetailInfo(Integer sourceId) {
        return mapper.deleteByPrimaryKey(sourceId);
    }
}
