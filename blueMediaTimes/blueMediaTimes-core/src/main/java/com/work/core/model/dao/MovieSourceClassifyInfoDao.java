package com.work.core.model.dao;

import com.work.core.model.pojo.MovieSourceClassifyInfo;

/**
 * Created by huyan on 15/5/28.
 */
public interface MovieSourceClassifyInfoDao {

    public int insertMovieSourceClassifyInfo(MovieSourceClassifyInfo movieSourceClassifyInfo);

    public int deleteMovieSourceClassifyInfo(int sourceId);
}
