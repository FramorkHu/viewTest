package com.work.service.impl;

import com.work.core.model.dao.MovieImgInfoDao;
import com.work.core.model.pojo.MovieImgInfo;
import com.work.service.MovieImgInfoService;

/**
 * Created by huyan on 15/5/16.
 */
public class MovieImgInfoServiceImpl implements MovieImgInfoService {

    private MovieImgInfoDao movieImgInfoDao;

    public void setMovieImgInfoDao(MovieImgInfoDao movieImgInfoDao) {
        this.movieImgInfoDao = movieImgInfoDao;
    }

    @Override
    public int insertMovieImgInfo(MovieImgInfo movieImgInfo) {
        return movieImgInfoDao.insertMovieImgInfo(movieImgInfo);
    }

    @Override
    public int deleteMovieImgInfo(int sourceId) {
        return movieImgInfoDao.deleteMovieImgInfo(sourceId);
    }
}
