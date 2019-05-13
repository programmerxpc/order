package com.xiao.order.controller;

import com.xiao.order.model.Orders;
import com.xiao.order.model.UserInfo;
import com.xiao.order.service.OrdersService;
import com.xiao.order.service.ProductInfoService;
import com.xiao.order.service.UserInfoService;
import com.xiao.order.vo.ProductVo;
import com.xiao.order.vo.ResultVo;
import com.xiao.order.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author XiaoPengCheng
 * @create 2019-04-22 15:27
 */
@RestController
@RequestMapping(value = "/user/*")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private ProductInfoService productInfoService;

    @GetMapping(value = "register")
    public ResultVo register(UserInfo userInfo){
        ResultVo resultVo = new ResultVo();

        int number = userInfoService.register(userInfo);
        if (number == 0){
            //注册成功
            resultVo.setCode(0);
            resultVo.setMsg("注册成功!");
        }else {
            //注册失败
            if (number == 1){
                resultVo.setCode(1);
                resultVo.setMsg("注册失败！,该用户已存在!");
            }else {
                resultVo.setCode(2);
                resultVo.setMsg("数据库异常！");
            }
        }
        return resultVo;
    }

    @GetMapping(value = "login")
    public ResultVo login(UserInfo userInfo){
        ResultVo resultVo = new ResultVo();
        UserVo userVo = new UserVo();

        UserInfo userInfo_result = userInfoService.login(userInfo);
        if (userInfo_result != null){
            //用户存在
            userVo.setUsername(userInfo_result.getUsername());
            userVo.setAddress(userInfo_result.getAddress());
            userVo.setEmail(userInfo_result.getEmail());
            userVo.setPhone(userInfo_result.getPhone());

            resultVo.setCode(0);
            resultVo.setMsg("登录成功!");
            resultVo.setData(userVo);
        }else {
            //用户不存在
            resultVo.setCode(1);
            resultVo.setMsg("该用户不存在!");
        }
        return resultVo;
    }

    @GetMapping(value = "saveOrder")
    public ResultVo saveOrder(Orders orders){

        ResultVo resultVo = new ResultVo();

        int code = ordersService.save(orders);
        if (code == 0){
            //保存成功
            resultVo.setCode(0);
            resultVo.setMsg("下单成功!");
        }else {
            //保存失败
            resultVo.setCode(1);
            resultVo.setMsg("数据异常!");
        }

        return resultVo;

    }

    @GetMapping(value = "showOrder")
    public ResultVo showOrder(Orders orders){

        ResultVo resultVo = new ResultVo();

        List<Orders> orderList = ordersService.getByUsername(orders);
        if (orderList != null && orderList.size() > 0){
            //订单存在
            resultVo.setCode(0);
            resultVo.setMsg("订单存在!");
            resultVo.setData(orderList);
        }else {
            resultVo.setCode(1);
            resultVo.setMsg("订单不存在");
        }

        return resultVo;

    }

    @GetMapping(value = "deleteOrder")
    public ResultVo deleteOrder(Orders orders){

        ResultVo resultVo = new ResultVo();

        int code = ordersService.removeByOrderId(orders);
        if (code == 0){
            //删除成功
            resultVo.setCode(0);
            resultVo.setMsg("订单删除成功!");
        }else {
            resultVo.setCode(1);
            resultVo.setMsg("删除失败!无该订单！");
        }

        return resultVo;

    }

    //根据类别名称获取商品信息
    @GetMapping("listByProductCategoryName")
    public ResultVo listByProductCategoryName(ProductVo productVo){
        ResultVo resultVo = new ResultVo();

        List<ProductVo> productVoList = productInfoService.listByProductCategoryName(productVo);
        if (productVoList != null){
            //商品信息存在
            resultVo.setCode(0);
            resultVo.setMsg("success");
            resultVo.setData(productVoList);
        }else {
            resultVo.setCode(1);
            resultVo.setMsg("商品不存在!");
        }

        return resultVo;
    }

}
