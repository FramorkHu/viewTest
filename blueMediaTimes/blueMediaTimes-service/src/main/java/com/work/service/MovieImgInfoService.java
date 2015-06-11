package com.work.service;

import com.work.core.model.pojo.MovieImgInfo;

/**
 * Created by huyan on 15/5/16.
 */
public interface MovieImgInfoService {

    public int insertMovieImgInfo(MovieImgInfo movieImgInfo);

    public int deleteMovieImgInfo(int sourceId);

}
