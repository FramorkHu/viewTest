package com.work.core.model.dao;

import com.work.core.model.pojo.UserInfo;

/**
 * Created by huyan on 2015/5/7.
 */
public interface UserInfoDao {

    public UserInfo getUserInfo(String userName, String passwd);

}
