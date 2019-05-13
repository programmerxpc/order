package com.xiao.order.service;

import com.xiao.order.model.AdminInfo;

/**
 * @author XiaoPengCheng
 * @create 2019-04-26 16:19
 */
public interface AdminInfoService {

    /**
     * 管理员登录
     * @param adminInfo
     * @return 返回用户对象不为空，登录成功；为空登录失败
     */
    AdminInfo login(AdminInfo adminInfo);

}
