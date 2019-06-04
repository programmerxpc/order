package com.xiao.order.service;

import com.xiao.order.model.UserInfo;

/**
 * @author XiaoPengCheng
 * @create 2019-04-22 15:04
 */
public interface UserInfoService {

    /**
     * 用户注册
     * @param userInfo
     * @return 如果注册成功，返回0；
     * 注册失败，返回1,该用户存在；返回2，数据库错误
     */
    int register(UserInfo userInfo);

    /**
     * 用户登录
     * @param userInfo
     * @return 返回登录成功的用户信息；如果返回值为null，登录失败
     */
    UserInfo login(UserInfo userInfo);

    /**
     * 用户查询个人信息
     * @param userinfo 包含参数：username
     * @return
     */
    UserInfo getByUsername(UserInfo userinfo);

}
