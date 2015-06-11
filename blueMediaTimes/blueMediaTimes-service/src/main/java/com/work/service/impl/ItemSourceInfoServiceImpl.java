package com.work.service.impl;

import com.work.core.model.bvo.ItemModelSourceInfo;
import com.work.core.model.dao.ItemSourceInfoDao;
import com.work.service.ItemSourceInfoService;

import java.util.*;

/**
 * Created by huyan on 15/5/9.
 */
public class ItemSourceInfoServiceImpl implements ItemSourceInfoService {

    private ItemSourceInfoDao itemSourceInfoDao;

    public void setItemSourceInfoDao(ItemSourceInfoDao itemSourceInfoDao) {
        this.itemSourceInfoDao = itemSourceInfoDao;
    }

    @Override
    public List<ItemModelSourceInfo> getItemModelSourceInfos(Integer itemId, Integer modelId) {
        List<ItemModelSourceInfo> modelInfos = new ArrayList<ItemModelSourceInfo>();

        List<ItemModelSourceInfo> itemSourceInfos = itemSourceInfoDao.getItemSource(itemId, modelId);
        modelInfos.addAll(itemSourceInfos);

        return modelInfos;
    }

}
