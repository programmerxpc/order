package com.xiao.order.mapper;

import com.xiao.order.model.UserInfo;
import org.apache.ibatis.annotations.*;

/**
 * @author XiaoPengCheng
 * @create 2019-04-22 12:41
 */
public interface UserInfoMapper {

    @Insert("INSERT INTO user_info(username,`password`,phone,address,email) VALUES(#{username},MD5(#{password}),#{phone},#{address},#{email})")
    @ResultMap(value = "userInfoMap")
    int save(UserInfo userInfo);

    @Select("SELECT * FROM user_info WHERE username=#{username}")
    @Results(id = "userInfoMap", value = {
            @Result(property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "password", column = "password"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "address", column = "address"),
            @Result(property = "email", column = "email")
    })
    UserInfo getByUsername(UserInfo userInfo);

    @Select("SELECT * FROM user_info WHERE username=#{username} AND `password`=MD5(#{password})")
    @ResultMap(value = "userInfoMap")
    UserInfo getByUsernameAndPassword(UserInfo userInfo);

}
