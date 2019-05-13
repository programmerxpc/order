package com.xiao.order.service;

import com.xiao.order.model.Orders;

import java.util.List;

/**
 * @author XiaoPengCheng
 * @create 2019-04-23 16:26
 */
public interface OrdersService {

    /**
     * 保存订单，保存成功返回0，保存失败返回1
     * @param orders
     * @return
     */
    int save(Orders orders);

    /**
     * 查看订单
     * @param orders
     * @return 订单信息，如果订单不存在，返回null
     */
    List<Orders> getByUsername(Orders orders);

    /**
     * 删除订单
     * @param orders 订单号
     * @return 删除成功返回0，删除失败返回1
     */
    int removeByOrderId(Orders orders);

    /**
     * 查看所有订单
     * @return
     */
    List<Orders> list();

}
