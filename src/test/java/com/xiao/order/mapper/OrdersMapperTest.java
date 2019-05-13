package com.xiao.order.mapper;

import com.xiao.order.model.Orders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author XiaoPengCheng
 * @create 2019-04-23 15:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdersMapperTest {

    @SuppressWarnings("all")
    @Autowired
    private OrdersMapper ordersMapper;

    @Test
    public void save() {

        Orders orders = new Orders();
        orders.setUsername("test");
        orders.setProductId(1);
        orders.setProductName("碎冰冰");
        orders.setProductQuantity(10);

        int row = ordersMapper.save(orders);
        System.out.println("影响行数：" + row);

    }

    @Test
    public void getByUsername(){
        Orders orders = new Orders();
        orders.setUsername("test");

        List<Orders> list = ordersMapper.getByUsername(orders);
        System.out.println(list);
    }
}