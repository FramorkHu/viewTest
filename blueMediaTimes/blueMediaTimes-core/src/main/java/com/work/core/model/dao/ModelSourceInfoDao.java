package com.work.core.model.dao;

import com.work.core.model.pojo.ModelSourceInfo;

/**
 * Created by huyan on 15/5/13.
 */
public interface ModelSourceInfoDao {

    public int updateModelSourceInfo(ModelSourceInfo modelSourceInfo);

    public ModelSourceInfo getModelSourceInfo(int id);

    public int insertItemModelSource(ModelSourceInfo sourceInfo);

    public int deleteItemModelSource(Integer id);
}
