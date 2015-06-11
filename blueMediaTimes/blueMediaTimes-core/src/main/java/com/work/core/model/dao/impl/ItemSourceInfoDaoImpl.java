package com.work.core.model.dao.impl;

import com.work.core.model.bvo.ItemModelSourceInfo;
import com.work.core.model.dao.ItemSourceInfoDao;
import com.work.core.model.mapper.ItemSourceInfoMapper;
import com.work.core.model.pojo.ItemSourceInfo;
import com.work.core.model.pojo.ItemSourceInfoExample;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huyan on 15/5/9.
 */
public class ItemSourceInfoDaoImpl extends SqlSessionDaoSupport implements ItemSourceInfoDao {

    @Autowired
    ItemSourceInfoMapper mapper;

    @Override
    public List<ItemModelSourceInfo> getItemSource(Integer itemId, Integer modelId) {
        Map<String, Object> parm = new HashMap<String, Object>();
        parm.put("itemId", itemId);
        parm.put("modelId", modelId);
        return getSqlSession().selectList("com.work.core.model.dao.impl.ItemSourceInfoDaoImpl.getItemSource", parm);

    }
}
