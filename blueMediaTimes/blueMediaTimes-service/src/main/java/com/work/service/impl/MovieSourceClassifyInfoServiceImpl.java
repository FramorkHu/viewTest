package com.work.service.impl;

import com.work.core.model.dao.MovieSourceClassifyInfoDao;
import com.work.core.model.pojo.MovieSourceClassifyInfo;
import com.work.service.MovieSourceClassifyInfoService;

/**
 * Created by huyan on 15/5/28.
 */
public class MovieSourceClassifyInfoServiceImpl implements MovieSourceClassifyInfoService {

    private MovieSourceClassifyInfoDao movieSourceClassifyInfoDao;

    public void setMovieSourceClassifyInfoDao(MovieSourceClassifyInfoDao movieSourceClassifyInfoDao) {
        this.movieSourceClassifyInfoDao = movieSourceClassifyInfoDao;
    }

    @Override
    public int insertMovieSourceClassifyInfo(MovieSourceClassifyInfo movieSourceClassifyInfo) {
        return movieSourceClassifyInfoDao.insertMovieSourceClassifyInfo(movieSourceClassifyInfo);
    }

    @Override
    public int deleteMovieSourceClassifyInfo(int sourceId) {
        return movieSourceClassifyInfoDao.deleteMovieSourceClassifyInfo(sourceId);
    }
}
