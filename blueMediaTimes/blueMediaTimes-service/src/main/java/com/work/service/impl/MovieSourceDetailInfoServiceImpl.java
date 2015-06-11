package com.work.service.impl;

import com.util.StringUtils;
import com.work.core.model.bvo.MovieSourceBaseDataBvo;
import com.work.core.model.bvo.MovieSourceDetailBvo;
import com.work.core.model.dao.MovieSourceDetailInfoDao;
import com.work.core.model.pojo.MovieSourceDetailInfo;
import com.work.core.model.pojo.MovieSourceDetailInfoWithBLOBs;
import com.work.service.MovieSourceDetailInfoService;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huyan on 15/5/11.
 */
public class MovieSourceDetailInfoServiceImpl implements MovieSourceDetailInfoService {

    private static final Logger LOGGER = LoggerFactory.getLogger( MovieSourceDetailInfoServiceImpl.class);

    private MovieSourceDetailInfoDao movieSourceDetailInfoDao;

    public void setMovieSourceDetailInfoDao(MovieSourceDetailInfoDao movieSourceDetailInfoDao) {
        this.movieSourceDetailInfoDao = movieSourceDetailInfoDao;
    }

    @Override
    public List<String> getProductYearMovieSource() {
        return movieSourceDetailInfoDao.getProductYearMovieSource();
    }

    @Override
    public List<MovieSourceBaseDataBvo> getMovieSourceByCondition(Integer year, Integer classifyId, Integer attribute, Integer start, Integer rows) {
        return movieSourceDetailInfoDao.getMovieSourceByCondition(year, classifyId,attribute, start, rows);
    }

    @Override
    public int countMovieSourceByCondition(Integer year, Integer classifyId, Integer attribute) {
        return movieSourceDetailInfoDao.countMovieSourceByCondition(year, classifyId, attribute);
    }

    @Override
    public int insertMovieSourceDetailInfo(MovieSourceDetailInfoWithBLOBs detailInfo) {
        return movieSourceDetailInfoDao.insertMovieSourceDetailInfo(detailInfo);
    }

    @Override
    public List<MovieSourceDetailInfoWithBLOBs> getMovieSourceDetailInfo(String movieName, Integer startPage, Integer pageSize) {
        List<MovieSourceDetailInfoWithBLOBs> sourceDetailInfos = new ArrayList<MovieSourceDetailInfoWithBLOBs>();

        sourceDetailInfos.addAll(movieSourceDetailInfoDao.getMovieSourceDetailInfo(movieName, startPage, pageSize));
        return sourceDetailInfos;
    }

    @Override
    public List<MovieSourceBaseDataBvo> getMovieSourceBaseDataByName(String movieName) {

        List<MovieSourceBaseDataBvo> baseDataBvos = new ArrayList<MovieSourceBaseDataBvo>();
        baseDataBvos.addAll(movieSourceDetailInfoDao.getMovieSourceBaseDataByName(movieName));
        return baseDataBvos;
    }

    @Override
    public int countMovieSourceDetailInfo(String movieName) {
        return movieSourceDetailInfoDao.countMovieSourceDetailInfo(movieName);
    }

    @Override
    public MovieSourceDetailBvo getMovieSourceDetailBvo(Integer sourceId) {
        MovieSourceDetailInfoWithBLOBs detailInfoWithBLOBs =
                movieSourceDetailInfoDao.getMovieSourceDetailById(sourceId);
        if (detailInfoWithBLOBs == null){
            return null;
        }
        MovieSourceDetailBvo detailBvo = new MovieSourceDetailBvo();
        List<String> imgPaths = movieSourceDetailInfoDao.getMovieSourceImgPaths(sourceId);
        List<String> classifyNameList = movieSourceDetailInfoDao.getMovieSourceClassifyList(sourceId);
        String classifyName = StringUtils.parseListToString(classifyNameList);
        try {
            BeanUtils.copyProperties(detailBvo, detailInfoWithBLOBs);
            detailBvo.setImgPaths(imgPaths);
            detailBvo.setMovieClassifyName(classifyName);
        } catch (Exception e){
            LOGGER.error("MovieSourceDetailBvo copyProperties is error", e);
        }


        return detailBvo;
    }

    @Override
    public int updateMovieSourceDetailInfo(MovieSourceDetailInfoWithBLOBs infoWithBLOBs) {
        return movieSourceDetailInfoDao.updateMovieSourceDetailInfo(infoWithBLOBs);
    }

    @Override
    public int deleteMovieSourceDetail(Integer sourceId) {
        return movieSourceDetailInfoDao.deleteMovieSourceDetailInfo(sourceId);
    }
}
