package com.work.core.model.dao.impl;

import com.work.core.model.dao.MovieImgInfoDao;
import com.work.core.model.mapper.MovieImgInfoMapper;
import com.work.core.model.pojo.MovieImgInfo;
import com.work.core.model.pojo.MovieImgInfoExample;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by huyan on 15/5/16.
 */
public class MovieImgInfoDaoImpl extends SqlSessionDaoSupport implements MovieImgInfoDao {

    @Autowired
    MovieImgInfoMapper mapper;

    @Override
    public int insertMovieImgInfo(MovieImgInfo movieImgInfo) {
        return mapper.insert(movieImgInfo);
    }

    @Override
    public int deleteMovieImgInfo(int sourceId) {
        MovieImgInfoExample example = new MovieImgInfoExample();

        MovieImgInfoExample.Criteria criteria = example.createCriteria();
        criteria.andSourceIdEqualTo(sourceId);

        return mapper.deleteByExample(example);
    }
}
