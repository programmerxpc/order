package com.xiao.order.service.impl;

import com.xiao.order.mapper.OrdersMapper;
import com.xiao.order.model.Orders;
import com.xiao.order.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author XiaoPengCheng
 * @create 2019-04-23 16:33
 */
@Service
public class OrdersServiceImpl implements OrdersService {

    @SuppressWarnings("all")
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public int save(Orders orders) {

        try {
            ordersMapper.save(orders);
            return 0;
        } catch (Exception e) {
            return 1;
        }

    }

    @Override
    public List<Orders> getByUsername(Orders orders) {

        List<Orders> ordersList = ordersMapper.getByUsername(orders);
        if (ordersList != null && ordersList.size() > 0){
            //订单存在
            return ordersList;
        }else {
            return null;
        }

    }

    @Override
    public int removeByOrderId(Orders orders) {

        try {
            int row = ordersMapper.removeByOrderId(orders);
            if (row != 0){
                //删除成功
                return 0;
            }else{
                return 2;
            }
        } catch (Exception e) {
            return 1;
        }

    }

    @Override
    public List<Orders> list() {
        List<Orders> ordersList = ordersMapper.list();
        if (ordersList != null && ordersList.size() > 0){
            //订单存在
            return ordersList;
        }else {
            return null;
        }
    }
}
