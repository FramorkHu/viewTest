package com.work.service.impl;

import com.work.core.model.bvo.ItemModelSourceInfo;
import com.work.core.model.dao.ModelSourceInfoDao;
import com.work.core.model.pojo.ModelSourceInfo;
import com.work.service.ModelSourceInfoService;

/**
 * Created by huyan on 15/5/13.
 */
public class ModelSourceInfoServiceImpl implements ModelSourceInfoService {

    private ModelSourceInfoDao modelSourceInfoDao;

    public void setModelSourceInfoDao(ModelSourceInfoDao modelSourceInfoDao) {
        this.modelSourceInfoDao = modelSourceInfoDao;
    }

    @Override
    public int updateModelSourceInfo(ModelSourceInfo modelSourceInfo) {
        return modelSourceInfoDao.updateModelSourceInfo(modelSourceInfo);
    }

    @Override
    public ModelSourceInfo getModelSourceInfo(int id) {
        return modelSourceInfoDao.getModelSourceInfo(id);
    }

    @Override
    public int insertItemModelSource(ModelSourceInfo sourceInfo) {
        return modelSourceInfoDao.insertItemModelSource(sourceInfo);
    }

    @Override
    public int deleteItemModelSource(Integer id) {
        return modelSourceInfoDao.deleteItemModelSource(id);
    }
}
