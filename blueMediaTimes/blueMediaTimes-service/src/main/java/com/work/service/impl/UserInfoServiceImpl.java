package com.work.service.impl;

import com.work.core.model.dao.UserInfoDao;
import com.work.core.model.pojo.UserInfo;
import com.work.service.UserInfoService;

/**
 * Created by huyan on 2015/5/7.
 */
public class UserInfoServiceImpl implements UserInfoService {

    private UserInfoDao userInfoDao;

    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    @Override
    public UserInfo getUserInfoData(String userName, String password) {
        return userInfoDao.getUserInfo(userName, password);
    }

}
