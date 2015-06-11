package com.work.core.model.dao.impl;

import com.work.core.model.dao.MovieClassifyDao;
import com.work.core.model.mapper.MovieClassifyMapper;
import com.work.core.model.pojo.MovieClassify;
import com.work.core.model.pojo.MovieClassifyExample;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by huyan on 15/5/16.
 */
public class MovieClassifyDaoImpl extends SqlSessionDaoSupport implements MovieClassifyDao {

    @Autowired
    MovieClassifyMapper mapper;

    @Override
    public List<MovieClassify> getMovieClassify(Integer start, Integer pageSize) {
        MovieClassifyExample example = new MovieClassifyExample();

        String limitStr = "";
        if ( start != null && pageSize!= null){
            limitStr = " limit "+start+","+pageSize;
        }
        example.setOrderByClause(" id "+limitStr);
        return mapper.selectByExample(example);
    }

    @Override
    public MovieClassify getMovieClassifyById(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int countMovieClassify() {
        MovieClassifyExample example = new MovieClassifyExample();
        return mapper.countByExample(example);
    }

    @Override
    public int insertMovieClassify(MovieClassify movieClassify) {
        return mapper.insert(movieClassify);
    }

    @Override
    public int delMovieClassify(int id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateMovieClassify(MovieClassify movieClassify) {
        return mapper.updateByPrimaryKey(movieClassify);
    }
}
