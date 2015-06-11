package com.work.service;

import com.work.core.model.pojo.UserInfo;

/**
 * Created by huyan on 2015/5/7.
 */
public interface UserInfoService {

    public UserInfo getUserInfoData(String userName, String password);

}
