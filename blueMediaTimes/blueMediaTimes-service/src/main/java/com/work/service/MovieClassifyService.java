package com.work.service;

import com.work.core.model.pojo.MovieClassify;

import java.util.List;

/**
 * Created by huyan on 15/5/16.
 */
public interface MovieClassifyService {

    public List<MovieClassify> getMovieClassify(Integer start, Integer pageSize);

    public MovieClassify getMovieClassifyById(int id);

    public int countMovieClassify();

    public int insertMovieClassify(MovieClassify movieClassify);

    public int delMovieClassify(int id);

    public int updateMovieClassify(MovieClassify movieClassify);
}
