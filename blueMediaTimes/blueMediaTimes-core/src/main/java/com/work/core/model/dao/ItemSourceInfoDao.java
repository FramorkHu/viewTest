package com.work.core.model.dao;

import com.work.core.model.bvo.ItemModelSourceInfo;

import java.util.List;

/**
 * Created by huyan on 15/5/9.
 */
public interface ItemSourceInfoDao {

    public List<ItemModelSourceInfo> getItemSource(Integer itemId, Integer modelId);

}
