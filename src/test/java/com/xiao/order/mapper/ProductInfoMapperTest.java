package com.xiao.order.mapper;

import com.xiao.order.model.ProductInfo;
import com.xiao.order.vo.ProductVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author XiaoPengCheng
 * @create 2019-04-27 17:32
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoMapperTest {

    @SuppressWarnings("all")
    @Autowired
    private ProductInfoMapper productInfoMapper;

    @Test
    public void list() {

        List<ProductInfo> list = productInfoMapper.list();
        System.out.println("记录：" + list);

    }

    @Test
    public void listByNameAndCategoryName(){

        ProductVo productVo = new ProductVo();
        productVo.setProductName("可乐");

        List<ProductVo> productInfoList = productInfoMapper.listByNameAndCategoryName(productVo);
        System.out.println("记录：" + productInfoList);

    }

    @Test
    public void listByProductCategoryName(){
        ProductVo productVo = new ProductVo();
        productVo.setCategoryName("水果类");

        List<ProductVo> productVoList = productInfoMapper.listByProductCategoryName(productVo);
        System.out.println("商品信息："+productVoList);
    }
}