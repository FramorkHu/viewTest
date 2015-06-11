package com.work.service.impl;

import com.work.core.model.dao.MovieClassifyDao;
import com.work.core.model.pojo.MovieClassify;
import com.work.service.MovieClassifyService;

import java.util.List;

/**
 * Created by huyan on 15/5/16.
 */
public class MovieClassifyServiceImpl implements MovieClassifyService {

    private MovieClassifyDao movieClassifyDao;

    public void setMovieClassifyDao(MovieClassifyDao movieClassifyDao) {
        this.movieClassifyDao = movieClassifyDao;
    }

    @Override
    public List<MovieClassify> getMovieClassify(Integer start, Integer pageSize) {
        return movieClassifyDao.getMovieClassify(start, pageSize);
    }

    @Override
    public MovieClassify getMovieClassifyById(int id) {
        return movieClassifyDao.getMovieClassifyById(id);
    }

    @Override
    public int countMovieClassify() {
        return movieClassifyDao.countMovieClassify();
    }

    @Override
    public int insertMovieClassify(MovieClassify movieClassify) {
        return movieClassifyDao.insertMovieClassify(movieClassify);
    }

    @Override
    public int delMovieClassify(int id) {
        return movieClassifyDao.delMovieClassify(id);
    }

    @Override
    public int updateMovieClassify(MovieClassify movieClassify) {
        return movieClassifyDao.updateMovieClassify(movieClassify);
    }
}
