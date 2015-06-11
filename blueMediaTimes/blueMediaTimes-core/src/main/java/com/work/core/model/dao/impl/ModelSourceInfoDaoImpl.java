package com.work.core.model.dao.impl;

import com.work.core.model.dao.ModelSourceInfoDao;
import com.work.core.model.mapper.ModelSourceInfoMapper;
import com.work.core.model.pojo.ModelSourceInfo;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by huyan on 15/5/13.
 */
public class ModelSourceInfoDaoImpl extends SqlSessionDaoSupport implements ModelSourceInfoDao {

    @Autowired
    ModelSourceInfoMapper mapper;

    @Override
    public int updateModelSourceInfo(ModelSourceInfo modelSourceInfo) {
        return mapper.updateByPrimaryKey(modelSourceInfo);
    }

    @Override
    public ModelSourceInfo getModelSourceInfo(int id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertItemModelSource(ModelSourceInfo sourceInfo) {
        return mapper.insert(sourceInfo);
    }

    @Override
    public int deleteItemModelSource(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }
}
