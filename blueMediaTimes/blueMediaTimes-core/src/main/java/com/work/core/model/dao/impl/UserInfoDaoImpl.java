package com.work.core.model.dao.impl;

import com.work.core.model.dao.UserInfoDao;
import com.work.core.model.mapper.UserInfoMapper;
import com.work.core.model.pojo.UserInfo;
import com.work.core.model.pojo.UserInfoExample;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by huyan on 2015/5/7.
 */
public class UserInfoDaoImpl extends SqlSessionDaoSupport implements UserInfoDao {

    @Autowired
    UserInfoMapper mapper;

    @Override
    public UserInfo getUserInfo(String userName, String password) {
        UserInfoExample example = new UserInfoExample();
        UserInfoExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(userName).andPasswordEqualTo(password);

        List<UserInfo> userInfos = mapper.selectByExample(example);
        if (userInfos != null && !userInfos.isEmpty()){
            return userInfos.get(0);
        }

        return null;
    }
}
