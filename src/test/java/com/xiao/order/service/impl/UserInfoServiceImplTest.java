package com.xiao.order.service.impl;

import com.xiao.order.model.UserInfo;
import com.xiao.order.service.UserInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author XiaoPengCheng
 * @create 2019-04-22 15:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoServiceImplTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void register() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("test1");
        userInfo.setPassword("123");
        userInfo.setPhone("13022222222");
        userInfo.setEmail("1212@qq.com");
        userInfo.setAddress("成都市高新区");

        int num = userInfoService.register(userInfo);
        System.out.println("注册代码：" + num);
    }

    @Test
    public void login() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("test1");
        userInfo.setPassword("123");

        UserInfo user = userInfoService.login(userInfo);
        System.out.println("用户信息：" + user);
    }
}