package com.xiao.order.mapper;

import com.xiao.order.model.Orders;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author XiaoPengCheng
 * @create 2019-04-23 12:06
 */
public interface OrdersMapper {

    /**
     * 下单
     * @param orders，需要参数：用户名，商品编号，商品名称，商品数量
     * @return
     */
    @Insert("INSERT INTO orders(username,product_id,product_name,product_quantity,order_amount) VALUES(#{username}," +
            "#{productId},#{productName},#{productQuantity},(SELECT product_price*(#{productQuantity}) order_amount FROM product_info WHERE product_id=#{productId}))")
    @Results({
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "username", column = "username"),
            @Result(property = "productId", column = "product_id"),
            @Result(property = "productName", column = "product_name"),
            @Result(property = "productQuantity", column = "product_quantity"),
            @Result(property = "orderAmount", column = "order_amount"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    int save(Orders orders);

    /**
     * 查看订单
     * @param orders 参数：用户名
     * @return
     */
    @Select("SELECT * FROM orders WHERE username=#{username}")
    @Results({
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "username", column = "username"),
            @Result(property = "productId", column = "product_id"),
            @Result(property = "productName", column = "product_name"),
            @Result(property = "productQuantity", column = "product_quantity"),
            @Result(property = "orderAmount", column = "order_amount"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    List<Orders> getByUsername(Orders orders);

    /**
     *
     * @param orders 参数：订单id
     * @return 受影响行数
     */
    @Delete("DELETE FROM orders WHERE order_id=#{orderId}")
    @Results({
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "username", column = "username"),
            @Result(property = "productId", column = "product_id"),
            @Result(property = "productName", column = "product_name"),
            @Result(property = "productQuantity", column = "product_quantity"),
            @Result(property = "orderAmount", column = "order_amount"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    int removeByOrderId(Orders orders);

    @Select("SELECT * FROM orders")
    @Results({
            @Result(property = "orderId", column = "order_id"),
            @Result(property = "username", column = "username"),
            @Result(property = "productId", column = "product_id"),
            @Result(property = "productName", column = "product_name"),
            @Result(property = "productQuantity", column = "product_quantity"),
            @Result(property = "orderAmount", column = "order_amount"),
            @Result(property = "createTime", column = "create_time"),
            @Result(property = "updateTime", column = "update_time")
    })
    List<Orders> list();

}
