package com.xiao.order.mapper;

import com.xiao.order.model.UserInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author XiaoPengCheng
 * @create 2019-04-22 12:58
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoMapperTest {

    @SuppressWarnings("all")
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Test
    public void save() {

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("test2");
        userInfo.setPassword("123");
        userInfo.setAddress("成都市");
        userInfo.setPhone("13011111111");
        userInfo.setEmail("123@qq.com");

        int row = userInfoMapper.save(userInfo);
        System.out.println("添加了：" + row);

    }

    @Test
    public void getByUsername(){

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("test2");

        UserInfo user = userInfoMapper.getByUsername(userInfo);
        System.out.println("根据用户名获取用户：" + user);

    }

    @Test
    public void getByUsernameAndPassword(){

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("test2");
        userInfo.setPassword("123");

        UserInfo user = userInfoMapper.getByUsernameAndPassword(userInfo);
        System.out.println("根据用户名和密码获取用户：" + user);

    }

}