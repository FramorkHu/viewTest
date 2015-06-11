package com.work.service;

import com.work.core.model.bvo.ItemModelSourceInfo;

import java.util.List;

/**
 * Created by huyan on 15/5/9.
 */
public interface ItemSourceInfoService {

    public List<ItemModelSourceInfo> getItemModelSourceInfos(Integer itemId, Integer modelId);



}
