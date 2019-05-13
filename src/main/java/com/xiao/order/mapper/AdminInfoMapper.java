package com.xiao.order.mapper;

import com.xiao.order.model.AdminInfo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author XiaoPengCheng
 * @create 2019-04-26 16:11
 */
public interface AdminInfoMapper {

    @Select("SELECT * FROM admin_info WHERE admin_name=#{adminName} AND admin_password=MD5(#{adminPassword})")
    @Results({
            @Result(property = "adminName", column = "admin_name"),
            @Result(property = "adminPassword", column = "admin_password")
    })
    AdminInfo getByNameAndPassword(AdminInfo adminInfo);

}
