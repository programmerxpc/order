package com.xiao.order.service.impl;

import com.xiao.order.mapper.UserInfoMapper;
import com.xiao.order.model.UserInfo;
import com.xiao.order.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XiaoPengCheng
 * @create 2019-04-22 15:12
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @SuppressWarnings("all")
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public int register(UserInfo userInfo) {
        UserInfo user = userInfoMapper.getByUsername(userInfo);
        try {
            if (user == null){
                //该用户不存在
                int row = userInfoMapper.save(userInfo);//返回受影响的行数
                if (row > 0){
                    return 0;
                }else{
                    return 2;
                }
            }else{
                //该用户存在
                return 1;
            }
        } catch (Exception e) {
            return 2;
        }
    }

    @Override
    public UserInfo login(UserInfo userInfo) {
        return userInfoMapper.getByUsernameAndPassword(userInfo);
    }

    @Override
    public UserInfo getByUsername(UserInfo userinfo) {
        return userInfoMapper.getByUsername(userinfo);
    }
}
