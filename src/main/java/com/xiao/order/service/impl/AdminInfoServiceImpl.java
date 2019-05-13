package com.xiao.order.service.impl;

import com.xiao.order.mapper.AdminInfoMapper;
import com.xiao.order.model.AdminInfo;
import com.xiao.order.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author XiaoPengCheng
 * @create 2019-04-26 16:22
 */
@Service
public class AdminInfoServiceImpl implements AdminInfoService {

    @Autowired
    @SuppressWarnings("all")
    private AdminInfoMapper adminInfoMapper;

    @Override
    public AdminInfo login(AdminInfo adminInfo) {
        return adminInfoMapper.getByNameAndPassword(adminInfo);
    }
}
