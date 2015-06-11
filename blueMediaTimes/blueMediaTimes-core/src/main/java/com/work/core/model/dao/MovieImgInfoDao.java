package com.work.core.model.dao;

import com.work.core.model.pojo.MovieImgInfo;

/**
 * Created by huyan on 15/5/16.
 */
public interface MovieImgInfoDao {

    public int insertMovieImgInfo(MovieImgInfo movieImgInfo);

    public int deleteMovieImgInfo(int sourceId);
}
