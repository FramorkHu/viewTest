package com.work.core.model.dao.impl;

import com.work.core.model.dao.MovieSourceClassifyInfoDao;
import com.work.core.model.mapper.MovieSourceClassifyInfoMapper;
import com.work.core.model.pojo.MovieSourceClassifyInfo;
import com.work.core.model.pojo.MovieSourceClassifyInfoExample;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by huyan on 15/5/28.
 */
public class MovieSourceClassifyInfoDaoImpl extends SqlSessionDaoSupport implements MovieSourceClassifyInfoDao {

    @Autowired
    MovieSourceClassifyInfoMapper mapper;

    @Override
    public int insertMovieSourceClassifyInfo(MovieSourceClassifyInfo movieSourceClassifyInfo) {
        return mapper.insert(movieSourceClassifyInfo);
    }

    @Override
    public int deleteMovieSourceClassifyInfo(int sourceId) {
        MovieSourceClassifyInfoExample example = new MovieSourceClassifyInfoExample();
        MovieSourceClassifyInfoExample.Criteria criteria = example.createCriteria();
        criteria.andSourceIdEqualTo(sourceId);
        return mapper.deleteByExample(example);
    }
}
